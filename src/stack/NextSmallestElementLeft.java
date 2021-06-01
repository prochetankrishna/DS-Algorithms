package stack;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class NextSmallestElementLeft {

    public static void main(String[] args) {
        int[] arr = {4, 5, 2, 10, 8};
        System.out.println("Array : " + Arrays.toString(arr));
        System.out.println("Result : " + Arrays.toString(findNextSmallestElementLeft(arr)));
        System.out.println("Result : " + findNextSmallestElementLeftStack(arr));
    }

    public static List<Integer> findNextSmallestElementLeftStack (int[] arr) {

        List<Integer> result = new LinkedList<>();
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < arr.length; i++) {

            if (stack.isEmpty()) {
                result.add (-1);
            } else if (!stack.isEmpty() && stack.peek() < arr[i]) {
                result.add (stack.peek());
            } else if (!stack.isEmpty() && stack.peek() >= arr[i]) {

                while (!stack.isEmpty() && stack.peek() >= arr[i]) {
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
    public static int[] findNextSmallestElementLeft (int[] arr) {

        int[] result = new int[arr.length];
        int previous;

        for (int i = 0; i < arr.length; i++) {
            previous = -1;
            for (int j = i - 1; j >= 0; j--) {
                if (arr[i] > arr[j]) {
                    previous = arr[j];
                    break;
                }
            }
            result[i] = previous;
        }
        return result;
    }
}
