package _techlead_coderpro;

public class WordSearch {
    public static void main(String[] args) {

        char[][] matrix = {
                {'F', 'A', 'C', 'I'},
                {'O', 'B', 'Q', 'P'},
                {'A', 'N', 'O', 'B'},
                {'M', 'A', 'S', 'S'}
        };
    }

    boolean wordSearch(char[][] matrix, String word) {

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (wordSearchRight(matrix[i], j, word)) {
                    return true;
                }
                if (wordSearchBottom(matrix, i, word)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean wordSearchBottom(char[][] matrix, int i, String word) {

        return false;
    }

    private boolean wordSearchRight(char[] matrix, int c, String word) {
        int in = 0;
        for (int i = c; i < matrix.length; i++) {
            if (matrix[i] != word.charAt(in)) {
                return false;
            }
        }
        return true;
    }
}
