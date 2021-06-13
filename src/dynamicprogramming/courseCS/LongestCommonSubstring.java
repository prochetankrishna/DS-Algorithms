package dynamicprogramming.courseCS;

public class LongestCommonSubstring {

    public static void main(String[] args) {

        String X = "zxabcdezy";
        String Y = "yzabcdezx";

        int m = X.length();
        int n = Y.length();

        System.out.println("Length of Longest Common Substring  : " + lengthOfLongestCommonSubstring(X, Y, m, n, 0));
        System.out.println("Length of Longest Common Substring  : " + lengthOfLongestCommonSubstringBottomUp(X, Y, m, n));
        System.out.println("Length of Longest Common Substring  : " + lengthOfLongestCommonSubstringBottomUpSpaceOptimized(X, Y, m, n));

    }

    public static int lengthOfLongestCommonSubstring (String X, String Y, int m, int n, int count) {

        if (m <= 0 || n <= 0) {
            return count;
        }

        if (X.charAt(m - 1) == Y.charAt(n - 1)) {
            count =  lengthOfLongestCommonSubstring(X, Y, m - 1, n - 1, count + 1);
        } else {
            count =  Math.max(Math.max (lengthOfLongestCommonSubstring(X, Y, m - 1, n, 0),
                    lengthOfLongestCommonSubstring(X, Y, m, n - 1, 0)), count);
        }
        return count;
    }

    public static int lengthOfLongestCommonSubstringBottomUp(String X, String Y, int m, int n){

        if (m <= 0 || n <= 0) {
            return 0;
        }

        int[][] dp = new int[m + 1][n + 1];

        int result = 0;
        for (int i = 0; i < m + 1; i++) {
            for (int j = 0; j < n + 1; j++) {

                if (i == 0 || j == 0) {
                    dp[i][j] = 0;
                } else if (X.charAt(i - 1) == Y.charAt(j - 1)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                    result = Math.max(result, dp[i][j]);
                } else {
                    dp[i][j] = 0;
                }
            }
        }

        return result;
    }

    public static int lengthOfLongestCommonSubstringBottomUpSpaceOptimized(String X, String Y, int m, int n){

        if (m <= 0 || n <= 0) {
            return 0;
        }

        int[][] dp = new int[2][n + 1];

        int result = 0;
        int bi = 0;
        for (int i = 0; i < m + 1; i++) {
            bi = i  & 1;
            for (int j = 0; j < n + 1; j++) {
                if (i == 0 || j == 0) {
                    dp[bi][j] = 0;
                } else if (X.charAt(i - 1) == Y.charAt(j - 1)) {
                    dp[bi][j] = 1 + dp[1 - bi][j - 1];
                    result = Math.max(result, dp[bi][j]);
                } else {
                    dp[bi][j] = 0;
                }
            }
        }
        return result;
    }
}
