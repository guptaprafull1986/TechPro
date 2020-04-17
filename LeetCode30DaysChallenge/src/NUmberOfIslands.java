/**
 * Number of Islands
 * Given a 2d grid map of '1's (land) and '0's (water), count the number of islands.
 * An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically.
 * You may assume all four edges of the grid are all surrounded by water.
 * <p>
 * Example 1:
 * <p>
 * Input:
 * 11110
 * 11010
 * 11000
 * 00000
 * <p>
 * Output: 1
 * Example 2:
 * <p>
 * Input:
 * 11000
 * 11000
 * 00100
 * 00011
 * <p>
 * Output: 3
 */
public class NUmberOfIslands {

    private static final int[] dr = {0, 0, -1, 1};
    private static final int[] dc = {-1, 1, 0, 0};
    private boolean[][] visit;
    private int row, col;

    public int numIslands(char[][] grid) {
        int count = 0;
        row = grid.length;
        if (row == 0)
            return count;
        col = grid[0].length;

        visit = new boolean[row][col];

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == '1' && !visit[i][j]) {
                    count++;
                    visit[i][j] = true;
                    dfs(grid, i, j);
                }
            }
        }
        return count;
    }

    private void dfs(char[][] grid, int r, int c) {
        for (int i = 0; i < 4; i++) {
            int rr = r + dr[i];
            int cc = c + dc[i];
            if (isValid(grid, rr, cc)) {
                visit[rr][cc] = true;
                dfs(grid, rr, cc);
            }
        }
    }

    private boolean isValid(char[][] grid, int r, int c) {
        if (r < 0 || r >= row || c < 0 || c >= col || grid[r][c] == '0' || visit[r][c])
            return false;

        return true;
    }
}
