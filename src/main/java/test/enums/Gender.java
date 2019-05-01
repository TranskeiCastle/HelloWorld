package test.enums;

public enum Gender implements GenderDesc {
	// 此处的枚举值必须调用对应的构造方法创建
	MALE("男"), FEMALE("女");
	private final String name;

	// 枚举类的构造方法只能使用private修饰
	private Gender(String name) {
		this.name = name;
	}

	public String getName() {
		return this.name;
	}

	public void info() {
		System.out.println("do something...");
	}
	public static void main(String[] args) {
		Gender.MALE.info();
		Gender.MALE.print();
		GenderDesc.print2();
	}
}