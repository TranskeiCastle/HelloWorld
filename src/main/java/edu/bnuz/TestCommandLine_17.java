package edu.bnuz;

/**
 * 命令行参数：计算器
 * 
 * @author Castle
 *
 */
public class TestCommandLine_17{
	public static void main(String[] args) {
		if (args.length != 3) {
			System.out.println("Usage: java TestCommandLine_17 operand1 operator operand2");
			System.exit(0);
		}

		int result = 0;
		switch (args[1].charAt(0)) {
		case '+':
			result = Integer.parseInt(args[0]) + Integer.parseInt(args[2]);
			break;
		case '-':
			result = Integer.parseInt(args[0]) - Integer.parseInt(args[2]);
			break;
		case '*':
			result = Integer.parseInt(args[0]) * Integer.parseInt(args[2]);
			break;
		case '/':
			result = Integer.parseInt(args[0]) / Integer.parseInt(args[2]);
			break;
		}
		System.out.println(args[0] + ' ' + args[1] + ' ' + args[2] + " = " + result);
	}
}
