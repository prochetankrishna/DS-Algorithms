package stack;

import java.sql.SQLOutput;

public class RainWaterTrapping {

    public static void main(String[] args) {

        int[] arr = {0, 3, 0, 0, 2, 0, 4};
        RainWaterTrapping rainWaterTrapping = new RainWaterTrapping();
        System.out.println(rainWaterTrapping.findRainWaterTrapped(arr));
    }

    public int findRainWaterTrapped (int[] arr) {

        int[] maxLeft = findMaximumTowardsLeft(arr);
        int[] maxRight = findMaximumTowardsRight(arr);

        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += Math.min(maxLeft[i], maxRight[i]) - arr[i];
        }
        return sum;
    }

    public int[] findMaximumTowardsLeft (int[] arr) {

        int[] result = new int[arr.length];
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > max) {
                result[i] = arr[i];
                max = arr[i];
            } else {
                result[i] = max;
            }
        }
        return result;
    }

    public int[] findMaximumTowardsRight (int[] arr) {

        int[] result = new int[arr.length];
        int max = Integer.MIN_VALUE;
        for (int i = arr.length - 1; i >= 0; i--) {
            if (arr[i] > max) {
                result[i] = arr[i];
                max = arr[i];
            } else {
                result[i] = max;
            }
        }
        return result;
    }
}
