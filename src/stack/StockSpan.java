package stack;

import java.util.Arrays;
import java.util.Stack;

public class StockSpan {

    static class StackNode {
        int data, index;

        public StackNode(int data, int index) {
            this.data = data;
            this.index = index;
        }
    }
    public static void main(String[] args) {
        int[] arr = {100, 80, 60, 70, 60, 75, 85};
        System.out.println("Array : " + Arrays.toString(arr));
        System.out.println("Result : " + Arrays.toString(findStockSpan(arr)));
    }

    private static int[] findStockSpan (int[] arr) {

        Stack<StackNode> stack = new Stack<>();
        int[] stockSpan = new int[arr.length];

        for (int i = 0; i < arr.length; i++) {

            if (stack.isEmpty()) {
                stockSpan[i] = i - (-1);
            } else if (!stack.isEmpty() && stack.peek().data > arr[i]) {
                stockSpan[i] = i - stack.peek().index;
            } else if (!stack.isEmpty() && stack.peek().data <= arr[i]) {

                while (!stack.isEmpty() && stack.peek().data <= arr[i]) {
                    stack.pop();
                }

                if (stack.isEmpty()) {
                    stockSpan[i] = i - (-1);
                } else {
                    stockSpan[i] = i - stack.peek().index;
                }
            }
            stack.push(new StackNode(arr[i], i));
        }
        return stockSpan;
    }

}
