package yzh.algorithm.offer;

/**
 * @author yongzh
 * @date 2021/8/11
 * <p>
 * 剑指 Offer 11. 旋转数组的最小数字
 * https://leetcode-cn.com/problems/xuan-zhuan-shu-zu-de-zui-xiao-shu-zi-lcof/
 */
public class No_11_MinArray {
    public int minArray(int[] numbers) {
        int left = 0;
        int right = numbers.length - 1;
        while (left < right) {
            int mid = (left + right) / 2;
            if (numbers[mid] < numbers[right]) {
                right = mid;
            } else if (numbers[mid] > numbers[right]) {
                left = mid + 1;
            } else {
                right -= 1;
            }
        }
        return numbers[left];
    }


    public static void main(String[] args) {
        No_11_MinArray no_11_minArray = new No_11_MinArray();
        int[] numbers = {3, 1, 3};
        System.out.println(no_11_minArray.minArray(numbers));
    }
}
