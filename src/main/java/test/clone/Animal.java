package test.clone;

public class Animal implements Cloneable {
	private String name;

	public Animal() {

	}

	public Animal(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Object myClone() throws CloneNotSupportedException {
		return super.clone();
	}

	protected void breath() {
		System.out.println("protected breath method...");
	}

	public void breath2() {
		System.out.println("public breath2 method....");
	}
}
