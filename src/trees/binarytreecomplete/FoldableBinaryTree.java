package trees.binarytreecomplete;

public class FoldableBinaryTree implements BinaryTreeUtil{

    public static void main(String[] args) {
        FoldableBinaryTree binaryTreeUtil = new FoldableBinaryTree();

        TreeNode rootNode = binaryTreeUtil.getNewNode(2);
        rootNode.left = binaryTreeUtil.getNewNode(7);
        rootNode.right = binaryTreeUtil.getNewNode(8);
        

        System.out.println("Foldable ?? : " + binaryTreeUtil.isBinaryTreeFoldable(rootNode));
    }

    public boolean isBinaryTreeFoldable(TreeNode rootNode) {

        if (rootNode == null) {
            return true;
        }

        return isMirrorStructure (rootNode.left, rootNode.right);
    }

    private boolean isMirrorStructure(TreeNode leftTree, TreeNode rightTree) {

        if (leftTree == null && rightTree == null) {
            return true;
        }

        if (leftTree == null || rightTree == null) {
            return false;
        }

        return isMirrorStructure(leftTree.left, rightTree.right)
                && isMirrorStructure(leftTree.left, rightTree.left);
    }
}
