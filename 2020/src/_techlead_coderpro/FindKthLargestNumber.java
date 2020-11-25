package _techlead_coderpro;

public class FindKthLargestNumber {
    public static void main(String[] args) {
        System.out.println(quickSelect(new int[]{8, 7, 2, 3, 4, 1, 5, 6, 9, 0}, 1));
    }

    private static int quickSelect(int[] arr, int k) {
        k = arr.length - k;
        int left = 0;
        int right = arr.length - 1;

        while (left <= right) {
            int pivotIndex = partition(arr, left, right);
            if (pivotIndex == k) {
                return arr[pivotIndex];
            } else if (pivotIndex > k) {
                right = pivotIndex - 1;
            } else {
                left = pivotIndex + 1;
            }
        }
        return -1;
    }

    private static int partition(int[] arr, int left, int right) {
        int key = arr[right];
        int i = left;
        for (int j = left; j < right; j++) {
            if (arr[j] <= key) {
                int temp = arr[j];
                arr[j] = arr[i];
                arr[i] = temp;
                i++;
            }
        }
        int temp = arr[i];
        arr[i] = arr[right];
        arr[right] = temp;
        return i;
    }
}
