package reflectionDemo.staticProxy;

public class Test {
	public static void main(String[] args) {
		Hello hi = new HelloProxy();
		hi.say("Castle");
	}
}
