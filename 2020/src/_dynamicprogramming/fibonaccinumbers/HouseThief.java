package _dynamicprogramming.fibonaccinumbers;

public class HouseThief {
    public static void main(String[] args) {
        System.out.println(maxMoney(
                new int[]{2, 5, 1, 3, 6, 2, 4}, 0));

        System.out.println(maxMoneyDP(
                new int[]{2, 5, 1, 3, 6, 2, 4}));
    }

    static int maxMoney(int[] arr, int index) {
        if (index >= arr.length) return 0;

        int stealCurrent = arr[index] + maxMoney(arr, index + 2);
        int stealNext = maxMoney(arr, index + 1);

        return Math.max(stealCurrent, stealNext);
    }

    static int maxMoneyDP(int[] arr) {
        if (arr.length == 0) return 0;
        int prev = 0;
        int current = arr[0];
        for (int i = 1; i < arr.length; i++) {
            int temp = Math.max(prev + arr[i], current);
            prev = current;
            current = temp;
        }
        return current;
    }
}
