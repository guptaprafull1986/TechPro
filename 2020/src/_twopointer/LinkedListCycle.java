package _twopointer;

import _techlead_coderpro.Node;

import java.util.HashMap;
import java.util.Map;

public class LinkedListCycle {
    public static void main(String[] args) {

    }

    boolean isCycleInLinkedList(Node head) {
        if (head == null || head.next == null) return false;
        Node slow = head;
        Node fast = head.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) return true;
        }
        return false;
    }

    boolean isCycleInLinkedListHashMap(Node head) {
        if (head == null || head.next == null) return false;
        Map<Node, Boolean> map = new HashMap<>();
        map.put(head, true);
        Node ptr = head.next;
        while (ptr != null) {
            if (map.containsKey(ptr)) return true;
            map.put(ptr, true);
            ptr = ptr.next;
        }
        return false;
    }
}
