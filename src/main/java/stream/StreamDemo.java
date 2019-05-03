package stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.Test;

/**
 * https://blog.csdn.net/oliver__lau/article/details/78672222
 * 
 * @author BigBoss
 *
 */
public class StreamDemo {
    /**
     * Stream可以说是一个高级版本的Iterator，原始版本的Iterator，用户只能一个个的遍历元素并对其执行某些操作，高级版本的Stream，用户只需要给出需要对其包含的元素执行什么操作即可。
     * 
     * 
     * 得到 Stream 对象的方式，Stream类的
     * of()、generate()、iterate()静态方法，Collection接口的stream()默认方法，以及各种转换方法filter()distinct()map()skip()limit()
     */
    @Test
    public void streamDemo() {
        Stream.generate(Math::random).limit(10).forEach(System.out::println);
        Stream.iterate(1, item -> item + 1).limit(10).forEach(System.out::println);

        List<Integer> nums = Arrays.asList(1, 1, null, 2, 3, 4, null, 5, 6, 7, 8, 9, 10);

        System.out.println("sum is: " + nums.stream().filter(num -> num != null).distinct().mapToInt(num -> num * 2)
                .peek(System.out::println).skip(2).limit(4).sum());// sum is: 36
    }

    /**
     * Reduce Stream，放到一个集合里面
     */
    @Test
    public void streamDemo2() {
        List<Integer> nums = Arrays.asList(1, 1, null, 2, 3, 4, null, 5);
        List<Integer> numsWithoutNull = nums.stream().filter(num -> num != null).collect(() -> new ArrayList<Integer>(),
                (list, item) -> list.add(item), (list1, list2) -> list1.addAll(list2));
        numsWithoutNull.forEach(System.out::println);
        // 简化
        List<Integer> numsWithoutNull2 = nums.stream().filter(e -> e != null).collect(ArrayList::new, ArrayList::add, ArrayList::addAll);
        numsWithoutNull2.forEach(System.out::println);
        // 再简化
        List<Integer> numsWithoutNull3 = nums.stream().filter(e -> e != null).collect(Collectors.toList());
        numsWithoutNull3.forEach(System.out::println);
    }

    /**
     * Reduce Stream，对 Stream 再次计算
     */
    @Test
    public void streamDemo3() {
        List<Integer> ints = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        // 这个函数有两个参数，第一个参数是上次函数执行的返回值（也称为中间结果），第二个参数是stream中的元素，这个函数把这两个值相加，得到的和会被赋值给下次执行这个函数的第一个参数
        // ints sum is: 55
        System.out.println("ints sum is: " + ints.stream().reduce((sum, item) -> sum + item).get());
        // 它允许用户提供一个循环计算的初始值，如果Stream为空，就直接返回该值。而且这个方法不会返回Optional，因为其不会出现null值
        System.out.println("ints sum is: " + ints.stream().reduce(0, (sum, item) -> sum + item));
        System.out.println("ints count is: " + ints.stream().count());
        System.out.println(ints.stream().allMatch(item -> item < 100));
        System.out.println(ints.stream().anyMatch(item -> item > 100));
        System.out.println(ints.stream().noneMatch(item -> item == 100));
        ints.stream().max((e1,e2) -> e1.compareTo(e2)).ifPresent(System.out::println);
        // 应该是 mapToInt 以后有了特殊的统计函数可以使用
        IntSummaryStatistics data = ints.stream().mapToInt((e) -> e).summaryStatistics();
        System.out.println(data.getMax());
        System.out.println(data.getMin());
        System.out.println(data.getAverage());
    }
}
