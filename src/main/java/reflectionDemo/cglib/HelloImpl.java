package reflectionDemo.cglib;

public class HelloImpl extends Hello {

	@Override
	void sayHello(String name) {
		System.out.println("你好哇 " + name);
	}
}
