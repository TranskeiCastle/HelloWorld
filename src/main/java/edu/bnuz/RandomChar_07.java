package edu.bnuz;

/**
 * 每个字符都有一个唯一的在十六进制数0到FFFF（即十进制的65535）之间的同一码。
 * 
 * 生成一个随机字符就是生成一个从0到65535之间的随机整数。因为0<=Math.random()<1.0，必须给65535加上1。
 * 
 * @author Castle
 *
 */
public class RandomChar_07 {
	public static void main(String[] args) {
		System.out.println("random int: " + (int) (Math.random() * (65535 + 1)));
		// (int)((int) 'a' + Math.random() * ((int)'z' - (int)'a' +1)
		System.out.println("random lower case char: " + (char) ('a' + Math.random() * ('z' - 'a' + 1)));
		System.out.println("random upper case char: " + (char) ('A' + Math.random() * ('Z' - 'A' + 1)));
		for(int i = 0; i < 50; i++) {
			System.out.print(RandomChar_07.getRandomCharacter('0', '9'));;
		}
	}
	
	public static char getRandomCharacter(char char1, char char2) {
		char result;
		result = (char) (char1 + Math.random() * (char2 - char1 + 1));
		return result;
	}
}
