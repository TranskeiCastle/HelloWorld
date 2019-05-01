package edu.bnuz;

public class GCD {

	public static void main(String[] args) {
		System.out.println("the GCD of 21 and 24 is: " + findGCD(21, 24));
	}

	public static long findGCD(long a, long b) {
		long a1 = Math.abs(a);
		long b1 = Math.abs(b);
		int gcd = 1;
		for (int k = 1; k <= a1 && k <= b1; k++) {
			if (a1 % k == 0 && b1 % k == 0) {
				gcd = k;
			}
		}
		return gcd;
	}
}
