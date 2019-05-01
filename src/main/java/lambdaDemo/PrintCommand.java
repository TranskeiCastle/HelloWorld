package lambdaDemo;

public class PrintCommand implements Command {
    @Override
    public void process(int[] target) {
        for (int temp : target) {
            System.out.println(temp);
        }
    }
}
