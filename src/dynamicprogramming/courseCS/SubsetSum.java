package dynamicprogramming.courseCS;

import java.util.Arrays;

public class SubsetSum {

    public static void main(String[] args) {

        int[] arr = {2, 3, 7, 8, 10};
        int sum = 11;

        System.out.println(isSubsetSumExistsRecursive(arr, arr.length, sum));
        System.out.println(isSubsetSumExistsTopDownMem(arr, arr.length, sum) == 1 ? true : false);
        System.out.println(isSubsetSumExistsBottomUpDP(arr, arr.length, sum));
        System.out.println(isSubsetSumExistsBottomUpDPSpaceOptimized(arr, arr.length, sum));
    }

    public static boolean isSubsetSumExistsBottomUpDPSpaceOptimized (int[] value, int n, int sum) {

        if (sum == 0) {
            return true;
        }

        if (n <= 0) {
            return false;
        }

        boolean[][] dp = new boolean[2][sum + 1];
        int bi = 0;
        for (int i = 0; i < n + 1; i++) {
            bi = i & 1;
            for (int j = 0; j < sum + 1; j++) {
                if (i == 0 || j == 0) {
                    if (i == 0) {
                        dp[bi][j] = false;
                    }

                    if (j == 0) {
                        dp[bi][j] = true;
                    }
                } else if (value[i - 1] <= j) {
                    dp[bi][j] = dp[1- bi][j - value[i - 1]] || dp[1 - bi][j];
                } else {
                    dp[bi][j] = dp[1 - bi][j];
                }
            }
        }
        return dp[bi][sum];
    }

    public static boolean isSubsetSumExistsBottomUpDP (int[] value, int n, int sum) {

        if (sum == 0) {
            return true;
        }

        if (n <= 0) {
            return false;
        }

        boolean[][] dp = new boolean[n + 1][sum + 1];

        for (int i = 0; i < n + 1; i++) {
            for (int j = 0; j < sum + 1; j++) {
                if (i == 0 || j == 0) {
                    if (i == 0) {
                        dp[i][j] = false;
                    }

                    if (j == 0) {
                        dp[i][j] = true;
                    }
                } else if (value[i - 1] <= j) {
                    dp[i][j] = dp[i - 1][j - value[i - 1]] || dp[i - 1][j];
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[n][sum];
    }

    static int[][] dp;
    public static int isSubsetSumExistsTopDownMem (int[] value, int n, int sum) {

        dp = new int[n + 1][sum + 1];
        for (int i = 0; i < n + 1; i++) {
            Arrays.fill(dp[i], -1);
        }

        return isSubsetSumExistsTopDownMemUtil (value, n, sum, dp);
    }

    public static int isSubsetSumExistsTopDownMemUtil (int[] value, int n, int sum, int[][] dp) {

        if (sum == 0) {
            return 1;
        }

        if (n <= 0) {
            return 0;
        }

        if (dp[n][sum] != -1) {
            return dp[n][sum];
        }

        if (value[n - 1] <= sum) {
            dp[n][sum] = Math.max(isSubsetSumExistsTopDownMemUtil(value, n - 1, sum - value[n - 1], dp),
                    isSubsetSumExistsTopDownMemUtil(value, n - 1, sum, dp));
        } else {
            dp[n][sum] = isSubsetSumExistsTopDownMemUtil(value, n - 1, sum, dp);
        }

        return dp[n][sum];
    }

    public static boolean isSubsetSumExistsRecursive (int[] value, int n, int sum) {

        if (n == 0 && sum == 0) {
            return true;
        }

        if (n == 0 && sum != 0) {
            return false;
        }

        if (sum == 0) {
            return true;
        }

        if (value[n - 1] <= sum) {
            return isSubsetSumExistsRecursive(value, n - 1, sum - value[n - 1]) || isSubsetSumExistsRecursive(value, n - 1, sum);
        } else {
            return isSubsetSumExistsRecursive(value, n - 1, sum);
        }
    }
}
