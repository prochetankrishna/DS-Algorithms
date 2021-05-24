package arrays;

public class RemoveDuplicates {

    public static void main(String[] args) {


    }

    public static int removeDuplicates(int[] nums) {


        for (int i = 1; i < nums.length; i++) {

            if (nums [i - 1] == nums[i]) {
                //Remove current element
            }
        }
        return nums.length;
    }
}
