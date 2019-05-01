package reflectionDemo.cglib;

public class Test {
    public static void main(String[] args) {
        Hello hi = CGLibDynamicProxy.getInstance().getProxy(HelloImpl.class);
        /*
         * before------------- 你好哇 Castle after-------------
         */
        hi.sayHello("Castle");
    }
}
