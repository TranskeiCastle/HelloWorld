package edu.bnuz;

/***
 * 线性查找
 * 
 * @author Castle
 *
 */
public class ArraySearching_11 {
	public static void main(String[] args) {
		int[] myArray = { 2016, 10, 4, 12, 14, 56 };
		System.out.println("target index: " + linearSerching(myArray, 2016));
		System.out.println("target index: " + linearSerching(myArray, 1987));
	}

	public static int linearSerching(int[] numbers, int key) {
		int result = -1;
		for (int i = 0; i < numbers.length; i++) {
			if (numbers[i] == key) {
				result = i;
			}
		}
		return result;
	}
}
