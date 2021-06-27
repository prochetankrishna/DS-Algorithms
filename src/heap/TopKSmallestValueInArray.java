package heap;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

public class TopKSmallestValueInArray {

    public static void main(String[] args) {

        int[] arr = {10, 7, 11, 30, 8, 38, 2, 45};
        System.out.println(findKSmallestValueInArray(arr, 4));
        System.out.println(findKSmallestValueInArrayUsingMaxHeap(arr, 4));
    }

    public static List<Integer> findKSmallestValueInArrayUsingMaxHeap (int[] arr, int k) {

        List<Integer> result = new ArrayList<>();
        if (arr.length < k) {
            System.out.println("Invalid Input");
            return result;
        }

        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

        for (int i = 0; i < k; i++) {
            maxHeap.offer(arr[i]);
        }

        for (int i = k; i < arr.length; i++) {
            if (arr[i] < maxHeap.peek()) {
                maxHeap.poll();
                maxHeap.offer(arr[i]);
            }
        }

        for (int i = 0; i < k; i++) {
            result.add(maxHeap.poll());
        }
        return result;
    }

    public static List<Integer> findKSmallestValueInArray (int[] arr, int k) {

        List<Integer> result = new ArrayList<>();
        if (arr.length < k) {
            System.out.println("Invalid Input");
            return result;
        }

        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        for (int i = 0; i < arr.length; i++) {
            minHeap.offer(arr[i]);
        }

        for (int i = 1; i <= k; i++) {
            result.add(minHeap.poll());
        }

        return result;
    }
}
