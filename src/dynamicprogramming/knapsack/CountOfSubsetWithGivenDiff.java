package dynamicprogramming.knapsack;

public class CountOfSubsetWithGivenDiff {

    public static void main(String[] args) {

        int arr[] = {1, 1, 2, 3};
        int diff = 1;
        System.out.println(countSubSetWithDiff(arr, arr.length, diff));

    }

    public static int countSubSetWithDiff (int[] arr, int n, int diff) {

        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += arr[i];
        }

        int subsetSum = (sum + diff) / 2;

        if (subsetSum % 2 != 0) {
            return -1;
        } else {

            int countOfSubsetSum = CountNumberSubsetSum.countNumberOfSubsetSum(arr, arr.length, subsetSum);
            return countOfSubsetSum;
        }
    }
}
