package yzh.old;

/**
 * @author yongzh
 * @date 2019/10/9
 */
public class LazyInnerSingleton {
    private LazyInnerSingleton() {
    }


    public static LazyInnerSingleton getInstance() {
        return LazyHolder.INSTANCE;
    }

    private static class LazyHolder {
        private static final LazyInnerSingleton INSTANCE = new LazyInnerSingleton();
    }
}
