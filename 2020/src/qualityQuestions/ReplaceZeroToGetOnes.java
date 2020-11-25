package qualityQuestions;

import java.util.HashMap;
import java.util.Map;

public class ReplaceZeroToGetOnes {
    public static void main(String[] args) {
//        int[] array = {0, 0, 1, 1, 1, 1, 0, 0, 1, 1, 1, 1, 0, 1, 1, 0, 1, 0, 1, 1, 1, 1, 0};
        int[] array = {1, 1, 0, 0, 1, 0, 1, 1, 1, 0, 1, 1, 1};
        Map<Integer, Obj> map = new HashMap<>();

        int leftCount = 0;
        int rightCount = 0;
        int end = array.length;
        for (int i = 0; i < end; i++) {
            if (array[i] == 0) {
                if (!map.containsKey(i)) {
                    map.put(i, new Obj(leftCount, 0));
                } else {
                    map.get(i).left = leftCount;
                }
                leftCount = 0;
            } else {
                leftCount++;
            }


            if (array[end - 1 - i] == 0) {
                if (!map.containsKey(end - 1 - i)) {
                    map.put(end - 1 - i, new Obj(0, rightCount));
                } else {
                    map.get(end - 1 - i).right = rightCount;
                }
                rightCount = 0;
            } else {
                rightCount++;
            }
        }

//        count = 0;
//        for (int i = array.length - 1; i >= 0; i--) {
//            if (array[i] == 0) {
//                map.get(i).right = count;
//                count = 0;
//            } else {
//                count++;
//            }
//        }

        int max = 0;
        int index = -1;
        for (Map.Entry<Integer, Obj> entry : map.entrySet()) {
            Obj obj = entry.getValue();
            int sum = obj.left + obj.right;
            if (sum > max) {
                max = sum;
                index = entry.getKey();
            }
        }
        System.out.println("index is : " + index);
        for (Map.Entry<Integer, Obj> entry : map.entrySet()) {
            Obj obj = entry.getValue();
            System.out.println(entry.getKey() + " left : " + obj.left + " right : " + obj.right);
        }
    }
}

class Obj {
    int left, right;

    public Obj(int left, int right) {
        this.left = left;
        this.right = right;
    }
}