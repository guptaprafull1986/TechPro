package google;

public class ThreeSum {
    public static void main(String[] args) {

    }

    public static int threeSumCount(int[] arr, int target) {
        int count = 0;

        int n = arr.length;
        for (int i = 0; i < n - 2; i++) {
            int low = i + 1;
            int high = n - 1;
            while (low < high) {
                int sum = arr[i] + arr[low] + arr[high];
                if (sum < target) {
                    low++;
                    count += (high - low);
                } else {
                    high--;
                }
            }
        }
        return count;
    }
}
