package codechef;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix {

    public static void main(String[] args) {
        int[][] matrix = {
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12}
        };
        List<Integer> list = spiralOrder(matrix);
        for (int n :
                list) {
            System.out.print(n + " ");
        }
        System.out.println();
    }

    static public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> list = new ArrayList<>();
        int R = matrix.length;
        if (R == 0) return list;
        int C = matrix[0].length;
        int Cmin = 0;
        int Cmax = C - 1;
        int Rmin = 0;
        int Rmax = R - 1;

        while (Cmin <= Cmax && Rmin <= Rmax) {

            int c = Cmin;
            while (c <= Cmax) {
                list.add(matrix[Rmin][c]);
                c++;
            }
            Rmin++;

            int r = Rmin;
            while (r <= Rmax) {
                list.add(matrix[r][Cmax]);
                r++;
            }
            Cmax--;

            c = Cmax;
            while (c >= Cmin) {
                list.add(matrix[Rmax][c]);
                c--;
            }
            Rmax--;

            r = Rmax;
            while (r >= Rmin) {
                list.add(matrix[r][Cmin]);
                r--;
            }
            Cmin++;
        }

        return list;
    }
}
