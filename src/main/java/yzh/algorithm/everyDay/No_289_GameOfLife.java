package yzh.algorithm.everyDay;

/**
 * @author yongzh
 * @date 2020/4/2
 */


/**
 * 289. 生命游戏
 * 根据 百度百科 ，生命游戏，简称为生命，是英国数学家约翰·何顿·康威在 1970 年发明的细胞自动机。
 * <p>
 * 给定一个包含 m × n 个格子的面板，每一个格子都可以看成是一个细胞。
 * 每个细胞都具有一个初始状态：1 即为活细胞（live），或 0 即为死细胞（dead）。
 * 每个细胞与其八个相邻位置（水平，垂直，对角线）的细胞都遵循以下四条生存定律：
 * <p>
 * 1、如果活细胞周围八个位置的活细胞数少于两个，则该位置活细胞死亡；
 * 2、如果活细胞周围八个位置有两个或三个活细胞，则该位置活细胞仍然存活；
 * 3、如果活细胞周围八个位置有超过三个活细胞，则该位置活细胞死亡；
 * 4、如果死细胞周围正好有三个活细胞，则该位置死细胞复活；
 * 根据当前状态，写一个函数来计算面板上所有细胞的下一个（一次更新后的）状态。下一个状态是通过将上述规则同时应用于当前状态下的每个细胞所形成的，
 * 其中细胞的出生和死亡是同时发生的。
 * <p>
 * 示例：
 * <p>
 * 输入：
 * [
 * [0,1,0],
 * [0,0,1],
 * [1,1,1],
 * [0,0,0]
 * ]
 * 输出：
 * [
 * [0,0,0],
 * [1,0,1],
 * [0,1,1],
 * [0,1,0]
 * ]
 */
public class No_289_GameOfLife {
    public void gameOfLife(int[][] board) {
        if (board.length == 0) return;
        int[][] temp = new int[board.length][board[0].length];
        for (int i = 0; i < temp.length; i++) {
            for (int j = 0; j < temp[i].length; j++) {
                temp[i][j] = board[i][j];
            }
        }
        for (int i = 0; i < temp.length; i++) {
            for (int j = 0; j < temp[i].length; j++) {
                int count = 0;
                if (i == 0 && i == temp.length - 1) {
                    if (j == 0 && j + 1 == temp[i].length) {
                        count = 0;
                    } else if (j > 0 && j < temp[i].length - 1) {
                        count += temp[i][j - 1] == 0 ? 0 : 1;
                        count += temp[i][j + 1] == 0 ? 0 : 1;
                    } else if (j == 0) {
                        count += temp[i][j + 1] == 0 ? 0 : 1;
                    } else {
                        count += temp[i][j - 1] == 0 ? 0 : 1;
                    }
                } else if (i > 0 && i < temp.length - 1) {
                    if (j == 0 && j + 1 == temp[i].length) {
                        count += temp[i - 1][j] == 0 ? 0 : 1;
                        count += temp[i + 1][j] == 0 ? 0 : 1;
                    } else if (j > 0 && j < temp[i].length - 1) {
                        count += temp[i - 1][j - 1] == 0 ? 0 : 1;
                        count += temp[i - 1][j] == 0 ? 0 : 1;
                        count += temp[i - 1][j + 1] == 0 ? 0 : 1;
                        count += temp[i][j - 1] == 0 ? 0 : 1;
                        count += temp[i][j + 1] == 0 ? 0 : 1;
                        count += temp[i + 1][j - 1] == 0 ? 0 : 1;
                        count += temp[i + 1][j] == 0 ? 0 : 1;
                        count += temp[i + 1][j + 1] == 0 ? 0 : 1;
                    } else if (j == 0) {
                        count += temp[i - 1][j] == 0 ? 0 : 1;
                        count += temp[i - 1][j + 1] == 0 ? 0 : 1;
                        count += temp[i][j + 1] == 0 ? 0 : 1;
                        count += temp[i + 1][j] == 0 ? 0 : 1;
                        count += temp[i + 1][j + 1] == 0 ? 0 : 1;
                    } else {
                        count += temp[i - 1][j - 1] == 0 ? 0 : 1;
                        count += temp[i - 1][j] == 0 ? 0 : 1;
                        count += temp[i][j - 1] == 0 ? 0 : 1;
                        count += temp[i + 1][j - 1] == 0 ? 0 : 1;
                        count += temp[i + 1][j] == 0 ? 0 : 1;
                    }
                } else if (i == 0) {
                    if (j == 0 && j + 1 == temp[i].length) {
                        count += temp[i + 1][j] == 0 ? 0 : 1;
                    } else if (j > 0 && j < temp[i].length - 1) {
                        count += temp[i][j - 1] == 0 ? 0 : 1;
                        count += temp[i][j + 1] == 0 ? 0 : 1;
                        count += temp[i + 1][j - 1] == 0 ? 0 : 1;
                        count += temp[i + 1][j] == 0 ? 0 : 1;
                        count += temp[i + 1][j + 1] == 0 ? 0 : 1;
                    } else if (j == 0) {
                        count += temp[i][j + 1] == 0 ? 0 : 1;
                        count += temp[i + 1][j] == 0 ? 0 : 1;
                        count += temp[i + 1][j + 1] == 0 ? 0 : 1;
                    } else {
                        count += temp[i][j - 1] == 0 ? 0 : 1;
                        count += temp[i + 1][j - 1] == 0 ? 0 : 1;
                        count += temp[i + 1][j] == 0 ? 0 : 1;
                    }
                } else if (i == temp.length - 1) {
                    if (j == 0 && j + 1 == temp[i].length) {
                        count += temp[i - 1][j] == 0 ? 0 : 1;
                    } else if (j > 0 && j < temp[i].length - 1) {
                        count += temp[i][j - 1] == 0 ? 0 : 1;
                        count += temp[i][j + 1] == 0 ? 0 : 1;
                        count += temp[i - 1][j - 1] == 0 ? 0 : 1;
                        count += temp[i - 1][j] == 0 ? 0 : 1;
                        count += temp[i - 1][j + 1] == 0 ? 0 : 1;
                    } else if (j == 0) {
                        count += temp[i][j + 1] == 0 ? 0 : 1;
                        count += temp[i - 1][j] == 0 ? 0 : 1;
                        count += temp[i - 1][j + 1] == 0 ? 0 : 1;
                    } else {
                        count += temp[i][j - 1] == 0 ? 0 : 1;
                        count += temp[i - 1][j - 1] == 0 ? 0 : 1;
                        count += temp[i - 1][j] == 0 ? 0 : 1;
                    }
                }
                if (board[i][j] == 1) {
                    if (count < 2 || count > 3) board[i][j] = 0;
                } else {
                    if (count == 3) board[i][j] = 1;
                }
            }
        }
    }

    public void gameOfLife2(int[][] board) {
        if (board.length == 0) return;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                int count = 0;
                if (i == 0 && i == board.length - 1) {
                    if (j == 0 && j + 1 == board[i].length) {
                        count += 0;
                    } else if (j > 0 && j < board[i].length - 1) {
                        count += getCount(board[i][j - 1]);
                        count += getCount(board[i][j + 1]);
                    } else if (j == 0) {
                        count += getCount(board[i][j + 1]);
                    } else {
                        count += getCount(board[i][j - 1]);
                    }
                } else if (i > 0 && i < board.length - 1) {
                    if (j == 0 && j + 1 == board[i].length) {
                        count += getCount(board[i - 1][j]);
                        count += getCount(board[i + 1][j]);
                    } else if (j > 0 && j < board[i].length - 1) {
                        count += getCount(board[i - 1][j - 1]);
                        count += getCount(board[i - 1][j]);
                        count += getCount(board[i - 1][j + 1]);
                        count += getCount(board[i][j - 1]);
                        count += getCount(board[i][j + 1]);
                        count += getCount(board[i + 1][j - 1]);
                        count += getCount(board[i + 1][j]);
                        count += getCount(board[i + 1][j + 1]);
                    } else if (j == 0) {
                        count += getCount(board[i - 1][j]);
                        count += getCount(board[i - 1][j + 1]);
                        count += getCount(board[i][j + 1]);
                        count += getCount(board[i + 1][j]);
                        count += getCount(board[i + 1][j + 1]);
                    } else {
                        count += getCount(board[i - 1][j - 1]);
                        count += getCount(board[i - 1][j]);
                        count += getCount(board[i][j - 1]);
                        count += getCount(board[i + 1][j - 1]);
                        count += getCount(board[i + 1][j]);
                    }
                } else if (i == 0) {
                    if (j == 0 && j + 1 == board[i].length) {
                        count += getCount(board[i + 1][j]);
                    } else if (j > 0 && j < board[i].length - 1) {
                        count += getCount(board[i][j - 1]);
                        count += getCount(board[i][j + 1]);
                        count += getCount(board[i + 1][j - 1]);
                        count += getCount(board[i + 1][j]);
                        count += getCount(board[i + 1][j + 1]);
                    } else if (j == 0) {
                        count += getCount(board[i][j + 1]);
                        count += getCount(board[i + 1][j]);
                        count += getCount(board[i + 1][j + 1]);
                    } else {
                        count += getCount(board[i][j - 1]);
                        count += getCount(board[i + 1][j - 1]);
                        count += getCount(board[i + 1][j]);
                    }
                } else if (i == board.length - 1) {
                    if (j == 0 && j + 1 == board[i].length) {
                        count += getCount(board[i - 1][j]);
                    } else if (j > 0 && j < board[i].length - 1) {
                        count += getCount(board[i][j - 1]);
                        count += getCount(board[i][j + 1]);
                        count += getCount(board[i - 1][j - 1]);
                        count += getCount(board[i - 1][j]);
                        count += getCount(board[i - 1][j + 1]);
                    } else if (j == 0) {
                        count += getCount(board[i][j + 1]);
                        count += getCount(board[i - 1][j]);
                        count += getCount(board[i - 1][j + 1]);
                    } else {
                        count += getCount(board[i][j - 1]);
                        count += getCount(board[i - 1][j - 1]);
                        count += getCount(board[i - 1][j]);
                    }
                }
                if (board[i][j] == 1) {
                    if (count < 2 || count > 3) board[i][j] = 3;
                } else {
                    if (count == 3) board[i][j] = 2;
                }
            }
        }
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == 2) board[i][j] = 1;
                else if (board[i][j] == 3) board[i][j] = 0;
            }
        }
    }

    private int getCount(int num) {
        return num % 2 == 0 ? 0 : 1;
    }


    public static void main(String[] args) {
        int[][] board = {{0, 1, 0}, {0, 0, 1}, {1, 1, 1}, {0, 0, 0}};
        No_289_GameOfLife temp = new No_289_GameOfLife();
        temp.gameOfLife(board);
    }
}
