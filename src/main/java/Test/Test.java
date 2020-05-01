package Test;

import java.sql.DriverManager;
import java.util.*;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @author yongzh
 * @date 2020/4/7
 */
public class Test {
    public static void main(String[] args) {
        temp6();
    }


    static void temp1() {
        String s = String.valueOf(1);
        StringBuilder sbl = new StringBuilder().append(1);
        StringBuffer sbf = new StringBuffer().append("1");

        String s1 = "AB";
        String s2 = "AB";
        String s3 = new String("AB");
        System.out.println(s1 == s2);
        System.out.println(s1 == s3);
    }

    static void temp2() {
        String ss = "111";
        ArrayList<String> arrList = new ArrayList<>();
        LinkedList<String> linkList = new LinkedList<>();
        arrList.add(ss);
        linkList.add(ss);
        arrList.indexOf(ss);
        linkList.indexOf(ss);
        arrList.remove(ss);
        linkList.remove(ss);
    }

    static void temp3() {
        String ss = "111";

        HashMap hashMap = new HashMap();
        hashMap.put(ss, ss);

        Hashtable hashtable = new Hashtable();
        hashtable.put(ss, ss);

        hashMap.equals(hashtable);

        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put(ss, ss);

        ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();
        concurrentHashMap.put(ss, ss);
        Iterable iterable = (Iterable) concurrentHashMap.keySet().iterator();


        TreeMap treeMap = new TreeMap();
        treeMap.put(ss, ss);

        TreeMap<String, String> map = new TreeMap<String, String>(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o2.compareTo(o1);
            }

        });
    }

    static void fatherAndSon() {
        Son son = new Son();
        son.print();
    }


    static void temp4() {
        Map<String, Long> map = new ConcurrentHashMap<>();
        map.put("ss", map.get("ss") + 1);
        System.out.println(map.get("ss"));
    }

    static void temp5() {
        Integer in1 = new Integer(133334);
        Integer in2 = new Integer(133334);
        System.out.println(in1.hashCode());
        System.out.println(in2.hashCode());
        System.out.println(in1 == in2);
        System.out.println(in1.equals(in2));
    }

    static void temp6() {
        StringBuilder sb = new StringBuilder("abc");
        StringBuilder sb1 = new StringBuilder("abc");
        System.out.println(sb.hashCode());
        System.out.println(sb1.hashCode());
        System.out.println(sb1.equals(sb));
    }

    static void temp7() {
        ClassLoader system = ClassLoader.getSystemClassLoader();
        Class<?> clazz = null;
        try {
            clazz = system.loadClass("");
        } catch (Exception e) {

        }
    }

    static void temp8() {
        List<String> list = Collections.synchronizedList(new ArrayList<>());
        list.add("sss");
        CopyOnWriteArrayList<String> list1 = new CopyOnWriteArrayList<>();
        list1.add("sss");
        AtomicInteger integer = new AtomicInteger();
        integer.getAndIncrement();
        integer.addAndGet(1);
    }

    static void temp9() {
        ReentrantLock reentrantLock = new ReentrantLock();
        reentrantLock.lock();
        reentrantLock.unlock();
        ReentrantReadWriteLock reentrantReadWriteLock = new ReentrantReadWriteLock();
        reentrantReadWriteLock.writeLock();

    }

    static void temp10() throws Exception {
        CountDownLatch countDownLatch = new CountDownLatch(10);
        countDownLatch.await();
        countDownLatch.await(10, TimeUnit.DAYS);

        CyclicBarrier cyclicBarrier = new CyclicBarrier(10);


        Semaphore semaphore = new Semaphore(10);
    }

    static void temp11() {
        ExecutorService executorService = new ThreadPoolExecutor(1, 1, 0L,
                TimeUnit.SECONDS, new LinkedBlockingQueue<>(), Executors.defaultThreadFactory(),
                new ThreadPoolExecutor.AbortPolicy());

        ExecutorService executorService1 = Executors.newFixedThreadPool(1,
                Executors.defaultThreadFactory());

        ExecutorService executorService2 = Executors.newCachedThreadPool();

        ExecutorService executorService3 = Executors.newSingleThreadExecutor();

        ExecutorService executorService4 = Executors.newScheduledThreadPool(1);

        ArrayBlockingQueue<String> arrayBlockingQueue =
                new ArrayBlockingQueue<>(1);
        arrayBlockingQueue.add("333");

        LinkedBlockingQueue<String> linkedBlockingQueue = new LinkedBlockingQueue();
        linkedBlockingQueue.add("333");

        SynchronousQueue<String> synchronousQueue = new SynchronousQueue<>();
        synchronousQueue.add("333");

        DelayQueue delayQueue = new DelayQueue<>();
        delayQueue.add(new Delayed() {
            @Override
            public long getDelay(TimeUnit unit) {
                return 0;
            }

            @Override
            public int compareTo(Delayed o) {
                return 0;
            }
        });

        executorService.submit(() -> System.out.println("test ThreadPoolExecutor"));
    }

}
