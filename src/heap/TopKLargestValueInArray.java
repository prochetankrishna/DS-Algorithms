package heap;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

public class TopKLargestValueInArray {

    public static void main(String[] args) {

        int[] arr = {10, 7, 11, 30, 8, 38, 2, 45};
        System.out.println(findKLargestValueInArray(arr, 4));
        System.out.println(findKLargestValueInArrayUsingMinHeap(arr, 4));
    }

    public static List<Integer> findKLargestValueInArrayUsingMinHeap (int[] arr, int k) {

        List<Integer> result = new ArrayList<>();
        if (arr.length < k) {
            System.out.println("Invalid Input");
            return result;
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

        for (int i = 0; i < k; i++) {
            result.add(minHeap.poll());
        }
        return result;
    }
    public static List<Integer> findKLargestValueInArray (int[] arr, int k) {

        List<Integer> result = new ArrayList<>();
        if (arr.length < k) {
            System.out.println("Invalid Input");
            return result;
        }

        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

        for (int i = 0; i < arr.length; i++) {
            maxHeap.offer(arr[i]);
        }

        for (int i = 1; i <= k; i++) {
            result.add(maxHeap.poll());
        }

        return result;
    }
}
