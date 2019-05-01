package edu.bnuz;

public class InnerClass1_04 {
	private String describe = "成员内部类，非static。";

	public static void main(String[] args) {
		// 内部类是非static的，因此，创建内部类需要依靠外部类的实例
		InnerClass1_04 outter = new InnerClass1_04();
		InnerClass1_04.Printer inner = outter.new Printer();
		inner.print();
	}

	public class Printer {
		private String describe = "这是一个内部类";

		public void print() {
			System.out.println(describe);
			// 内部类引用外部类成员变量，不需要外部类实例
			System.out.println(InnerClass1_04.this.describe);
			System.out.println("Invoke inner class...");
		}
	}

	public String getDescribe() {
		return describe;
	}

	public void setDescribe(String describe) {
		this.describe = describe;
	}

}
