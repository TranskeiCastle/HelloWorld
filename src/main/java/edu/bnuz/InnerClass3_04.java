package edu.bnuz;

public class InnerClass3_04 {
	public static void main(String[] args) {
		int i = 10;
		double j = 3;
		System.out.println(i / j);
	}

	public void test(final int b) {
		final int a = 10;
		new Thread() {
			public void run() {
				System.out.println(a);
				System.out.println(b);
			};
		}.start();
	}

}
