package qualityQuestions;

public class CutWood {

    /**
     * Given an int array wood representing the length of n pieces of wood and an int k.
     * It is required to cut these pieces of wood such that more or equal to k pieces of the same length len are cut. What is the longest len you can get?
     * <p>
     * Example 1:
     * <p>
     * Input: wood = [5, 9, 7], k = 3
     * Output: 5
     * Explanation:
     * 5 -> 5
     * 9 -> 5 + 4
     * 7 -> 5 + 2
     * Example 2:
     * <p>
     * Input: wood = [5, 9, 7], k = 4
     * Output: 4
     * Explanation:
     * 5 -> 4 + 1
     * 9 -> 4 * 2 + 1
     * 7 -> 4 + 3
     * Example 3:
     * <p>
     * Input: wood = [1, 2, 3], k = 7
     * Output: 0
     * Explanation: We cannot make it.
     * Example 4:
     * <p>
     * Input: wood = [232, 124, 456], k = 7
     * Output: 114
     * Explanation: We can cut it into 7 pieces if any piece is 114 long, however we can't cut it into 7 pieces if any piece is 115 long.
     *
     * @param args
     */
    public static void main(String[] args) {
        int[] wood = {232, 124, 456};
        int k = 7;

        int length = getLongestLen(wood, k);
        System.out.println(length);
    }

    private static int getLongestLen(int[] wood, int k) {
        int max = 0;
        for (int w : wood) {
            max = Math.max(max, w);
        }

        int low = 1;
        int high = max;

        int result = 0;
        while (low < high) {
            int mid = low + (high - low) / 2;

            if (isValid(wood, mid, k)) {
                result = mid;
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        return result;
    }

    private static boolean isValid(int[] wood, int mid, int k) {
        int count = 0;
        for (int w : wood) {
            count += (w / mid);
        }
        return count >= k;
    }
}
