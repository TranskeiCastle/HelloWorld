package test.clone;

public class Example implements Cloneable {
	private int foo;
	private int[] bar;

	public Example() {

	}

	public Example(int foo, int[] bar) {
		super();
		this.foo = foo;
		this.bar = bar;
	}

	public int getFoo() {
		return foo;
	}

	public void setFoo(int foo) {
		this.foo = foo;
	}

	public int[] getBar() {
		return bar;
	}

	public void setBar(int[] bar) {
		this.bar = bar;
	}

	public static void main(String[] args) throws CloneNotSupportedException {
		Example e = new Example(1, new int[] { 1, 2 });
		Example e2 = (Example) e.clone();
		int[] intList = {5,6};
		e.setFoo(10);
		e.setBar(intList);
		System.out.println("in e, foo is: " + e.getFoo() + ", bar[0] is: " + e.getBar()[0]);
		System.out.println("in e2, foo is: " + e2.getFoo() + ", bar[0] is: " + e2.getBar()[0]);
	}

}
