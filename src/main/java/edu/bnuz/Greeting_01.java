package edu.bnuz;

public class Greeting_01 {
	public static void main(String[] args) {
		// System.out.println("Fight Bravely!!");
		System.out.println(2.0 / 0); // Infinity
		System.out.println(-2.0 / 0); // -Infinity
		double i = Double.POSITIVE_INFINITY;
		double j = i + 2;
		System.out.println(i == j); // true, 正无穷与正无穷当然一样大咯
	}
}
