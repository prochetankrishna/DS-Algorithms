package stack;

import java.util.Stack;

class MinStack {

    Stack<Integer> stack;
    int minElement;

    public MinStack() {
        this.stack = new Stack<>();
        this.minElement = Integer.MIN_VALUE;
    }

    public void push (int data) {

        if (stack.isEmpty()) {
            minElement = data;
            stack.push (data);
            return;
        }

        if (data >= minElement) {
            stack.push(data);
        } else {
            stack.push(2 * data - minElement);
            minElement = data;
        }
    }

    public int pop () {

        if (stack.isEmpty()) {
            return Integer.MIN_VALUE;
        }

        int dataAtTop = stack.pop();

        if (dataAtTop < minElement) {
            minElement = 2 * minElement - dataAtTop;
            return dataAtTop;
        } else {
            return dataAtTop;
        }
    }

    public int peek() {

        if (stack.isEmpty()) {
            return Integer.MIN_VALUE;
        }

        if (stack.peek() >= minElement) {
            return stack.peek();
        } else {
            return minElement;
        }
    }

    public int getMinElement () {

        if(stack.isEmpty()) {
            return Integer.MIN_VALUE;
        }

        return minElement;
    }
}

public class MinimumStackConstantSpace {

    public static void main(String[] args) {
        MinStack stack = new MinStack();
        stack.push(18);
        stack.push(19);
        System.out.println("Current Minimum Element : [" + stack.getMinElement() + "]");
        stack.push(29);
        stack.push(15);
        System.out.println("Current Minimum Element : [" + stack.getMinElement() + "]");
        stack.push(15);
        System.out.println("Current Minimum Element : [" + stack.getMinElement() + "]");
        stack.push(16);
        System.out.println("Current Minimum Element : [" + stack.getMinElement() + "]");

        stack.pop(); //Removes 16
        stack.pop(); //Removes 15
        System.out.println("Current Minimum Element : [" + stack.getMinElement() + "]");

        stack.pop(); //Removes 15
        stack.pop(); //Removes 29
        System.out.println("Current Minimum Element : [" + stack.getMinElement() + "]");
    }
}
