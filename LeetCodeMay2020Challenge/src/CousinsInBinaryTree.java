/**
 * In a binary tree, the root node is at depth 0, and children of each depth k node are at depth k+1.
 * <p>
 * Two nodes of a binary tree are cousins if they have the same depth, but have different parents.
 * <p>
 * We are given the root of a binary tree with unique values, and the values x and y of two different nodes in the tree.
 * <p>
 * Return true if and only if the nodes corresponding to the values x and y are cousins.
 *              1
 *            /  \
 *           2    3
 *          /
 *         4
 * Example 1:
 * Input: root = [1,2,3,4], x = 4, y = 3
 * Output: false
 * <p>
 * Example 2:
 *              1
 *            /  \
 *           2    3
 *            \    \
 *             4    5
 * Input: root = [1,2,3,null,4,null,5], x = 5, y = 4
 * Output: true
 * <p>
 * Example 3:
 *              1
 *            /  \
 *           2    3
 *            \
 *             4
 * <p>
 * Input: root = [1,2,3,null,4], x = 2, y = 3
 * Output: false
 */
public class CousinsInBinaryTree {
    public static void main(String[] args) {

    }

    public static boolean isCousins(TreeNode root, int x, int y) {
        Node nodeX = getNode(null, root, x, 0);
        Node nodeY = getNode(null, root, y, 0);

        if (nodeX == null || nodeY == null) return false;
        if (nodeX.depth == nodeY.depth && nodeX.parent != nodeY.parent) {
            return true;
        }
        return false;
    }

    static Node getNode(TreeNode parent, TreeNode root, int x, int depth) {
        if (root == null) return null;

        if (root.val == x) {
            return new Node(parent, depth);
        }

        Node left = getNode(root, root.left, x, depth + 1);
        if (left != null) {
            return left;
        }

        return getNode(root, root.right, x, depth + 1);
    }
}

class Node {
    TreeNode parent;
    int depth;

    Node(TreeNode parent, int depth) {
        this.parent = parent;
        this.depth = depth;
    }
}