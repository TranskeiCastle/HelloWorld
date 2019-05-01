package lambdaDemo;

public class ProcessArray {
    // 调用该方法时才传入一个 Command 对象（接口的实现类），这时候才确定对数组的处理行为
    public void process(int[] target, Command cmd) {
        cmd.process(target);
    }
}
