/**
 * ClassName: ReflectInvokeMethodTest.java
 * Author: qiujy
 * CreateTime: 2009-4-12
 * EMAIL: qjyong@gmail.com
 * Copyright 2009 ++YONG All rights reserved.
 */
package reflection;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/** 利用反射来动态调用指定类的指定方法 */
public class ReflectInvokeMethodTest {
    public static void main(String[] args) {
        try {
            Class<?> clazz = Class.forName("reflection.Product");
            // 利用无参构造方法创建一个Product的对象
            Product prod = (Product) clazz.newInstance();

            // 获取名为setName,带一个类型为String的成员方法所对应的对象代表
            Method method1 = clazz.getDeclaredMethod("setName", String.class);
            // 在prod对象上调用setName,并传值给它,返回值是空
            Object returnValue = method1.invoke(prod, "爪哇");
            System.out.println("返回值：" + returnValue);

            // 获取名为displayInfo,不带参数的成员方法所对应的对象代表
            Method method2 = clazz.getDeclaredMethod("displayInfo");
            method2.setAccessible(true);
            // 在prod对象上调用displayInfo方法
            method2.invoke(prod);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SecurityException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }
    }
}

class Product {
    private static long count = 0;
    private long id;
    private String name = "无名氏";

    public Product() {
        System.out.println("默认的构造方法");
        id = ++count;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        System.out.println("调用setName方法");
        this.name = name;
    }

    private void displayInfo() { // 私有方法
        System.out.println(getClass().getName() + "[id=" + id + ",name=" + name + "]");
    }
}
