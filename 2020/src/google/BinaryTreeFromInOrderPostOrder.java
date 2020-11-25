package google;

import _techlead_coderpro.TreeNode;

public class BinaryTreeFromInOrderPostOrder {
    public static TreeNode binaryTree(int[] inOrder, int[] postOrder) {
        PostOrderIndex index = new PostOrderIndex(0);
        return binaryTreeUtils(inOrder, postOrder, 0, inOrder.length - 1, index);
    }

    private static TreeNode binaryTreeUtils(int[] inOrder,
                                            int[] postOrder,
                                            int inStart,
                                            int inEnd,
                                            PostOrderIndex index) {

        if (inStart > inEnd) return null;
        TreeNode root = new TreeNode(postOrder[index.index]);
        index.index -= 1;

        int inIndex = search(inOrder, inStart, inEnd, root.val);
        root.right = binaryTreeUtils(inOrder, postOrder, inIndex + 1, inEnd, index);
        root.left = binaryTreeUtils(inOrder, postOrder, inStart, inIndex - 1, index);
        return root;
    }

    private static int search(int[] arr, int start, int end, int val) {
        while (start <= end) {
            if (arr[start] == val) return start;
            start++;
        }
        return -1;
    }
}

class PostOrderIndex {
    int index;

    PostOrderIndex(int index) {
        this.index = index;
    }
}