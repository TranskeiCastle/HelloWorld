package edu.bnuz;

public class ArraySort_14 {

	public static void main(String[] args) {
		double[] list = { 1, 9, 4.5, 6.6, 5.7, -4.5 };
		ArraySort_14.insertionSort(list);
		for (double d : list) {
			System.out.println(d);
		}
	}

	public static void insertionSort(double[] list) {
		for (int i = 1; i < list.length; i++) {
			// insert list[i] into a sorted sublist list[0...i-1]
			// so that list[0...i] is sorted
			double currentElement = list[i];
			int k;
			for (k = i - 1; k >= 0 && list[k] > currentElement; k--) {
				// 相当于比currentElement的元素，都往右移一位
				list[k + 1] = list[k];
			}
			// insert the current element into list[k + 1]
			list[k + 1] = currentElement;
		}
	}
}
