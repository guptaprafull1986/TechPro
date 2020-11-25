package google;

import java.util.HashMap;
import java.util.Map;

class LRUCache {

    private Map<Integer, Node> map = new HashMap<>();
    private int capacity;
    Node start = new Node(-1 , -1);
    Node end = new Node(-1 , -1);

    public LRUCache(int capacity) {
        this.capacity = capacity;
        join(start, end);
    }

    public int get(int key) {
        if(!map.containsKey(key)) {
            return -1;
        }

        Node node = map.get(key);
        remove(node);
        moveToHead(node);
        return node.val;
    }

    public void put(int key, int value) {
        if(map.containsKey(key)) {
            Node node = map.get(key);
            node.val = value;   // need to update value of existing key
            remove(node);
            moveToHead(node);
        } else {

            if(map.size() == capacity) {
                if(end.prev != start) {
                    map.remove(end.prev.key);
                    remove(end.prev);
                }
            }
            Node node = new Node(key, value);
            moveToHead(node);
            map.put(key, node);
        }
    }

    public void moveToHead(Node node) {
        Node next = start.next;
        join(start, node);
        join(node, next);
    }

    public void remove(Node node) {
        Node prev = node.prev;
        Node next = node. next;

        prev.next = next;
        next.prev = prev;
    }


    public void join(Node n1, Node n2) {
        n1.next = n2;
        n2.prev = n1;

    }
}

class Node {
    int key;
    int val;
    Node prev;
    Node next;

    public Node(int key, int val) {
        this.key = key;
        this.val = val;
    }
}
/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
