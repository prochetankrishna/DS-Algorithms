package dynamicprogramming.courseCS;

public class MinimumOperationTransform {

    public static void main(String[] args) {
        String X = "BAT";
        String Y = "BUT";
        int m = X.length();
        int n = Y.length();

        System.out.println("Minimum Operations required : " + minimumOperationsRequiredAD(X, Y, m, n));
        System.out.println("Minimum Operations required : " + minimumOperationsRequiredADBottomUp(X, Y, m, n));
        System.out.println("Minimum Operations required : " + minimumOperationsRequiredAMD(X, Y, m, n));
        System.out.println("Minimum Operations required : " + minimumOperationsRequiredAMDBottomUp(X, Y, m, n));

    }

    //Add Delete
    public static int minimumOperationsRequiredAD (String X, String Y, int m, int n) {

        if (X.equals(Y)) {
            return 0;
        }

        if (m == 0) {
            return n;
        }

        if (n == 0) {
            return m;
        }

        if (X.charAt(m - 1) == Y.charAt(n - 1)) {
            return minimumOperationsRequiredAD(X, Y, m - 1, n - 1);
        } else {
            return 1 + Math.min(minimumOperationsRequiredAD(X, Y, m - 1, n),
                    minimumOperationsRequiredAD(X, Y, m, n - 1));
        }
    }

    //Add Delete
    public static int minimumOperationsRequiredADBottomUp (String X, String Y, int m, int n) {

        if (X.equals(Y)) {
            return 0;
        }

        if (m == 0) {
            return n;
        }

        if (n == 0) {
            return m;
        }

        int[][] dp = new int[m + 1][n + 1];
        for (int i = 0 ; i < m  + 1; i++) {
            for (int j = 0; j < n + 1; j++) {
                if (i == 0 || j == 0) {
                    dp[i][j] = 0;
                } else if (X.charAt(i - 1) == Y.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = 1 + Math.min(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[m][n];
    }

    //Add Modify Delete
    public static int minimumOperationsRequiredAMD (String X, String Y, int m, int n) {

        if (X.equals(Y)) {
            return 0;
        }

        if (m == 0) {
            return n;
        }

        if (n == 0) {
            return m;
        }

        if (X.charAt(m - 1) == Y.charAt(n - 1)) {
            return minimumOperationsRequiredAMD(X, Y, m - 1, n - 1);
        } else {
            return 1 + Math.min(minimumOperationsRequiredAMD(X, Y, m, n - 1), Math.min(
                    minimumOperationsRequiredAMD(X, Y, m - 1, n),
                    minimumOperationsRequiredAMD(X, Y, m - 1, n - 1)
            ));
        }
    }

    //Add Modify Delete
    public static int minimumOperationsRequiredAMDBottomUp (String X, String Y, int m, int n) {

        if (X.equals(Y)) {
            return 0;
        }

        if (m == 0) {
            return n;
        }

        if (n == 0) {
            return m;
        }

        int[][] dp = new int[m + 1][n + 1];
        for (int i = 0 ; i < m  + 1; i++) {
            for (int j = 0; j < n + 1; j++) {
                if (i == 0 || j == 0) {
                    dp[i][j] = 0;
                } else if (X.charAt(i - 1) == Y.charAt(i - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = 1 + Math.min((Math.min(dp[i - 1][j - 1], dp[i - 1][j])), dp[i][j - 1]);
                }
            }
        }
        return dp[m][n];
    }
}
