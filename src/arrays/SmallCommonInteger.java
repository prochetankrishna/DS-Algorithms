package arrays;

public class SmallCommonInteger {

    public static void main(String[] args) {
        int[] arr1 = {6, 7, 10, 25, 30, 63, 64};
        int[] arr2 = {0, 4, 5, 6, 7, 8, 50};
        int[] arr3 = {1, 6, 10, 14};
        System.out.println(findLeastCommonNumber(arr1, arr2, arr3));
    }

    static Integer findLeastCommonNumber(int[] arr1, int[] arr2, int[] arr3) {
        //TODO: Write - Your - Code
        int i = 0, j = 0, k = 0;

        while (i < arr1.length && j < arr2.length && k < arr3.length) {

            if (arr1[i] == arr2[j] && arr2[j] == arr3[k]) {
                return arr1[i];
            } else if ((arr1[i] < arr2[j]) && (arr1[i] < arr3[k])) {
                i++;
            } else if ((arr2[j] < arr1[i]) && (arr2[j] < arr3[k])) {
                j++;
            } else if ((arr3[k] < arr1[i]) && (arr3[k] < arr2[j])) {
                k++;
            }
        }
        return -1;
    }
}
