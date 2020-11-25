package _techlead_coderpro;

import java.util.HashMap;
import java.util.Map;

public class FrequentSubTreeSum91 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(1);
        root.right = new TreeNode(-3);
        System.out.println(frequentSum(root));
    }

    static int frequentSum(TreeNode root) {
        Map<Integer, Integer> map = new HashMap<>();
        sumUtils(root, map);
        int maxSum = 0;
        int maxCount = 0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() > maxCount) {
                maxSum = entry.getKey();
                maxCount = entry.getValue();
            }
        }
        return maxSum;
    }

    private static int sumUtils(TreeNode node, Map<Integer, Integer> map) {
        if (node == null) return 0;

        int left = sumUtils(node.left, map);
        int right = sumUtils(node.right, map);
        int sum = left + right + node.val;
        if (!map.containsKey(sum)) {
            map.put(sum, 1);
        } else {
            map.put(sum, map.get(sum) + 1);
        }
        return sum;
    }
}
