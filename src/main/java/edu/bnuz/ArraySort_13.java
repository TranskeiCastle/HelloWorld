package edu.bnuz;

/**
 * 选择排列
 * 
 * 先找到数列中最小的数，然后将它放到数列的最前面，接着在剩下的数里再找最小的数，放到第一个数的后面，依次类推。
 * 
 * 为毛单看上面的原理我想不到互换2个数？
 * 
 * @author Castle
 *
 */
public class ArraySort_13 {

	public static void main(String[] args) {
		double[] list = { 1, 9, 4.5, 6.6, 5.7, -4.5 };
		ArraySort_13.selectionSort(list);
		for (double d : list) {
			System.out.println(d);
		}
	}

	public static void selectionSort(double[] list) {
		for (int i = 0; i < list.length; i++) {
			// Find the minimum in the list[i..list.length-1
			double currentMin = list[i];
			int currentMinIndex = i;

			for (int j = i + 1; j < list.length; j++) {
				// once find the smaller one, update currentMin and
				// currentMinIndex
				if (currentMin > list[j]) {
					currentMin = list[j];
					currentMinIndex = j;
				}
			}
			// once a update happened, swap list[i] with list[currentMinIndex]
			if (currentMinIndex != i) {
				// firstly, shift the original one (list[i]) to where the
				// smaller one takes place
				list[currentMinIndex] = list[i];
				// secondly, shift the smaller one in its correct position,
				// and there is nothing business with it
				list[i] = currentMin;
			}
		}
	}
}
