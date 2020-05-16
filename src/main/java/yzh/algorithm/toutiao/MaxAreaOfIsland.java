package yzh.algorithm.toutiao;

import java.util.ArrayDeque;

/**
 * @author yongzh
 * @date 2020/5/16
 */
public class MaxAreaOfIsland {
    public int maxAreaOfIsland(int[][] grid) {
        if (grid.length == 0) return 0;
        int[][] help = new int[grid.length][grid[0].length];
        ArrayDeque<Integer> queue1 = new ArrayDeque<>();
        ArrayDeque<Integer> queue2 = new ArrayDeque<>();
        int max = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 1) {
                    if (help[i][j] == 0) {
                        int sum = 0;
                        help[i][j] = 1;
                        queue1.add(i);
                        queue2.add(j);
                        while (queue1.size() != 0) {
                            sum++;
                            int col = queue1.remove();
                            int row = queue2.remove();

                            if (grid.length == 1) {
                            } else if (col == 0) {
                                if (help[col + 1][row] == 0) {
                                    help[col + 1][row] = 1;

                                    if (grid[col + 1][row] == 1) {
                                        queue1.add(col + 1);
                                        queue2.add(row);
                                    }
                                }
                            } else if (col == grid.length - 1) {
                                if (help[col - 1][row] == 0) {
                                    help[col - 1][row] = 1;

                                    if (grid[col - 1][row] == 1) {
                                        queue1.add(col - 1);
                                        queue2.add(row);
                                    }
                                }
                            } else {
                                if (help[col + 1][row] == 0) {
                                    help[col + 1][row] = 1;

                                    if (grid[col + 1][row] == 1) {
                                        queue1.add(col + 1);
                                        queue2.add(row);
                                    }
                                }
                                if (help[col - 1][row] == 0) {
                                    help[col - 1][row] = 1;

                                    if (grid[col - 1][row] == 1) {
                                        queue1.add(col - 1);
                                        queue2.add(row);
                                    }
                                }
                            }
                            if (grid[i].length == 1) {
                            } else if (row == 0) {
                                if (help[col][row + 1] == 0) {
                                    help[col][row + 1] = 1;

                                    if (grid[col][row + 1] == 1) {
                                        queue1.add(col);
                                        queue2.add(row + 1);
                                    }
                                }
                            } else if (row == grid[i].length - 1) {
                                if (help[col][row - 1] == 0) {
                                    help[col][row - 1] = 1;

                                    if (grid[col][row - 1] == 1) {
                                        queue1.add(col);
                                        queue2.add(row - 1);
                                    }
                                }
                            } else {
                                if (help[col][row + 1] == 0) {
                                    help[col][row + 1] = 1;

                                    if (grid[col][row + 1] == 1) {
                                        queue1.add(col);
                                        queue2.add(row + 1);
                                    }
                                }
                                if (help[col][row - 1] == 0) {
                                    help[col][row - 1] = 1;

                                    if (grid[col][row - 1] == 1) {
                                        queue1.add(col);
                                        queue2.add(row - 1);
                                    }
                                }
                            }
                        }
                        max = Math.max(max, sum);
                    }
                }
            }
        }
        return max;
    }

    public static void main(String[] args) {
        MaxAreaOfIsland maxAreaOfIsland = new MaxAreaOfIsland();

        int[][] arr = {{1, 0, 1}, {1, 0, 1}, {1, 1, 1}};
        System.out.println(maxAreaOfIsland.maxAreaOfIsland(arr));
    }
}
