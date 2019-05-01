/**
 * ClassName: ReflectCreateArrayTest.java
 * Author: qiujy
 * CreateTime: 2009-4-12
 * EMAIL: qjyong@gmail.com
 * Copyright 2009 ++YONG All rights reserved.
 */
package reflection;

import java.lang.reflect.Array;

/** 利用反射动态创建数组的示例 */
public class ReflectCreateArrayTest {
	public static void main(String[] args) {
		Object obj = Array.newInstance(int.class, 5); //动态创建一个长度为5的int类型数组
		for(int i = 0; i< 5; i++){ //动态设置数组元素的值
			Array.setInt(obj, i, i * 10); 
		}
		for (int i = 0; i < 5; i++) { //动态获取数组元素的值
			System.out.println("第" + i + "号元素的值：" + Array.getInt(obj, i));
		}
	}

}
