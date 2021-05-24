package sorting;

import java.util.Arrays;

public class MergeSort {

    public static void main(String[] args) {

        int[] arr = new int[] {5, 4, 3, 2, 1, 0};
        System.out.println(Arrays.toString(arr));
        mergeSort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }

    public static void mergeSort (int[] arr, int low, int high) {

        if (high > low) {
            int mid = low + (high - low) / 2;
            mergeSort(arr, low, mid);
            mergeSort(arr, mid + 1, high);
            merge(arr, low, mid, high);
        }
    }
    public static void merge (int[] arr, int low, int mid, int high) {

        int lengthOfFirstHalf = mid - low + 1;
        int lengthOfSecondHalf = high - mid;

        int[] L = new int[lengthOfFirstHalf];
        int[] R = new int[lengthOfSecondHalf];

        for (int i = 0; i < lengthOfFirstHalf; i++) {
            L[i] = arr[low + i];
        }

        for (int j = 0; j < lengthOfSecondHalf; j++) {
            R[j] = arr[mid + 1 + j];
        }

        int i = 0, j = 0;
        int k = low;

        while (i < lengthOfFirstHalf && j < lengthOfSecondHalf) {
            if (L[i] < R[j]) {
                arr[k] = L[i];
                k++;
                i++;
            } else {
                arr[k] = R[j];
                k++;
                j++;
            }
        }

        while (i < lengthOfFirstHalf) {
            arr[k] = L[i];
            k++;
            i++;
        }

        while (j < lengthOfSecondHalf) {
            arr[k] = R[j];
            k++;
            j++;
        }
    }
}
