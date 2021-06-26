package heap;

import java.util.Collections;
import java.util.PriorityQueue;

public class HeapUsingPriorityQueue {

    public static void minHeap (int[] arr) {

        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        for (int i = 0; i < arr.length; i++) {
            minHeap.add(arr[i]);
            System.out.print (minHeap.peek() + " ");
        }
        System.out.println();

        for (int i = 0; i < arr.length; i++) {
            minHeap.poll();
            System.out.print(minHeap.peek() + " ");
        }
        System.out.println();
    }

    public static void maxHeap (int[] arr) {

        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

        for (int i = 0; i < arr.length; i++) {
            maxHeap.add(arr[i]);
            System.out.print (maxHeap.peek() + " ");
        }
        System.out.println();

        for (int i = 0; i < arr.length; i++) {
            maxHeap.poll();
            System.out.print(maxHeap.peek() + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {

        int[] arr = {10, 7, 11, 5, 2, 13, 1, 45};
        System.out.println("Min Heap");
        minHeap(arr);

        System.out.println("Max Heap");
        maxHeap(arr);
    }
}
