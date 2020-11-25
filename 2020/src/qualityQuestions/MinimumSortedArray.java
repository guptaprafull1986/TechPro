package qualityQuestions;

/**
 * Custom sorted array
 * n an array, elements at any two indices can be swapped  a single operation called a move.
 * For example, if the arr = [17, 4, 8], swap arr[0] = 12 and arr[2] = 8 to get arr = [8, 4, 17] in a single move.
 * Determine the minimum numbers of move required to sort an array such that all of the even elements re at the beginning
 * of the array nd all of the odd elements are at the end of an array.
 * <p>
 * Example
 * arr = [6, 3, 4 ,5]
 * The following four rrays are valid custom sorted arrays:
 * a = [6, 4, 3, 5]
 * a = [4, 6, 3, 5]
 * a = [6, 4, 5, 3]
 * a = [4, 6, 5, 3]
 * <p>
 * he most efficient sorting requires 1 move: swap the 4 and 3.
 * <p>
 * Function description:
 * complete the function moves in the editor below.
 * <p>
 * moves has the following parameter(s).
 * int arr[n]: an array of positive numbers
 * Returns
 * int: the minimum number of moves t takes to sort an array fo integers ith all even elements at earlier indices than that of odd elements
 * <p>
 * Note:
 * The order of he elements withing even or odd oes not matter.
 */
public class MinimumSortedArray {

    public static void main(String[] args) {
        int[] arr = new int[]{6, 3, 4, 5};
        System.out.println(moves(arr));
        printArray(arr);


        arr = new int[]{3, 5, 7, 4, 3, 2, 4, 5, 6, 7, 8, 7, 6, 5, 4, 5, 6, 7};
        System.out.println(moves(arr));
        printArray(arr);
    }

    private static void printArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    static int moves(int[] arr) {

        // 6 , 3 ,4 5
        int even = 0;
        int odd = arr.length - 1;

        int moves = 0;
        while (even < odd) {
            while ((arr[even] & 1) == 0) {
                even++;
            }
            while ((arr[odd] & 1) == 1) {
                odd--;
            }

            moves++;
            int temp = arr[even];
            arr[even] = arr[odd];
            arr[odd] = temp;
            even++;
            odd--;
        }
        return moves;
    }
}
