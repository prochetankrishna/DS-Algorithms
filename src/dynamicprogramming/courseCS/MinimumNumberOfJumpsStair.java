package dynamicprogramming.courseCS;

//Note - This is Greedy Question IMO
//Step Size Allowed = 1, 2, 3
public class MinimumNumberOfJumpsStair {

    public static void main(String[] args) {

        int N = 10;
        System.out.println("Minimum Number of Steps Required : " +
                minNumberOfStepsRecursive(N));
        System.out.println("Minimum Number of Steps Required : " +
                minNumberOfStepsRecursiveOptimized(N));
        int[] memDP = new int[N + 2];
        System.out.println("Minimum Number of Steps Required : " +
                minNumberOfStepsTopDownMem(memDP, N));
        System.out.println("Minimum Number of Steps Required : " +
                minNumberOfStepsBottomUp(N));
        System.out.println("Minimum Number of Steps Required : " +
                minNumberOfStepsBottomUpOptimized(N));
    }

    public static int minNumberOfStepsRecursive (int N) {

        if (N == 0) {
            return 0;
        }

        if (N == 1 || N == 2 || N == 3) {
            return 1;
        }

        return 1 + findMinimum(minNumberOfStepsRecursive(N - 1), minNumberOfStepsRecursive(N - 2),
                minNumberOfStepsRecursive(N - 3));
    }

    public static int minNumberOfStepsRecursiveOptimized (int N) {

        if (N == 0) {
            return 0;
        }

        if (N == 1 || N == 2 || N == 3) {
            return 1;
        }

        return 1 + minNumberOfStepsRecursiveOptimized(N - 3);
    }

    public static int minNumberOfStepsTopDownMem (int[] memDP, int N) {

        if (N == 0) {
            return 0;
        }

        if (N == 1 || N == 2 || N == 3) {
            return 1;
        }

        if (memDP[N] == 0) {
            memDP[N] = 1 + findMinimum(minNumberOfStepsTopDownMem(memDP, N - 1),
                                    minNumberOfStepsTopDownMem(memDP, N - 2),
                                    minNumberOfStepsTopDownMem(memDP, N - 3));
        }
        return memDP[N];
    }

    public static int minNumberOfStepsBottomUp (int N) {

        int[] dp = new int[N + 1];
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 1;

        for (int i = 3; i <= N; i++) {
            dp[i] = 1 + findMinimum(dp[i - 1], dp[i - 2], dp[i - 3]);
        }
        return dp[N];
    }

    public static int minNumberOfStepsBottomUpOptimized (int N) {

        if (N == 0) {
            return 0;
        }

        if (N == 1 || N == 2 || N == 3) {
            return 1;
        }

        int numOne = 0;
        int numTwo = 1;
        int numThree = 1;

        for (int i = 3; i <= N; i++) {
            int temp = 1 + findMinimum(numOne, numTwo, numThree);
            numOne = numTwo;
            numTwo = numThree;
            numThree = temp;
        }
        return numThree;
    }

    public static int findMinimum (int numOne, int numTwo, int numThree) {

        return numOne <= numTwo ? (numOne < numThree ? numOne : numThree) :
                (numTwo <= numThree ? numTwo : numThree);
    }
}

