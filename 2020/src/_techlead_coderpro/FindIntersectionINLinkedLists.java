package _techlead_coderpro;

public class FindIntersectionINLinkedLists {
    public static void main(String[] args) {

    }

    int intersection(Node list1, Node list2) {
        int lenA = lengthOf(list1);
        int lenB = lengthOf(list2);

        int k = lenA - lenB;
        if (k > 0) {
            return getIntersection(list1, list2, k);
        } else {
            return getIntersection(list2, list1, k);
        }


    }

    private int getIntersection(Node list1, Node list2, int k) {
        Node fast = list1;
        for (int i = 0; i < k; i++) {
            if (fast == null) return -1;
            fast = fast.next;
        }
        Node slow = list2;

        while (slow != null && fast != null) {
            if (fast == slow) {
                return fast.val;
            }
            fast = fast.next;
            slow = slow.next;
        }
        return -1;
    }

    private int lengthOf(Node node) {
        Node ptr = node;
        int length = 0;

        while ((ptr != null)) {
            length++;
            ptr = ptr.next;
        }
        return length;
    }

    class Node {
        int val;
        Node next;

        Node(int val) {
            this.val = val;
        }
    }
}
