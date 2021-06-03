package stack;

//class StackNode {
//    int data, index;
//
//    public StackNode () {};
//
//    public StackNode(int data, int index) {
//        this.data = data;
//        this.index = index;
//    }
//}

import java.util.Arrays;
import java.util.Stack;

public class MaximumAreaOfRectangleInBinaryMatrix {

    public static void main(String[] args) {

        int[][] binaryMatrix = {{0, 1, 1, 0},
                                {1, 1, 1, 1},
                                {1, 1, 1, 1},
                                {1, 1, 0, 0}};

        System.out.println("Maximum Area : " + findMaximumAreaOfRectangleInBinaryMatrix(binaryMatrix));
    }

    public static int findMaximumAreaOfRectangleInBinaryMatrix (int[][] binaryMatrix) {

        int maxArea = Integer.MIN_VALUE;

        int[] histogram = new int[binaryMatrix[0].length];

        for (int i = 0; i < binaryMatrix.length; i++) {
            for (int j = 0; j < binaryMatrix[i].length; j++) {
                if (binaryMatrix[i][j] == 1) {
                    histogram[j] += binaryMatrix[i][j];
                } else {
                    histogram[j] = 0;
                }
            }
            System.out.println("[" + i + " ] : " + Arrays.toString(histogram));
            int area = findMaximumAreaOfHistogram(histogram);
            if (area > maxArea) {
                maxArea = area;
            }
        }
        return maxArea;
    }

    public static int findMaximumAreaOfHistogram (int[] arr) {

        int[] NSLIndex = findNearestSmallestToLeftIndex(arr);
        int[] NSRIndex = findNearestSmallestToRightIndex(arr);

        int[] width = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            width[i] = NSRIndex[i] - NSLIndex[i] - 1;
        }

        int maxArea = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            int area = arr[i] * width[i];
            if (area > maxArea) {
                maxArea = area;
            }
        }
        return maxArea;
    }

    public static int[] findNearestSmallestToLeftIndex (int[] arr) {

        int[] result = new int[arr.length];
        Stack<StackNode> stack = new Stack<>();

        for (int i = 0; i < arr.length; i++) {

            if (stack.isEmpty()) {
                result[i] = -1;
            } else if (!stack.isEmpty() && stack.peek().data < arr[i]) {
                result[i] = stack.peek().index;
            } else if (!stack.isEmpty() && stack.peek().data >= arr[i]) {

                while (!stack.isEmpty() && stack.peek().data >= arr[i]) {
                    stack.pop();
                }

                if (stack.isEmpty()) {
                    result[i] = -1;
                } else {
                    result[i] = stack.peek().index;
                }
            }
            stack.push(new StackNode(arr[i], i));
        }
        return result;
    }

    public static int[] findNearestSmallestToRightIndex (int[] arr) {

        int[] result = new int[arr.length];
        Stack<StackNode> stack = new Stack<>();

        for (int i = arr.length - 1; i >= 0; i--) {

            if (stack.isEmpty()) {
                result[i] = arr.length;
            } else if (!stack.isEmpty() && stack.peek().data < arr[i]) {
                result[i] = stack.peek().index;
            } else if (!stack.isEmpty() && stack.peek().data >= arr[i]) {

                while (!stack.isEmpty() && stack.peek().data >= arr[i]) {
                    stack.pop();
                }

                if (stack.isEmpty()) {
                    result[i] = arr.length;
                } else {
                    result[i] = stack.peek().index;
                }
            }
            stack.push(new StackNode(arr[i], i));
        }
        return result;
    }
}
