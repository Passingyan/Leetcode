package yzh.algorithm.toutiao;

import java.util.List;

/**
 * @author yongzh
 * @date 2020/5/23
 */
public class MinimumTotal {
    public int minimumTotal(List<List<Integer>> triangle) {
        if (triangle == null) return 0;
        int size = triangle.size();
        if (size == 0) return 0;
        int[] arr = new int[size];
        size--;
        while (size >= 0) {
            List<Integer> list = triangle.get(size);
            for (int i = 0; i <= size; i++) {
                if (size == triangle.size() - 1) {
                    arr[i] = list.get(i);
                } else {
                    arr[i] = Math.min(arr[i], arr[i + 1]) + list.get(i);
                }
            }
            size--;
        }
        return arr[0];
    }
}
