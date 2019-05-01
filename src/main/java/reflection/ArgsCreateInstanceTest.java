/**
 * ClassName: ArgsCreateInstanceTest.java
 * Author: qiujy
 * CreateTime: 2009-4-12
 * EMAIL: qjyong@gmail.com
 * Copyright 2009 ++YONG All rights reserved.
 */
package reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Date;

/** 利用反射使用指定带参构造方法创建指定名称类的对象 */
public class ArgsCreateInstanceTest {

    public static void main(String[] args) {
        try {
            // 加载指定名称的类,获取对应的Class对象,
            Class<?> clazz = Class.forName("java.util.Date");
            // 获取具有指定参数类型的构造方法
            Constructor<?> constructor = clazz.getConstructor(long.class);
            // 给指定的构造方法传入参数值,创建出一个对象
            Date date = (Date) constructor.newInstance(123456789000L);
            System.out.println(date);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SecurityException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }
}
