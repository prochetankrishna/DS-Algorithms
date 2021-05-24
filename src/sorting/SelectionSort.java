package sorting;

import java.util.Arrays;

public class SelectionSort {

    public static void main(String[] args) {

        int[] arrayToBeSorted = new int[] {5, 4, 3, 2, 1};
        System.out.println(Arrays.toString(arrayToBeSorted));
        selectionSort(arrayToBeSorted);
        System.out.println(Arrays.toString(arrayToBeSorted));
    }

    public static void selectionSort (int[] arr) {

        for (int i = 0; i < arr.length - 1; i++) {
            int min_idx = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[min_idx] > arr[j]) {
                    min_idx = j;
                }
            }
            int temp = arr[min_idx];
            arr[min_idx] = arr[i];
            arr[i] = temp;
        }
    }
}
