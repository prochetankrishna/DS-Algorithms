package dynamicprogramming.unboundedknapsack;

public class UnboundedKnapSack {

    public static void main(String[] args) {

        int[] wt = {5, 10, 15};
        int[] value = {10, 30, 20};
        int W = 100;
        int n = value.length;
        System.out.println(unboundedKnapsackRecursion(wt, value, n, W));
        System.out.println(unboundedKnapsackDP(wt, value, n, W));

        //ROD CUTTING PROBLEM
        int[] price = {1, 5, 8, 9, 10, 17, 17, 20};
        int[] size = {1, 2, 3, 4, 5, 6, 7, 8};
        int length = 8;
        int arrLength = price.length;
        System.out.println(unboundedKnapsackDP(size, price, arrLength, length));
    }

    public static int unboundedKnapsackRecursion (int[] wt, int[] value, int n, int W) {

        if (n == 0 || W == 0) {
            return 0;
        }

        if (wt[n - 1] <= W) {
            return Math.max(value[n - 1] + unboundedKnapsackRecursion(wt, value, n, W - wt[n - 1]), unboundedKnapsackRecursion(wt, value, n - 1, W));
        } else {
            return unboundedKnapsackRecursion(wt, value, n - 1, W);
        }
    }

    public static int unboundedKnapsackDP (int[] wt, int[] value, int n, int W) {

        int[][] t = new int[n + 1][W + 1];

        //Initialization
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
                    t[i][j] = Math.max(value[i - 1] + t[i][j - wt[i - 1]], t[i - 1][j]);
                } else {
                    t[i][j] = t[i - 1][j];
                }
            }
        }
        return t[n][W];
    }
}
