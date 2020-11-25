package google;

public class SpiralMatrix {
    public static void main(String[] args) {
        int[][] matrix =
                {
                        {1, 2, 3, 4},
                        {5, 6, 7, 8},
                        {9, 0, 1, 1},
                        {3, 4, 5, 6}
                };

        printSpiral(matrix);
    }

    private static void printSpiral(int[][] matrix) {
        int lowR = 0;
        int highR = matrix.length - 1;
        int lowC = 0;
        int highC = matrix[0].length - 1;

        while (lowR <= highR && lowC <= highC) {

            //left to right
            for (int c = lowC; c <= highC; c++) {
                System.out.print(matrix[lowR][c] + " ");
            }
            lowR++;

            //top to bottom
            for (int r = lowR; r <= highR; r++) {
                System.out.print(matrix[r][highC] + " ");
            }
            highC--;

            //right to left
            for (int c = highC; c >= lowC; c--) {
                System.out.print(matrix[highR][c] + " ");
            }
            highR--;

            //bottom to top
            for (int r = highR; r >= lowR; r--) {
                System.out.print(matrix[r][lowC] + " ");
            }
            lowC++;
        }
    }
}
