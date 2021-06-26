package heap;

import java.util.Collections;
import java.util.PriorityQueue;

public class KthSmallestValueInStream {

    PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

    public int add (int num, int k) {
        if (maxHeap.size() < k) {
            maxHeap.offer(num);
            return maxHeap.size() == k ? maxHeap.peek() : Integer.MAX_VALUE;
        }

        if (num < maxHeap.peek()) {
            maxHeap.poll();
            maxHeap.offer(num);
        }

        return maxHeap.peek();
    }

    public static void main(String[] args) {

        KthSmallestValueInStream kthSmallestValueInStream = new KthSmallestValueInStream();

        int[] arr = {10, 7, 11, 5, 27, 8, 9, 45};
        int k = 5;

        for (int i = 0; i < arr.length; i++) {
            System.out.println(kthSmallestValueInStream.add(arr[i], k));
        }
    }
}
