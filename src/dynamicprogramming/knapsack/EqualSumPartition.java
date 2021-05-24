package dynamicprogramming.knapsack;

public class EqualSumPartition {

    public static void main(String[] args) {

        int[] arr = {3, 1, 1, 2, 2, 1};
        System.out.println(isEqualSumSubsetExists(arr, arr.length));
    }

    public static boolean isEqualSumSubsetExists (int[] arr, int n) {

        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
        }

        if (sum % 2 != 0) {
            return false;
        }

        return isSubsetWithSumExists(arr, arr.length, sum/2);
    }

    public static boolean isSubsetWithSumExists (int[] arr, int n, int sum) {

        boolean dp[][] = new boolean[n + 1][sum + 1];

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
                    dp[i][j] = dp[i - 1][j] || dp[i - 1][j - arr[i - 1]];
                } else {
                    dp[i][j] = dp[i- 1][j];
                }
            }
        }
        return dp[n][sum];
    }
}
