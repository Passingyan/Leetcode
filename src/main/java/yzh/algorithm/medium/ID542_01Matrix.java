package yzh.algorithm.medium;

/**
 * @author yzh
 * @date 2019/8/14
 */
public class ID542_01Matrix {

    public static void main(String[] args) {
        int[][] matrix = {{0, 0, 0}, {0, 1, 0}, {0, 0, 0}};

        int[][] result = updateMatrix(matrix);
        for (int i = 0; i < result.length; i++) {
            for (int j = 0; j < result[i].length; j++) {
                System.out.print(result[i][j]);
            }
            System.out.println();
        }

    }

    static int[][] updateMatrix(int[][] matrix) {
        int row = matrix.length;
        int col = matrix[0].length;
        int[][] distance = new int[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                distance[i][j] = 10001;
            }
        }
        int ab;
        int pre;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (matrix[i][j] == 0) {
                    distance[i][j] = 0;
                } else {
                    ab = 10001;
                    pre = 10001;
                    if (i > 0) {
                        ab = distance[i - 1][j];
                    }
                    if (j > 0) {
                        pre = distance[i][j - 1];
                    }
                    distance[i][j] = Math.min(ab, pre) + 1;
                }
            }
        }
        for (int i = row - 1; i >= 0; i--) {
            for (int j = col - 1; j >= 0; j--) {
                ab = 10001;
                pre = 10001;
                if (i < row - 1) {
                    ab = distance[i + 1][j];
                }
                if (j < col - 1) {
                    pre = distance[i][j + 1];
                }
                distance[i][j] = Math.min(distance[i][j], Math.min(ab, pre) + 1);
            }
        }
        return distance;
    }
}
