package yzh.algorithm.offer;

/**
 * @author yongzh
 * @date 2021/8/11
 * <p>
 * 剑指 Offer 04. 二维数组中的查找
 * https://leetcode-cn.com/problems/er-wei-shu-zu-zhong-de-cha-zhao-lcof/
 */
public class No_04_FindNumberIn2DArray {

    /**
     * 取中间点，从左往右，从上往下都是递增有序，则右上角的数属于中间点，
     * 比它大的，在其下方，比它小的，在其左侧.
     */
    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        if (matrix.length == 0) {
            return false;
        }
        int col = 0;
        int row = matrix[0].length - 1;
        while (col < matrix.length && row >= 0) {
            if (matrix[col][row] == target) {
                return true;
            } else if (matrix[col][row] > target) {
                row--;
            } else {
                col++;
            }
        }
        return false;
    }
}
