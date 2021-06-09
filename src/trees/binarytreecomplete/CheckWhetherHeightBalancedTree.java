package trees.binarytreecomplete;

class Height {
    int value;
}

public class CheckWhetherHeightBalancedTree implements BinaryTreeUtil{

    public static void main(String[] args) {

        CheckWhetherHeightBalancedTree binaryTreeUtil = new CheckWhetherHeightBalancedTree();
        TreeNode rootNode = binaryTreeUtil.getNewNode(2);
        rootNode.left = binaryTreeUtil.getNewNode(7);
        rootNode.right = binaryTreeUtil.getNewNode(5);
        //rootNode.right.left = binaryTreeUtil.getNewNode(18);
        rootNode.left.left = binaryTreeUtil.getNewNode(2);
        rootNode.left.right = binaryTreeUtil.getNewNode(6);
        rootNode.left.right.left = binaryTreeUtil.getNewNode(5);
        rootNode.left.right.right = binaryTreeUtil.getNewNode(11);
        rootNode.right.right = binaryTreeUtil.getNewNode(9);
        rootNode.right.right.left = binaryTreeUtil.getNewNode(4);

        System.out.println(binaryTreeUtil.isHeightBalancedTree(rootNode));
        System.out.println(binaryTreeUtil.isHeightBalancedTreeOptimized(rootNode, new Height()));
    }

    //O(n)
    public boolean isHeightBalancedTreeOptimized (TreeNode rootNode, Height height) {

        if (rootNode == null) {
            height.value = 0;
            return true;
        }

        Height lHeight = new Height();
        Height rHeight = new Height();

        boolean isLeftBalanced = isHeightBalancedTreeOptimized(rootNode.left, lHeight);
        boolean isRightBalanced = isHeightBalancedTreeOptimized(rootNode.right, rHeight);

        int leftHeight = lHeight.value;
        int rightHeight = rHeight.value;

        height.value = Math.max(leftHeight, rightHeight) + 1;

        if (Math.abs(leftHeight - rightHeight) >= 2) {
            return false;
        } else {
            return isLeftBalanced && isRightBalanced;
        }
    }
    //O(n2)
    public boolean isHeightBalancedTree (TreeNode rootNode) {

        if (rootNode == null) {
            return true;
        }

        int leftHeight = findHeightOfBinaryTree(rootNode.left);
        int rightHeight = findHeightOfBinaryTree(rootNode.right);

        if ((Math.abs(leftHeight - rightHeight) <= 1) &&
                isHeightBalancedTree(rootNode.left) &&
                        isHeightBalancedTree(rootNode.right)) {
            return true;
        }
        return false;
    }

    public int findHeightOfBinaryTree (TreeNode rootNode) {

        if (rootNode == null) {
            return 0;
        }

        return 1 + Math.max(findHeightOfBinaryTree(rootNode.left), findHeightOfBinaryTree(rootNode.right));
    }
}
