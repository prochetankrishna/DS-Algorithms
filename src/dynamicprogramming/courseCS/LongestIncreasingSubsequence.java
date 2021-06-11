package dynamicprogramming.courseCS;

import java.util.Arrays;

public class LongestIncreasingSubsequence {

    public static void main(String[] args) {

        int[] arr = {3, 10, 2, 20};
        System.out.println("LIS Length : " + lengthOfLongestIncreasingSubsequenceRecursive(arr));
        System.out.println("LIS Length : " + lengthOfLongestIncreasingSubsequenceBottomUp(arr, arr.length));
    }

    public static int lengthOfLongestIncreasingSubsequenceBottomUp (int[] arr, int n) {

        int[] lis = new int[n];
        Arrays.fill(lis, 1);

        int max = 0;
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (arr[i] > arr[j] && lis[i] < lis[j] + 1){
                    lis[i] = lis[j] + 1;
                }
            }
        }

        for (int i = 0; i < n; i++) {
            if (lis[i] > max) {
                max = lis[i];
            }
        }
        return max;
    }

    static int maxLengthOfLIS;
    public static int lengthOfLongestIncreasingSubsequenceRecursive(int[] arr) {

        maxLengthOfLIS = 1;
        _lengthOfLongestIncreasingSubsequenceRecursive(arr, arr.length);
        return maxLengthOfLIS;
    }

    public static int _lengthOfLongestIncreasingSubsequenceRecursive (int[] arr, int n) {

        if (n == 1) {
            return 1;
        }

        int result, max_ending_here = 1;
        for (int i = 1; i < n; i++) {
            result = _lengthOfLongestIncreasingSubsequenceRecursive(arr, i);
            if (arr[i - 1] < arr[n - 1] && result + 1 > max_ending_here) {
                max_ending_here = result + 1;
            }
        }

        if (max_ending_here > maxLengthOfLIS) {
            maxLengthOfLIS = max_ending_here;
        }

        return max_ending_here;
    }
}
