package sorting;

import java.util.Arrays;

public class InsertionSort {

    public static void main(String[] args) {

        int[] arrayToBeSorted = new int[] {5, 4, 3, 2, 1};
        System.out.println(Arrays.toString(arrayToBeSorted));
        insertionSort(arrayToBeSorted);
        System.out.println(Arrays.toString(arrayToBeSorted));
    }

    public static void insertionSort (int[] arr) {

        for (int i = 1; i < arr.length; i++) {
            int j = i - 1;
            int temp = arr[i];
            while (j >= 0 && arr[j] > temp) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = temp;
        }
    }
}
