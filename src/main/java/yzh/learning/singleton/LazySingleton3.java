package yzh.learning.singleton;

public class LazySingleton3 {

    private LazySingleton3() {
    }

    private static LazySingleton3 instance;

    public static LazySingleton3 getInstance() {
        if (instance == null) {
            synchronized (LazySingleton3.class) {
                if (instance == null) {
                    instance = new LazySingleton3();
                }
            }
        }
        return instance;
    }

}
