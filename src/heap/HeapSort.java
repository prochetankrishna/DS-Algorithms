package heap;

import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;

public class HeapSort {

    public static void main(String[] args) {

        int[] arrForIncreasingOrder = {10, 7, 11, 30, 8, 38, 2, 45};
        System.out.println("*************************************************************");
        System.out.println("**********************INCREASING ORDER **********************");
        System.out.println("Array Before Sort : " + Arrays.toString(arrForIncreasingOrder));
        increasingOrderHeapSort(arrForIncreasingOrder);
        System.out.println("Array After Sort : " + Arrays.toString(arrForIncreasingOrder));
        System.out.println("*************************************************************");

        int[] arrForDecreasingOrder = {10, 7, 11, 30, 8, 38, 2, 45};
        System.out.println("*************************************************************");
        System.out.println("**********************DECREASING ORDER **********************");
        System.out.println("Array Before Sort : " + Arrays.toString(arrForDecreasingOrder));
        decreasingOrderHeapSort(arrForDecreasingOrder);
        System.out.println("Array After Sort : " + Arrays.toString(arrForDecreasingOrder));
        System.out.println("*************************************************************");
    }

    private static void decreasingOrderHeapSort(int[] arr) {

        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        for (int i = 0; i < arr.length; i++) {
            maxHeap.offer(arr[i]);
        }

        for (int i = 0; i < arr.length; i++) {
            arr[i] = maxHeap.poll();
        }
    }

    private static void increasingOrderHeapSort(int[] arr) {

        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for (int i = 0; i < arr.length; i++) {
            minHeap.offer(arr[i]);
        }

        for (int i = 0; i < arr.length; i++) {
            arr[i] = minHeap.poll();
        }
    }
}
