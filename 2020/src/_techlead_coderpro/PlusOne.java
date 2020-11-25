package _techlead_coderpro;

import java.util.Arrays;

public class PlusOne {
    public static void main(String[] args) {
//        int[] arr = {1, 5, 2, 9};
        int[] arr = {1, 5, 2, 9};
        System.out.println(Arrays.toString(plusOne(new int[]{1, 5, 2, 9})));
        System.out.println(Arrays.toString(plusOne(new int[]{9, 9})));

    }

    private static int[] plusOne(int[] arr) {
        int carry = 1;
        int sum = 0;
        for (int i = arr.length - 1; i >= 0; i--) {
            sum = arr[i] + carry;
            if (sum < 10) {
                arr[i] = sum;
                carry = 0;
                break;
            }
            arr[i] = sum % 10;
            carry = 1;
        }
        if (carry == 1) {
            int[] array = new int[arr.length + 1];
            array[0] = 1;
            for (int i = 0; i < arr.length; i++) {
                array[i + 1] = arr[i];
            }
            return array;
        } else {
            return arr;
        }
    }
}
