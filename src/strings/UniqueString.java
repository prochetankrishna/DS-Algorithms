package strings;

import java.util.Arrays;

public class UniqueString {

    public static void main(String[] args) {
        String str = "CHETAN";
//        System.out.println(isUniqueStringBF(str));
//        System.out.println(isUniqueStringON(str));
        System.out.println(isUniqueStringBIT(str));
    }

    public static boolean isUniqueStringBIT (String str) {

        int checker = 0;
        for (int i = 0; i < str.length(); i++) {

            int bitAtIndex = str.charAt(i) - 'a';
            System.out.println(1 << bitAtIndex);

            if ((checker & (1 << bitAtIndex)) > 0) {
                return false;
            }

            checker = checker | (1 << bitAtIndex);
        }
        return true;
    }

    public static boolean isUniqueStringBF (String str) {

        for (int i = 0; i < str.length(); i++) {
            for (int j = i + 1; j < str.length(); j++) {
                if (str.charAt(i) == str.charAt(j)) {
                        return false;
                }
            }
        }
        return true;
    }

    public static boolean isUniqueStringON (String str) {

        boolean[] charChecker = new boolean[256];

        if (str.length() > 256) {
            return false;
        }
        Arrays.fill(charChecker, false);
        for (int i = 0; i < str.length(); i++) {

            int charValue = str.charAt(i);
            System.out.println(charValue);
            if (charChecker[charValue] == true) {
                return false;
            }
            charChecker[charValue] = true;
        }
        return true;
    }
}
