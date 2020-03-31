/**
 * You are given two non-empty linked lists representing two non-negative integers.
 * The digits are stored in reverse order and each of their nodes contain a single digit.
 * Add the two numbers and return it as a linked list.
 * <p>
 * You may assume the two numbers do not contain any leading zero, except the number 0 itself.
 * <p>
 * Example:
 * <p>
 * Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
 * Output: 7 -> 0 -> 8
 * Explanation: 342 + 465 = 807.
 */
public class AddTwoLinkedList {
    public static void main(String[] args) {
        Node list1 = new Node(2);
        list1.next = new Node(4);
        list1.next.next = new Node(3);

        Node list2 = new Node(5);
        list2.next = new Node(6);
        list2.next.next = new Node(9);
        list2.next.next.next = new Node(9);
        list2.next.next.next.next = new Node(9);


        Node result = addTwoLinkedList(list1, list2);
        printList(result);
    }

    private static void printList(Node root) {
        Node ptr = root;
        while (ptr != null) {
            System.out.print(ptr.data + " ");
            ptr = ptr.next;
        }
        System.out.println();
    }

    private static Node addTwoLinkedList(Node list1, Node list2) {
        Node result = null;
        int carry = 0;

        Node ptr1 = list1;
        Node ptr2 = list2;
        Node ptr = null;
        while ((ptr1 != null && ptr2 != null) || carry == 1) {
            int x = ptr1 != null ? ptr1.data : 0;
            int y = ptr2 != null ? ptr2.data : 0;
            int sum = x + y + carry;
            Node temp = new Node(sum % 10);
            carry = sum / 10;
            if (result == null) {
                result = temp;
                ptr = result;
            } else {
                ptr.next = temp;
                ptr = ptr.next;
            }

            if (ptr1 != null) ptr1 = ptr1.next;
            if (ptr2 != null) ptr2 = ptr2.next;
        }
        return result;
    }


}
