package queue;

import java.util.Stack;

//Enqueue Expensive
public class ImplementQueueUsingStackI {

    static class Queue {

        static Stack<Integer> stackOne = new Stack<>();
        static Stack<Integer> stackTwo = new Stack<>();

        static void enQueue (int x) {

            while (!stackOne.isEmpty()) {
                stackTwo.push(stackOne.pop());
            }

            stackOne.push(x);

            while (!stackTwo.isEmpty()) {
                stackOne.push(stackTwo.pop());
            }
        }

        static int deQueue () {

            if (stackOne.isEmpty()) {
                System.out.println("Queue is Empty");
                return  -1;
            }
            return stackOne.pop();
        }
    };

    public static void main(String[] args) {
        Queue.enQueue(1);
        Queue.enQueue(2);
        Queue.enQueue(3);
        System.out.println(Queue.deQueue());
        System.out.println(Queue.deQueue());
        System.out.println(Queue.deQueue());
        System.out.println(Queue.deQueue());

    }
}
