/**
 * Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.
 *
 * push(x) -- Push element x onto stack.
 * pop() -- Removes the element on top of the stack.
 * top() -- Get the top element.
 * getMin() -- Retrieve the minimum element in the stack.
 *
 *
 * Example:
 *
 * MinStack minStack = new MinStack();
 * minStack.push(-2);
 * minStack.push(0);
 * minStack.push(-3);
 * minStack.getMin();   --> Returns -3.
 * minStack.pop();
 * minStack.top();      --> Returns 0.
 * minStack.getMin();   --> Returns -2.
 */
/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
import java.util.ArrayList;
import java.util.List;

class MinStack {

    class Node {
        int data;
        int min;

        Node(int data) {
            this.data = data;
        }
    }

    List<Node> arr;
    int min;

    /**
     * initialize your data structure here.
     */
    public MinStack() {
        arr = new ArrayList<>();
        min = Integer.MAX_VALUE;
    }

    public void push(int x) {
        Node node = new Node(x);
        if (arr.isEmpty()) {
            min = x;
        } else {
            if (min > x) {
                min = x;
            }
        }
        node.min = min;
        arr.add(node);

    }

    public void pop() {
        arr.remove(arr.size() - 1);
        if (!arr.isEmpty()) {
            min = arr.get(arr.size() - 1).min;
        } else {
            min = Integer.MAX_VALUE;
        }
    }

    public int top() {
        return arr.get(arr.size() - 1).data;
    }

    public int getMin() {
        return min;
    }
}
