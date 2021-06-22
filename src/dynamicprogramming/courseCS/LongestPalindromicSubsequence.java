package dynamicprogramming.courseCS;

import java.util.Arrays;

public class LongestPalindromicSubsequence {

    public static void main(String[] args) {
        String X = "ABEEBAC";
        System.out.println("LPS Length : " + longestPalindromicSubsequenceRecursive(X, 0, X.length() - 1));
        System.out.println("LPS Length : " + longestPalindromicSubsequenceTopDownMemoization(X, 0, X.length() - 1));
        System.out.println("LPS Length : " + longestPalindromicSubsequenceBottomUpDP(X));
    }

    public static int longestPalindromicSubsequenceRecursive (String X, int start, int end) {

        if (start > end) {
            return 0;
        }

        if (start == end) {
            return 1;
        }

        if (X.charAt(start) == X.charAt(end)) {
            return longestPalindromicSubsequenceRecursive(X, start + 1, end - 1) + 2;
        }

        return Math.max(longestPalindromicSubsequenceRecursive(X, start + 1, end),
                            longestPalindromicSubsequenceRecursive(X, start, end - 1));
    }

    public static int longestPalindromicSubsequenceTopDownMemoization (String X, int start, int end) {

        int[][] dp = new int[X.length()][X.length()];
        for (int i = 0; i < X.length(); i++) {
            Arrays.fill(dp[i], -1);
        }
        return longestPalindromicSubsequenceTopDownMemoizationUtil(X, start, end, dp);
    }

    private static int longestPalindromicSubsequenceTopDownMemoizationUtil(String X, int start, int end, int[][] dp) {

        if (start > end) {
            return 0;
        }

        if (start == end) {
            return 1;
        }

        if (dp[start][end] != -1) {
            return dp[start][end];
        }

        if (X.charAt(start) == X.charAt(end)) {
            dp[start][end] =  longestPalindromicSubsequenceRecursive(X, start + 1, end - 1) + 2;

        } else {
            dp[start][end] = Math.max(longestPalindromicSubsequenceRecursive(X, start + 1, end),
                    longestPalindromicSubsequenceRecursive(X, start, end - 1));
        }
        return dp[start][end];
    }

    public static int longestPalindromicSubsequenceBottomUpDP(String X) {

        int n = X.length();
        int[][] dp = new int[X.length()][X.length()];

        for (int i = 0; i < n; i++) {
            dp[i][i] = 1;
        }

        for (int i = n - 2; i >= 0; i--) {
            for (int j = i + 1; j < n; j++) {
                if (X.charAt(i) == X.charAt(j)) {
                    dp[i][j] = 2 + dp[i + 1][j - 1];
                } else {
                    dp[i][j] = Math.max(dp[i + 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[0][n - 1];
    }
}


