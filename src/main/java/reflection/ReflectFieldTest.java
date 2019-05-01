/**
 * ClassName: ReflectFieldTest.java
 * Author: qiujy
 * CreateTime: 2009-4-12
 * EMAIL: qjyong@gmail.com
 * Copyright 2009 ++YONG All rights reserved.
 */
package reflection;

import java.lang.reflect.Field;

/**利用反射来动态获取或设置指定对象的指定成员变量的值 */
public class ReflectFieldTest {
	public static void main(String[] args) {
		try {
		    Class<?> c = Class.forName("com.qiujy.corejava15.Product");
		    //使用无参构造方法创建对象
		    Product prod = (Product)c.newInstance();
		    //调用私有属性
		    Field idField = c.getDeclaredField("id");
		    idField.setAccessible(true); //取消对本字段的访问检查
		    idField.setLong(prod, 100); //设置prod对象的"idField"成员变量的值为100
		    //获取prod对象的"idField"成员变量的值
		    System.out.println("id=" + idField.getLong(prod));
		    Field nameField = c.getDeclaredField("name");
		    nameField.setAccessible(true);
		    nameField.set(prod, "张三");
		    System.out.println("name=" + nameField.get(prod));
		} catch (ClassNotFoundException e) {
		    e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (SecurityException e) {
			e.printStackTrace();
		} catch (NoSuchFieldException e) {
			e.printStackTrace();
		}
	}
}