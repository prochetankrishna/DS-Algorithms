package heap;

import java.util.Collections;
import java.util.PriorityQueue;

public class KthLargestValueInArray {

    public static void main(String[] args) {

        int[] arr = {10, 7, 11, 5, 27, 8, 20, 45};
        int k = 4;

        System.out.println(k + "th Largest value is : " + findKthLargestValueInArray(arr, k));
        System.out.println(k + "th Largest value is : " + findKthLargestValueInArrayUsingMinHeap(arr, k));
    }

    //Optimal Solution
    public static int findKthLargestValueInArrayUsingMinHeap (int[] arr, int k) {

        if (arr.length < k) {
            System.out.println("Invalid Case");
            return Integer.MIN_VALUE;
        }

        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for (int i = 0; i < k; i++) {
            minHeap.offer(arr[i]);
        }

        for (int i = k; i < arr.length; i++) {
            if (arr[i] > minHeap.peek()) {
                minHeap.poll();
                minHeap.offer(arr[i]);
            }
        }
        return minHeap.peek();
    }

    public static int findKthLargestValueInArray (int[] arr, int k) {

        if (arr.length < k) {
            System.out.println("Invalid Case");
            return Integer.MIN_VALUE;
        }

        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        for (int i = 0; i < arr.length; i++) {
            maxHeap.offer(arr[i]);
        }

        for (int i = 1; i < k; i++) {
            maxHeap.poll();
        }

        return maxHeap.peek();
    }
}
