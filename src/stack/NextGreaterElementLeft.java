package stack;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class NextGreaterElementLeft {

    public static void main(String[] args) {
        int[] arr = {1, 3, 2, 4};
        System.out.println("Array : " + Arrays.toString(arr));
        System.out.println("Result : " + Arrays.toString(findNextGreaterElementLeft(arr)));
        System.out.println("Result : " + findNextGreaterElementLeftStack(arr));
    }

    public static List<Integer> findNextGreaterElementLeftStack (int[] arr) {

        List<Integer> result = new LinkedList<>();
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < arr.length; i++) {

            if (stack.isEmpty()) {
                result.add (-1);
            } else if (!stack.isEmpty() && stack.peek() > arr[i]) {
                result.add(stack.peek());
            } else if (!stack.isEmpty() && stack.peek() <= arr[i]) {

                while (!stack.isEmpty() && stack.peek() <= arr[i]) {
                    stack.pop();
                }

                if (stack.isEmpty()) {
                    result.add (-1);
                } else {
                    result.add (stack.peek());
                }
            }
            stack.push (arr[i]);
        }
        return result;
    }

    //Brute Force
    public static int[] findNextGreaterElementLeft (int[] arr) {

        int[] result = new int[arr.length];
        int next;

        for (int i = 0; i < arr.length; i++) {
            next = -1;
            for (int j = i - 1; j >= 0; j--) {
                if (arr[i] < arr[j]) {
                    next = arr[j];
                    break;
                }
            }
            result[i] = next;
        }
        return result;
    }
}
