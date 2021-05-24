package dynamicprogramming.lcs;

public class LongestCommonSubsequence {

    private static int[][] M = new int[1000][1000];

    public static void main(String[] args) {

        String X = "abdca";
        String Y = "cbda";

        //System.out.println(findLCSRecursive(X, Y, X.length(), Y.length()));

        for (int i = 0; i < 1000; i++) {
            for (int j = 0; j < 1000; j++) {
                M[i][j] = -1;
            }
        }

        //System.out.println(findLCSMemoization(X, Y, X.length(), Y.length()));

//        for (int i = 0; i < X.length() + 1; i++) {
//            for (int j = 0; j < Y.length() + 1; j++) {
//                System.out.print(M[i][j] + " ");
//            }
//            System.out.println();
//        }
        System.out.println(findLCSDP(X, Y, X.length(), Y.length()));
    }

    public static int findLCSRecursive (String X, String Y, int m, int n) {

        if (m == 0 || n == 0) {
            return 0;
        }

        if (X.charAt(m - 1) == Y.charAt(n - 1)) {
            return 1 + findLCSRecursive(X, Y, m - 1, n - 1);
        } else {
            return Math.max(findLCSRecursive(X, Y, m  -1, n) , findLCSRecursive(X, Y, m, n - 1));
        }
    }

    public static int findLCSMemoization (String X, String Y, int m, int n) {

        if (m == 0 || n == 0) {
            return 0;
        }

        if (M[m][n] != -1) {
            return M[m][n];
        }

        if (X.charAt(m - 1) == Y.charAt(n - 1)) {
            M[m][n] = 1 + findLCSMemoization(X, Y, m - 1, n - 1);
            return M[m][n];
        } else {
            M[m][n] = Math.max(findLCSMemoization(X, Y, m - 1, n), findLCSMemoization(X, Y, m, n - 1));
            return M[m][n];
        }
    }

    public static int findLCSDP (String X, String Y, int m, int n) {

        int[][] dp = new int[m + 1][n + 1];


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
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        for (int i = 0 ; i < m + 1; i++) {
            for (int j = 0; j < n + 1; j++) {
                System.out.print(dp[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
        return dp[m][n];
    }


}
