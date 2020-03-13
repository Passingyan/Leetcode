package yzh.learning.singleton;

public class HungrySingleton1 {

    private HungrySingleton1() {
    }

    private static final HungrySingleton1 INSTANCE = new HungrySingleton1();

    public static HungrySingleton1 getInstance() {
        return INSTANCE;
    }
}
