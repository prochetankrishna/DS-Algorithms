package trees.binarytreecomplete;

import trees.binarytreecomplete.interfaces.BinaryTreeUtil;

public class DiameterOfTree implements BinaryTreeUtil {

    int diameter;
    public static void main(String[] args) {
        DiameterOfTree binaryTreeUtil = new DiameterOfTree();
        TreeNode rootNode = binaryTreeUtil.getNewNode(2);
        rootNode.left = binaryTreeUtil.getNewNode(7);
        rootNode.right = binaryTreeUtil.getNewNode(5);
        rootNode.left.left = binaryTreeUtil.getNewNode(2);
        rootNode.left.right = binaryTreeUtil.getNewNode(6);
        rootNode.left.right.left = binaryTreeUtil.getNewNode(5);
        rootNode.left.right.right = binaryTreeUtil.getNewNode(11);
        rootNode.right.right = binaryTreeUtil.getNewNode(9);
        rootNode.right.right.left = binaryTreeUtil.getNewNode(4);
//        binaryTreeUtil.printLevelOrderTraversalLineByLine(rootNode);
//        System.out.println();

        System.out.println("Diameter : " + binaryTreeUtil.diameterOfBinaryTree(rootNode));
        System.out.println("Diameter : " + binaryTreeUtil.getDiameterOfBinaryTree(rootNode));
    }

    //O(n) solution
    static class Result {
        int result = Integer.MIN_VALUE;
    }

    public int getDiameterOfBinaryTree(TreeNode rootNode) {

        Result result = new Result();
        getDiameterOfBinaryTree(rootNode, result);
        return result.result + 1;
    }

    private int getDiameterOfBinaryTree(TreeNode rootNode, Result result) {

        if (rootNode == null) {
            return 0;
        }

        int leftCount = getDiameterOfBinaryTree(rootNode.left, result);
        int rightCount = getDiameterOfBinaryTree(rootNode.right, result);

        int temp = leftCount + rightCount;
        result.result = Math.max(result.result, temp);
        return 1 + Math.max(leftCount, rightCount);
    }

    public int diameterOfBinaryTree (TreeNode rootNode) {

        if (rootNode == null) {
            return 0;
        }

        int leftHeight = this.getHeightOfTree(rootNode.left);
        int rightHeight = this.getHeightOfTree(rootNode.right);

        int leftDiameter = diameterOfBinaryTree(rootNode.left);
        int rightDiameter = diameterOfBinaryTree(rootNode.right);

        return Math.max(leftHeight + rightHeight + 1, Math.max(leftDiameter, rightDiameter));
    }

    @Override
    public int getHeightOfTree (TreeNode rootNode) {

        if (rootNode == null) {
            return 0;
        }

        int lHeight = getHeightOfTree(rootNode.left);
        int rHeight = getHeightOfTree(rootNode.right);

        return 1 + Math.max (lHeight, rHeight);
    }
}
