package strings;

import java.util.Arrays;

public class Anagrams {

    public static void main(String[] args) {
        String strOne = "CAT";
        String strTwo = "ACT";
        System.out.println(isAnagram(strOne, strTwo));
    }

    public static boolean isAnagram (String strOne, String strTwo) {

        if (strOne.length() != strTwo.length()) {
            return false;
        }

        int[] count = new int[256];
        Arrays.fill(count, 0);

        for (int i = 0; i < strOne.length(); i++) {
            count[strOne.charAt(i)]++;
            count[strTwo.charAt(i)]--;
        }

        for (int i = 0; i < 256; i++) {
            if (count[i] != 0) {
                return false;
            }
        }
        return true;
    }
}
