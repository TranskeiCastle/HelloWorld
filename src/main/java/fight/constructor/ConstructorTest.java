package fight.constructor;

/**
 * Base 为什么需要无参方法
 * 
 * @author 
 *
 *
 *         当构造一个子类对象时，子类构造方法在完成自己的任务之前，会首先调用它的父类的构造方法。如果父类继承自其它类，那么父类构造方法又会在完成自己的任务之前，调用它自己的父类的构造方法，这个过程将持续到调用这个继承体系结构的最后一个构造方法(来自最基本的类)被调用为止。
 *         构造方法可以调用重载的构造方法或它的父类的构造方法。如果它们都没有显式地调用，编译器就会自动地将super()作为构造方法的第一条语句。
 *         如果一个类要设计为扩展的，最好提供一个无参构造方法以避免程序设计错误。 Implicit super constructor
 *         Base() is undefined for default constructor. Must define an explicit
 *         constructor
 */
class Base {
    public Base() {
        System.out.println("我是无参构造方法");
    }

    public Base(String s) {
        System.out.print("B");
    }
}

public class ConstructorTest extends Base {
    public ConstructorTest(String s) {
        System.out.print("D");
    }

    public static void main(String[] args) {
        new ConstructorTest("C");
        // 我是无参构造方法
        // D
    }
}