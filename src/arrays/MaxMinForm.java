package arrays;

public class MaxMinForm {

    public static void main(String[] args) {
        int[] arr = {1, 3, 4, 5, 8, 9};
        minMaxForm(arr, arr.length);
    }

    public static void minMaxForm (int arr[], int n) {

        int maxIndex = n - 1;
        int minIndex = 0;
        int maxElement = arr[n - 1] + 1;

        for (int i = 0; i < n; i++) {

            if (i % 2 == 0) {
                arr[i] += arr[maxIndex] % maxElement * maxElement;
                maxIndex--;
            } else {
                arr[i] += arr[minIndex] % maxElement * maxElement;
                minIndex++;
            }
        }

        for (int i = 0; i < n; i++) {
            arr[i] /= maxElement;
        }

        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
}
