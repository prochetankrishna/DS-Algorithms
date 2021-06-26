package dynamicprogramming.courseCS;

import java.util.Arrays;

public class KnapsackMaxProfit {

    public static void main(String[] args) {

        int[] weight = {1, 2, 3, 5};
        int[] value = {1, 4, 7, 10};
        int W = 8;
        int n = weight.length;

        System.out.println("Max Profit : " + findMaxProfitKnapsack(weight, value, n, W));
        System.out.println("Max Profit : " + findMaxProfitKnapsackTopDownMem(weight, value, n, W));
        System.out.println("Max Profit : " + findMaxProfitKnapsackBottomUpDP(weight, value, n, W));
        System.out.println("Max Profit : " + findMaxProfitKnapsackBottomUpDPSpaceOptimized(weight, value, n, W));

    }

    public static int findMaxProfitKnapsack (int[] weight, int[] value, int n, int W) {

        if (n <= 0) {
            return 0;
        }

        if (W <= 0) {
            return 0;
        }

        if (weight[n - 1] <= W) {
            return Math.max(value[n - 1] + findMaxProfitKnapsack(weight, value, n - 1, W - weight[n - 1]),
                    findMaxProfitKnapsack(weight, value, n - 1, W));
        } else {
            return findMaxProfitKnapsack(weight, value, n - 1, W);
        }
    }

    static int[][] dp;
    public static int findMaxProfitKnapsackTopDownMem(int[] weight, int[] value, int n, int W) {

        dp = new int[n + 1][W + 1];
        for (int i = 0; i < n + 1; i++) {
            Arrays.fill(dp[i], -1);
        }

        return findMaxProfitKnapsackTopDownMemUtil(weight, value, n, W);
    }

    private static int findMaxProfitKnapsackTopDownMemUtil(int[] weight, int[] value, int n, int W) {

        if (n <= 0) {
            return 0;
        }

        if (W <= 0) {
            return 0;
        }

        if (dp[n][W] != -1) {
            return dp[n][W];
        }

        if (weight[n - 1] <= W) {
            dp[n][W] = Math.max(value[n - 1] + findMaxProfitKnapsackTopDownMemUtil(weight, value, n - 1, W - weight[n - 1]),
                    findMaxProfitKnapsackTopDownMemUtil(weight, value, n - 1, W));
        } else {
            dp[n][W] = findMaxProfitKnapsackTopDownMemUtil(weight, value, n - 1, W);
        }
        return dp[n][W];
    }

    public static int findMaxProfitKnapsackBottomUpDP(int[] weight, int[] value, int n, int W) {

        if (n <= 0) {
            return 0;
        }

        if (W <= 0) {
            return 0;
        }

        int[][] dp = new int[n + 1][W + 1];
        for (int i = 0; i < n + 1; i++) {
            for (int j = 0; j < W + 1; j++) {

                if (i == 0 || j == 0) {
                    dp[i][j] = 0;
                    continue;
                }

                if (weight[i - 1] <= j) {
                    dp[i][j] = Math.max(value[i - 1] + dp[i - 1][j - weight[i - 1]], dp[i - 1][j]);
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[n][W];
    }

    public static int findMaxProfitKnapsackBottomUpDPSpaceOptimized(int[] weight, int[] value, int n, int W) {

        if (n <= 0) {
            return 0;
        }

        if (W <= 0) {
            return 0;
        }

        int[][] dp = new int[2][W + 1];
        int bi = 0;

        for (int i = 0; i < n + 1; i++) {
            bi = i & 1;
            for (int j = 0; j < W + 1; j++) {

                if (i == 0 || j == 0) {
                    dp[bi][j] = 0;
                    continue;
                }

                if (weight[i - 1] <= j) {
                    dp[bi][j] = Math.max(value[i - 1] + dp[1 - bi][j - weight[i - 1]], dp[1 - bi][j]);
                } else {
                    dp[bi][j] = dp[1 - bi][j];
                }
            }
        }
        return dp[bi][W];
    }

    //TODO : How to print Selected Items
}
