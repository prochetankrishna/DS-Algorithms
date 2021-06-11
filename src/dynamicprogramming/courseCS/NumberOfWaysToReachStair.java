package dynamicprogramming.courseCS;

//Step Size allowed = 1, 2, 3
public class NumberOfWaysToReachStair {

    public static void main(String[] args) {

        int N = 10;
        System.out.println("Number of ways to reach : [" + N + "] stair : " +
                findNumberOfWaysRecursive(N));
        System.out.println("Number of ways to reach : [" + N + "] stair : " +
                findNumberOfWaysTopDownMem(N));
        System.out.println("Number of ways to reach : [" + N + "] stair : " +
                findNumberOfWaysBottomUp(N));
        System.out.println("Number of ways to reach : [" + N + "] stair : " +
                findNumberOfWaysBottomUpSpaceOptimized(N));
    }

    public static int findNumberOfWaysRecursive (int N) {

        if (N == 0) {
            return 1;
        }

        if (N == 1) {
            return 1;
        }

        if (N == 2) {
            return 2;
        }

        return findNumberOfWaysRecursive(N - 1) + findNumberOfWaysRecursive(N - 2)
                + findNumberOfWaysRecursive(N - 3);
    }

    static int[] memDP = new int[1000];
    public static int findNumberOfWaysTopDownMem (int N) {

        if (N == 0) {
            return 1;
        }

        if (N == 1) {
            return 1;
        }

        if (N == 2) {
            return 2;
        }

        if (memDP[N] != 0) {
            return memDP[N];
        } else {
            memDP[N] = findNumberOfWaysTopDownMem(N - 1) + findNumberOfWaysTopDownMem(N - 2) +
                    findNumberOfWaysTopDownMem(N - 3);
            return memDP[N];
        }
    }

    public static int findNumberOfWaysBottomUp (int N) {

        int[] dp = new int[N + 3];
        dp[0] = 1;
        dp[1] = 1;
        dp[2] = 2;

        for (int i = 3; i <= N; i++) {
            dp[i] = dp[i - 1] + dp[i - 2] + dp[i - 3];
        }
        return dp[N];
    }

    public static int findNumberOfWaysBottomUpSpaceOptimized (int N) {

        int numOne = 1;
        int numTwo = 1;
        int numThree = 2;

        if (N == 0) {
            return numOne;
        }

        if (N == 1) {
            return numTwo;
        }

        for (int i = 3; i <= N; i++) {
            int temp = numThree + numTwo + numOne;
            numOne = numTwo;
            numTwo = numThree;
            numThree = temp;
        }
        return numThree;
    }
}


