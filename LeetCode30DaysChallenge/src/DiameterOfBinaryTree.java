/**
 * Given a binary tree, you need to compute the length of the diameter of the tree.
 * The diameter of a binary tree is the length of the longest path between any two nodes in a tree. This path may or may not pass through the root.
 * <p>
 * Example:
 * Given a binary tree
 * 1
 * / \
 * 2   3
 * / \
 * 4   5
 * Return 3, which is the length of the path [4,2,1,3] or [5,2,1,3].
 * <p>
 * Note: The length of path between two nodes is represented by the number of edges between them.
 */
public class DiameterOfBinaryTree {
    public static void main(String[] args) {

    }

    static int max = 0;

    public static int diameterOfBinaryTree(TreeNode root) {
        max = 0;
        util(root);
        return max;
    }

    public static int util(TreeNode root) {
        if (root == null) return 0;
        int left = util(root.left);
        int right = util(root.right);

        int count = left + right;
        if (max < count) {
            max = count;
        }
        return 1 + Math.max(left, right);
    }
}
