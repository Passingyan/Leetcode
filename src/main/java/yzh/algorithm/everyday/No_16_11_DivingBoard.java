package yzh.algorithm.everyday;

import java.util.ArrayList;
import java.util.List;

/**
 * 面试题 16.11. 跳水板
 * 你正在使用一堆木板建造跳水板。有两种类型的木板，其中长度较短的木板长度为shorter，长度较长的木板长度为longer。你必须正好使用k块木板。编写一个方法，生成跳水板所有可能的长度。
 * <p>
 * 返回的长度需要从小到大排列。
 * <p>
 * 示例：
 * <p>
 * 输入：
 * shorter = 1
 * longer = 2
 * k = 3
 * 输出： {3,4,5,6}
 * 提示：
 * <p>
 * 0 < shorter <= longer
 * 0 <= k <= 100000
 */
public class No_16_11_DivingBoard {
    public int[] divingBoard(int shorter, int longer, int k) {
        if (k == 0) {
            return new int[]{};
        }
        if (shorter == longer) {
            return new int[]{k * shorter};
        }
        int[] result = new int[k + 1];
        int sum = 0;
        for (int i = 0; i <= k; i++) {
            if (sum == 0) {
                sum = k * shorter;
            } else {
                sum += longer - shorter;
            }
            result[i] = sum;
        }
        return result;
    }
}
