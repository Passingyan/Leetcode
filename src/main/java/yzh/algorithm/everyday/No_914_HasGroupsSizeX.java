package yzh.algorithm.everyday;

import java.util.HashMap;
import java.util.Map;

/**
 * 914. 卡牌分组
 * 给定一副牌，每张牌上都写着一个整数。
 * <p>
 * 此时，你需要选定一个数字 X，使我们可以将整副牌按下述规则分成 1 组或更多组：
 * <p>
 * 每组都有 X 张牌。
 * 组内所有的牌上都写着相同的整数。
 * 仅当你可选的 X >= 2 时返回 true。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：[1,2,3,4,4,3,2,1]
 * 输出：true
 * 解释：可行的分组是 [1,1]，[2,2]，[3,3]，[4,4]
 * 示例 2：
 * <p>
 * 输入：[1,1,1,2,2,2,3,3]
 * 输出：false
 * 解释：没有满足要求的分组。
 */

public class No_914_HasGroupsSizeX {
    public boolean hasGroupsSizeX(int[] deck) {
        if (deck.length == 1) return false;
        Map<Integer, Integer> temp = new HashMap<>();
        for (int i : deck) {
            if (temp.containsKey(i)) {
                temp.put(i, temp.get(i) + 1);
            } else {
                temp.put(i, 1);
            }
        }
        int num = -1;
        for (int i : temp.values()) {
            if (num == -1) num = i;

            else num = gcd(num, i);
        }
        return num >= 2;
    }


    public int gcd(int x, int y) {
        return x == 0 ? y : gcd(y % x, x);
    }

    public static void main(String[] args) {
        int[] deck = {1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 3, 3, 3, 3, 3, 3, 3, 3};
        System.out.println(new No_914_HasGroupsSizeX().hasGroupsSizeX(deck));
    }
}
