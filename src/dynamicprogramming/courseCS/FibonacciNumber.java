package dynamicprogramming.courseCS;

public class FibonacciNumber {

    public static void main(String[] args) {

        int num = 10;
        for (int i = 0; i < num; i++) {
            System.out.print(getFibonacciNumberRecursive(i) + " ");
        }
        System.out.println();
        for (int i = 0; i < num; i++) {
            System.out.print(getFibonacciNumberBottomUpDP(i) + " ");
        }
        System.out.println();
        for (int i = 0; i < num; i++) {
            System.out.print(getFibonacciNumberTopDownDPMemoized(i) + " ");
        }
        System.out.println();
        for (int i = 0; i < num; i++) {
            System.out.print(getFibonacciNumberSpaceOptimizedTopDown(i) + " ");
        }
        System.out.println();
    }

    public static int getFibonacciNumberRecursive (int num) {

        if (num < 2) {
            return num;
        }

        return getFibonacciNumberRecursive(num - 1) + getFibonacciNumberRecursive(num -2);
    }

    public static int getFibonacciNumberBottomUpDP (int N) {

        int[] dp = new int[N  + 2];
        dp[0] = 0;
        dp[1] = 1;

        for (int i = 2; i <= N; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[N];
    }

    static int[] memDP = new int[1000];
    public static  int getFibonacciNumberTopDownDPMemoized (int N) {

        if (N < 2) {
            return N;
        }

        if (memDP[N] != 0) {
            return memDP[N];
        } else {
            memDP[N] = getFibonacciNumberTopDownDPMemoized(N - 1) +
                            getFibonacciNumberTopDownDPMemoized(N - 2);
        }
        return memDP[N];
    }

    public static int getFibonacciNumberSpaceOptimizedTopDown (int N) {

        int numOne = 0;
        int numTwo = 1;

        if (N == 0) {
            return numOne;
        }

        for (int i = 2; i <= N; i++) {

            int temp = numOne + numTwo;
            numOne = numTwo;
            numTwo = temp;
        }
        return numTwo;
    }
}
