public class Permutation1 {

    public static void main(String[] args) {

        permutation(3);
    }

    private static void permutation(int num) {
        boolean[] visit = new boolean[num + 1];
        int[] array = new int[num + 1];
        permutationUtil(array, visit, 1, num);
    }

    private static void permutationUtil(int[] array, boolean[] visit, int index, int num) {
        if (index > num) {
            for (int i = 1; i <= num; i++) {
                System.out.print(array[i] + " ");
            }
            System.out.println();
            return;
        }

        for (int i = 1; i <= num; i++) {
            if (!visit[i]) {
                visit[i] = true;
                array[index] = i;
                permutationUtil(array, visit, index + 1, num);
                visit[i] = false;
            }
        }
    }
}
