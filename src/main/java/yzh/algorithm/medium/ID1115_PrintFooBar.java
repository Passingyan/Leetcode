package yzh.algorithm.medium;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author yzh
 */
public class ID1115_PrintFooBar {
    public static void main(String[] args) {

    }

}

class FooBar {
    private int n;
    private AtomicInteger count;

    public FooBar(int n) {
        this.n = n;
        this.count = new AtomicInteger();
    }

    public void foo(Runnable printFoo) throws InterruptedException {
        int i = 0;
        while (i < n) {
            if (count.get() % 2 == 0) {
                printFoo.run();
                count.getAndIncrement();
                i++;
            }
        }

    }

    public void bar(Runnable printBar) throws InterruptedException {
        int i = 0;
        while (i < n) {
            if (count.get() % 2 == 1) {
                printBar.run();
                count.getAndIncrement();
                i++;
            }
        }
    }
}

