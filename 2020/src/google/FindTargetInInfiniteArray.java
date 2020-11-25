package google;

public class FindTargetInInfiniteArray {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 11, 12, 13, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1};
        System.out.println(isExist(arr, 70));
    }

    public static boolean isExist(int[] arr, int target) {

        int low = 0;
        int high = 1;
        while (arr[high] != -1 && target > arr[high]) {
            low = high;
            high = high << 1;
            if (arr[high] == target) return true;
        }
        return binarySearch(arr, low, high, target);
    }

    private static boolean binarySearch(int[] arr, int low, int high, int target) {

        while ((low <= high)) {

            int mid = low + (high - low) / 2;
            if (arr[mid] == target) return true;
            else if (arr[mid] == -1 || arr[mid] > target) high = mid - 1;
            else low = mid + 1;
        }
        return false;
    }
}
