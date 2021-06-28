package heap;

import java.util.*;

public class FrequencySort {

    public static void main(String[] args) {

        String expression = "chetankrishna";
        int[] arr = {8, 10, 7, 8, 11, 30, 11, 8, 38, 11, 2, 45, 2, 8};

        System.out.println(frequencySortCharacters(expression.toCharArray()));
        System.out.println(frequencySortNumbers(arr));
    }

    public static List<Character> frequencySortCharacters (char[] arr) {

        List<Character> result = new ArrayList<>();
        if (arr.length <= 0) {
            return result;
        }

        Map<Character, Integer> frequencyMap = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            frequencyMap.put(arr[i], frequencyMap.getOrDefault(arr[i], 0) + 1);
        }

        PriorityQueue<Map.Entry<Character, Integer>> maxHeap = new PriorityQueue<>(
                (entryOne, entryTwo) -> {
                    if (!entryOne.getValue().equals(entryTwo.getValue())) {
                        return entryTwo.getValue() - entryOne.getValue();
                    } else {
                        return entryOne.getKey() - entryTwo.getKey();
                    }
                }
        );

        maxHeap.addAll(frequencyMap.entrySet());

        while (!maxHeap.isEmpty()) {
            Map.Entry<Character, Integer> eachEntry = maxHeap.poll();
            for (int i = 0; i < eachEntry.getValue(); i++) {
                result.add(eachEntry.getKey());
            }
        }

        return result;
    }

    public static List<Integer> frequencySortNumbers(int[] arr) {

        List<Integer> result = new ArrayList<>();
        if (arr.length <= 0) {
            return result;
        }

        Map<Integer, Integer> frequencyMap = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            frequencyMap.put(arr[i], frequencyMap.getOrDefault(arr[i], 0) + 1);
        }

        PriorityQueue<Map.Entry<Integer, Integer>> maxHeap = new PriorityQueue<>(
                (entryOne, entryTwo) -> {
                    if (entryOne.getValue() != entryTwo.getValue()) {
                        return entryTwo.getValue() - entryOne.getValue();
                    } else {
                        return entryOne.getKey() - entryTwo.getKey();
                    }
                }
        );

        maxHeap.addAll(frequencyMap.entrySet());

        while (!maxHeap.isEmpty()) {
            Map.Entry<Integer, Integer> eachEntry = maxHeap.poll();
            for (int i = 0; i < eachEntry.getValue(); i++) {
                result.add(eachEntry.getKey());
            }
        }

        return result;
    }
}
