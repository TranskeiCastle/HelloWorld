package lambdaMethodRef;

import java.util.Arrays;
import java.util.List;

import javax.swing.JFrame;

import org.junit.Test;

public class MethodRef {
    /**
     * 调用 PrintUtil 的方法
     */
    @Test
    public void myFunction() {
        List<String> strList = Arrays.asList("A", "B", "C");
        strList.forEach(System.out::println);
        strList.forEach(c -> PrintUtil.addStr(c));
        // 上面 Lambda 表达式的代码块只有一行调用类方法的代码，可以使用“类方法引用”替换
        strList.forEach(PrintUtil::addStr);
        strList.forEach(c -> new PrintUtil().addString(c));
        // 上面 Lambda 表达式的代码块只有一行调用实例方法的代码，可以使用“实例方法引用”替换
        strList.forEach(new PrintUtil()::addString);
    }

    /**
     * 方法引用：引用类方法，static
     */
    @Test
    public void myTest() {
        Convert c = str -> Integer.valueOf(str);
        System.out.println(c.convert("99"));
        Convert con = Integer::valueOf;
        System.out.println(con.convert("99"));
    }

    /**
     * 方法引用：引用特定对象的实例方法
     */
    @Test
    public void myTest2() {
        Convert c = e -> "acer".indexOf(e);
        System.out.println(c.convert(new String("A")));
        Convert con = new String("Apple")::indexOf;
        System.out.println(con.convert("A"));
    }

    /**
     * 引用某个类对象的实例方法
     */
    @Test
    public void myTest3() {
        ConvertBeta c = (str, a, b) -> str.substring(a, b);
        String str = "Macbook";
        System.out.println(c.convert(str, 0, 4));
        ConvertBeta con = String::substring;
        System.out.println(con.convert("Macbook", 0, 3));
    }

    /**
     * 引用构造器
     */
    @Test
    public void myTest4() {
        // 也可以是 (String e)，我们要用最简洁的~
        ConvertGamma c = e -> new JFrame(e);
        c.win("我的世界");
        System.out.println(c);
        ConvertGamma con = JFrame::new;
        con.win("老人与海");
        System.out.println(con);
    }
    
    /**
     * 调用 Arrays 的类方法
     */
    @Test
    public void lambdaArrays() {
        String[] arr1 = new String[] { "go", "Ruby", "iOS", "Java", "Python", "Android" };
        Arrays.parallelSort(arr1, (o1, o2) -> o1.length() - o2.length());
        System.out.println(Arrays.toString(arr1));

        int[] arr2 = new int[] { 2, 1, 0, 3 };
        // left 代表代表数组中前一个索引处的元素，计算第一个元素时，left为1
        // right 代表数组中当前索引处的元素
        Arrays.parallelPrefix(arr2, (left, right) -> left + right);
        System.out.println(Arrays.toString(arr2));
        
        long[] arr3 = new long[5];
        // idx 代表正在计算的元素索引
        Arrays.parallelSetAll(arr3, idx -> idx * 5);
        System.out.println(Arrays.toString(arr3));
    }
}
