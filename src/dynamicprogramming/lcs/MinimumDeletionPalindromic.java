package dynamicprogramming.lcs;

public class MinimumDeletionPalindromic {

    public static void main(String[] args) {

        String X = "AGBCBA";
        int lengthOfX = X.length();

        StringBuilder reverseString = new StringBuilder();
        reverseString.append(X);
        reverseString.reverse();
        String Y = reverseString.toString();

        int lengthOfLPS = LongestCommonSubsequence.findLCSDP(X, Y, X.length(), Y.length());
        System.out.println("Minimum Operation Required : " + (lengthOfX - lengthOfLPS));
    }
}
