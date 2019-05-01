package test.enums;

public enum Operation {
	PLUS {
		public double eval(double x, double y) {
			return x + y;
		}
	},
	MINUS {
		public double eval(double x, double y) {
			return x - y;
		}
	},
	TIMES {
		public double eval(double x, double y) {
			return x * y;
		}
	},
	DIVIDE {
		public double eval(double x, double y) {
			return x / y;
		}
	};
	// 这个抽象方法由不同的枚举值提供不同的实现
	public abstract double eval(double x, double y);

	public static void main(String[] args) {
		System.out.println(Operation.PLUS.eval(3, 4));
		System.out.println(Operation.MINUS.eval(56, 8));
	}
}