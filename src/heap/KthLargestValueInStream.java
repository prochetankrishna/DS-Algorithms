package heap;

import java.util.PriorityQueue;

public class KthLargestValueInStream {

    PriorityQueue<Integer> minHeap = new PriorityQueue<>();

    public int add (int num, int k) {
        if (minHeap.size() < k) {
            minHeap.offer(num);
            return minHeap.size() == k ? minHeap.peek() : Integer.MIN_VALUE;
        }

        if (num > minHeap.peek()) {
            minHeap.poll();
            minHeap.offer(num);
        }

        return minHeap.peek();
    }

    public static void main(String[] args) {

        KthLargestValueInStream kthLargestValueInStream = new KthLargestValueInStream();

        int[] arr = {10, 7, 11, 5, 27, 8, 9, 45};
        int k = 3;

        for (int i = 0; i < arr.length; i++) {
            System.out.println(kthLargestValueInStream.add(arr[i], k));
        }
    }
}
