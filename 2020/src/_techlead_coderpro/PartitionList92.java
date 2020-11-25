package _techlead_coderpro;

public class PartitionList92 {
    public static void main(String[] args) {
        int[] arr = {8, 9, 2, 4, 1, 1, 0};
        int k = 3;
        partitionList(arr, k);
        for (int n : arr) {
            System.out.print(n + " ");
        }
    }

    static void partitionList(int[] arr, int k) {
        int low = 0;
        int high = arr.length - 1;
        while (low <= high) {
            if (arr[low] > k) {
                int temp = arr[low];
                arr[low] = arr[high];
                arr[high] = temp;
                high--;
            }
            low++;
        }
    }
}
