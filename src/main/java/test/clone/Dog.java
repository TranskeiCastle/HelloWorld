package test.clone;

/**
 * Dog实例可以调用 Object 类的clone方法
 * 
 * @author Castle
 *
 */
public class Dog extends Animal {
	public Dog() {
	}

	protected void play() {
		System.out.println("protected 玩个球。。。");
	}

	public void play2() {
		System.out.println("public 玩个球。。。");
	}

	public static void main(String[] args) {
		Dog dog = new Dog();
		dog.breath();
		dog.breath2();
		// test.Dog
		System.out.println(dog.getClass().getName());
		// test.Animal
		System.out.println(dog.getClass().getSuperclass().getName());
	}
}
