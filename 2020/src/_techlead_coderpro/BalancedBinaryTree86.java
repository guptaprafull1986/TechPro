package _techlead_coderpro;

public class BalancedBinaryTree86 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);

        /**
                        1
                       / \
                      2   3
                     /
                    4
         */
        System.out.println(isBalancedBinaryTree(root));

        root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(4);

        /**
                      1
                     /
                    2
                   /
                  4
         */
        System.out.println(isBalancedBinaryTree(root));
    }


    /*O(N) complexity*/
    static boolean isBalancedTreeUtil(BalancedBinaryTree.TreeNode node, BalancedBinaryTree.Height height) {
        if (node == null) {
            height.height = 0;
            return true;
        }

        BalancedBinaryTree.Height leftHeight = new BalancedBinaryTree.Height();
        BalancedBinaryTree.Height rightHeight = new BalancedBinaryTree.Height();

        boolean isLeft = isBalancedTreeUtil(node.left, leftHeight);
        boolean isRight = isBalancedTreeUtil(node.right, leftHeight);

        height.height = Math.max(leftHeight.height, rightHeight.height) + 1;

        if (Math.abs(leftHeight.height - rightHeight.height) > 1) return false;

        else return isLeft && isRight;
    }

    static boolean isBalancedBinaryTree(TreeNode root) {
        return height(root) != -1;
    }

    private static int height(TreeNode root) {
        if (root == null) return 0;
        int left = height(root.left);
        int right = height(root.right);

        if (left >= 0 && right >= 0 && Math.abs(left - right) <= 1) {
            return Math.max(left, right) + 1;
        }
        return -1;
    }
}
