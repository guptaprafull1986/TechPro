package google;

public class SearchIn2DSortedMatrix {
    public static void main(String[] args) {
        int[][] matrix =
                {
                        {1, 3, 5, 7},
                        {10, 11, 16, 20},
                        {23, 30, 34, 50}

                };

        System.out.println(binarySearch(matrix, 10));
        System.out.println(binarySearch(matrix, 23));
        System.out.println(binarySearch(matrix, 8));
    }

    static boolean binarySearch(int[][] matrix, int target) {

        int row = 0;
        int col = matrix[0].length - 1;

        while (row <= matrix.length - 1 && col >= 0) {

            int data = matrix[row][col];

            if (data == target) {
                return true;
            } else if (target < data) {
                col--;
            } else {
                row++;
            }
        }
        return false;
    }
}
