package edu.bnuz;

/**
 * 调用方法：静态类名字.静态方法名；实例名字.实例方法名。 静态方法里调用的方法、变量也需要是静态的。
 * 
 * @author Castle
 * @date 2016-09-10
 *
 */
public class MethodInvoke_03 {
	public static void main(String[] agrs) {
		int intA = 5;
		int intB = 30;
		double doubleA = 2.0;
		double doubleB = 24.0;
		// 这个实例将用于避免编译错误：Cannot make a static reference to the non-static method
		MethodInvoke_03 invoke = new MethodInvoke_03();
		// 静态方法可以直接调用，因为在同一类里，连类名都省了
		System.out.println("the bigger Int is " + max(intA, intB));
		// 实例方法需要实例名字.实例方法名
		System.out.println("the bigger Double is " + invoke.max(doubleA, doubleB));
	}

	public static int max(int m, int n) {
		return m >= n ? m : n;
	}

	public double max(double m, double n) {
		return m >= n ? m : n;
	}
	
	// TODO 竟然可以比较，不是说方法执行完马上销毁嘛？
	
}
