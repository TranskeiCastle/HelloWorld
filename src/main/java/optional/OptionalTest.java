package optional;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.junit.Test;

/**
 * 
 * @author Castle
 *
 */
public class OptionalTest {
    /**
     * 非空打印，空用零代替
     * 
     * Optional<Integer> op = Optional.ofNullable(99);
     *
     * 仅仅是System.out.println(op);意义不大，它会输出 Optional[99]
     * 
     * 如果是System.out.println(op.orElse(-1);就会在op有值的时候打印op的值；在op是null的时候打印-1
     */
    @Test
    public void optionalTest() {
        Integer[] ints = { 1, 2, 3, null, 5, 6, 7 };

        for (int i = 0; i < ints.length; i++) {
            Optional<Integer> o = Optional.ofNullable(ints[i]);
            System.out.println(o.orElse(0));
        }

        Arrays.stream(ints).forEach(e -> {
            Optional<Integer> o = Optional.ofNullable(e);
            System.out.println(o.orElse(0));
        });
    }

    @Test
    public void optionalTest2() {
        String s1 = "runoob";
        String s2 = "runoob";
        // 因为在 Java 中 + 操作法的优先级大于 ==，所以输出部分表达式等于 “s1 == s2 is:runoob” ==
        // “runoob”，该表达式计算结果为 false
        System.out.println("s1 == s2 is:" + s1 == s2);
    }

    /**
     * Optional -> List/Set
     */
    @Test
    public void optionalTest3() {
        Optional<String> op = Optional.of("puppy");
        List<String> list = op.map(Collections::singletonList).orElse(Collections.emptyList());
        Set<String> set = op.map(Collections::singleton).orElse(Collections.emptySet());
    }

    /**
     * TODO 暂时理解不了 Optional 的 flatMap()方法和map()方法
     * 
     * flatMap()方法和map()类似，不同点是，map可以返回任意类型，系统会自动包装为Optional，但是flatMap必须返回Optional，系统不会自动做包装。
     * 
     * map()： 有值怎么处理，null值怎么处理
     */
    @Test
    public void optionalTest4() {
        Optional<String> op = Optional.ofNullable("puppy");
        Optional<String> newName = op.map(v -> v.toUpperCase());
        Optional<String> newName2 = op.flatMap((value) -> Optional.of(value.toUpperCase()));
        System.out.println(newName.orElse("404"));
        System.out.println(newName2.orElse("500"));

        String[] languages = { "c", "js", "html", null };
        Arrays.stream(languages).forEach(e -> {
            Optional<String> opt = Optional.ofNullable(e);
            System.out.println(opt.map(ele -> ele.toUpperCase()).orElse("unknow"));
        });
    }
}
