import java.util.HashMap;
import java.util.Map;

public class LRUCache {
    public static void main(String[] args) {
        LRUCache cache = new LRUCache(2);
        cache.put(1, 1);
        cache.put(2, 2);
        System.out.println(cache.get(1));
        cache.put(3, 3);
        System.out.println(cache.get(2));
        cache.put(4, 4);
        System.out.println(cache.get(1));
        System.out.println(cache.get(3));
        System.out.println(cache.get(4));
    }

    Map<Integer, Node> map;
    int length;
    Node front, rear;

    public LRUCache(int capacity) {
        map = new HashMap<>();
        length = capacity;
    }


    public int get(int key) {
        if (map.containsKey(key)) // Key Already Exist, just update the
        {
            Node node = map.get(key);
            removeNode(node);
            addAtTop(node);
            return node.data;
        }
        return -1;
    }

    public void put(int key, int value) {
        if (map.containsKey(key)) // Key Already Exist, just update the value and move it to top
        {
            Node node = map.get(key);
            node.data = value;
            removeNode(node);
            addAtTop(node);
        } else {
            Node node = new Node(key, value);
            node.prev = null;
            node.next = null;
            if (map.size() >= length) {
                map.remove(rear.key);
                removeNode(rear);
            }
            addAtTop(node);

            map.put(key, node);
        }
    }

    public void addAtTop(Node node) {
        node.next = front;
        node.prev = null;
        if (front != null)
            front.prev = node;
        front = node;
        if (rear == null)
            rear = front;
    }

    public void removeNode(Node node) {

        if (node.prev != null) {
            node.prev.next = node.next;
        } else {
            front = node.next;
        }

        if (node.next != null) {
            node.next.prev = node.prev;
        } else {
            rear = node.prev;
        }
    }
}

class Node {
    int key;
    int data;
    Node prev;
    Node next;

    Node(int key, int data) {
        this.key = key;
        this.data = data;
    }
}