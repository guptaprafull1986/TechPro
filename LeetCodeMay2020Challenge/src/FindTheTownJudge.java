public class FindTheTownJudge {

    public static void main(String[] args) {
        int[][] arr = {{1, 2}, {2, 3}};
        int judge = findJudge(3, arr);
        System.out.println(judge);
    }

    public static int findJudge(int N, int[][] arr) {
        int[] trust = new int[N + 1];
        int[] trusted = new int[N + 1];
        for (int i = 0; i < arr.length; i++) {
            int x = arr[i][0];
            int y = arr[i][1];
            trust[x]++;
            trusted[y]++;
        }

        for (int i = 1; i <= N; i++) {
            if (trust[i] == 0 && trusted[i] == N - 1) {
                return i;
            }
        }
        return -1;


    }
}
