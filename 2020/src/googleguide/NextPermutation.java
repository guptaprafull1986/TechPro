package googleguide;

/**
 * Implement next permutation, which rearranges numbers into the lexicographically
 * next greater permutation of numbers.
 * If such arrangement is not possible, it must rearrange it as the lowest possible
 * order (ie, sorted in ascending order).
 * The replacement must be in-place, do not allocate extra memory.
 * Here are some examples. Inputs are in the left-hand column and its corresponding
 * outputs are in the right-hand column.
 * <p>
 * 1,2,3 → 1,3,2
 * 3,2,1 → 1,2,3
 * 1,1,5 → 1,5,1
 */
public class NextPermutation {

    public static void main(String[] args) {
        int[] arr = nextPermutation(new int[]{1, 2, 3});
        print(arr);
        arr = nextPermutation(new int[]{3, 2, 1});
        print(arr);
        arr = nextPermutation(new int[]{1, 1, 3});
        print(arr);
        arr = nextPermutation(new int[]{1, 4, 8, 7, 5, 3, 2});
        print(arr);
    }

    private static void print(int[] arr) {
        for (int n :
                arr) {
            System.out.print(n + " ");
        }
        System.out.println();
    }


    static int[] nextPermutation(int[] arr) {

        int n = arr.length;
        int i = n - 1;
        for (; i >= 1; i--) {
            if (arr[i] > arr[i - 1]) {
                break;
            }
        }

        if (i == 0) {
            rotateArray(arr, 0, n - 1);
        } else {

            int num = arr[i - 1];
            int min = i;
            for (int j = i + 1; j < n; j++) {
                if(arr[j] > num && arr[j] < arr[min]) {
                    min = j;
                }
            }
            swap(arr, i - 1, min);


            rotateArray(arr, i, n - 1);
        }

        return arr;
    }

    private static void swap(int[] arr, int start, int end) {
        int temp = arr[start];
        arr[start] = arr[end];
        arr[end] = temp;
    }

    private static void rotateArray(int[] arr, int start, int end) {
        while (start < end) {
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
    }


}
