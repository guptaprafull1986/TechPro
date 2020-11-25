package _techlead_coderpro;

public class RotateLinkedList {
    public static void main(String[] args) {
        Node root = new Node(1, new Node(2, new Node(3, new Node(4, new Node(5, null)))));
        printList(root);
        root = rotate(root, 2);
        printList(root);
    }

    static void printList(Node root) {
        if (root == null) return;
        Node ptr = root;
        while (ptr.next != null) {
            System.out.print(ptr.val + " -> ");
            ptr = ptr.next;
        }
        System.out.println(ptr.val);
    }

    static Node rotate(Node root, int n) {
        int length = 0;
        Node ptr = root;
        while (ptr != null) {
            ptr = ptr.next;
            length++;
        }

        n = n % length;

        Node slow = root;
        Node fast = root;
        for (int i = 0; i < n; i++) {
            fast = fast.next;
        }

        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }

        fast.next = root;
        root = slow.next;
        slow.next = null;
        return root;
    }
}
