package edu.bnuz;

/**
 * 可变长参数列表：可以把类型相同但个数可变的参数传递给方法
 * 
 * 在方法声明中，指定类型后紧跟着省略号。
 * 
 * 只能给方法中指定一个可变长参数，同时该参数必须是最后一个参数，任何常规参数必须在它之前。
 * 
 * @author Castle
 *
 */
public class ArrayInvoke_10 {
	public static void main(String[] args) {
		// the Max value is 56.5
		printMax(34, 3, 3, 2, 56.5);
		// the Max value is 3.0
		printMax(new double[] { 1, 2, 3 });
	}

	public static void printMax(double... numbers) {
		if (numbers.length == 0) {
			System.out.println("No argument passed");
			return;
		}
		double result = numbers[0];
		for (double d : numbers) {
			if (d > result) {
				result = d;
			}
		}
		System.out.println("the Max value is " + result);
	}
}
