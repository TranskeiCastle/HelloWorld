package reflectionDemo.staticProxy;

public class HelloImpl implements Hello {

	@Override
	public void say(String who) {
		System.out.println("你好哇，" + who);
	}

}
