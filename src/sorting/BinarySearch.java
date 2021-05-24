package sorting;

import java.util.ArrayList;
import java.util.List;

public class BinarySearch {

    public static void main(String[] args) {

        List<Integer> integerList = new ArrayList<>();
        integerList.add(1);
        integerList.add(2);
        integerList.add(3);
        integerList.add(4);
        integerList.add(5);
        Integer[] arr = new Integer[integerList.size()];
        integerList.toArray(arr);
        System.out.println(binarySearchIterative(arr, 1));
        System.out.println(binarySearchIterative(arr, 2));
        System.out.println(binarySearchIterative(arr, 4));
        System.out.println(binarySearchIterative(arr, 8));
        System.out.println(binarySearchIterative(arr, 5));
    }

    public static int binarySearchIterative (Integer[] arr, int key) {

        int low = 0;
        int high = arr.length - 1;

        while (low <= high) {

            int mid = low + (high - low) / 2;

            if (arr[mid] == key) {
                return mid;
            } else if (arr[mid] < key) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return -1;
    }
}
