package stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
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
     * of()、generate()、iterate()静态方法，Collection接口的stream()默认方法，以及各种转换方法concat()filter()distinct()map()skip()limit()
     * 
     * map() 我感觉就是对每个元素做一次统一变换，比如都乘以2啊，都加上3啊这样
     * 
     * filter() 接受的参数是一个 Predicate，返回布尔值
     * 
     * reduce 的意思是减少，将所有值合成一个，reduce操作又叫折叠操作——接收多个值返回一个值
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
        ints.stream().max((e1, e2) -> e1.compareTo(e2)).ifPresent(System.out::println);
        // 应该是 mapToInt 以后有了特殊的统计函数可以使用。summaryStatistics 描述流中元素的各种摘要数据
        IntSummaryStatistics data = ints.stream().mapToInt((e) -> e).summaryStatistics();
        System.out.println(data.getMax());
        System.out.println(data.getMin());
        System.out.println(data.getAverage());
    }

    /**
     * Predicate
     */
    @Test
    public void streamDemo4() {
        List<String> languages = Arrays.asList("Java", "Scala", "C++", "Haskell", "Lisp");
        // Predicate 要给出泛型类型，不然编译器会使用 Object 类型，Object 没有 startsWith()
        Predicate<String> pre1 = (str) -> str.startsWith("J");
        Predicate<String> pre2 = (str) -> str.length() == 4;
        // 以“J”打头，并且长度为4
        languages.stream().filter(pre1.and(pre2)).forEach(System.out::println);
    }

    /**
     * lambda表达式有个限制，那就是只能引用 final 或 final 局部变量，这就是说不能在lambda内部修改定义在域外的变量。
     * 
     * compile time error: "local variables referenced from a lambda expression must
     * be final or effectively final"
     */
    @Test
    public void streamDemo5() {
        List<Integer> primes = Arrays.asList(new Integer[] { 2, 3, 5, 7 });
        int factor = 2;
        primes.forEach(element -> {
            // factor++;
        });

        // 只是访问它而不作修改是可以的：
        List<Integer> primesBeta = Arrays.asList(new Integer[] { 2, 3, 5, 7 });
        int factor2 = 2;
        primesBeta.forEach(element -> {
            System.out.println(factor2 * element);
        });
    }

    /**
     * 数组转成 Stream
     */
    @Test
    public void streamDemo6() {
        int ids[] = new int[] { 1, 2, 3, 4 };
        Arrays.stream(ids).forEach(System.out::println);
    }

    /**
     * 分割数据
     */
    @Test
    public void streamDemo7() {
        Map<Boolean, List<Integer>> collectParti = Stream.of(1, 2, 3, 4).collect(Collectors.partitioningBy(it -> it % 2 == 0));
        // 打印结果 collectParti : {false=[1, 3], true=[2, 4]}
        System.out.println("collectParti : " + collectParti);

        Map<Boolean, List<Integer>> collectGroup = Stream.of(1, 2, 3, 4).collect(Collectors.groupingBy(it -> it > 3));
        // 打印结果 collectGroup : {false=[1, 2, 3], true=[4]}
        System.out.println("collectGroup : " + collectGroup);
    }

    /**
     * 字符处理，Joining函数接受三个参数，分别表示分隔符（用以分隔多个元素）、前缀和后缀
     */
    @Test
    public void streamDemo8() {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        StringBuilder sb = new StringBuilder();
        for (Integer it : list) {
            if (sb.length() > 0) {
                sb.append(",");
            }
            sb.append(it);
        }
        // 1,2,3,4
        System.out.println(sb.toString());
        System.out.println(Stream.of("1", "2", "3", "4").collect(Collectors.joining(",", "[", "]")));
    }

    /**
     * 分组后列表的个数。Map，然后使用list.size（）
     * 
     * 在partitioningBy方法中，有这么一个变形：在partitioningBy方法中，我们不仅传递了条件函数，同时传入了第二个收集器，用以收集最终结果的一个子集，这些收集器叫作下游收集器。收集器是生成最终结果的一剂配方，下游收集器则是生成部分结果的配方，主收集器中会用到下游收集器。这种组合使用收集器的方式，
     * 使得它们在 Stream 类库中的作用更加强大。
     * 
     * 那些为基本类型特殊定制的函数，如averagingInt、summarizingLong等，事实上和调用特殊Stream上的方法是等价的，加上它们是为了将它们当作下游收集器来使用的。
     */
    @Test
    public void streamDemo9() {
        // 分割数据块
        Map<Boolean, List<Integer>> collectParti = Stream.of(1, 2, 3, 4).collect(Collectors.partitioningBy(it -> it % 2 == 0));
        Map<Boolean, Integer> mapSize = new HashMap<>();
        collectParti.entrySet().forEach(entry -> mapSize.put(entry.getKey(), entry.getValue().size()));

        // mapSize : {false=2, true=2}
        System.out.println("mapSize : " + mapSize);

        Map<Boolean, Long> partiCount = Stream.of(1, 2, 3, 4)
                .collect(Collectors.partitioningBy(it -> it.intValue() % 2 == 0, Collectors.counting()));
        // partiCount: {false=2, true=2}
        System.out.println("partiCount: " + partiCount);
    }
}
