package sorting;

import java.util.Arrays;

public class CountingSort {

    public static void main(String[] args) {

        int[] arr = {6, 3, 9, 10, 15, 6, 8, 12, 3, 6};

        System.out.println(Arrays.toString(countingSort(arr)));
    }

    public static int[] countingSort (int[] arr) {

        int[] result = new int[arr.length];
        int max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }

        int[] count = new int[max + 1];
        for (int i = 0; i < max + 1; i++) {
            count[i] = 0;
        }

        for (int i = 0; i < arr.length; i++) {
            count[arr[i]]++;
        }

//        for (int i = 0; i < max + 1; i++) {
//            System.out.print(count[i] + " ");
//        }
//        System.out.println();

        int i = 0, j = 0;
        while (i < max + 1) {
            int temp = count[i];
            if (temp > 0) {
                while (temp != 0) {
                    result[j] = i;
                    j++;
                    temp--;
                }
            }
            i++;
        }
        return result;
    }
}
