package yzh.learning.singleton;

public class HungrySingleton3 {

    private HungrySingleton3() {
    }

    public static final HungrySingleton3 INSTANCE;

    static {
        INSTANCE = new HungrySingleton3();
    }
}
