package collection;

import java.util.EnumSet;

public class EnumSetTest {
	public static void main(String[] args) {
		EnumSet<Season> enumSet = EnumSet.allOf(Season.class);
		// [SPRING, SUMMAR, AUTUMN, WINTER]
		System.out.println(enumSet);
		EnumSet<Season> enumSet2 = EnumSet.noneOf(Season.class);
		// []
		System.out.println(enumSet2);
		enumSet2.add(Season.WINTER);
		enumSet2.add(Season.SPRING);
		// [SPRING, WINTER]
		System.out.println(enumSet2);
	}
}

enum Season {
	SPRING, SUMMAR, AUTUMN, WINTER;
}