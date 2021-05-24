package dynamicprogramming.knapsack;

public class CountNumberSubsetSum {

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 3};
        System.out.println(countNumberOfSubsetSum(arr, arr.length, 6));
    }

    public static int countNumberOfSubsetSum (int[] arr, int n, int sum) {

        int[][] dp = new int[n + 1][sum + 1];

        for (int i = 0; i < n + 1; i++) {
            for (int j = 0; j < sum + 1; j++) {

                if (i == 0) {
                    dp[i][j] = 0;
                }

                if (j == 0) {
                    dp[i][j] = 1;
                }
            }
        }

        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < sum + 1; j++) {

                if (arr[i - 1] <= j) {
                    dp[i][j] = dp[i - 1][j] + dp[i - 1][j - arr[i - 1]];
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[n][sum];
    }
}
