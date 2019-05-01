package edu.bnuz;

/**
 * 覆盖equals()的正确写法
 * 
 * @author Castle
 * @date 2016-08-30
 *
 */

public class TestEqualsRight_02 {
	public static void main(String[] args) {
		CircleNew circle1 = new CircleNew();
		CircleNew circle2 = new CircleNew();
		System.out.println(circle1.equals(circle2));// true
	}
}

class CircleNew {
	double radius;

	public double getRadius() {
		return this.radius;
	}

	public void setRadius(double radius) {
		this.radius = radius;
	}

	// 覆盖equals(), 注意行数左边有个绿色三角号标记, Overrides
	public boolean equals(Object obj) {
		return radius == ((CircleNew) obj).radius;
	}
}
