package yzh.designmodel.singleton;

import java.util.HashMap;
import java.util.Map;

/**
 * @author yongzh
 * @date 2019/10/10
 */
public class ContainerSingleton {
    private static Map<String, Object> containerMap = new HashMap<>();

    public static Object getInstance(String className) {
        synchronized (containerMap) {
            if (!containerMap.containsKey(className)) {
                Object obj = null;
                try {
                    obj = Class.forName(className).newInstance();
                    containerMap.put(className, obj);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                return obj;
            } else {
                return containerMap.get(className);
            }
        }
    }
}
