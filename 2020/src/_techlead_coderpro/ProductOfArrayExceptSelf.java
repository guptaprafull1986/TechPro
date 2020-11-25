package _techlead_coderpro;

import java.util.Arrays;

public class ProductOfArrayExceptSelf {
    public static void main(String[] args) {
        int[] product = productUtil(new int[]{1, 2, 3, 4});
        for (int n :
                product) {
            System.out.print(n+ " ");
        }
    }

    private static int[] productUtil(int[] arr) {
        int[] product = new int[arr.length];
        Arrays.fill(product, 1);
        for (int i = 1; i < arr.length; i++) {
            product[i] = product[i - 1] * arr[i - 1];
        }

        int p = arr[arr.length - 1];
        for (int i = arr.length - 2; i >= 0; i--) {
            product[i] = product[i] * p;
            p *= arr[i];
        }
        return product;
    }
}
