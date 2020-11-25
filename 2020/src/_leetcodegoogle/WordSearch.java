package _leetcodegoogle;

public class WordSearch {
    public static void main(String[] args) {

        char[][] board =
                {
                        {'A', 'B', 'C', 'E'},
                        {'S', 'F', 'C', 'S'},
                        {'A', 'D', 'E', 'E'}
                };

        /**
         * Given word = "ABCCED", return true.
         * Given word = "SEE", return true.
         * Given word = "ABCB", return false.
         */
        System.out.println(exist(board, "ABCCED"));
        System.out.println(exist(board, "SEE"));
        System.out.println(exist(board, "ABCB"));

        char[][] b =
                {
                        {'A'}
                };
        System.out.println(exist(b, "A"));
    }

    static int[] dr = {0, 0, -1, 1};
    static int[] dc = {-1, 1, 0, 0};

    static int m;
    static int n;

    static public boolean exist(char[][] board, String word) {
        if (word == null) return false;
        if (word.isEmpty()) return true;
        m = board.length;
        if (m == 0) return false;
        n = board[0].length;
        char[] str = word.toCharArray();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == str[0]) {
                    boolean[][] visit = new boolean[m][n];
                    visit[i][j] = true;
                    if (existRec(board, visit, str, 1, i, j)) {
                        return true;
                    }
                    visit[i][j] = false;
                }
            }
        }
        return false;
    }

    private static boolean existRec(char[][] board, boolean[][] visit,
                                    char[] str, int index,
                                    int r, int c) {
        if (index >= str.length) return true;


        for (int i = 0; i < 4; i++) {
            int row = r + dr[i];
            int col = c + dc[i];

            if (valid(board, visit, str, row, col, index)) {
                visit[r][c] = true;
                if (existRec(board, visit, str,
                        index + 1, row, col)) {
                    return true;
                }
                visit[r][c] = false;
            }
        }
        return false;
    }

    private static boolean valid(char[][] board, boolean[][] visit, char[] str, int row, int col, int index) {
        if (row < 0 || row >= m
                || col < 0 || col >= n
                || visit[row][col]
                || str[index] != board[row][col])
            return false;

        return true;
    }
}
