package ThinkingInJava.concurrency.transform_21_2_9;

import java.util.concurrent.TimeUnit;

/**
 * 线程的多种写法（编码的变体）
 * 几种变体方式都要掌握
 */
class InnerThread1 {
    private int countDown = 5;
    private Inner inner;
    private class Inner extends Thread {
        Inner(String name) {
            super(name);
            start();
        }

        public void run() {
            try {
                while (true) {
                    System.out.println(this);
                    if (--countDown == 0)
                        return;
                    sleep(10);
                }
            } catch (InterruptedException e) {
                System.out.println("InnerThread1 Interrupted");
            }
        }

        public String toString() {
            return getName() + ": " + countDown;
        }
    }
    public InnerThread1(String name) {
        inner = new Inner(name);
    }
}

class InnerThread2 {
    private int countDown = 5;
    private Thread t;
    public InnerThread2(String name) {
        t = new Thread(name) {
            public void run() {
                try {
                    while (true) {
                        System.out.println(this);
                        if (--countDown == 0)
                            return;
                        sleep(10);
                    }
                } catch (InterruptedException e) {
                    System.out.println("InnerThread2 Interrupted");
                }
            }

            public String toString() {
                return getName() + ": " + countDown;
            }
        };
        t.start();
    }
}

/**
 * 通过自管理Runnable的内部类来实现线程的初始化和开启
 */
class InnerRunnable1 {
    private int countDown = 5;
    private Inner inner;
    private class Inner implements Runnable {
        Thread t;
        Inner(String name) {
            t = new Thread(this, name);
            t.start();
        }

        @Override
        public void run() {
            try {
                while (true) {
                    System.out.println(this);
                    if (--countDown == 0)
                        return;
                    t.sleep(10);
                }
            } catch (InterruptedException e) {
                System.out.println("InnerRunnable1 Interrupted");
            }
        }

        @Override
        public String toString() {
            return t.getName() + ": " + countDown;
        }
    }
    public InnerRunnable1(String name) {
        inner = new Inner(name);
    }
}

class InnerRunnable2 {
    private int countDown = 5;
    private Thread t;
    public InnerRunnable2(String name) {
        t = new Thread(new Runnable() {
            public void run() {
                try {
                    while (true) {
                        System.out.println(this);
                        if (--countDown == 0)
                            return;
                        TimeUnit.MILLISECONDS.sleep(10);
                    }
                } catch (InterruptedException e) {
                    System.out.println("InnerRunnable2 Interrupted");
                }
            }

            public String toString() {
                return Thread.currentThread().getName() + ": " + countDown;
            }
        }, name);
        t.start();
    }
}

class ThreadMethod {
    private String name;
    private int countDown = 5;
    private Thread t;
    public ThreadMethod(String name) {
        this.name = name;
    }
    public void runTask() {
        t = new Thread(name) {
            public void run() {
                try {
                    while (true) {
                        System.out.println(this);
                        if (--countDown == 0)
                            return;
                        sleep(10);
                    }
                } catch (InterruptedException e) {
                    System.out.println("ThreadMethod Interrupted");
                }
            }

            public String toString() {
                return getName() + ": " + countDown;
            }
        };
        t.start();
    }
}

public class ThreadVariations {
    public static void main(String []args) {
//        new InnerThread1("InnerThread1");
//        new InnerThread2("InnerThread2");
//        new InnerRunnable1("InnerRunnable1");
//        new InnerRunnable2("InnerRunnable2");
//        new ThreadMethod("ThreadMethod").runTask();
        new InnerRunnable1("first");
        new InnerRunnable1("second");
        new InnerRunnable1("third");
    }
}
