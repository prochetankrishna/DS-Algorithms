package heap;

import java.util.Collections;
import java.util.PriorityQueue;

public class KthSmallestValueInArray {

    public static void main(String[] args) {

        int[] arr = {10, 7, 11, 30, 20, 38, 2, 45};
        System.out.println(findKthSmallestValueInArray(arr, 4));
        System.out.println(findKthSmallestValueInArrayUsingMaxHeap(arr, 4));
    }

    public static int findKthSmallestValueInArrayUsingMaxHeap (int[] arr, int k) {

        if (k > arr.length) {
            System.out.println("Invalid Value");
            return Integer.MAX_VALUE;
        }

        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

        for (int i = 0; i < k; i++) {
            maxHeap.add(arr[i]);
        }

        for (int i = k; i < arr.length; i++) {
            if (arr[i] < maxHeap.peek()) {
                maxHeap.poll();
                maxHeap.offer(arr[i]);
            }
        }

        return maxHeap.peek();
    }

    public static int findKthSmallestValueInArray (int[] arr, int k) {

        if (k > arr.length) {
            System.out.println("Invalid Value");
            return Integer.MAX_VALUE;
        }

        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        for (int i = 0; i < arr.length; i++) {
            minHeap.offer(arr[i]);
        }

        for (int i = 1; i < k; i++) {
            minHeap.poll();
        }

        return minHeap.peek();
    }
}
