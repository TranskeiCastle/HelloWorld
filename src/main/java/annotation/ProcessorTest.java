package annotation;

import java.lang.reflect.Method;

/**
 * 关联类： Testable / MyTest / ProcessorTest
 * 
 * 输出：m1 m3 m5 m7 执行成功的方法数：4 执行失败的方法数： 0 总共方法数： 4
 * 
 * 即程序中@Testable起作用了，有@Testable注解的方法都执行了
 * 
 * @author Castle
 *
 */
public class ProcessorTest {
	public static void process(String clazz) throws ClassNotFoundException {
		int passed = 0;
		int failed = 0;
		for (Method m : Class.forName(clazz).getMethods()) {
			if (m.isAnnotationPresent(Testable.class)) {
				try {
					m.invoke(null);
					passed++;
				} catch (Exception ex) {
					System.out.println("方法" + m + "运行失败，原因： " + ex.getCause());
					failed++;
				}
			}
		}
		System.out.println("执行成功的方法数：" + passed);
		System.out.println("执行失败的方法数： " + failed);
		System.out.println("总共方法数： " + (passed + failed));
	}

	public static void main(String[] args) throws ClassNotFoundException {
		// full quality name of class
		ProcessorTest.process("test.annotation.MyTest");
	}
}
