package googleguide;

public class PlusOne {

    public int[] plusOne(int[] arr) {

        int carry = 1;

        for (int i = arr.length - 1; i >= 0; i--) {
            int sum = arr[i] + carry;
            arr[i] = sum % 10;
            carry = sum / 10;
            if (carry == 0) return arr;
        }
        int[] result = new int[arr.length + 1];
        arr[0] = 1;

        for (int i = 0; i < arr.length; i++) {
            result[i + 1] = arr[i];
        }
        return result;
    }
}
