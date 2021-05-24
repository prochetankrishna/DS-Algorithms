package dynamicprogramming.lcs;

import java.util.Arrays;

public class LongestPalindromicSubsequence {

    public static void main(String[] args) {

        String X = "AGBCBA";

        StringBuilder reverseString = new StringBuilder();
        reverseString.append(X);
        reverseString.reverse();
        String Y = reverseString.toString();

        PrintLongestCommonSubsequence.printLCS(X, Y, X.length(), Y.length());
    }
}
