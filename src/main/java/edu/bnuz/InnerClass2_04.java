package edu.bnuz;

public class InnerClass2_04 {
	// static类型的内部类，不能访问外部类中的非static成员——外部类的非static成员必须依附于具体的对象
	private static String describe = "成员内部类，static。";

	public static void main(String[] args) {
		// 内部类是static的，因此，创建内部类不需要外部类的实例
		InnerClass2_04.Printer inner = new InnerClass2_04.Printer();
		inner.print();
	}

	public static class Printer {

		public void print() {

			System.out.println(describe);
			System.out.println("Invoke inner class...");
		}
	}

}
