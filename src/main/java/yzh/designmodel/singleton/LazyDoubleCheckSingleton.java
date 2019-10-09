package yzh.designmodel.singleton;

/**
 * @author yongzh
 * @date 2019/10/9
 */
public class LazyDoubleCheckSingleton {
    private LazyDoubleCheckSingleton() {
    }

    private static volatile LazyDoubleCheckSingleton instance = null;

    public static LazyDoubleCheckSingleton getInstance() {
        if (instance == null) {
            synchronized (LazyDoubleCheckSingleton.class) {
                if (instance == null) {
                    instance = new LazyDoubleCheckSingleton();
                }
            }
        }
        return instance;
    }
}
