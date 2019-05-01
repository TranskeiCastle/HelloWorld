package lambdaDemo;

import org.junit.Test;

public class LambdaDemo {
    public void eat(Eatable eat) {
        eat.eat();
    }

    public void fly(Flyable fly) {
        // "sunny"并不会出现在控制台，这个语句并没有输出
        fly.fly("sunny");
    }

    public void add(Addable ad) {
        // 这个语句对控制台输出了
        System.out.println("3+5= " + ad.add(3, 5));
    }

    /**
     * 没有参数、一个参数、两个参数的 Lambda 写法
     */
    @Test
    public void myMethod() {
        LambdaDemo l = new LambdaDemo();
        // 看 l.eat() 的方法签名void test.LambdaDemo.eat(Eatable eat)，
        // 可以知道 Lambda 表达式的目标类型是 Eatable，函数式接口只能有一个抽象方法。
        l.eat(() -> System.out.println("加个鸡腿"));
        l.fly(e -> System.out.println("..."));
        l.add((a, b) -> a + b);
    }
}

interface Eatable {
    void eat();
}

interface Flyable {
    void fly(String weather);
}

interface Addable {
    int add(int a, int b);
}