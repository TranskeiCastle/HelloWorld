/**
 * ClassName: ReflectionTest.java
 * Author: qiujy
 * CreateTime: 2009-4-12
 * EMAIL: qjyong@gmail.com
 * Copyright 2009 ++YONG All rights reserved.
 */
package reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

/** 用反射分析类信息 */
public class ReflectionTest {

    /**
     * 测试
     * 
     * @param args
     * @throws ClassNotFoundException
     */
    public static void main(String[] args) throws ClassNotFoundException {
        Class<?> clazz = Class.forName("java.util.ArrayList");
        printPackage(clazz);
        printClassName(clazz);
        printFields(clazz);
        printConstructors(clazz);
        printMethods(clazz);
        System.out.println("}");
    }

    /**
     * 打印包
     * 
     * @param clazz
     */
    public static void printPackage(Class<?> clazz) {
        String packageName = clazz.getPackage().getName();
        System.out.println("package " + packageName + ";\n");
    }

    /**
     * 打印类名
     * 
     * @param clazz
     */
    public static void printClassName(Class<?> clazz) {
        // 得到访问修饰符
        String modifier = Modifier.toString(clazz.getModifiers());
        System.out.print(modifier + " " + clazz.getName());
        // 得到父类
        Class<?> superClazz = clazz.getSuperclass();
        if (superClazz != null && !superClazz.equals(Object.class)) {
            System.out.print(" extends " + superClazz.getName());
        }
        // 获取所有实现的接口
        Class<?>[] interfaces = clazz.getInterfaces();
        if (interfaces.length > 0) {
            System.out.print(" implements ");
        }
        for (int i = 0; i < interfaces.length; i++) {
            if (i > 0) {
                System.out.print(",");
            }
            System.out.print(interfaces[i].getName());
        }

        System.out.println("　{");
    }

    /**
     * 输出所有构造方法的信息
     * 
     * @param clazz
     */
    public static void printConstructors(Class<?> clazz) {
        // 获取所有的构造方法
        Constructor<?>[] constrcutors = clazz.getDeclaredConstructors();
        for (Constructor<?> constructor : constrcutors) {
            String name = constructor.getName();// 得到构造方法名
            String modifier = Modifier.toString(constructor.getModifiers());// 得到访问修饰符
            System.out.print("    " + modifier + " " + name + "(");
            Class<?>[] paramTypes = constructor.getParameterTypes();// 得到方法的参数列表
            for (int i = 0; i < paramTypes.length; i++) {
                if (i > 0) {
                    System.out.print(", ");
                }
                if (paramTypes[i].isArray()) { // 处理参数类型为数组时的情况
                    System.out.println(paramTypes[i].getComponentType().getName() + "[]");
                } else {
                    System.out.print(paramTypes[i].getName());
                }
            }
            System.out.println(");");
        }
        System.out.println();
    }

    /**
     * 打印所有成员变量的信息
     * 
     * @param clazz
     */
    public static void printFields(Class<?> clazz) {
        // 获得所有的成员变量
        Field[] fields = clazz.getDeclaredFields();

        for (Field field : fields) {
            // 访问修饰符
            String modifier = Modifier.toString(field.getModifiers());
            // 数据类型
            Class<?> type = field.getType();
            // 字段名
            String name = field.getName();

            if (type.isArray()) { // 如果是数组类型要特别处理一下
                String arrType = type.getComponentType().getName() + "[]";
                System.out.println("    " + modifier + " " + arrType + " " + name + ";");
            } else {
                System.out.println("    " + modifier + " " + type + " " + name + ";");
            }
        }
        System.out.println();
    }

    /**
     * 打印所有的成员方法的信息
     * 
     * @param clazz
     */
    public static void printMethods(Class<?> clazz) {
        Method[] methods = clazz.getDeclaredMethods();// 获得所有的方法
        for (Method method : methods) { // 循环处理每个方法
            String modifier = Modifier.toString(method.getModifiers());// 访问修饰符

            Class<?> returnType = method.getReturnType();// 返回类型
            if (returnType.isArray()) { // 如果是数组类型要特别处理一下
                String arrType = returnType.getComponentType().getName() + "[]";
                System.out.print("    " + modifier + " " + arrType + " " + method.getName() + "(");
            } else {
                System.out.print("    " + modifier + " " + returnType.getName() + " " + method.getName() + "(");
            }

            Class<?>[] paramTypes = method.getParameterTypes();// 得到方法的参数Class数组
            for (int i = 0; i < paramTypes.length; i++) {
                if (i > 0) {
                    System.out.print(", ");
                }
                if (paramTypes[i].isArray()) { // 如果是数组类型要特别处理一下
                    System.out.print(paramTypes[i].getComponentType().getName() + "[]");
                } else {
                    System.out.print(paramTypes[i].getName());
                }
            }
            System.out.println(");");
        }
    }
}
