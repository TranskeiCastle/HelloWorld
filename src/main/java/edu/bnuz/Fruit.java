package edu.bnuz;

/**
 * 构造方法链
 * 
 * 当构造一个子类对象时，子类构造方法在完成自己的任务之前，会首先调用它的父类的构造方法。
 * 
 * 如果父类继承自其它类，那么父类构造方法又会在完成自己的任务之前，
 * 调用它自己的父类的构造方法，这个过程将持续到调用这个继承体系结构的最后一个构造方法(来自最基本的类)被调用为止。
 * 
 * @author Castle
 *
 */
public class Fruit {

	public Fruit(String name) {
		System.out.println("Fruit's constructor is invoked");
	}
}

class Apple extends Fruit {

	public Apple(String name) {
		super(name);
		System.out.println("I'm apple");
	}

}
