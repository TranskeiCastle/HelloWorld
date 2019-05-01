package reflectionDemo.reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

public class MyLoader {
	int age = 6;
	
	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public void p(String str) {
		System.out.println(str);
	}

	public void p() {
		System.out.println("no args");
	}

	public static void main(String[] args) throws Exception {
		Class<?> clazz = Class.forName("reflect.MyLoader");
		// 调用无参构造方法
		Object instance = clazz.newInstance();
		Method methodNoArgs = clazz.getDeclaredMethod("p");
		Method methodWithArgs = clazz.getDeclaredMethod("p", String.class);
		// 调用方法
		methodNoArgs.invoke(instance);
		methodWithArgs.invoke(instance, "hehe");
		// 根据参数列表调用特定构造方法
		Constructor<?> constructor = clazz.getConstructor();
		Object obj = constructor.newInstance();
		System.out.println(((MyLoader)obj).getAge()==(((MyLoader)instance).getAge()));
	}
}