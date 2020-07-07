package yzh.algorithm.everyday;

/**
 * @author yongzh
 * @date 2020/4/7
 */


/**
 * 面试题 01.07. 旋转矩阵
 * 给你一幅由 N × N 矩阵表示的图像，其中每个像素的大小为 4 字节。请你设计一种算法，将图像旋转 90 度。
 * <p>
 * 不占用额外内存空间能否做到？
 * <p>
 * 示例 1:
 * <p>
 * 给定 matrix =
 * [
 * [1,2,3],
 * [4,5,6],
 * [7,8,9]
 * ],
 * <p>
 * 原地旋转输入矩阵，使其变为:
 * [
 * [7,4,1],
 * [8,5,2],
 * [9,6,3]
 * ]
 * 示例 2:
 * <p>
 * 给定 matrix =
 * [
 * [ 5, 1, 9,11],
 * [ 2, 4, 8,10],
 * [13, 3, 6, 7],
 * [15,14,12,16]
 * ],
 * <p>
 * 原地旋转输入矩阵，使其变为:
 * [
 * [15,13, 2, 5],
 * [14, 3, 4, 1],
 * [12, 6, 8, 9],
 * [16, 7,10,11]
 * ]
 */
public class No_01_07_Rotate {
    /**
     * 思想：
     * 旋转90度，即一次更换1各方位的值，为避免有些位置的重复选择，可以利用对角线进行区分
     * 行数增加，遍历的列数就需要减少，不然会存在位置的90°*N的重复旋转
     * 如
     * [[1,2,3],
     * [4,5,6],
     * [7,8,9]]
     * ，只需遍历
     * 1,2
     * ,5
     * 即可，
     * 再如
     * [[15,13, 2, 5],
     * [14, 3, 4, 1],
     * [12, 6, 8, 9],
     * [16, 7,10,11]]
     * 只需遍历
     * 15,13,2
     * ,3
     * 即可
     *
     * @param matrix 传入二位数组
     */
    public void rotate(int[][] matrix) {
        if (matrix.length == 0 || matrix.length == 1) return;
        for (int i = 0; i < (matrix.length + 1) / 2; i++) {
            for (int j = i; j < matrix.length - 1 - i; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[matrix.length - 1 - j][i];
                matrix[matrix.length - 1 - j][i] =
                        matrix[matrix.length - 1 - i][matrix.length - 1 - j];
                matrix[matrix.length - 1 - i][matrix.length - 1 - j] =
                        matrix[j][matrix.length - 1 - i];
                matrix[j][matrix.length - 1 - i] = temp;
            }
        }
    }
}
