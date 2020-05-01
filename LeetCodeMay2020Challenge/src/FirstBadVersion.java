/**
 * You are a product manager and currently leading a team to develop a new product. Unfortunately, the latest version of your product fails the quality check.
 * Since each version is developed based on the previous version, all the versions after a bad version are also bad.
 * <p>
 * Suppose you have n versions [1, 2, ..., n] and you want to find out the first bad one, which causes all the following ones to be bad.
 * <p>
 * You are given an API bool isBadVersion(version) which will return whether version is bad. Implement a function to find the first bad version.
 * You should minimize the number of calls to the API.
 * <p>
 * Example:
 * <p>
 * Given n = 5, and version = 4 is the first bad version.
 * <p>
 * call isBadVersion(3) -> false
 * call isBadVersion(5) -> true
 * call isBadVersion(4) -> true
 * <p>
 * Then 4 is the first bad version.
 */


public class FirstBadVersion {
    static final int[] version = {0, 1, 2, 3, 5, 6};

    public static void main(String[] args) {

        System.out.println(firstBadVersion(5));
    }

    public static int firstBadVersion(int n) {

        int start = 1;
        int end = n;
        int version = -1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            boolean isBad = isBadVersion(mid);
            if (isBad) {
                // move to left side
                version = mid;
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }

        return version;
    }

    private static boolean isBadVersion(int mid) {
        return version[mid] != mid;
    }
}
