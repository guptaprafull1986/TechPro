public class RaotatedBinarySearch {

    public static void main(String[] args) {

    }

    public static int search(int[] nums, int target) {
        if (nums.length == 0) return -1;

        int pivot = getPivot(nums, 0, nums.length - 1);
        if (pivot == -1) {
            return bt(nums, 0, nums.length - 1, target);
        }
        if (nums[pivot] == target) {
            return pivot;
        }
        if (nums[0] <= target) {
            return bt(nums, 0, pivot - 1, target);
        }
        return bt(nums, pivot + 1, nums.length - 1, target);
    }

    static int bt(int[] nums, int start, int end, int target) {
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (target == nums[mid]) {
                return mid;
            } else if (target > nums[mid]) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        return -1;
    }

    static int getPivot(int[] nums, int low, int high) {
        if (low > high) {
            return -1;
        }

        if (low == high) {
            return low;
        }

        int mid = low + (high - low) / 2;
        if (mid < high && nums[mid] > nums[mid + 1]) {
            return mid;
        }

        if (mid > low && nums[mid] < nums[mid - 1]) {
            return mid - 1;
        }

        if (nums[low] >= nums[mid]) {
            return getPivot(nums, low, mid - 1);
        }
        return getPivot(nums, mid + 1, high);
    }
}
