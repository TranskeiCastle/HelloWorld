package com.define.budget.config;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.TreeSet;
public class Test {
	public static void main(String[] args) {
		String[] strs = new String[60];
		System.out.println(strs.length);
		strs = expendCapacity(strs, 80);
		System.out.println(strs.length);
	}

	public static <T> T[] expendCapacity(T[] datas, int newLength) {
		newLength = newLength < 0 ? 0 : newLength;
		return Arrays.copyOf(datas, newLength);
	}
}
public class Test {
	public static void main(String[] org){
		 <select id="getDetailNumber" resultType="String">
        select Max(CONVERT(number,SIGNED)) from dy_pay_number where execute_year=#{value}
    </select>
		@Override
    public String getDetailNumber(String executeYear) {
        String flowNumber = payNumberDao.getDetailNumber(executeYear);
        String number = "00000001";
        if (StringUtils.isNotEmpty(flowNumber)) {
            int num = Integer.parseInt(flowNumber);
            num++;
            number = String.format("%08d%n", num);
        }
        return number;
    }
		TreeSet<String> ts = new TreeSet<String>();
		ts.add("20101");
		ts.add("20102");
		ts.add("202");
		ts.add("20103");
		ts.add("20206");
		ts.add("20206");
		ts.add("20201");
		/*for(int i=0;i<ts.size();i++){
			ts.iterator();
		}*/
		BigDecimal a = new BigDecimal(0.5);
		BigDecimal b = new BigDecimal(0.0);
		double c = a.add(b).doubleValue();
		String s = "0.0";
		double i = Double.parseDouble(s);
		List<Map<String,Object>> list = new ArrayList<>();
		Map<String,Object> map = new HashMap<>();
		map.put("a", "1");
		map.put("b", "");
		map.put("c", "2");
		list.add(map);
		String ss = list.get(0).get("b").toString();
		
		List<Integer> numbers = Arrays.asList(3, 2, 2, 3, 7, 3, 5);
		 
		IntSummaryStatistics stats = numbers.stream().mapToInt((x) -> x).summaryStatistics();
		 
		System.out.println("列表中最大的数 : " + stats.getMax());
		System.out.println("列表中最小的数 : " + stats.getMin());
		System.out.println("所有数之和 : " + stats.getSum());
		System.out.println("平均数 : " + stats.getAverage());
		
		System.out.println(ss);
	}
}
