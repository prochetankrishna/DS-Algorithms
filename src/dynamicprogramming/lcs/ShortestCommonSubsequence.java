package dynamicprogramming.lcs;

public class ShortestCommonSubsequence {

    public static void main(String[] args) {

        String X = "GEEK";
        String Y = "EKE";

        int lengthOfX = X.length();
        int lengthOfY = Y.length();

        int LCSOfXAndY = LongestCommonSubsequence.findLCSDP(X, Y, X.length(), Y.length());

        System.out.println("Length of Shortest Common Subsequence : " + (lengthOfX + lengthOfY - LCSOfXAndY));
    }
}
