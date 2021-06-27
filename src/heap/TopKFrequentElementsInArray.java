package heap;

import java.util.*;

public class TopKFrequentElementsInArray {

    public static void main(String[] args) {

        int[] arr = {8, 10, 7, 8, 11, 30, 11, 8, 38, 11, 2, 45, 2, 8};
        int k = 5;
        System.out.println("Top " + k + " Frequent Elements : " + findTopKFrequentElementsInArrayUsingMaxHeap(arr, k));
        System.out.println("Top " + k + " Frequent Elements : " + findTopKFrequentElementsInArrayUsingMinHeap(arr, k));
    }

    public static List<Integer> findTopKFrequentElementsInArrayUsingMinHeap (int[] arr, int k) {

        List<Integer> result = new ArrayList<>();
        if (k > arr.length) {
            System.out.println("Invalid Input");
            return result;
        }

        Map<Integer, Integer> frequencyMap = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            frequencyMap.put(arr[i], frequencyMap.getOrDefault(arr[i], 0) + 1);
        }

        PriorityQueue<Map.Entry<Integer, Integer>> minHeap = new PriorityQueue<>(
                (numberOne, numberTwo) -> numberOne.getValue() - numberTwo.getValue()
        );

        for (Map.Entry<Integer, Integer> eachEntry : frequencyMap.entrySet()) {
            if (minHeap.size() < k) {
                minHeap.offer(eachEntry);
            } else {
                if (eachEntry.getValue() > minHeap.peek().getValue()) {
                    minHeap.poll();
                    minHeap.offer(eachEntry);
                }
            }
        }

        for (int i = 1; i <= k; i++) {
            result.add(minHeap.poll().getKey());
        }

        return result;
    }

    public static List<Integer> findTopKFrequentElementsInArrayUsingMaxHeap (int[] arr, int k) {

        List<Integer> result = new ArrayList<>();
        if (k > arr.length) {
            System.out.println("Invalid Input");
            return result;
        }

        Map<Integer, Integer> frequencyMap = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            frequencyMap.put(arr[i], frequencyMap.getOrDefault(arr[i], 0) + 1);
        }

        PriorityQueue<Map.Entry<Integer, Integer>> maxHeap = new PriorityQueue<>(
                (numberOne, numberTwo) -> numberTwo.getValue() - numberOne.getValue()
        );

        maxHeap.addAll(frequencyMap.entrySet());

        for (int i = 1; i <= k; i++) {
            result.add(maxHeap.poll().getKey());
        }

        return result;
    }
}
