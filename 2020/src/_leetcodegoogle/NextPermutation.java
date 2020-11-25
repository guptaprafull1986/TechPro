package _leetcodegoogle;

public class NextPermutation {

    public static void main(String[] args) {
        int[] arr = {1, 1};
        nextPermutation(arr);
        for (int n : arr) {
            System.out.print(n + " ");
        }
        System.out.println();
    }

    public static void nextPermutation(int[] nums) {
        int i = nums.length - 1;
        while (i >= 1) {
            if (nums[i] > nums[i - 1]) {
                break;
            }
            i--;
        }
        int start = 0;
        if (i != 0) {
            int key = i - 1;
            int min = i;
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] > nums[key]) {
                    min = j;
                }
            }

            swap(nums, key, min);
            start = i;
        }
        reverse(nums, start, nums.length - 1);
    }

    static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    static void reverse(int[] nums, int low, int high) {
        while (low < high) {
            swap(nums, low, high);
            low++;
            high--;
        }
    }
}
