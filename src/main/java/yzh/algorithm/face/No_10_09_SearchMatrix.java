package yzh.algorithm.face;


/**
 * 给定M×N矩阵，每一行、每一列都按升序排列，请编写代码找出某元素。
 * <p>
 * 示例:
 * <p>
 * 现有矩阵 matrix 如下：
 * <p>
 * [
 * [1,   4,  7, 11, 15],
 * [2,   5,  8, 12, 19],
 * [3,   6,  9, 16, 22],
 * [10, 13, 14, 17, 24],
 * [18, 21, 23, 26, 30]
 * ]
 * 给定 target = 5，返回 true。
 * <p>
 * 给定 target = 20，返回 false。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/sorted-matrix-search-lcci
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class No_10_09_SearchMatrix {
    public static void main(String[] args) {
        int target = 1;
        int[][] matrix = {{}};
        System.out.println(new No_10_09_SearchMatrix().searchMatrix(matrix, target));
    }


    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix.length == 0 || matrix[0].length == 0) return false;
        return searchRecursive(matrix, matrix.length - 1, 0, target);
    }

    public boolean searchRecursive(int[][] matrix, int col, int row, int target) {
        for (int i = col; i >= 0; i--) {
            if (target == matrix[i][row]) {
                return true;
            } else {
                if (target > matrix[i][row]) {
                    if (row == matrix[i].length - 1) return false;
                    return searchRecursive(matrix, i, row + 1, target);
                } else {
                    return searchRecursive(matrix, i - 1, row, target);
                }
            }
        }
        return false;
    }
}
