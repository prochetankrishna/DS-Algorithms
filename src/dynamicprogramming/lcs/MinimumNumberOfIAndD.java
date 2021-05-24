package dynamicprogramming.lcs;

public class MinimumNumberOfIAndD {

    public static void main(String[] args) {

        String X = "HEAP";
        String Y = "PEA";

        int lengthOfX = X.length();
        int lengthOfY = Y.length();

        int lcsOfXAndY = LongestCommonSubsequence.findLCSDP(X, Y, X.length(), Y.length());

        int numberOfDeletion = lengthOfX - lcsOfXAndY;
        int numberOfInsertion = lengthOfY - lcsOfXAndY;

        System.out.println("Minimum Number of Insertion and Deletion required : " + (numberOfDeletion + numberOfInsertion));
    }
}
