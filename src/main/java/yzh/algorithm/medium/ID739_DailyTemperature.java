package yzh.algorithm.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * @author yzh
 * <p>
 * 根据每日 气温 列表，请重新生成一个列表，对应位置的输入是你需要再等待多久温度才会升高超过该日的天数。如果之后都不会升高，请在该位置用 0 来代替。
 * <p>
 * 例如，给定一个列表 temperatures = [73, 74, 75, 71, 69, 72, 76, 73]，你的输出应该是 [1, 1, 4, 2, 1, 1, 0, 0]。
 * <p>
 * 提示：气温 列表长度的范围是 [1, 30000]。每个气温的值的均为华氏度，都是在 [30, 100] 范围内的整数。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/daily-temperatures
 */
public class ID739_DailyTemperature {

    /**
     * 思路：反向遍历，记录每天的状态信息，类似动态规划
     */
    public int[] dailyTemperatures(int[] T) {
        int[] result = new int[T.length]; // 记录返回结果
        int[] high = new int[T.length];  // 记录当前天之后，与它最近的高温的下标
        int index = T.length - 1;
        result[index] = 0;
        high[index] = -1;  // 最后一天，以及之后没有比它高温的，统一记为-1
        while (index >= 0) {
            index--;
            if (index < 0) {
                break;
            } else {
                if (T[index] < T[index + 1]) {
                    result[index] = 1;
                    high[index] = index + 1;
                } else {
                    int highIndex = high[index + 1]; // 取得后一天的高温记录下标
                    while (highIndex < T.length) {
                        if (highIndex == -1) {  // 后续没有比当前还高，直接赋值，退出循环
                            result[index] = 0;
                            high[index] = -1;
                            break;
                        } else {    // 找到比它高的下标
                            if (T[index] < T[highIndex]) {
                                result[index] = highIndex - index;
                                high[index] = highIndex;
                                break;
                            }
                            highIndex = high[highIndex];
                        }
                    }
                }
            }
        }
        return result;
    }


    public int[] dailyTemperatures1(int[] T) {
        int[] result = new int[T.length]; // 记录返回结果
        int index = T.length - 1;
        result[index] = 0;
        while (index >= 0) {
            index--;
            if (index < 0) {
                break;
            } else {
                if (T[index] < T[index + 1]) {
                    result[index] = 1;
                } else {
                    if (result[index + 1] == 0) {  //后一天的高温是本身，则当天后面没有高温出现
                        result[index] = 0;
                        continue;
                    }
                    int highIndex = index + 1 + result[index + 1]; // 取得后一天的高温记录下标
                    while (highIndex < T.length) {
                        if (T[index] < T[highIndex]) {   // 比当天大，则直接相减
                            result[index] = highIndex - index;
                            break;
                        } else if (result[highIndex] == 0) {
                            // 不比当天大，但highIndex后续没有高温，则为 0
                            result[index] = 0;
                            break;
                        } else {
                            // 继续向后查找
                            highIndex += result[highIndex];
                        }
                    }
                }
            }
        }
        return result;
    }

}
