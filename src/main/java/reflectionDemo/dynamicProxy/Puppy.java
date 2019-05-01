package reflectionDemo.dynamicProxy;

public class Puppy implements Dog {

    @Override
    public void info() {
        System.out.println("puppy 是一条小狗");

    }

    @Override
    public void run() {
        System.out.println("跑不快");
    }

}
