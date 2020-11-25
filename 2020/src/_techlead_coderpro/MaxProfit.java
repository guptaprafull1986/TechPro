package _techlead_coderpro;

public class MaxProfit {
    public static void main(String[] args) {
        int[] stocks = {9, 11, 8, 5, 7, 10};

        System.out.println(maxProfit(stocks));
    }

    private static int maxProfit(int[] stocks) {
        int maxProfit = 0;
        int min = Integer.MAX_VALUE;
        for (int n : stocks) {
            min = Math.min(min, n);
            maxProfit = Math.max(maxProfit, n - min);
        }
        return maxProfit;
    }
}
