package _techlead_coderpro;

public class MazePath89 {
    public static void main(String[] args) {
        int[][] maze = {
                {0, 1, 0},
                {0, 0, 1},
                {0, 0, 0}
        };
        System.out.println(mazePathCount(maze));
    }

    static int mazePathCount(int[][] maze) {
        int m = maze.length;
        int n = maze[0].length;
        int[][] path = new int[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 && j == 0) {
                    path[i][j] = 1;
                } else if (i == 0) {
                    path[i][j] = maze[i][j] == 0 ? path[i][j - 1] : 0;
                } else if (j == 0) {
                    path[i][j] = maze[i][j] == 0 ? path[i - 1][j] : 0;
                } else {
                    path[i][j] = maze[i][j] == 0 ? path[i][j - 1] + path[i - 1][j] : 0;
                }
            }
        }

        return path[m - 1][n - 1];
    }
}
