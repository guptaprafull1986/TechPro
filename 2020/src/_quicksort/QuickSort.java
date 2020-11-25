package _quicksort;

public class QuickSort {
    public static void main(String[] args) {
        int[] arr = {5, 6, 3, 4, 8, 7, 6, 5};
        sort(arr, false);
        int[] arr1 = {5, 4, 3, 2, 1};
        sort(arr1, false);

        int[] arr2 = {5, 6, 3, 4, 8, 7, 6, 5};
        sort(arr2, true);
    }

    private static void sort(int[] arr, boolean isDesc) {
        if (!isDesc)
            quickSort(arr, 0, arr.length - 1);
        else
            quickSortDesc(arr, 0, arr.length - 1);

        for (int n : arr) {
            System.out.print(n + " ");
        }
        System.out.println();
    }

    private static void quickSortDesc(int[] arr, int start, int end) {
        if (start < end) {
            int pivot = partitionDesc(arr, start, end);
            quickSort(arr, start, pivot - 1);
            quickSort(arr, pivot + 1, end);
        }
    }

    private static int partitionDesc(int[] arr, int start, int end) {
        int key = arr[end];
        int index = start - 1;
        for (int i = start; i < end; i++) {
            if (arr[i] > key) {
                index++;
                swap(arr, index, i);
            }
        }
        index += 1;
        swap(arr, index, end);
        return index;
    }

    private static void quickSort(int[] arr, int start, int end) {
        if (start < end) {
            int pivot = partition(arr, start, end);
            quickSort(arr, start, pivot - 1);
            quickSort(arr, pivot + 1, end);
        }
    }

    private static int partition(int[] arr, int start, int end) {
        int key = arr[end];
        int index = start - 1;
        for (int i = start; i < end; i++) {
            if (arr[i] < key) {
                index++;
                swap(arr, index, i);
            }
        }
        swap(arr, index + 1, end);
        return index + 1;
    }

    private static void swap(int[] arr, int x, int y) {
        int temp = arr[x];
        arr[x] = arr[y];
        arr[y] = temp;
    }
}
