package dynamicprogramming.knapsack;

public class MinimumSubsetSumDifference {

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 9};
        int[] anotherArray = {3, 1, 4, 2, 2, 1};
        System.out.println(findMinimumSubsetSumDifference(arr, arr.length));
        System.out.println(findMinimumSubsetSumDifference(anotherArray, anotherArray.length));
    }

    public static int findMinimumSubsetSumDifference (int[] arr, int n) {

        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += arr[i];
        }

        boolean[][] dp = new boolean[n + 1][sum + 1];

        for (int i = 0; i < n + 1; i++) {
            for (int j = 0; j < sum + 1; j++) {
                if (i == 0) {
                    dp[i][j] = false;
                }
                if (j == 0) {
                    dp[i][j] = true;
                }
            }
        }

        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < sum + 1; j++) {
                if (arr[i - 1] <= j) {
                    dp[i][j] = dp[i - 1][j - arr[i - 1]] || dp[i - 1][j];
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }

        int diff = Integer.MAX_VALUE;

        for (int j = sum / 2; j >= 0; j--) {
            if (dp[n][j] == true) {
                diff = sum - 2*j;
                break;
            }
        }
        return diff;
    }
}
