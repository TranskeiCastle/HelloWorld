package reflectionDemo.dynamicProxy;

import java.lang.reflect.Proxy;

public class DogTest {
    public static void main(String[] args) {
        Dog dog = new Puppy();
        Dog dogg = (Dog)MyProxyFactory.getProxy(dog);
        dogg.info();
    }
}

class MyProxyFactory {
    public static Object getProxy(Object target) {
        DynamicInvocationHandler handler = new DynamicInvocationHandler();
        handler.setTarget(target);
        
        return Proxy.newProxyInstance(
        		target.getClass().getClassLoader(), 
        		target.getClass().getInterfaces(), 
        		handler
        		);
    }
}