package sorting;

import java.util.Arrays;

public class BubbleSort {

    public static void main(String[] args) {

        int[] arrayToBeSorted = new int[] {5, 7, 3, 8, 1};
        System.out.println(Arrays.toString(arrayToBeSorted));
        bubbleSort(arrayToBeSorted);
        System.out.println(Arrays.toString(arrayToBeSorted));

        int[] arrayToBeSortedImproved = new int[] {5, 7, 3, 8, 1};
        System.out.println(Arrays.toString(arrayToBeSortedImproved));
        bubbleSortImproved(arrayToBeSortedImproved);
        System.out.println(Arrays.toString(arrayToBeSortedImproved));
    }

    public static void bubbleSort (int[] arr) {

        //Number of pass will be length of array - 1
        for (int i = 0; i < arr.length - 1; i++) {

            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }

    public static void bubbleSortImproved (int[] arr) {

        boolean isSwapDone;
        //Number of pass will be length of array - 1
        for (int i = 0; i < arr.length - 1; i++) {
            isSwapDone = false;
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    isSwapDone = true;
                }
            }
            if (!isSwapDone) {
                break;
            }
        }
    }

}
