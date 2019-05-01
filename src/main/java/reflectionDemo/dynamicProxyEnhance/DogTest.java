package reflectionDemo.dynamicProxyEnhance;

public class DogTest {
	public static void main(String[] args) {
		Dog dog = new DynamicInvocationHandler(new Puppy()).getProxy();
		dog.info();
	}
}