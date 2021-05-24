package arrays;

import java.util.Arrays;

public class DuplicateZeroes {

    public static void main(String[] args) {

        int[] arr = new int[]{0, 0, 0};

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 0) {
                for (int j = arr.length - 1; j > i ; j--) {
                    arr [j] = arr [j - 1];
                }
                if (i <= arr.length - 2) {
                    arr [i + 1] = 0;
                }
                i++;
            }
            System.out.println(Arrays.toString(arr));
        }
    }
}
