package yzh.algorithm.everyDay;

public class No_892_SurfaceArea {
    public int surfaceArea(int[][] grid) {
        int sum = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                int num = grid[i][j];
                if (num == 0) continue;
                int area = 6 * num - 2 * (num - 1);
                if (i > 0) {
                    area -= Math.min(num, grid[i - 1][j]);
                }
                if (i < grid.length - 1) {
                    area -= Math.min(num, grid[i + 1][j]);
                }
                if (j > 0) {
                    area -= Math.min(num, grid[i][j - 1]);
                }
                if (j < grid[i].length - 1) {
                    area -= Math.min(num, grid[i][j + 1]);
                }
                sum += area;
            }
        }
        return sum;
    }
}
