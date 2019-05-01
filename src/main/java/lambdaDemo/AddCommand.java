package lambdaDemo;

public class AddCommand implements Command {

    @Override
    public void process(int[] target) {
        int sum = 0;
        for (int temp : target) {
            sum += temp;
        }
        System.out.println("sum: " + sum);
    }
}