/**
 * ClassName: ReflectArrayTest.java
 * Author: qiujy
 * CreateTime: 2009-4-12
 * EMAIL: qjyong@gmail.com
 * Copyright 2009 ++YONG All rights reserved.
 */
package reflection;

/** 反射获取数组信息 */
public class ReflectArrayTest {

	public static void main(String[] args) {
		short[] sArr = new short[5]; //创建数组
        int[] iArr = new int[5]; 
        long[] lArr = new long[5]; 
        float[] fArr = new float[5]; 
        double[] dArr = new double[5]; 
        byte[] bArr = new byte[5]; 
        boolean[] zArr = new boolean[5]; 
        String[] strArr = new String[5]; 
        System.out.println("short 数组类：" + sArr.getClass().getName()); //直接获取数组的类型名
        System.out.println("int 数组类：" + iArr.getClass().getName()); 
        System.out.println("long 数组类：" + lArr.getClass().getName()); 
        System.out.println("float 数组类：" + fArr.getClass().getName()); 
        System.out.println("double 数组类：" + dArr.getClass().getName()); 
        System.out.println("byte 数组类：" + bArr.getClass().getName()); 
        System.out.println("boolean 数组类：" + zArr.getClass().getName()); 
        System.out.println("String 数组类：" + strArr.getClass().getName());
        System.out.println("=====================");
        //通过getComponentType()方法获取此数组类型的Class,再获取它的全限定名
        System.out.println("short 数组类：" + sArr.getClass().getComponentType().getName());
        System.out.println("int 数组类：" + iArr.getClass().getComponentType().getName()); 
        System.out.println("long 数组类：" + lArr.getClass().getComponentType().getName()); 
        System.out.println("float 数组类：" + fArr.getClass().getComponentType().getName()); 
        System.out.println("double 数组类：" + dArr.getClass().getComponentType().getName()); 
        System.out.println("byte 数组类：" + bArr.getClass().getComponentType().getName()); 
        System.out.println("boolean 数组类：" + zArr.getClass().getComponentType().getName()); 
        System.out.println("String 数组类：" + strArr.getClass().getComponentType().getName());
	}

}
