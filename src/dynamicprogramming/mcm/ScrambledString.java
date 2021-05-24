package dynamicprogramming.mcm;

import javax.print.DocFlavor;

public class ScrambledString {


    public static void main(String[] args) {

        String a = "abcde";
        String b = "caebd";
        System.out.println(solveScrambledString(a, b));
    }
    public static boolean solveScrambledString (String a, String b) {

        if (a.length() != b.length()) {
            return false;
        }

        if (a.length() == 0 && b.length() == 0) {
            return true;
        }

        if (a.equals(b)) {
            return true;
        }

        if (a.length() <= 1) {
            return false;
        }

        int n = a.length();
        boolean isScrambled = false;

        for (int i = 1; i < n; i++) {

            boolean conditionOne = (solveScrambledString (getSubString(a, 0, i), getSubString(b, n - i, i))
                                   &&
                                    solveScrambledString (getSubString(a, i,n - i), getSubString(b, 0, n - i)));

            boolean conditionTwo = (solveScrambledString (getSubString(a, 0, i), getSubString(b, 0, i))
                                   &&
                                   solveScrambledString (getSubString(a, i, n - i), getSubString(b, i, n - i)));

            if (conditionOne || conditionTwo) {
                isScrambled = true;
                break;
            }
        }

        return isScrambled;
    }

    public static String getSubString(String str, int startIndex, int numCharacters) {

        StringBuilder stringBuilder = new StringBuilder();

        String subString = str.substring(startIndex);

        for (int i = 0; i < numCharacters; i++) {
            stringBuilder.append(subString.charAt(i));
        }
        return stringBuilder.toString();
    }
}
