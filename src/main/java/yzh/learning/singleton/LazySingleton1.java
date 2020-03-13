package yzh.learning.singleton;

public class LazySingleton1 {

    private LazySingleton1() {
    }

    private static LazySingleton1 instance;

    public static LazySingleton1 getInstance() {
        if (instance == null) {
            instance = new LazySingleton1();
        }
        return instance;
    }

}
