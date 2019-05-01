package reflectionDemo.dynamicProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class DynamicInvocationHandler implements InvocationHandler {
    private Object target;

    public void setTarget(Object obj) {
        this.target = obj;
    }
    
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        before();
        // 以 target 来执行方法
        Object result = method.invoke(target, args);
        after();
        
        return result;
    }
    
    public void before() {
        System.out.println("追加在前面的逻辑");
    }
    
    public void after() {
        System.out.println("追加在后面的逻辑");
    }

}
