package arrays;

import java.util.Arrays;

public class MergeSortedArray {

    public static void merge(int[] nums1, int m, int[] nums2, int n) {

        int i = 0;
        int j = 0;

        while (i < m && j < n) {

            if (nums1[i] <= nums2[j]) {
                i++;
            } else {

            }
        }

        while (j < n) {
            nums1[i++] = nums2[j++];
        }
        System.out.println(Arrays.toString(nums1));
    }

    public static void main(String[] args) {

        int[] nums1 = new int[]{1};
        int[] nums2 = new int[]{};

        merge(nums1, 1, nums2, 0);
    }
}
