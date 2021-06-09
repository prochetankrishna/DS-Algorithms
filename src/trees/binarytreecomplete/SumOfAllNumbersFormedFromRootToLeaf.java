package trees.binarytreecomplete;

public class SumOfAllNumbersFormedFromRootToLeaf implements BinaryTreeUtil{

    int totalSum = 0;
    public static void main(String[] args) {

        SumOfAllNumbersFormedFromRootToLeaf binaryTreeUtil = new SumOfAllNumbersFormedFromRootToLeaf();
        TreeNode rootNode = binaryTreeUtil.getNewNode(2);
        rootNode.left = binaryTreeUtil.getNewNode(7);
        rootNode.right = binaryTreeUtil.getNewNode(5);
        rootNode.left.left = binaryTreeUtil.getNewNode(2);
        rootNode.left.right = binaryTreeUtil.getNewNode(6);
        rootNode.left.right.left = binaryTreeUtil.getNewNode(5);
        rootNode.left.right.right = binaryTreeUtil.getNewNode(9);
        rootNode.right.right = binaryTreeUtil.getNewNode(9);
        rootNode.right.right.left = binaryTreeUtil.getNewNode(4);

        binaryTreeUtil.printAllBinaryTreePaths(rootNode);
        System.out.println(binaryTreeUtil.totalSum);
        System.out.println(binaryTreeUtil.findSumOfNumbers(rootNode, 0));
        binaryTreeUtil.findSumOfAllPathNumberFormed(rootNode, 0);
        System.out.println(binaryTreeUtil.sumRootToLeaf);
    }

    int sumRootToLeaf = 0;
    public void findSumOfAllPathNumberFormed (TreeNode rootNode, int number) {

        if (rootNode == null) {
            return;
        }

        if (rootNode.left == null && rootNode.right == null) {
            sumRootToLeaf = sumRootToLeaf + (number * 10 + rootNode.data);
        }

        findSumOfAllPathNumberFormed(rootNode.left, number * 10 + rootNode.data);
        findSumOfAllPathNumberFormed(rootNode.right, number * 10 + rootNode.data);
    }

    //Best
    public int findSumOfNumbers (TreeNode rootNode, int totalSum) {

        if (rootNode == null) {
            return 0;
        }

        totalSum = totalSum * 10 + rootNode.data;
        //System.out.println("Current Node : [" + rootNode.data + "], TotalSum : [" + totalSum + "]");
        if (rootNode.left == null && rootNode.right == null) {
            return totalSum;
        }

        return findSumOfNumbers(rootNode.left, totalSum) + findSumOfNumbers(rootNode.right, totalSum);
    }
    public void printAllBinaryTreePaths (TreeNode rootNode) {

        if (rootNode == null) {
            return;
        }

        int[] arr = new int[100];
        printRootToLeafAllPath(rootNode, arr, 0);

    }

    private void printRootToLeafAllPath (TreeNode rootNode, int[] arr, int currentIndex) {

        if (rootNode == null) {
            return;
        }

        arr[currentIndex] = rootNode.data;
        if (rootNode.left == null && rootNode.right == null) {

            //Print
            printPath(arr, currentIndex);
        } else {

            //Keep Inserting
            printRootToLeafAllPath(rootNode.left, arr, currentIndex + 1);
            printRootToLeafAllPath(rootNode.right, arr, currentIndex + 1);
        }
    }

    private void printPath(int[] arr, int currentIndex) {

        String str = new String("");
        for (int i = 0; i <= currentIndex; i++) {
            str += arr[i];
        }
        int currentValue = Integer.parseInt(str);
        //System.out.println("Current Value : " + currentValue);
        totalSum += currentValue;
    }
}
