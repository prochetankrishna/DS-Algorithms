package sorting;

import java.util.Arrays;

public class QuickSort {

    public static void main(String[] args) {

        int[] arr = new int[] {7, 5, 1, 3, 2, 10};
        System.out.println(Arrays.toString(arr));
        performQuickSort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));

    }

    public static void swapElements (int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static int partitioningLogicForQS (int[] arr, int low, int high) {

        int pivot = arr[high];
        int i = low - 1;

        for (int j = low; j <= high - 1; j++) {

            if (arr[j] < pivot) {
                i++;
                swapElements(arr, i, j);
            }
        }
        swapElements(arr, i + 1, high);

        for (int k = 0; k < arr.length; k++) {
            System.out.print(arr[k] + " ");
        }
        System.out.println();
        return i + 1;
    }

    public static void performQuickSort (int[] arr, int low, int high) {

        if (low < high) {
            int partitionElement = partitioningLogicForQS(arr, low, high);
            //System.out.println("I : [" + partitionElement + "]" );
            //System.out.println(Arrays.toString(arr));
            performQuickSort(arr, low, partitionElement - 1);
            performQuickSort(arr, partitionElement + 1, high);
        }
    }
}
