package lambdaMethodRef;

public class PrintUtil {

    public void addString(String x) {
        System.out.println(x + " added");
    }

    public static void addStr(String x) {
        System.out.println(x + " added by static");
    }

    // Todo 2个参数，怎么写 Lambda 表达式
    public static void addStr(String x, String y) {
        System.out.println(x + y);
    }
}