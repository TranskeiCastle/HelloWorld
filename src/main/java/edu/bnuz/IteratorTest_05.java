package edu.bnuz;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class IteratorTest_05 {
	public static void main(String[] args) {
		List<Integer> list = new ArrayList<Integer>();
		for (int i = 0; i <= 9; i++) {
			list.add(i);
		}
		for (int i = 0; i <= list.size() - 1; i++) {
			System.out.println("element: " + list.get(i));
		}
		Iterator<Integer> it = list.iterator();
		while (it.hasNext()) {
			int i = it.next();
			System.out.println(i);
			it.remove();
		}
		System.out.println("remain length: " + list.size());
	}
}
