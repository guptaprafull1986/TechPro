package _techlead_coderpro;

public class ArithmeticBinaryTree93 {
    public static void main(String[] args) {

    }

    static int evaluateTree(NodeT root) {
        if (root == null) return 0;
        int x = evaluateTree(root.left);
        int y = evaluateTree(root.right);

        if (root.val == '+' || root.val == '-' || root.val == '*' || root.val == '/') {
            return eval(x, y, root.val);
        }
        return root.val - '0';
    }

    private static int eval(int x, int y, char op) {
        switch (op) {
            case '+':
                return x + y;
            case '-':
                return x - y;
            case '*':
                return x * y;
            case '/':
                return x / y;
        }
        return -1;
    }
}

class NodeT {
    char val;
    NodeT left;
    NodeT right;
}
