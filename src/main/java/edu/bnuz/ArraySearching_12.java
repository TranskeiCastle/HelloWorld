package edu.bnuz;

/**
 * 二分查找
 * 
 * 假设数组已经按照升序排列，二分查法找首先将关键字与数组中间的元素进行比较：
 * 
 * 1、如果关键字小于中间元素，只需要在数组的前一半元素中继续寻找关键字；
 * 
 * 2、如果关键字和中间元素相等，则匹配成功，查找结束；
 * 
 * 3、如果关键字大于中间元素，只需要在数组的后一半元素中继续寻找关键字；
 * 
 * @author Castle
 *
 */
public class ArraySearching_12 {

	public static void main(String[] args) {
		int[] myArray = { 2, 4, 7, 10, 11, 45, 50, 59, 60, 66, 69, 70, 79 };
		System.out.println(binarySearching(myArray, 3));
		System.out.println(binarySearching(myArray, 11));
		System.out.println(binarySearching(myArray, 50));
	}

	/**
	 * 课本上说返回 -head-1是比较好的，没理解，算了。
	 * 
	 * @param numbers
	 * @param key
	 * @return
	 */
	public static int binarySearching(int[] numbers, int key) {
		int result = -1;
		int head = 0;
		int tail = numbers.length - 1;
		// 假设数组从左到右升序排列
		while (tail >= head) {
			int middle = (head + tail) / 2;
			System.out.println("--------------" + middle);
			if (numbers[middle] == key) {
				result = middle;
				return result;
			} else if (numbers[middle] > key) {
				// 从前半部分查找
				tail = middle - 1;
			} else {
				// 从后半部分查找
				head = middle + 1;
			}
		}
		return result;
	}
}
