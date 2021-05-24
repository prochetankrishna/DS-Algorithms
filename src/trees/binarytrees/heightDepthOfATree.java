package trees.binarytrees;

import trees.binarytrees.BinaryTree.*;


public class heightDepthOfATree {

    public static void main(String[] args) {
        BinaryTree binaryTree = new BinaryTree();
        TreeNode rootNode = binaryTree.getHeadNode();

        rootNode = new BinaryTree.TreeNode(1);
        rootNode.left = new BinaryTree.TreeNode(2);
        rootNode.right = new BinaryTree.TreeNode(3);

        rootNode.left.left = new BinaryTree.TreeNode(4);
        rootNode.left.right = new BinaryTree.TreeNode(5);

        rootNode.right.left = new BinaryTree.TreeNode(6);
        rootNode.right.right = new BinaryTree.TreeNode(7);

        System.out.println("Height of Tree is : " + heightDepthOfTree(rootNode));
    }

    public static int heightDepthOfTree (TreeNode root) {

        if (root == null) {
            return 0;
        }

        int lHeight = heightDepthOfTree(root.left);
        int rHeight = heightDepthOfTree(root.right);

        return 1 + Math.max(lHeight, rHeight);
    }
}
