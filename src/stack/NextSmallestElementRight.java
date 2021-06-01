package stack;

import java.util.*;

public class NextSmallestElementRight {

    public static void main(String[] args) {
        int[] arr = {4, 5, 2, 10, 8};
        System.out.println("Array : " + Arrays.toString(arr));
        System.out.println("Result : " + Arrays.toString(findNextSmallestElementRight(arr)));
        System.out.println("Result : " + findNextSmallestElementRightStack(arr));
    }

    public static List<Integer> findNextSmallestElementRightStack (int[] arr) {

        List<Integer> result = new LinkedList<>();
        Stack<Integer> stack = new Stack<>();

        for (int i = arr.length - 1; i >= 0; i--) {

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
            stack.push(arr[i]);
        }
        Collections.reverse(result);
        return result;
    }

    //Brute Force
    public static int[] findNextSmallestElementRight (int[] arr) {

        int[] result =  new int[arr.length];
        int previous;

        for (int i = arr.length - 1; i >= 0; i--) {
            previous = -1;
            for (int j = i + 1; j < arr.length; j++) {

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
