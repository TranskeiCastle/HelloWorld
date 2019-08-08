package fight.bound;

import org.junit.Test;

/**
 * 边界
 * @author Castle
 * @version 2019-08-08
 */
public class BoundTest {
    /**
     * += 其实是一种强制类型转换
     */
    @Test
    public void byteTest() {
        byte b = 10;
        // 反编译的结果是 b = (byte)(b + 1);
        b += 1;
        // 编译错误，b + 1 是整型，不允许赋值给一个 byte
        // b = b + 1;
        System.out.println(b);
    }

    /**
     * byte 的范围是 -128 到 127，所以 127 + 1 等于 -128
     */
    @Test
    public void byteTest2() {
        byte b = 127;
        // 编译错误Type mismatch: cannot convert from int to byte
        // byte bb = 128;
        // 允许
        b += 1;
        // -128
        System.out.println(b);
    }

    /**
     * i <= MAX 引起溢出。i等于MAX的时候，执行循环体，然后i++。完蛋。
     * 
     * 如果是i < MAX，循环体执行完毕，j自增到100。
     */
    @Test
    public void integerTest() {
        final int MAX = Integer.MAX_VALUE;
        final int start = MAX - 100;
        int j = 0;
        for (int i = start; i <= MAX; i++) {
            // System.out.println(i);
            j++;
        }
        System.out.println(j);
    }

    /**
     * 正无穷已经是一个概念了，不是一个数，所以加1不会越界。好比一群羊再加一只羊也没有问题
     */
    @Test
    public void infinityTest() {
        System.out.println(2.0 / 0); // Infinity
        System.out.println(-2.0 / 0); // -Infinity
        double positive = Double.POSITIVE_INFINITY;
        Double negative = Double.NEGATIVE_INFINITY;
        double p2 = positive + 1;
        // true, 正无穷与正无穷当然一样大咯
        System.out.println(positive == p2); 
        System.out.println(negative == (negative +1));
    }
}
