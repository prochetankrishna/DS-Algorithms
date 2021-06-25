package trees.binarytreecomplete;

import trees.binarytreecomplete.interfaces.BinaryTreeUtil;

public class MaxSumRootToLeaf implements BinaryTreeUtil {

    public static void main(String[] args) {

        MaxSumRootToLeaf binaryTreeUtil = new MaxSumRootToLeaf();
        TreeNode rootNode = binaryTreeUtil.getNewNode(2);
        rootNode.left = binaryTreeUtil.getNewNode(7);
        rootNode.right = binaryTreeUtil.getNewNode(5);
        rootNode.left.left = binaryTreeUtil.getNewNode(2);
        rootNode.left.right = binaryTreeUtil.getNewNode(6);
        rootNode.left.right.left = binaryTreeUtil.getNewNode(5);
        rootNode.left.right.right = binaryTreeUtil.getNewNode(11);
        rootNode.right.right = binaryTreeUtil.getNewNode(9);
        rootNode.right.right.left = binaryTreeUtil.getNewNode(4);

        binaryTreeUtil.maxSumRootToLeaf(rootNode, 0);
        System.out.println(binaryTreeUtil.maximumSum);
    }

    int maximumSum = 0;
    private void maxSumRootToLeaf (TreeNode rootNode, int sumSoFar) {

        if (rootNode == null) {
            return;
        }

        if (rootNode.left == null && rootNode.right == null) {

            if (sumSoFar + rootNode.data > maximumSum) {
                maximumSum = sumSoFar + rootNode.data;
                return;
            }
        } else {

            maxSumRootToLeaf(rootNode.left, sumSoFar + rootNode.data);
            maxSumRootToLeaf(rootNode.right, sumSoFar + rootNode.data);
        }
    }
}
