package date;

import java.time.Clock;
import java.time.Duration;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.MonthDay;
import java.time.Year;
import java.time.YearMonth;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

import org.junit.Test;

public class DateDemo {

    /**
     * 标准格式 yyyy-MM-dd、HH:mm 可以直接 parse 解析得到
     */
    @Test
    public void met() {
        // 非标准格式，需要一个 Formatter
        // DateTimeFormatter fmt = DateTimeFormatter.ofPattern("yyyy/MM/dd");
        // LocalDate lo = LocalDate.parse("2015/12/21", fmt);
        LocalDate lo = LocalDate.parse("2015-12-21");
        // 2015-12-21
        System.out.println(lo.toString());
    }

    @Test
    public void met2() {
        LocalDateTime ldt = LocalDateTime.now();
        // 2019-04-24T19:41:18.370
        System.out.println(ldt);
        // 2019-04-24T19:41:18.370
        System.out.println(ldt.toString());
        String result = ldt.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        // 2019-04-24 19:42:33
        System.out.println(result);
        String resultMin = ldt.format(DateTimeFormatter.ofPattern("mm"));
        // 截取分钟数，42
        System.out.println(resultMin);

    }

    @Test
    public void newDateAPI() {
        /**
         * **************Clock************
         */
        System.out.println("**************Clock************");
        // 获取当前clock
        Clock clock = Clock.systemUTC();
        // 0000通过clock获取当前时刻。貌似是标准时间，东八区怎么打印？
        System.out.println("当前时刻：" + clock.instant());
        // 获取clock对应的毫秒数，与系统类System结果相同
        System.out.println(clock.millis());
        System.out.println(System.currentTimeMillis());

        /**
         * **************Duration************
         */
        System.out.println("\n**************Duration************");
        Duration duration = Duration.ofSeconds(6000);
        // 其实只是取整
        System.out.println("6000秒相当于 " + duration.toMinutes() + " 分钟");
        System.out.println("6000秒相当于 " + duration.toHours() + " 小时");
        System.out.println("6000秒相当于 " + duration.toDays() + " 天");
        // 在clock基础上加6000秒，返回新的clock
        Clock clock2 = Clock.offset(clock, duration);
        // 可以看到clock2与clock相差1小时40分
        System.out.println("当前时刻往后6000秒为：" + clock2.instant());

        /**
         * **************Instant************
         */
        System.out.println("\n**************Instant************");
        // 获取当前时间
        Instant instant = Instant.now();
        // 0000也是打印标准时间
        System.out.println(instant);
        // instant添加6000秒，即100分钟，返回新的Instant
        Instant instant2 = instant.plusSeconds(6000);
        System.out.println(instant2);
        // 根据字符串解析Instant对象
        Instant instant3 = Instant.parse("2016-11-17T20:30:45.343Z");
        System.out.println(instant3);
        // 在instant3的基础上往后5小时4分钟
        // 0000这个方法调用推算很有意思，静态方法/实例方法
        Instant instant4 = instant3.plus(Duration.ofHours(5).plusMinutes(4));
        System.out.println(instant4);
        // 获取instant4的5天以前的时刻
        Instant instant5 = instant4.minus(Duration.ofDays(5));
        System.out.println(instant5);

        /**
         * **************LocalDate************
         * 
         * 代表不带时区的日期，例如2003-12-03
         */
        System.out.println("\n**************LocalDate************");
        LocalDate localDate = LocalDate.now();
        System.out.println("当前日期: " + localDate);
        // 设置为2016年5月20号
        LocalDate localDate2 = LocalDate.of(2016, Month.MAY, 20);
        System.out.println("设置为2016年5月20号: " + localDate2);
        // 获取2016年的第366天
        LocalDate localDate3 = LocalDate.ofYearDay(2016, 366);
        System.out.println("获取2016年的第366天: " + localDate3);
        // 获取当前月份
        System.out.println("获取当前月份: " + localDate.getMonth() + ", 数字: " + localDate.getMonth().getValue());
        // 获取当前日期号数
        System.out.println("获取当前日期号数: " + localDate.getDayOfMonth());
        // 一年中的第几天
        System.out.println("一年中的第几天: " + localDate.getDayOfYear());
        // 一周中的第几天
        System.out.println("一周中的第几天: " + localDate.getDayOfWeek() + ", 数字: " + localDate.getDayOfWeek().getValue());

        /**
         * **************LocalTime************
         * 
         * 代表不带时区的时间，例如10:05:30
         */
        System.out.println("\n**************LocalTime************");
        LocalTime localTime = LocalTime.now();
        //
        System.out.println("当前时间: " + localTime);
        // 设置时间为21:22:23
        localTime = LocalTime.of(21, 22, 23);
        System.out.println("设置时间为21:22:23: " + localTime);
        // 返回一天中的第6000秒
        localTime = LocalTime.ofSecondOfDay(6000);
        System.out.println("返回一天中的第6000秒: " + localTime);

        /**
         * **************LocalDateTime************
         * 
         * 代表不带时区的日期、时间，例如2016-11-18T15:35:57.430
         */
        System.out.println("\n**************LocalDateTime************");
        LocalDateTime localDateTime = LocalDateTime.now();
        System.out.println("当前日期、时间: " + localDateTime);
        String result = localDateTime.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        System.out.println("对当前日期、时间做格式化处理: " + result);
        // 当前日前往后24小时1分钟
        LocalDateTime future = localDateTime.plusHours(24).plusMinutes(1);
        System.out.println("当前日前往后24小时1分钟: " + future);

        /**
         * **************Year, YearMonth, MonthDay************
         */
        System.out.println("\n**************Year, YearMonth, MonthDay************");
        // 获取当前年份
        Year year = Year.now();
        System.out.println("当前年份: " + year);
        // 当前年份再加5年
        Year year2 = year.plusYears(5);
        System.out.println("当前年份再加5年: " + year2);
        // 当前年-月格式日期
        YearMonth yearMonth = YearMonth.now();
        System.out.println("当前年-月格式日期: " + yearMonth);
        // 当前年月加5年、减3个月
        YearMonth yearMonth2 = yearMonth.plusYears(5).minusMonths(3);
        System.out.println("当前年月加5年、减3个月: " + yearMonth2);
        // 当前月-日格式日期
        MonthDay monthDay = MonthDay.now();
        System.out.println("当前月-日格式日期: " + monthDay);
        // 设置为5月20号
        // 重新构造对象
        MonthDay monthDay2 = MonthDay.of(Month.MAY, 20);
        // 修改已有对象
        MonthDay monthDay3 = monthDay.with(Month.MAY).withDayOfMonth(20);
        System.out.println("设置为5月20号: " + monthDay2 + "  " + monthDay3);
    }
}
