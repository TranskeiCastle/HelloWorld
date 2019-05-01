package lambdaDemo;

import org.junit.Test;

public class LambdaInInnerClass {

    /**
     * Lambda 表达式简化内部类写法
     */
    @Test
    public void myTest() {

        int[] ints = { 1, 2, 3, 4 };
        ProcessArray pa = new ProcessArray();
        // 调用一个已经存在的Command实现类
        pa.process(ints, new PrintCommand());
        pa.process(ints, new AddCommand());
        // 使用传统的匿名内部类实现
        pa.process(ints, new Command() {
            @Override
            public void process(int[] target) {
                int sum = 0;
                for (int temp : target) {
                    sum += temp;
                }
                System.out.println("sum: " + sum);
            }
        });
        // 使用 Lambda 表达式实现，
        // 第一行可以简写成 pa.process(ints, target -> {
        pa.process(ints, (int[] target) -> {
            int sum = 0;
            for (int temp : target) {
                sum += temp;
            }
            System.out.println("sum: " + sum);
        });

    }
}
