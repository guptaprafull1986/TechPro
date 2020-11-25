package _techlead_coderpro;

public class SwapNodes {
    public static void main(String[] args) {
        Node head = new Node(1, new Node(2, new Node(3, new Node(4, new Node(5)))));
        print(head);
        print(swapNode(head));
    }

    private static void print(Node node) {
        Node ptr = node;
        if (ptr == null) return;
        while (ptr.next != null) {
            System.out.print(ptr.val + "->");
            ptr = ptr.next;
        }
        System.out.println(ptr.val);
    }

    private static Node swapNode(Node head) {
        Node ptr = head;
        while (ptr != null && ptr.next != null) {
            int temp = ptr.val;
            ptr.val = ptr.next.val;
            ptr.next.val = temp;
            ptr = ptr.next.next;
        }
        return head;
    }
}
