package _dfs;

public class NumberOfIceLands {
    static int R;
    static int C;
    static boolean[][] visit;
    //left, right, top , bottom, TL, TR, BL, BR
    static final int[] dr = {0, 0, -1, 1, -1, -1, 1, 1};
    static final int[] dc = {-1, 1, 0, 0, -1, 1, -1, 1};

    static int numberOfIceLands(int[][] matrix) {
        int count = 0;
        R = matrix.length;
        if (R == 0) return count;
        C = matrix[0].length;

        visit = new boolean[R][C];
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (matrix[i][j] == 1 && !visit[i][j]) {
                    count++;
                    dfs(matrix, i, j);
                }
            }
        }
        return count;
    }

    static void dfs(int[][] matrix, int row, int col) {
        visit[row][col] = true;
        for (int i = 0; i < 8; i++) {
            int r = row + dr[i];
            int c = col + dc[i];
            if (isValid(matrix, r, c)) {
                dfs(matrix, r, c);
            }
        }
    }

    static boolean isValid(int[][] matrix, int r, int c) {
        if (r < 0 || r >= R || c < 0 || c >= C || visit[r][c] || matrix[r][c] == 0) {
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
        int mat[][] = {{1, 1, 0, 0, 0},
                {0, 1, 0, 0, 1},
                {1, 0, 0, 1, 1},
                {0, 0, 0, 0, 0},
                {1, 0, 1, 0, 1}
        };

        System.out.println(numberOfIceLands(mat));
    }

}
