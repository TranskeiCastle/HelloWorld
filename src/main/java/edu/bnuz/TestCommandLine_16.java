package edu.bnuz;

/**
 * 在命令行下编译运行该程序，执行java TestCommandLine_16 * 之后可以打印该目录下的所有文件
 * 
 * 编译方法：
 * 
 * 1、javac -d . TestCommandLine_16.java
 * 
 * 2、java edu.bnuz.TestCommandLine_16 *
 * 
 * @author Castle
 *
 */
public final class TestCommandLine_16 {

	public static void main(String[] args) {
		for (int i = 0; i < args.length; i++) {
			System.out.println(args[i]);
		}
	}
}
