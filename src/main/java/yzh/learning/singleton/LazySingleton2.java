package yzh.learning.singleton;

public class LazySingleton2 {

    private LazySingleton2() {
    }

    private static LazySingleton2 instance;

    public static LazySingleton2 getInstance() {
        synchronized (LazySingleton2.class) {
            if (instance == null) {
                instance = new LazySingleton2();
            }
        }
        return instance;
    }

}
