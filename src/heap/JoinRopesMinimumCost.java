package heap;

import java.util.PriorityQueue;

public class JoinRopesMinimumCost {

    public static void main(String[] args) {
        int[] ropesLength = {3, 4, 7, 2};
        System.out.println("Minimum Cost : " + minimumCostOfJoiningRopesUsingMinHeap(ropesLength));
    }

    public static int minimumCostOfJoiningRopesUsingMinHeap (int[] arr) {

        if (arr.length == 0 || arr.length == 1) {
            return 0;
        }

        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        for (int i = 0; i < arr.length; i++) {
            minHeap.offer(arr[i]);
        }

        int result = 0;

        while (minHeap.size() > 1) {
            int partialCost = minHeap.poll() + minHeap.poll();
            result += partialCost;

            minHeap.add(partialCost);
        }
        return result;
    }
}
