package _techlead_coderpro;

public class RemoveDuplicateFromLinkedList {

    public static void main(String[] args) {
        Node root = new Node(1, new Node(2, new Node(2, new Node(3, new Node(3, null)))));
//        removeDuplicates(root);
        removeDuplicatesUsingSinglePointer(root);
        printList(root);

        Node r = new Node(1);
        removeDuplicates(r);
        printList(r);
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

    static void removeDuplicatesUsingSinglePointer(Node root) {
        if (root == null) return;
        Node current = root;
        while (current != null && current.next != null) {
            if (current.val == current.next.val) {
                current.next = current.next.next;
            } else {
                current = current.next;
            }
        }
    }

    static void removeDuplicates(Node root) {
        if (root == null) return;
        Node current = root;
        Node next = root.next;
        while (next != null) {
            if (current.val != next.val) {
                current = next;
                next = next.next;
            } else {
                current.next = next.next;
                next = current.next;
            }
        }
    }
}
