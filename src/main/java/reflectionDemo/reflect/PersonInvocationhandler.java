package reflectionDemo.reflect;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class PersonInvocationhandler implements InvocationHandler {

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("正在执行的方法------->" + method);
        if (null != args) {
            System.out.println("参数列表---->");
            for (Object o : args) {
                System.out.println(o);
            }
        } else {
            System.out.println("没有参数列表----|");
        }
        return null;
    }
}
