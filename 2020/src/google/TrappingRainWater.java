package google;

public class TrappingRainWater {
    public static void main(String[] args) {
        int[] arr = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        System.out.println(trap(arr));
    }

    public static int trap(int[] arr) {
        int sum = 0;
        int[] left = new int[arr.length];
        int[] right = new int[arr.length];

        left[0] = arr[0];
        right[arr.length - 1] = arr[arr.length - 1];
        for (int i = 1; i < arr.length; i++) {
            left[i] = Math.max(left[i - 1], arr[i]);
        }

        for (int i = arr.length - 2; i >= 0; i--) {
            right[i] = Math.max(arr[i], right[i + 1]);
        }

        /*print(left);
        print(right);
        for (int i = 0; i < arr.length; i++) {
            left[i] = Math.min(left[i], right[i]);
        }

        print(left);*/
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < left[i]) {
                sum += Math.min(right[i], left[i]) - arr[i];
            }
        }
        return sum;
    }


    static void print(int[] arr) {
        for (int n : arr) {
            System.out.print(n + " ");
        }
        System.out.println();
    }
}
