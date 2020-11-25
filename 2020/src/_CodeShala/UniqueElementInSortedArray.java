package _CodeShala;

public class UniqueElementInSortedArray {

    public static void main(String[] args) {
//        int[] arr = {1, 2, 2, 3, 3, 4, 4, 6, 6, 7, 7};
        int[] arr = {1, 1, 2};
        System.out.println(unique(arr));
    }

    static int unique(int[] arr) {
        int start = 0;
        int end = arr.length - 1;
        int mid;

        if(arr[0] != arr[1]) {
            return arr[0];
        }

        if(arr[arr.length - 1] != arr[arr.length - 2]) {
            return arr[arr.length - 1];
        }
        while (start <= end) {

            mid = start + (end - start) / 2;

            if (mid == 0 && arr[mid] != arr[mid + 1]) {
                return arr[mid];
            } else if (mid == arr.length - 1 && arr[mid] != arr[mid - 1]) {
                return arr[mid];
            } else if (arr[mid] != arr[mid - 1] &&
                    arr[mid] != arr[mid + 1]) {
                return arr[mid];
            } else if ((mid & 1) == 1) {
                if (arr[mid] == arr[mid - 1]) {
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }
            } else {
                if (arr[mid] == arr[mid + 1]) {
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }
            }
        }

        return -1;
    }
}
