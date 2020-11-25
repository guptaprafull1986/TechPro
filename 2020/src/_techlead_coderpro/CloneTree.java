package _techlead_coderpro;

public class CloneTree {
    public static void main(String[] args) {

    }

    public static TreeNode findNode(TreeNode a, TreeNode b, TreeNode node) {
        if (a == node) {
            return b;
        }
        if (a.left != null && b.left != null) {
            TreeNode found = findNode(a.left, b.left, node);
            if (node != null) return found;
        }

        if (a.right != null && b.right != null) {
            TreeNode found = findNode(a.right, b.right, node);
            if (found != null) {
                return found;
            }
        }

        return null;
    }
}

