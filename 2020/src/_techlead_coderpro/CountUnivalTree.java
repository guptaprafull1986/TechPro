package _techlead_coderpro;

public class CountUnivalTree {


    int count = 0;

    public int univalCount(TreeNode node) {
        count = 0;
        univalCountUtil(node);
        return count;
    }

    boolean univalCountUtil(TreeNode root) {
        if (root == null) return true;

        boolean left = univalCountUtil(root.left);
        boolean right = univalCountUtil(root.right);

        if (left && right) {
            if (root.left != null && root.left.val != root.val)
                return false;
            if (root.right != null && root.right.val != root.val)
                return false;

            count += 1;
            return true;
        }
        return false;
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
