package queueusingstack;

import java.util.Stack;

/**
 * Queue implementation using Stack
 * This queue should support multithreaded environment
 * i.e. enqueue(), dequeue(), peek(), isEmpty() and size() operations should be synchronized
 */
public class Queue {

    Stack<Integer> front;
    Stack<Integer> rear;
    Object frontLock = new Object();
    Object rearLock = new Object();

    public Queue() {
        front = new Stack<>();
        rear = new Stack<>();
    }

    public void enqueue(int data) {
        synchronized (frontLock) {
            front.add(data);
            notifyAll();
        }
    }

    public int dequeue() {
        int value;
        synchronized (rearLock) {
            moveItemsFromRearToFront();
            value = front.pop();
        }
        return value;
    }

    public int peek() {
        moveItemsFromRearToFront();
        return front.peek();
    }

    public boolean isEmpty() {
        return front.isEmpty() && rear.isEmpty();
    }

    public int size() {
        return front.size() + rear.size();
    }

    private void moveItemsFromRearToFront() {
        // front stack holds all the queue item in reverse order
        // if queue items are 1 2 3 4 5
        // front stack items will be 5 4 3 2 1
        //on stack pop() 1 will be popped first
        // if front is empty, move all rear items to front
        if (front.isEmpty()) {
            synchronized (frontLock) {
                while (rear.isEmpty()) {
                    try {
                        frontLock.wait();
                    } catch (InterruptedException e) {
                        // InterruptedException
                    }
                }

                // transfer all rear items to front
                while (!rear.isEmpty()) {
                    front.add(rear.pop());
                }
            }
        }
    }
}

class Solution {
    public static void main(String[] args) {
        Queue queue = new Queue();
        queue.enqueue(1);
        System.out.println(queue.peek());
        System.out.println(queue.size());
        queue.enqueue(2);
        queue.enqueue(3);
        queue.enqueue(4);
        System.out.println(queue.dequeue());
        queue.enqueue(5);
        queue.enqueue(6);
        queue.enqueue(7);
        queue.enqueue(8);

        while (!queue.isEmpty()) {
            System.out.print(queue.dequeue() + " ");
        }
        System.out.println();
    }
}