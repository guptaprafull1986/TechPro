import java.util.PriorityQueue;

public class Coding {

    public static void main(String[] args) {

        int[] arr = {9, 9};
        int[] a = MinHeap.increment(arr);

        for(int i : a) {
            System.out.print(i + " ");
        }
        System.out.println();
//        int[] arr1 = {4, -1, 2, 3};
//        int[] arr2 = {54, -10, 0, 31, 6};
//
//        int k = 4;  // 4
//
//        MinHeap minHeap = new MinHeap(k);
//        int index = 0;
//        int i = 0;
//        int j = 0;
//        while(minHeap.size() < k) {
//            if(i < arr1.length) {
//                minHeap.enqueue(arr1[i++]);
//                //i++;
//            } else {
//                minHeap.enqueue(arr2[j++]);
//
//            }
//        }



    }
}

class MinHeap {

    private int size;
    int[] arr;
    int top;
    public MinHeap(int size) {
        this.size = size;
        arr = new int[this.size];
        top = 0;
    }
    public int size() {
        return top + 1;
    }

    public int peek() {
        if(top == 0) {
            throw new RuntimeException("Heap is empty()");
        }
        return arr[top - 1];
    }

    public void enqueue(int item) {
        arr[top] = item;
        int child = top;
        int parent = (child - 1) / 2;
        top++;

        while(child != 0 && isValid(arr[child], arr[parent])) {
            swap(child, parent);
            child = parent;
            parent = (child - 1) / 2;
        }
    }

    private boolean isValid(int x, int y) {
        return x < y ? true : false;
    }

    private void swap(int x, int y) {
        int temp = arr[x];
        arr[x] = arr[y];
        arr[y] = temp;
    }
    public int dequeue() {
        int value = arr[0];
        arr[0] = arr[top - 1];
        top--;
        reorderQueue(0);
        return value;
    }

    private void reorderQueue(int parent) {
        int minIndex = -1;
        int left = parent * 2 + 1;
        int right = parent * 2 + 2;

        if(right > minIndex) {
            if(left > minIndex) {
                return;
            } else {
                minIndex = left;
            }
        } else {
            if(arr[left] < arr[right]) {
                minIndex = left;
            } else {
                minIndex = right;
            }
        }

        if(arr[minIndex] < arr[parent]) {
            swap(minIndex, parent);
            reorderQueue((minIndex));
        }
    }

    static int[]  increment(int[] arr) {
        int carry = 1;

        for(int i = arr.length - 1; i >= 0; i--) {
            int sum = arr[i] + carry;
            arr[i] = sum % 10;
            carry = sum / 10;
            if(carry == 0) {
                return arr;
            }
        }

        int[] result = new int[arr.length + 1];
        result[0] = 1;
        for(int i = 0; i < arr.length; i++) {
            result[i + 1] = arr[i];
        }
        return result;
    }
}

// a1 not sorted
// a2 not sorted
// 2nd highest

//a = a1.length + a2.length

// (m + n) long (m + n)


//kth element
//(m + n)logk