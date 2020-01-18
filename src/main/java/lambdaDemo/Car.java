package lambdaDemo;

import lambdaMethodRef.PrintUtil;
import org.junit.Test;


import java.util.Arrays;
import java.util.List;

public class Car {

    @Test
    public void f() {
        List<String> strList = Arrays.asList("A", "B", "C");
        strList.forEach(System.out::println);
        strList.forEach(new PrintUtil()::addString);
        strList.forEach(c -> new PrintUtil().addString(c));
        // strList.forEach((String e,Date d) -> PrintUtil::addStr(e,d));
        // strList.forEach(c -> PrintUtil.addStr(c));
    }

    @Test
    public void myMethod() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Before Java8, too much code for too little to do");
            }
        }).start();
    }

    @Test
    public void myMethod2() {
        new Thread(() -> {
            System.out.println("In Java8, Lambda expression rocks !!");
        }).start();
    }
}