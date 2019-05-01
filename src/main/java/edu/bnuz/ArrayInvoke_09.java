package edu.bnuz;

public class ArrayInvoke_09 {
	public static void main(String[] args) {
		int[] myArray = { 2, 0, 1, 6 };
		int[] newArray = reverse(myArray);
		for (int i: newArray) {
			System.out.println(i);
		}
	}

	// reverse an array
	public static int[] reverse(int[] list) {
		int[] result = new int[list.length];
		for (int i = 0, j = list.length - 1; i < list.length; i++, j--) {
			result[i] = list[j];
		}
		return result;
	}
}
