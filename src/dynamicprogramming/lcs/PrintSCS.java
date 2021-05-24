package dynamicprogramming.lcs;

public class PrintSCS {

    public static void main(String[] args) {

        String X = "GEEK";
        String Y = "EKE";
        System.out.println("SCS : " + printSCS(X, Y, X.length(), Y.length()));
    }

    public static String printSCS (String X, String Y, int m, int n) {

        int[][] dp = new int[m + 1][n + 1];

        for (int i = 0; i < m + 1; i++) {
            for (int  j = 0; j < n + 1; j++) {
                if (i == 0 || j == 0) {
                    dp[i][j] = 0;
                }
            }
        }

        for (int i = 1; i < m + 1; i++) {
            for (int j = 1; j < n + 1; j++) {

                if (X.charAt(i - 1) == Y.charAt(j - 1)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

//        for (int i = 0; i < m + 1; i++) {
//            for (int j = 0; j < n + 1; j++) {
//                System.out.print(dp[i][j] + " ");
//            }
//            System.out.println();
//        }

        int i = m;
        int j = n;
        StringBuilder result = new StringBuilder();

        while (i > 0 && j > 0) {
            if (X.charAt(i - 1) == Y.charAt(j - 1)) {
                result.append(X.charAt(i - 1));
                i--;
                j--;
            } else if (dp[i - 1][j] > dp[i][j - 1]) {
                result.append(X.charAt(i - 1));
                i--;
            } else {
                result.append(Y.charAt(j - 1));
                j--;
            }
        }

        while (i > 0) {
            result.append(X.charAt(i - 1));
            i--;
        }

        while (j > 0) {
            result.append(Y.charAt(j - 1));
            j--;
        }

        result.reverse();
        return result.toString();
    }
}
