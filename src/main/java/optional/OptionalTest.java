package optional;

import java.util.Optional;

import org.junit.Test;

public class OptionalTest {
    /**
     * 好像没法写出“非空打印，空用零代替”？
     */
    @Test
    public void f() {
        Integer[] ints = { 1, 2, 3, null, 5, 6, 7 };
        for (int i = 0; i < ints.length; i++) {
            Optional<Integer> o = Optional.ofNullable(ints[i]);
            o.ifPresent(System.out::println);
        }
    }

    @Test
    public void f2() {
        String s1 = "runoob";
        String s2 = "runoob";
        // 因为在 Java 中 + 操作法的优先级大于 ==，所以输出部分表达式等于 “s1 == s2 is:runoob” ==
        // “runoob”，该表达式计算结果为 false
        System.out.println("s1 == s2 is:" + s1 == s2);
    }
}
