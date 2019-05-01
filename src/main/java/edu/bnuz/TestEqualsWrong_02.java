package edu.bnuz;

import java.util.Date;

/**
 * 覆盖equals()的错误写法
 * 
 * @author Castle
 * @date 2016-08-30
 *
 */
public class TestEqualsWrong_02 {
	public static void main(String[] args) {
		Object circle1 = new Circle();
		Object circle2 = new Circle();
		System.out.println(circle1.equals(circle2)); // false
		// 变量在声明时即确定了调用的方法，因此circle1调用不了自定义的toString方法
		// System.out.println(circle1.toString(new Date()));
	}
}

class Circle {
	double radius;

	public double getRadius() {
		return this.radius;
	}

	// 这里没有覆盖Override，只是重载Overload
	public boolean equals(Circle circle) {
		System.out.println("错误的比较方式。。。。");
		return this.radius == circle.radius;
	}

	public String toString(Date date) {
		return "from Circle.";
	}
}
