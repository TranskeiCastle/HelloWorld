
	/**
	 * 
	 * @Description: 求二个时间相差的月份数.
	 * @author Leo Li
	 * @date 2015年2月7日 上午10:19:32
	 * @param start
	 *            开始时间
	 * @param end
	 *            结束时间
	 * @return
	 */
	public static int getCompareMonth(Date start, Date end) {
		if (start.after(end)) {
			Date t = start;
			start = end;
			end = t;
		}
		Calendar startCalendar = Calendar.getInstance();
		startCalendar.setTime(start);
		Calendar endCalendar = Calendar.getInstance();
		endCalendar.setTime(end);
		Calendar temp = Calendar.getInstance();
		temp.setTime(end);
		temp.add(Calendar.DATE, 1);

		int year = endCalendar.get(Calendar.YEAR) - startCalendar.get(Calendar.YEAR);
		int month = endCalendar.get(Calendar.MONTH) - startCalendar.get(Calendar.MONTH);

		if ((startCalendar.get(Calendar.DATE) == 1) && (temp.get(Calendar.DATE) == 1)) {
			return year * 12 + month + 1;
		} else if ((startCalendar.get(Calendar.DATE) != 1) && (temp.get(Calendar.DATE) == 1)) {
			return year * 12 + month;
		} else if ((startCalendar.get(Calendar.DATE) == 1) && (temp.get(Calendar.DATE) != 1)) {
			return year * 12 + month;
		} else {
			return (year * 12 + month - 1) < 0 ? 0 : (year * 12 + month);
		}
	}
	
	/***********可以取代#168 getCompareMonth 求二个时间相差的月份数.**********/
	public static void main(String[] args) {
		LocalDate start = LocalDate.parse("2017-06-24");
		LocalDate end = start.plusDays(7);
		if(start.isAfter(end)){
			LocalDate temp = null;
			temp = start;
			start = end;
			end = temp;
		}
		// 原来的方法，用于和新的日期API比较
		int k = getCompareMonth(start.toDate(), end.toDate());
		// 自然月，6月24号，经过7天来到7月1号，计数结果是1
		int monthsBetween = Months.monthsBetween(start.withDayOfMonth(1), end.withDayOfMonth(1)).getMonths();
		// 非自然月，6月24号，经过7天来到7月1号，7天小于6月份天数，计数结果是0
		int monthsBetween2 = Months.monthsBetween(start, end).getMonths();
		int daysBetween = Days.daysBetween(start, end).getDays();
		System.out.println(start);
		System.out.println(end);
		System.out.println("原来的方法" + k);
		System.out.println(monthsBetween);
		System.out.println(monthsBetween2);
		System.out.println("中间经过天数" + daysBetween);
	}
=======================================
/**
	 * 
	 * @Description: 返回本周/上周/下周的第一天/最后一天的日期
	 * @author Leo Li
	 * @date 2015年2月3日 上午10:24:25
	 * @param week
	 *            利用类常量 分别表示上周，本周，下周
	 * @param day
	 *            利用类常量 分别表示第一天，最后一天
	 * @param formatStr
	 *            输出的时间格式，为null或者空串时默认yyyyMMdd
	 * @return
	 * @throws DateParseException
	 */
	public String DayOfWeek(Integer week, Integer day, String formatStr) throws DateParseException {
		if (week != DateUtil.LAST_WEEK && week != DateUtil.THIS_WEEK && week != DateUtil.NEXT_WEEK) {
			throw new DateParseException(
					"week参数请输入DateUtil.LAST_WEEK,DateUtil.THIS_WEEK 或者DateUtil.NEXT_WEEK表示上周,本周,下周");
		}
		if (day != DateUtil.FIRST_DAY && day != DateUtil.LAST_DAY) {
			throw new DateParseException("day参数请输入DateUtil.FIRST_DAY或者DateUtil.LAST_DAY表示第一天,最后一天");
		}
		if (formatStr == null || "".equals(formatStr)) {
			formatStr = "yyyyMMdd";
		}
		DateFormat format = new SimpleDateFormat(formatStr);
		Calendar c = Calendar.getInstance();
		int weekday = c.get(Calendar.DAY_OF_WEEK) - 1;
		if (week == DateUtil.LAST_WEEK && day == DateUtil.FIRST_DAY) {// 上周的第一天
			c.add(Calendar.DAY_OF_MONTH, -weekday - 7);
		} else if (week == DateUtil.LAST_WEEK && day == DateUtil.LAST_DAY) {// 上周的最后一天
			c.add(Calendar.DAY_OF_MONTH, 6 - weekday - 7);
		} else if (week == DateUtil.THIS_WEEK && day == DateUtil.FIRST_DAY) {// 本周第一天
			c.add(Calendar.DAY_OF_MONTH, -weekday);
		} else if (week == DateUtil.THIS_WEEK && day == DateUtil.LAST_DAY) {// 本周最后一天
			c.add(Calendar.DAY_OF_MONTH, 6 - weekday);
		} else if (week == DateUtil.NEXT_WEEK && day == DateUtil.FIRST_DAY) {// 下周的第一天
			c.add(Calendar.DAY_OF_MONTH, 7 - weekday);
		} else if (week == DateUtil.NEXT_WEEK && day == DateUtil.LAST_DAY) {// 下周的最后一天
			c.add(Calendar.DAY_OF_MONTH, 13 - weekday);
		}
		return format.format(c.getTime());
	}
	
	/***********可以标记为弃用#105 DayOfWeek 返回本周/上周/下周的第一天/最后一天的日期*************/
	public static void main(String[] args) {
		LocalDate start = LocalDate.now();
		DateUtil du = new DateUtil();
		// API以周一为每周第一天，需要以周日为起始的话，加上minusDays(1)
		System.out.println("本周第一天"+start.dayOfWeek().withMinimumValue().minusDays(1));
		System.out.println("本周最后一天"+start.dayOfWeek().withMaximumValue().minusDays(1));
		// plusWeeks(1)加1周
		System.out.println("下周第一天"+start.plusWeeks(1).dayOfWeek().withMinimumValue().minusDays(1));
		System.out.println("下周最后一天"+start.plusWeeks(1).dayOfWeek().withMaximumValue().minusDays(1));
		// minusWeeks(1)减1周
		System.out.println("上周第一天"+start.minusWeeks(1).dayOfWeek().withMinimumValue().minusDays(1));
		System.out.println("上周最后一天"+start.minusWeeks(1).dayOfWeek().withMaximumValue().minusDays(1));
	}