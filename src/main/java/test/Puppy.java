package test;

/**
 * 为什么需要无参方法
 * @author Castle
 *
 */
class Base {
    /*public Base() {
        
    }*/

    public Base(String s) {
        System.out.print("B");
    }
}

public class Puppy extends Base {
    public Puppy(String s) {
        System.out.print("D");
    }

    public static void main(String[] args) {
        new Puppy("C");
    }
}