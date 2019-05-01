package edu.bnuz;

import java.util.Arrays;

/**
 * Arrays 类
 * 
 * Arrays.sort() / Arrays.fill() / System.arraycopy() / Arrays.equals()
 * 
 * @author Castle
 *
 */
public class ArraySort_15 {
	public static void main(String[] args) {
		double[] numbers = { 6.0, 4.4, 1.9, 2.9, 3.4, 3.5 };
		Arrays.sort(numbers);
		for (double d : numbers) {
			System.out.println(d + "  ");
		}

		int[] myNumbers = new int[5];
		int[] myNumbers2 = new int[15];
		// 填充所有
		Arrays.fill(myNumbers, 5);
		for (int i : myNumbers) {
			System.out.println(i);
		}
		// 填充部分，跟截取字符串类似，包括1，不包括3
		Arrays.fill(myNumbers2, 1, 3, 8);
		for (int i : myNumbers2) {
			System.out.println(i);
		}
		// 参数含义：源数组引用，源数组复制起点，目标数组引用，目标数组赋值起点，复制的元素个数
		System.arraycopy(myNumbers, 0, myNumbers2, 6, 5);
		for (int i : myNumbers2) {
			System.out.println(i);
		}

		int[] list1 = { 2, 4, 7, 10 };
		int[] list2 = { 2, 4, 7, 10 };
		int[] list3 = { 4, 2, 7, 10 };
		// true
		System.out.println(Arrays.equals(list1, list2));
		// false
		System.out.println(Arrays.equals(list2, list3));
	}
}
