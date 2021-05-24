package sorting;

import java.lang.reflect.Array;
import java.util.Arrays;

public class CyclicSort {

    public static void main(String[] args) {

        int arr[] = {3, 1, 5, 2, 4};
        System.out.println(Arrays.toString(arr));
        cyclicSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void cyclicSort (int[] arr) {

        int i = 0;
        while (i < arr.length) {

            int j = arr[i] - 1;
            System.out.println("I : [" + i + "], J : [" + j + "], ARR[" + i + "] : " + arr[i] + ", ARR[" + j + "] : " + arr[j]);
            if (arr[i] != arr[j]) {
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            } else {
                i++;
            }
            System.out.println(Arrays.toString(arr));
        }
    }
}
