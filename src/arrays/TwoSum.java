package arrays;

import java.util.Arrays;
import java.util.HashSet;

public class TwoSum {

    public static void main(String[] args) {

        int[] arr = new int[] {1, 4, 45, 6, 10, -8};
        findPairsWithSum(arr, 16);
        findPairsWithSumHashing(arr, 16);
    }

    public static void findPairsWithSumHashing(int[] arr, int x) {

        HashSet<Integer> s = new HashSet<>();
        for (int i = 0; i < arr.length; i++) {

            int temp = x - arr[i];
            if (s.contains(temp)) {
                System.out.println("Pairs are [" + temp + "] and [" + arr[i] + "]");
            }
            s.add(arr[i]);
        }
    }
    public static void findPairsWithSum (int[] arr, int x) {

        int low = 0;
        int high = arr.length - 1;

        Arrays.sort(arr);

        while (low < high) {
            if (arr[low] + arr[high] == x) {
                System.out.println("Pairs are [" + arr[low] + "] and [" + arr[high] + "]");
                return;
            } else if (arr[low] + arr[high] < x) {
                low++;
            } else {
                high--;
            }
        }
    }
}
