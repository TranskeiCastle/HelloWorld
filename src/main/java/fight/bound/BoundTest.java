package fight.bound;

import org.junit.Test;

public class BoundTest {
    @Test
    public void byteTest() {
        byte b = 10;
        // 反编译的结果是 b = (byte)(b + 1);
        b += 1;
        // 编译错误，b + 1 是整型，不允许赋值给一个 byte
        b = b + 1;
        System.out.println(b);
    }

    @Test
    public void byteTest2() {
        byte b = 127;
        // 编译错误Type mismatch: cannot convert from int to byte
        byte bb = 128;
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
}
