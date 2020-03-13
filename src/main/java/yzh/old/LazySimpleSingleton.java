package yzh.old;

/**
 * @author yongzh
 * @date 2019/10/9
 */
public class LazySimpleSingleton {

    private LazySimpleSingleton() {
    }

    private static LazySimpleSingleton instance = null;


    public static LazySimpleSingleton getInstance() {
        if (instance == null) {
            instance = new LazySimpleSingleton();
        }
        return instance;
    }
}
