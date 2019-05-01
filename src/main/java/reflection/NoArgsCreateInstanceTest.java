/**
 * ClassName: NoArgsCreateInstanceTest.java
 * Author: qiujy
 * CreateTime: 2009-4-12
 * EMAIL: qjyong@gmail.com
 * Copyright 2009 ++YONG All rights reserved.
 */
package reflection;

import java.util.Date;

/** 使用反射机制调用无参构造方法创建指定名称类的对象 */
public class NoArgsCreateInstanceTest {

	public static void main(String[] args) {
		Date currentDate = (Date)newInstance("java.util.Date");
		System.out.println(currentDate);
	}

	public static Object newInstance(String className){
		Object obj = null;
		try {
			//加载指定名称的类,获取对应的Class对象,然后调用无参构造方法创建出一个对象
			obj = Class.forName(className).newInstance();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return obj;
	}
}
