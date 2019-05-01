package test.enums;

public interface GenderDesc {
	void info();
	// Java 8 新增：在接口中定义默认方法，必须使用default修饰符
	default void print() {
		System.out.println("default method...");
	}
	// Java 8 新增：在接口中定义类方法，必须使用static修饰符
	static void print2() {
		System.out.println("static method...");
	}
}
