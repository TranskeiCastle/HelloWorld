package test.lambda;

/**
 * Lambda表达式根据形参列表确定实现了哪个函数式接口的实例
 * 
 * @author Castle
 *
 */
public class LambdaQs {
	public void eat(Eatable e) {
		System.out.println(e);
		e.taste();
	}

	public void drive(Flyable f) {
		System.out.println("driving..." + f);
		f.fly("sunny");
	}

	public void testAdd(Addable add) {
		System.out.println("5 + 3 = " + add.add(5, 3));
	}

	public static void main(String[] args) {
		LambdaQs lambdaQs = new LambdaQs();
		// 面向Eatable接口编程，这里需要一个实例，并且它要实现Eatable接口
		// Lambda表达式的代码块只有一条语句，可以省略花括号
		lambdaQs.eat(() -> System.out.println("好吃到哭出来~~"));

		// Lambda 表达式的形参列表只有一个形参，可以省略圆括号
		lambdaQs.drive(weather -> {
			System.out.println("It's a good day...");
			System.out.println("other statement...");
		});

		// 代码块中只有1条语句，即使该表达式需要返回值，也可以省略return关键字
		lambdaQs.testAdd((a, b) -> (a + b));
		// 有return关键字就必须使用大括号
		// lambdaQs.testAdd((a, b) -> {
		// return a + b;
		// });
		// lambdaQs.testAdd((a, b) -> (return (a + b)));
	}

}

interface Eatable {
	void taste();
}

interface Flyable {
	void fly(String weather);
}

interface Addable {
	int add(int a, int b);
}