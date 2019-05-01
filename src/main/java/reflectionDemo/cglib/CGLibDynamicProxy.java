package reflectionDemo.cglib;

import java.lang.reflect.Method;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

public class CGLibDynamicProxy implements MethodInterceptor {

	private static CGLibDynamicProxy instance = new CGLibDynamicProxy();
	
	public static CGLibDynamicProxy getInstance() {
		return instance;
	}
	
	@SuppressWarnings("unchecked")
	public <T> T getProxy(Class<T> cls) {
		return (T) Enhancer.create(cls, this);
	}
	
	@Override
	public Object intercept(Object target, Method method, Object[] args, MethodProxy proxy) throws Throwable {
		before();
		Object result = proxy.invokeSuper(target, args);
		after();
		return result;
	}

	private void before() {
		System.out.println("before-------------");
	}
	
	private void after() {
		System.out.println("after-------------");
	}
}
