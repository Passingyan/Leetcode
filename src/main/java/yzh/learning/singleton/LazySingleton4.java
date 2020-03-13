package yzh.learning.singleton;

public class LazySingleton4 {

    private LazySingleton4() {
    }

    private static class Inner {
        private static final LazySingleton4 INSTANCE = new LazySingleton4();
    }

    public static LazySingleton4 getInstance() {
        return Inner.INSTANCE;
    }

}
