package test.clone;

/**
 * Dog实例不可以调用 Object 类的clone方法
 * 
 * @author Castle
 *
 */
public class DogTest {

	public static void main(String[] args) {
		Dog puppy = new Dog();
		puppy.breath();
		puppy.play();
		// The method clone() from the type Object is not visible
		// puppy.clone();
		// test.Dog
		System.out.println(puppy.getClass().getName());
		// test.Animal
		System.out.println(puppy.getClass().getSuperclass().getName());
		// java.lang.Object
		System.out.println(puppy.getClass().getSuperclass().getSuperclass().getName());

	}

}
