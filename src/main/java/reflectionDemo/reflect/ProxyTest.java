package reflectionDemo.reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

public class ProxyTest {
    public static void main(String[] args) throws Exception {
        InvocationHandler handler = new PersonInvocationhandler();
        
        // 动态代理类
        Class<?> proxyClass = Proxy.getProxyClass(Person.class.getClassLoader(), new Class[] {Person.class});
        // 动态代理类里面带一个 InvocationHandler 参数的构造方法
        Constructor<?> constructor = proxyClass.getConstructor(new Class[] {InvocationHandler.class});
        // 调用构造方法生成实例
        Person p = (Person)constructor.newInstance(new Object[] {handler});
        p.talk("加个微信呗");
        
        /**
         * 上面的步骤可以简化
         */
        Person instance = (Person) Proxy.newProxyInstance(Person.class.getClassLoader(), new Class[] { Person.class }, handler);
        instance.walk();
        instance.talk("行不行，不行我再想想办法");
    }
}