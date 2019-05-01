package edu.bnuz;

/**
 * 给方法传递数组
 * 
 * 对于基本数据类型参数，传递的是实参的值(pass by value)；
 * 
 * 对于数组类型参数，传递的是数组的引用(pass-by-sharing)，参数传递的是共享信息，即方法中的数组和传递的数组是一样的。所以，
 * 如果改变方法中的数组，将会看到方法外的数组也变化了。
 * 
 * @author Castle
 *
 */
public class ArrayInvoke_08 {
	public static void main(String[] args) {
		int x = 1;
		int[] y = new int[10];
		change(x, y);
		// print x is 1
		System.out.println("x is " + x);
		// print y[0] is 5555
		System.out.println("y[0] is " + y[0]);
	}

	public static void change(int number, int[] numbers) {
		number = 1001;
		numbers[0] = 5555;
	}

}
