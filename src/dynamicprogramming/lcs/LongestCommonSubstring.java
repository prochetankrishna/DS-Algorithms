package dynamicprogramming.lcs;

public class LongestCommonSubstring {

    public static void main(String[] args) {
        String X = "passport";
        String Y = "ppsspt";

        System.out.println(findLongestCommonSubstring(X, Y, X.length(), Y.length()));
    }

    public static int findLongestCommonSubstring (String X, String Y, int m, int n) {

        int[][] dp = new int[m  +1][n + 1];

        for (int i = 0 ; i < m + 1; i++) {
            for (int j = 0; j < n + 1; j++) {
                if (i == 0 || j == 0) {
                    dp[i][j] = 0;
                }
            }
        }

        for (int i = 1 ; i < m + 1; i++) {
            for (int j = 1; j < n + 1; j++) {
                if (X.charAt(i - 1) == Y.charAt(j - 1)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                } else {
                    dp[i][j] = 0;
                }
            }
        }

        int max = Integer.MIN_VALUE;
        for (int i = 0 ; i < m + 1; i++) {
            for (int j = 0; j < n + 1; j++) {
                if (max < dp[i][j]) {
                    max = dp[i][j];
                }
            }
        }

//        System.out.println(dp[m][n]);
        return max;
    }
}
