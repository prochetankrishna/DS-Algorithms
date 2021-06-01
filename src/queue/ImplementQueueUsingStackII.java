package queue;

import java.util.Stack;

public class ImplementQueueUsingStackII {

    static class Queue {

        static Stack<Integer> stackOne = new Stack<>();
        static Stack<Integer> stackTwo = new Stack<>();

        static void enqueue (int x) {
            stackOne.push(x);
        }

        static int dequeue() {

            if (stackOne.isEmpty() && stackTwo.isEmpty()) {
                System.out.println("Queue is Empty");
                return -1;
            }

            if (stackTwo.isEmpty()) {
                while (!stackOne.isEmpty()) {
                    stackTwo.push (stackOne.pop());
                }
            }
            return stackTwo.pop();
        }
    }

    public static void main(String[] args) {
        ImplementQueueUsingStackI.Queue.enQueue(1);
        ImplementQueueUsingStackI.Queue.enQueue(2);
        ImplementQueueUsingStackI.Queue.enQueue(3);
        System.out.println(ImplementQueueUsingStackI.Queue.deQueue());
        System.out.println(ImplementQueueUsingStackI.Queue.deQueue());
        System.out.println(ImplementQueueUsingStackI.Queue.deQueue());
        System.out.println(ImplementQueueUsingStackI.Queue.deQueue());
    }
}
