package dynamicprogramming.courseCS;

import java.util.Arrays;

public class LongestPalindromicSubString {

    public static void main(String[] args) {

        String X = "ABDBCA";
        System.out.println(longestPalindromicSubStringLength(X, 0, X.length() - 1));
        System.out.println(longestPalindromicSubStringLengthTopDownMemoization(X));
        System.out.println(longestPalindromicSubStringBottomUpDP(X));
    }

    public static int longestPalindromicSubStringLength (String X, int start, int end) {

        if (start > end) {
            return 0;
        }

        if (start == end) {
            return 1;
        }

        if (X.charAt(start) == X.charAt(end)) {
            int longestPalindromicSubStringRemaining = end - start - 1;

            if (longestPalindromicSubStringRemaining == longestPalindromicSubStringLength(X, start + 1, end - 1)) {
                return 2 + longestPalindromicSubStringRemaining;
            }
        }

        return Math.max(longestPalindromicSubStringLength(X, start + 1, end),
                longestPalindromicSubStringLength(X, start, end - 1));
    }

    public static int longestPalindromicSubStringLengthTopDownMemoization(String X) {

        int n = X.length();
        int[][] dp = new int[n][n];
        for (int i= 0; i < n; i++) {
            Arrays.fill(dp[i], -1);
        }
        return longestPalindromicSubStringUtil(X, 0, X.length() - 1, dp);
    }

    private static int longestPalindromicSubStringUtil(String X, int start, int end, int[][] dp) {

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
            int longestPalindromicSubStringRemaining = end - start - 1;

            if (longestPalindromicSubStringRemaining == longestPalindromicSubStringUtil(X, start + 1, end - 1, dp)){
                dp[start][end] = 2 + longestPalindromicSubStringRemaining;
                return dp[start][end];
            }
        }
        dp[start][end] = dp[start][end] = Math.max(longestPalindromicSubStringLength(X, start + 1, end),
                longestPalindromicSubStringLength(X, start, end - 1));
        return dp[start][end];
    }

    public static int longestPalindromicSubStringBottomUpDP(String X) {

        int n = X.length();
        boolean[][] dp = new boolean[n][n];

        for (int i = 0; i < n; i++) {
            dp[i][i] = true;
        }

        int maxLengthOfLPS = 1;
        //int startOfSubString = 0;
        for (int i = n - 2; i >= 0; i--) {
            for (int j = i + 1; j < n; j++) {
                if (X.charAt(i) == X.charAt(j)) {
                    if (dp[i + 1][j - 1] || j - i == 1) {
                        dp[i][j] = true;
                        if (maxLengthOfLPS < j - i + 1) {
                            //startOfSubString = i;
                            maxLengthOfLPS = j - i + 1;
                        }
                    }
                }
            }
        }

        //System.out.println(X.substring(startOfSubString, startOfSubString + maxLengthOfLPS));
        return maxLengthOfLPS;
    }
}
