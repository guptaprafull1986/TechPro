package _techlead_coderpro;

import java.util.LinkedList;
import java.util.Queue;

public class LabelByLabelTree {
    public static void main(String[] args) {
        NAryTreeNode tree = new NAryTreeNode('a', 2);
        tree.children[0] = new NAryTreeNode('b', 0);
        tree.children[1] = new NAryTreeNode('c', 3);
        tree.children[1].children[0] = new NAryTreeNode('d', 0);
        tree.children[1].children[1] = new NAryTreeNode('e', 0);
        tree.children[1].children[2] = new NAryTreeNode('f', 0);
        System.out.println(labelOrder(tree));
    }

    static String labelOrder(NAryTreeNode root) {

        Queue<NAryTreeNode> queue = new LinkedList<>();
        String result = "";
        queue.add(root);
        while (!queue.isEmpty()) {
            int num = queue.size();
            while (num > 0) {
                NAryTreeNode node = queue.poll();
                result += node.val;
                NAryTreeNode[] children = node.children;
                for (NAryTreeNode child : children) {
                    if (child != null) {
                        queue.add(child);
                    }
                }
                num -= 1;
            }

            result += "\n";
        }
        return result;
    }
}

class NAryTreeNode {
    char val;
    NAryTreeNode[] children;

    NAryTreeNode(char val, int length) {
        this.val = val;
        children = new NAryTreeNode[length];
    }
}
