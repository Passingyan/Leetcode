package yzh.old;

/**
 * @author yongzh
 * @date 2019/10/9
 */
public class LazySimpleSafetySingleton {
    private LazySimpleSafetySingleton() {
    }

    private static LazySimpleSafetySingleton instance = null;


    public synchronized static LazySimpleSafetySingleton getInstance() {
        if (instance == null) {
            instance = new LazySimpleSafetySingleton();
        }
        return instance;
    }
}
