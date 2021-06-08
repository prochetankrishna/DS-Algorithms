package trees.binarytreecomplete;

public class CheckWhetherBinaryTreesAreIsomorphic implements BinaryTreeUtil{

    public static void main(String[] args) {
        CheckWhetherBinaryTreesAreIsomorphic binaryTreeUtil = new CheckWhetherBinaryTreesAreIsomorphic();

        TreeNode rootNodeOne = binaryTreeUtil.getNewNode(2);
        rootNodeOne.left = binaryTreeUtil.getNewNode(7);
        rootNodeOne.left.left = binaryTreeUtil.getNewNode(5);
        rootNodeOne.right = binaryTreeUtil.getNewNode(8);

        TreeNode rootNodeTwo = binaryTreeUtil.getNewNode(2);
        rootNodeTwo.left = binaryTreeUtil.getNewNode(7);
        rootNodeTwo.right = binaryTreeUtil.getNewNode(8);
        rootNodeTwo.left.right = binaryTreeUtil.getNewNode(5);

        System.out.println("Isomorphic ?? : " + binaryTreeUtil.isBinaryTreesIsomorphic(rootNodeOne, rootNodeTwo));
    }

    public boolean isBinaryTreesIsomorphic(TreeNode rootNodeOne, TreeNode rootNodeTwo) {

        if (rootNodeOne == null && rootNodeTwo == null) {
            return true;
        }

        if (rootNodeOne == null || rootNodeTwo == null) {
            return false;
        }

        if (rootNodeOne.data != rootNodeTwo.data) {
            return false;
        }

        return (isBinaryTreesIsomorphic(rootNodeOne.left, rootNodeTwo.left)
                && isBinaryTreesIsomorphic(rootNodeOne.right, rootNodeTwo.right)) ||
                (isBinaryTreesIsomorphic(rootNodeOne.left, rootNodeTwo.right)
                        && isBinaryTreesIsomorphic(rootNodeOne.right, rootNodeTwo.left));
    }
}
