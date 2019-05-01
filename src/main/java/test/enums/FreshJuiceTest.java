package test.enums;

import test.enums.FreshJuice.FreshJuiceSize;

public class FreshJuiceTest {
	public static void main(String[] args) {
		FreshJuice juice = new FreshJuice();
		juice.size = FreshJuiceSize.MEDUIM;
		juice.size = FreshJuice.FreshJuiceSize.MEDUIM;
	}
}

class FreshJuice {
	enum FreshJuiceSize {SMALL, MEDUIM, LARGE}
	FreshJuiceSize size;
}
