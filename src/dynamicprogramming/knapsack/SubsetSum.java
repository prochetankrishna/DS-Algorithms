package dynamicprogramming.knapsack;

public class SubsetSum {

    public static void main(String[] args) {

        int[] arr = new int[]{2, 3, 7, 8, 10};
        System.out.println(subsetSumExists(arr, arr.length, 11));
    }

    public static boolean subsetSumExists (int[] arr, int n, int sum) {

        boolean[][] t = new boolean[n + 1][sum + 1];

        for (int i = 0; i < n + 1; i++) {
            for (int j = 0; j < sum + 1; j++) {
                if (i == 0) {
                    t[i][j] = false;
                }
                if (j == 0) {
                    t[i][j] = true;
                }
            }
        }

        for (int i = 1; i < n + 1; i++) {
            for (int  j = 1; j < sum + 1; j++) {

                if (arr[i - 1] <= j) {
                    t[i][j] = t[i - 1][j - arr[i - 1]] || t[i - 1][j];
                } else {
                    t[i][j] = t[i - 1][j];
                }
            }
        }

//        for (int i = 0; i < n + 1; i++) {
//            for (int j = 0; j < sum + 1; j++) {
//                System.out.print(t[i][j] + " ");
//            }
//            System.out.println();
//        }
        return t[n][sum];
    }
}
