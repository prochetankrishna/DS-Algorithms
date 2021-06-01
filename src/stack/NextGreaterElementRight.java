package stack;

import java.util.*;

public class NextGreaterElementRight {

    public static void main(String[] args) {

        int[] arr = {1, 3, 0, 0, 1, 2, 4};
        System.out.println("Input Array : " + Arrays.toString(arr));
        System.out.println("Result : " + Arrays.toString(findNextGreaterElementRight(arr)));
        System.out.println("Result : " + findNextGreaterElementRightStack(arr));


    }

    public static List<Integer> findNextGreaterElementRightStack (int[] arr) {

        List<Integer> result = new LinkedList<>();
        Stack<Integer> stack = new Stack<>();

        for (int i = arr.length - 1; i >= 0; i--) {

            if (stack.isEmpty()) {
                result.add (-1);
            } else if (!stack.isEmpty() && stack.peek() > arr[i]) {
                result.add (stack.peek());
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
        Collections.reverse(result);
        return result;
    }

    //Brute Force
    public static int[] findNextGreaterElementRight (int[] arr) {

        int[] result = new int[arr.length];

        int next;
        for (int i = 0; i < arr.length; i++) {
            next = -1;
            for (int j = i + 1; j < arr.length; j++) {
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
