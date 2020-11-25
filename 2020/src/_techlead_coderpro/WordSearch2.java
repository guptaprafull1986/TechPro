package _techlead_coderpro;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WordSearch2 {
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int m;
    static int n;

    public static void main(String[] args) {
        char[][] board = {
                {'o', 'a', 'a', 'n'},
                {'e', 't', 'a', 'e'},
                {'i', 'h', 'k', 'r'},
                {'i', 'f', 'l', 'v'}};
        String[] words = {"oath", "pea", "eat", "rain"};
        List<String> list = findWords(board, words);
        for (String s :
                list) {
            System.out.println(s);
        }
    }

    public static List<String> findWords(char[][] board, String[] words) {
        List<String> list = new ArrayList<>();
        m = board.length;
        if (m == 0) return list;

        Set<String> set = new HashSet<>();
        n = board[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                char c = board[i][j];
                for (String s : words) {
                    if (!s.isEmpty() && s.charAt(0) == c
                            && isFound(board, new boolean[m][n], s, 0, i, j)) {
                        set.add(s);
                    }
                }

            }
        }

        for (String s : set) {
            list.add(s);
        }

        return list;
    }

    static boolean isFound(char[][] board, boolean[][] visit, String word, int index,
                           int r, int c) {
        if (index == word.length() - 1) {
            return true;
        }

        visit[r][c] = true;

        for (int i = 0; i < 4; i++) {
            int row = r + dx[i];
            int col = c + dy[i];
            if (row < 0 || row >= m || col < 0 || col >= n
                    || visit[row][col] || board[row][col] != word.charAt(index + 1)) {
                continue;
            }

            if (isFound(board, visit, word, index + 1, row, col)) {
                return true;
            }
        }

        return false;
    }
}


