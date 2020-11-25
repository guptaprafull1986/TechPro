package _techlead_coderpro;

import java.util.HashMap;
import java.util.Map;

public class MacConnectedColorInGrid {
    public static void main(String[] args) {
        int[][] grid = {
                {2, 3, 3, 3},
                {2, 2, 3, 3},
                {2, 2, 2, 1},
                {2, 2, 3, 3}
        };
        System.out.println(maxColorLengthGrid(grid));
    }

    static int m;
    static int n;
    static int[][] matrix;
    static Map<String, Boolean> visit;
    static final int[][] neighbour = {{0, -1}, {0, 1}, {-1, 0}, {1, 0}};

    private static int maxColorLengthGrid(int[][] grid) {
        m = grid.length;
        if (m == 0) return 0;

        n = grid[0].length;
        matrix = grid;
        int max = 0;
        visit = new HashMap<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int current = dfs(i, j, matrix[i][j]);
                max = Math.max(max, current);

            }
        }
        return max;
    }

    private static int dfs(int i, int j, int val) {
        String key = getKey(i, j);
        if (visit.containsKey(key)) {
            return 0;
        }
        int result = 1;
        visit.put(key, true);

        for (int x = 0; x < neighbour.length; x++) {
            int row = i + neighbour[x][0];
            int col = j + neighbour[x][1];
            if (!isValid(row, col, val)) {
                continue;
            }
            result += dfs(row, col, val);
        }
        return result;
    }

    private static String getKey(int i, int j) {
        return i + ", " + j;
    }

    private static boolean isValid(int row, int col, int val) {
        if (row < 0 || row >= m || col < 0
                || col >= n || visit.containsKey(getKey(row, col))
                || matrix[row][col] != val) {
            return false;
        }
        return true;
    }
}
