package yzh.algorithm.medium;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.IntConsumer;

/**
 * @author yzh
 */
public class ID1116_ZeroEvenOdd {
    public static void main(String[] args) {
        ZeroEvenOdd zeroEvenOdd = new ZeroEvenOdd(2);
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    zeroEvenOdd.zero(x -> System.out.print(x));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    zeroEvenOdd.even(x -> System.out.print(x));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    zeroEvenOdd.odd(x -> System.out.print(x));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }
}


class ZeroEvenOdd {
    private int n;
    private AtomicInteger count = new AtomicInteger();

    public ZeroEvenOdd(int n) {
        this.n = n;
    }

    // printNumber.accept(x) outputs "x", where x is an integer.
    public void zero(IntConsumer printNumber) throws InterruptedException {

        while (count.get() < 2 * n) {
            if (count.get() % 4 == 0 || count.get() % 4 == 2) {
                printNumber.accept(0);
                count.getAndIncrement();
            }
        }

    }

    public void even(IntConsumer printNumber) throws InterruptedException {
        while (count.get() < 2 * n) {
            if (count.get() % 4 == 1) {
                printNumber.accept((count.get() + 1) / 2);
                count.getAndIncrement();
            }
        }
    }

    public void odd(IntConsumer printNumber) throws InterruptedException {
        while (count.get() < 2 * n) {
            if (count.get() % 4 == 3) {
                printNumber.accept((count.get() + 1) / 2);
                count.getAndIncrement();
            }
        }
    }
}
