package trees.binarytreecomplete;

import trees.binarytreecomplete.interfaces.BinaryTreeUtil;

public class CheckSumMatchesFromRootToLeaf implements BinaryTreeUtil {

    public static void main(String[] args) {

        CheckSumMatchesFromRootToLeaf binaryTreeUtil = new CheckSumMatchesFromRootToLeaf();
        TreeNode rootNode = binaryTreeUtil.getNewNode(2);
        rootNode.left = binaryTreeUtil.getNewNode(7);
        rootNode.right = binaryTreeUtil.getNewNode(5);
        rootNode.left.left = binaryTreeUtil.getNewNode(2);
        rootNode.left.right = binaryTreeUtil.getNewNode(6);
        rootNode.left.right.left = binaryTreeUtil.getNewNode(5);
        rootNode.left.right.right = binaryTreeUtil.getNewNode(11);
        rootNode.right.right = binaryTreeUtil.getNewNode(9);
        rootNode.right.right.left = binaryTreeUtil.getNewNode(4);

        System.out.println(binaryTreeUtil.isSumMatchesFromRootToLeaf(rootNode, 20));
    }

    public boolean isSumMatchesFromRootToLeaf (TreeNode rootNode, int sum) {

        if (rootNode == null) {
            return false;
        }

        if (rootNode.data == sum && rootNode.left == null && rootNode.right == null) {
            return true;
        }

        boolean isLeftMatches = isSumMatchesFromRootToLeaf(rootNode.left, sum - rootNode.data);

        if (isLeftMatches) {
            return true;
        } else {
            return isSumMatchesFromRootToLeaf(rootNode.right, sum - rootNode.data);
        }
    }
}
