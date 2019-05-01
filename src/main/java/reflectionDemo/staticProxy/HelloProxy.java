package reflectionDemo.staticProxy;

/**
 * HelloProxy 里面包含了一个 HelloImpl，以此达到扩展功能的目的。
 * @author Castle
 *
 */
public class HelloProxy implements Hello {

	private Hello h;
	public HelloProxy() {
		h = new HelloImpl();
	}

	@Override
	public void say(String who) {
		before();
		h.say(who);
		after();
	}
	
	public void before() {
		System.out.println("来了来了");
	}
	
	public void after() {
		System.out.println("走了走了");
	}

}
