package edu.bnuz;

import java.util.Random;

/**
 * 创建一个Random对象时，必须指定一个种子或者使用默认的种子。
 * 
 * 如果两个Random对象有相同的种子，那它们将产生相同的数列。
 * 
 * @author Castle
 *
 */
public class RandomUtil_16 {
	public static void main(String[] args) {
		Random random1 = new Random(5);
		System.out.print("From random1: ");
		for (int i = 0; i < 10; i++) {
			System.out.print(random1.nextInt(100) + "  ");
		}
		System.out.println();
		Random random2 = new Random(5);
		System.out.print("From random2: ");
		for (int i = 0; i < 10; i++) {
			System.out.print(random2.nextInt(100) + "  ");
		}
	}
}
