package stack;


import java.util.Stack;

class MinimumStack {

    Stack<Integer> mainStack;
    Stack<Integer> supportingStack;

    public MinimumStack() {
        this.mainStack = new Stack<>();
        this.supportingStack = new Stack<>();
    }

    public void push (int data) {

        this.mainStack.push(data);

        if (!supportingStack.isEmpty()) {
            int topOfSS = supportingStack.peek();

            if (topOfSS >= data) {
                supportingStack.push(data);
            }
        } else {
            supportingStack.push(data);
        }
    }

    public int pop() {

        if (mainStack.isEmpty()) {
            return -1;
        }

        int topOfMS = mainStack.pop();
        if (topOfMS == supportingStack.peek()) {
            supportingStack.pop();
        }
        return topOfMS;
    }

    public int peek() {

        if (mainStack.isEmpty()) {
            return -1;
        }
        return mainStack.peek();
    }

    public int minElement () {

        if (supportingStack.isEmpty()) {
            return -1;
        }

        return supportingStack.peek();
    }
}

public class MinimumElementInStackWithExtraSpace {

    public static void main(String[] args) {
        MinimumStack stack = new MinimumStack();

        stack.push(18);
        stack.push(19);
        System.out.println("Current Minimum Element : [" + stack.minElement() + "]");
        stack.push(29);
        stack.push(15);
        System.out.println("Current Minimum Element : [" + stack.minElement() + "]");
        stack.push(15);
        System.out.println("Current Minimum Element : [" + stack.minElement() + "]");
        stack.push(16);
        System.out.println("Current Minimum Element : [" + stack.minElement() + "]");

        stack.pop(); //Removes 16
        stack.pop(); //Removes 15
        System.out.println("Current Minimum Element : [" + stack.minElement() + "]");

        stack.pop(); //Removes 15
        stack.pop(); //Removes 29
        System.out.println("Current Minimum Element : [" + stack.minElement() + "]");
    }
}
