package arrays;

import java.util.Arrays;

public class RemoveElement {

    public static void main(String[] args) {

        int[] arr = new int[]{3, 3};
        System.out.println(Arrays.toString(arr));
        System.out.println(removeElement(arr, 3));
        System.out.println(Arrays.toString(arr));
    }

    public static int removeElement(int[] nums, int val) {

        int start = 0, end = nums.length - 1;
        int length = 0;
        while (start < end) {
            if (nums[start] == val) {
                while (nums[end] == val) {
                    end--;
                }
                int temp = nums[start];
                nums[start] = nums[end];
                nums[end] = temp;
                end--;
                start++;
            }else {
               start++;
            }
        }
        int counter = 0;
        while (counter < nums.length && nums[counter] != val) {
            length++;
            counter++;
        }
        return length;
    }
}
