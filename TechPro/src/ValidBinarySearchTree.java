public class ValidBinarySearchTree {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(100);
        root.left = new TreeNode(50);
        root.right = new TreeNode(200);
        root.right.left = new TreeNode(150);

        System.out.println(isValidBst(root, Integer.MIN_VALUE, Integer.MAX_VALUE));
    }

    public static boolean isValidBst(TreeNode root, int min, int max) {
        if (root == null) return true;

        if (root.data <= min || root.data >= max)
            return false;

        return isValidBst(root.left, min, root.data) && isValidBst(root.right, root.data, max);
    }
}

