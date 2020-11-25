/**
 * An image is represented by a 2-D array of integers, each integer representing the pixel value of the image (from 0 to 65535).
 * <p>
 * Given a coordinate (sr, sc) representing the starting pixel (row and column) of the flood fill, and a pixel value newColor, "flood fill" the image.
 * <p>
 * To perform a "flood fill", consider the starting pixel, plus any pixels connected 4-directionally to the starting pixel of the same color as the starting pixel,
 * plus any pixels connected 4-directionally to those pixels (also with the same color as the starting pixel), and so on. Replace the color of all of the aforementioned pixels with the newColor.
 * <p>
 * At the end, return the modified image.
 * <p>
 * Example 1:
 * Input:
 * image = [[1,1,1],[1,1,0],[1,0,1]]
 * sr = 1, sc = 1, newColor = 2
 * Output: [[2,2,2],[2,2,0],[2,0,1]]
 * Explanation:
 * From the center of the image (with position (sr, sc) = (1, 1)), all pixels connected
 * by a path of the same color as the starting pixel are colored with the new color.
 * Note the bottom corner is not colored 2, because it is not 4-directionally connected
 * to the starting pixel.
 * Note:
 * <p>
 * The length of image and image[0] will be in the range [1, 50].
 * The given starting pixel will satisfy 0 <= sr < image.length and 0 <= sc < image[0].length.
 * The value of each color in image[i][j] and newColor will be an integer in [0, 65535].
 */
public class FloodFill {
    private static final int[] dr = {0, 0, -1, 1};
    private static final int[] dc = {-1, 1, 0, 0};
    private static int R;
    private static int C;
    private static boolean[][] visit;

    public static void main(String[] args) {
//        int[][] image = {{0, 0, 0}, {0, 1, 0}};
        int[][] image = {{1, 1, 1}, {1, 1, 0}, {1, 0, 1}};
        image = floodFill(image, 1, 1, 2);
        for (int i = 0; i < image.length; i++) {
            for (int j = 0; j < image[0].length; j++) {
                System.out.print(image[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        R = image.length;
        C = image[0].length;
        visit = new boolean[R][C];
        int ec = image[sr][sc];
        visit[sr][sc] = true;
        image[sr][sc] = newColor;
        dfs(image, sr, sc, ec, newColor);
        return image;
    }

    static void dfs(int[][] image, int r, int c, int ec, int nc) {
        for (int x = 0; x < 4; x++) {
            int row = r + dr[x];
            int col = c + dc[x];
            if (isValid(image, row, col, ec)) {
                visit[row][col] = true;
                image[row][col] = nc;
                dfs(image, row, col, ec, nc);
            }
        }
    }

    private static boolean isValid(int[][] image, int row, int col, int color) {
        if (row < 0 || row >= R || col < 0 || col >= C
                || visit[row][col] || image[row][col] != color) {
            return false;
        }

        return true;
    }
}
