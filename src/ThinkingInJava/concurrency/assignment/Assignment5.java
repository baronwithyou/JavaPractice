package ThinkingInJava.concurrency.assignment;

import java.util.ArrayList;
import java.util.concurrent.*;

class Fibonacci implements Callable<Integer> {

    private int i;

    public Fibonacci(int i) {
        this.i = i;
    }

    @Override
    public Integer call() throws Exception {
        return fib(i);
    }

    private int fib(int i) {
        if (i <= 2)
            return 1;
        return fib(i - 1) + fib(i - 2);
    }
}

public class Assignment5{
    public static void main(String []args) {
        ExecutorService exec = Executors.newCachedThreadPool();
        ArrayList<Future<Integer>> results = new ArrayList<>();
        for (int i = 0; i < 5; i++)
            results.add(exec.submit(new Fibonacci(7)));
        for (Future<Integer> fs : results)
            try {
                System.out.println(fs.get());
            } catch (ExecutionException e) {
                System.out.println(e);
                return;
            } catch (InterruptedException e) {
                System.out.println(e);
            } finally {
                exec.shutdown();
            }
    }
}
