package _techlead_coderpro;

public class BalancedBinaryTree {

    public static void main(String[] args) {

    }

    static boolean isBalancedTreeUtil(TreeNode node, Height height) {
        if (node == null) {
            height.height = 0;
            return true;
        }

        Height leftHeight = new Height();
        Height rightHeight = new Height();

        boolean isLeft = isBalancedTreeUtil(node.left, leftHeight);
        boolean isRight = isBalancedTreeUtil(node.right, leftHeight);

        height.height = Math.max(leftHeight.height, rightHeight.height) + 1;

        if (Math.abs(leftHeight.height - rightHeight.height) > 1) return false;

        return isLeft && isRight;
    }

    static class Height {
        int height;
    }

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
            left = null;
            right = null;
        }
    }
}
