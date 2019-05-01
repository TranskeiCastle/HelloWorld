package collection;

import java.util.EnumMap;

public class EnumMapTest {
	public static void main(String[] args) {
		// enumMap 的所有key都是枚举类的值
		EnumMap<MySeason, String> enumMap = new EnumMap<>(MySeason.class);
		enumMap.put(MySeason.SPRING, "春暖花开");
		enumMap.put(MySeason.SUMMER, "夏日炎炎");
		// {SPRING=春暖花开, SUMMER=夏日炎炎}
		System.out.println(enumMap);
	}
}

enum MySeason {
	SPRING, SUMMER, AUTUMN, WINTER;
}