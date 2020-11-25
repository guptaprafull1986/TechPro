package _techlead_coderpro;

public class SortNums {

    public static void main(String[] args) {
        int[] num = {3, 2, 1, 2, 3, 2, 3, 1, 1, 2, 3, 2};
        sort(num);
        for(int n : num) {
            System.out.print(n + " ");
        }
        System.out.println();
    }

    private static void sort(int[] num) {
        int one_index = 0;
        int three_index = num.length - 1;
        int index = 0;
        while (index <= three_index) {
            if (num[index] == 1) {
                swap(num, index, one_index);
                index++;
                one_index++;
            } else if (num[index] == 2) {
                index++;
            } else {
                swap(num, index, three_index);
                three_index--;
            }
        }
    }

    private static void swap(int[] num, int i, int j) {
        int temp = num[i];
        num[i] = num[j];
        num[j] = temp;
    }
}
