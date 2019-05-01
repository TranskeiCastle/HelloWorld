package annotation;

/**
 * 程序定义了一个Base基类，该基类使用了@Inheritable修饰，则Base类的子类将会默认使用@Inheritable修饰
 * 
 * 把Base类的注解去掉，程序将输出false
 * 
 * @author Castle
 *
 */
public class InheritableTest extends Base {
	public void info() {
		System.out.println("Fruit's info()");
	}

	public static void main(String[] agrs) throws ClassNotFoundException {
		System.out.println(InheritableTest.class.isAnnotationPresent(Inheritable.class));
	}
}

@Inheritable
class Base {

}