package yzh.designmodel.singleton;

/**
 * @author yongzh
 * @date 2019/10/9
 */
public class HungrySingleton_1 {

    private HungrySingleton_1() {
    }

    private static HungrySingleton_1 instance = new HungrySingleton_1();

    public static HungrySingleton_1 getInstance() {
        return instance;
    }

}
