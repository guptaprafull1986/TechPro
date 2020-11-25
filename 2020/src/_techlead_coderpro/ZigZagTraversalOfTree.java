package _techlead_coderpro;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class ZigZagTraversalOfTree {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);

        root.left = new TreeNode(2);
        root.right = new TreeNode(3);

        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);

        root.left.left.left = new TreeNode(8);
        root.left.left.right = new TreeNode(9);
        root.left.right.left = new TreeNode(10);
        root.left.right.right = new TreeNode(11);

        root.right.left.left = new TreeNode(12);
        root.right.left.right = new TreeNode(13);
        root.right.right.left = new TreeNode(14);
        root.right.right.right = new TreeNode(15);
        inorder(root);
        zigZagTraversal(root);
    }

    static void inorder(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            System.out.print(node.val + " ");
            ;
            if (node.left != null) {
                queue.add(node.left);
            }
            if (node.right != null) {
                queue.add(node.right);
            }
        }
        System.out.println();
    }

    static void zigZagTraversal(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        boolean leftRightTraversal = false;
        while (!queue.isEmpty()) {

            Stack<TreeNode> stack = new Stack<>();
            while (!queue.isEmpty()) {
                TreeNode node = queue.poll();
                System.out.print(node.val + " ");

                if (leftRightTraversal) {
                    if (node.right != null)
                        stack.push(node.right);
                    if (node.left != null) {
                        stack.push(node.left);
                    }
                } else {
                    if (node.left != null)
                        stack.push(node.left);
                    if (node.right != null)
                        stack.push(node.right);
                }
            }

            while (!stack.isEmpty()) {
                queue.add(stack.pop());
            }
            System.out.println();
            leftRightTraversal = !leftRightTraversal;
        }
    }
}
