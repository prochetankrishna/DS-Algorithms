package stack;

import java.sql.SQLOutput;
import java.util.Arrays;
import java.util.Stack;

class StackNode {
    int data;
    int index;

    public StackNode() {};

    public StackNode(int data, int index) {
        this.data = data;
        this.index = index;
    }
}
public class MaximumAreaHistogram {

    public static void main(String[] args) {

        int[] arr = {6, 2, 5, 4, 5, 1, 6};
        int[] NSRIndex = findNextSmallestToRightIndex(arr);
        int[] NSLIndex = findNextSmallestToLeftIndex(arr);
        int[] width = findWidth(NSRIndex, NSLIndex);
        System.out.println("Arr : " + Arrays.toString(arr));
        System.out.println("NSR Index : " + Arrays.toString(NSRIndex));
        System.out.println("NSL Index : " + Arrays.toString(NSLIndex));
        System.out.println("WIDTH : " + Arrays.toString(width));
        System.out.println("Max Area of Histogram : " + findMaximumAreaOfHistogram(width, arr));
    }

    public static int findMaximumAreaOfHistogram (int[] width, int[] arr) {

        int max = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            int area = width[i] * arr[i];
            if (max < area) {
                max = area;
            }
        }
        return max;
    }

    public static int[] findWidth (int[] NSRI, int[] NSLI) {

        int[] width = new int[NSRI.length];
        for (int i = 0; i < width.length; i++) {
            width[i] = NSRI[i] - NSLI[i] - 1;
        }
        return width;
    }

    public static int[] findNextSmallestToLeftIndex (int[] arr) {

        Stack<StackNode> stack = new Stack<>();
        int[] NSLIndex = new int[arr.length];

        for (int i = 0; i < arr.length; i++) {

            if (stack.isEmpty()) {
                NSLIndex[i] = -1;

            } else if (!stack.isEmpty() && stack.peek().data < arr[i]) {
                NSLIndex[i] = stack.peek().index;
            } else if (!stack.isEmpty() && stack.peek().data >= arr[i]) {

                while (!stack.isEmpty() && stack.peek().data >= arr[i]) {
                    stack.pop();
                }

                if (stack.isEmpty()) {
                    NSLIndex[i] = -1;
                } else {
                    NSLIndex[i] = stack.peek().index;
                }
            }
            stack.push(new StackNode(arr[i], i));
        }
        return NSLIndex;
    }

    public static int[] findNextSmallestToRightIndex (int[] arr) {

        Stack<StackNode> stack = new Stack<>();
        int[] NSRIndex = new int[arr.length];

        for (int i = arr.length - 1; i >= 0; i--) {

            if (stack.isEmpty()) {
                NSRIndex[i] = arr.length;

            } else if (!stack.isEmpty() && stack.peek().data < arr[i]) {
                NSRIndex[i] = stack.peek().index;
            } else if (!stack.isEmpty() && stack.peek().data >= arr[i]) {

                while (!stack.isEmpty() && stack.peek().data >= arr[i]) {
                    stack.pop();
                }

                if (stack.isEmpty()) {
                    NSRIndex[i] = arr.length;
                } else {
                    NSRIndex[i] = stack.peek().index;
                }
            }
            stack.push(new StackNode(arr[i], i));
        }
        return NSRIndex;
    }
}
