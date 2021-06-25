package trees.binarytreecomplete;

import trees.binarytreecomplete.interfaces.BinaryTreeUtil;

public class CheckWhetherBinaryTreesAreMirrorStructure implements BinaryTreeUtil {

    public static void main(String[] args) {
        CheckWhetherBinaryTreesAreMirrorStructure binaryTreeUtil = new CheckWhetherBinaryTreesAreMirrorStructure();

        TreeNode rootNodeOne = binaryTreeUtil.getNewNode(2);
        rootNodeOne.left = binaryTreeUtil.getNewNode(7);
        rootNodeOne.left.left = binaryTreeUtil.getNewNode(5);
        rootNodeOne.right = binaryTreeUtil.getNewNode(8);

        TreeNode rootNodeTwo = binaryTreeUtil.getNewNode(2);
        rootNodeTwo.left = binaryTreeUtil.getNewNode(8);
        rootNodeTwo.right = binaryTreeUtil.getNewNode(7);
        rootNodeTwo.right.right = binaryTreeUtil.getNewNode(5);
        //rootNodeTwo.left.right = binaryTreeUtil.getNewNode(14);

        System.out.println("Mirror ?? : " + binaryTreeUtil.isBinaryTreesMirrorStructure(rootNodeOne, rootNodeTwo));
    }

    public boolean isBinaryTreesMirrorStructure(TreeNode rootNodeOne, TreeNode rootNodeTwo) {

        if (rootNodeOne == null && rootNodeTwo == null) {
            return true;
        }

        if (rootNodeOne == null || rootNodeTwo == null) {
            return false;
        }

        return isBinaryTreesMirrorStructure(rootNodeOne.left, rootNodeTwo.right)
                && isBinaryTreesMirrorStructure(rootNodeOne.right, rootNodeTwo.left);
    }
}
