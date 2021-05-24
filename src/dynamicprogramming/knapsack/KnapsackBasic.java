package dynamicprogramming.knapsack;

import java.util.Arrays;

public class KnapsackBasic {

    private static int[][] t = new int[4][51];

    public static void main(String[] args) {

        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 51; j++) {
                t[i][j] = -1;
            }
        }
        int[] wt = new int[] {1, 3, 4, 5};
        int[] value = new int[] {1, 4, 5, 7};
        int W = 7;
        int n = 4;
        //System.out.println(knapsackRecursive(wt, value, W, n));
        //System.out.println(knapsackRecursiveMemoize(wt, value, W, n));
//        for (int i = 0; i < 4; i++) {
//            for (int j = 0; j < 51; j++) {
//                System.out.print(t[i][j] + " ");
//            }
//            System.out.println();
//        }
        System.out.println(knapsackIterative(wt, value, W, n));
    }

    public static int knapsackRecursive (int[] wt, int[] value, int W, int n) {

        if (n == 0 || W == 0) {
            return 0;
        }

        if (wt[n - 1] <= W) {
            return Math.max(value[n - 1] + knapsackRecursive(wt, value, W - wt[n - 1], n - 1),
                    knapsackRecursive(wt, value, W, n - 1));
        } else {
            return knapsackRecursive(wt, value, W, n - 1);
        }
    }

    public static int knapsackRecursiveMemoize (int[] wt, int[] value, int W, int n) {

        if (n == 0 || W == 0) {
            return 0;
        }

        if (t[n][W] != -1) {
            return t[n][W];
        }

        if (wt[n - 1] <= W) {
            t[n][W] =  Math.max(value[n - 1] + knapsackRecursive(wt, value, W - wt[n - 1], n - 1),
                    knapsackRecursive(wt, value, W, n - 1));
            return t[n][W];
        } else {
            t[n][W] = knapsackRecursive(wt, value, W, n - 1);
            return t[n][W];
        }
    }

    public static int knapsackIterative (int[] wt, int[] value, int W, int n) {

        int[][] t = new int[n + 1][W + 1];

        for (int i = 0; i < n + 1; i++) {
            for (int j = 0; j < W + 1; j++) {
                if (i == 0 || j == 0) {
                    t[i][j] = 0;
                }
            }
        }

        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < W + 1; j++) {
                if (wt[i - 1] <= j) {
                    t[i][j] = Math.max(value[i - 1] + t[i - 1][j - wt[i - 1]], t[i - 1][j]);
                } else {
                    t[i][j] = t[i - 1][j];
                }
            }
        }

        for (int i = 0; i < n + 1; i++) {
            for (int j = 0; j < W + 1; j++) {
                System.out.print(t[i][j] + " ");
            }
            System.out.println();
        }
        //printSelectedItemsInKnapsack(t, wt, value, W, n);
        return t[n][W];
    }

    public static void printSelectedItemsInKnapsack (int[][] dp, int[] wt, int[] value, int W, int n) {

        int totalProfit = dp[n][W];

        for (int i = n; i > 0; i--) {
            if (totalProfit != dp[i - 1][W]) {
                System.out.print(" " + wt[i - 1]);
                W -= wt[i - 1];
                totalProfit -= value[i - 1];
            }
        }

        if (totalProfit != 0) {
            System.out.print(" " + wt[0]);
        }
        System.out.println();
    }
}
