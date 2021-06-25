package trees.binarytreecomplete;

import trees.binarytreecomplete.interfaces.BinaryTreeUtil;

public class PrintRootToLeafAllPath implements BinaryTreeUtil {

    public static void main(String[] args) {

        PrintRootToLeafAllPath binaryTreeUtil = new PrintRootToLeafAllPath();
        TreeNode rootNode = binaryTreeUtil.getNewNode(2);
        rootNode.left = binaryTreeUtil.getNewNode(7);
        rootNode.right = binaryTreeUtil.getNewNode(5);
        rootNode.left.left = binaryTreeUtil.getNewNode(2);
        rootNode.left.right = binaryTreeUtil.getNewNode(6);
        rootNode.left.right.left = binaryTreeUtil.getNewNode(5);
        rootNode.left.right.right = binaryTreeUtil.getNewNode(11);
        rootNode.right.right = binaryTreeUtil.getNewNode(9);
        rootNode.right.right.left = binaryTreeUtil.getNewNode(4);

        binaryTreeUtil.printAllBinaryTreePaths(rootNode);
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

        for (int i = 0; i <= currentIndex; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
}
