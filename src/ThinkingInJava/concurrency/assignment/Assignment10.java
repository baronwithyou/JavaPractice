package ThinkingInJava.concurrency.assignment;

import java.util.ArrayList;
import java.util.concurrent.*;

public class Assignment10 {
    private ExecutorService exec;
    public Assignment10() {
        exec = Executors.newCachedThreadPool();
    }

    public Future<Integer> runTask(int i) {
        Future<Integer> results = exec.submit(new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {
                return fib(i);
            }

            public int fib(int i) {
                if (i <= 2)
                    return 1;
                return fib(i - 1) + fib(i - 2);
            }
        });
        exec.shutdown();
        return results;
    }

    public static void main(String []args) throws Exception {
        ArrayList<Future<Integer>> results = new ArrayList<>();

        for (int i = 4; i < 41; i += 5) {
            results.add(new Assignment10().runTask(i));
        }

        for (Future<Integer> fs : results) {
            System.out.println(fs.get());
        }
    }
}
