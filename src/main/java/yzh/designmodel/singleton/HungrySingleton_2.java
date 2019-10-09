package yzh.designmodel.singleton;

/**
 * @author yongzh
 * @date 2019/10/9
 */
public class HungrySingleton_2 {
    private HungrySingleton_2() {
    }

    private static HungrySingleton_2 instance;

    static {
        instance = new HungrySingleton_2();
    }

    public static HungrySingleton_2 getInstance() {
        return instance;
    }
}
