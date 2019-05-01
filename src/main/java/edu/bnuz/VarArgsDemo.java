package edu.bnuz;

/**
 * 可以把类型相同但个数可变的参数传递给方法。方法中的参数声明如下：
 * 
 * 
 * typeName... parameterName
 * 
 * 
 * 在方法声明中，指定类型后紧跟省略号(...)。只能给方法中指定一个可变长参数，同时该参数必须是最后一个参数。任何常规参数必须在它之前。
 * 
 * @author Castle
 *
 */
public class VarArgsDemo {
	public static void main(String[] args) {
		printMax(34, 3, 3, 4, 56.6);
		printMax(new double[] { 1, 2, 3 });
	}

	public static void printMax(double... numbers) {
		if (numbers.length == 0) {
			System.out.println("No arguments pass");
			return;
		}
		double result = numbers[0];
		for (int i = 1; i < numbers.length; i++) {
			if (numbers[i] > result) {
				result = numbers[i];
			}
		}
		System.out.println("the maximun value is: " + result);
	}
}
