package trees.binarytrees;

import trees.binarytrees.BinaryTree.TreeNode;

public class BoundaryOfBinaryTree {

    public static void main(String[] args) {

        BinaryTree binaryTree = new BinaryTree();
        TreeNode rootNode = binaryTree.getHeadNode();

        rootNode = new TreeNode(20);
        rootNode.left = new TreeNode(8);
        rootNode.right = new TreeNode(22);

        rootNode.left.left = new TreeNode(4);
        rootNode.left.right = new TreeNode(12);

        rootNode.right.left = new TreeNode(4);
        rootNode.right.right = new TreeNode(25);

        rootNode.left.right.left = new TreeNode(10);
        rootNode.left.right.right = new TreeNode(14);

        printBoundaryOfBinaryTree(rootNode);
    }

    public static void printBoundaryOfBinaryTree (TreeNode rootNode) {

        if (rootNode == null) {
            return;
        }

        //Always Print the rootNode first
        System.out.print(rootNode.data + " ");

        printLeftBoundaryOfTree (rootNode.left);
        printLeavesOfTree (rootNode.left);
        printLeavesOfTree (rootNode.right);
        printRightBoundaryOfTree (rootNode.right);
    }

    private static void printRightBoundaryOfTree(TreeNode rootNode) {

        if (rootNode == null) {
            return;
        }

        if (rootNode.right != null) {

            printRightBoundaryOfTree(rootNode.right);
            System.out.print(rootNode.data + " ");
        } else if (rootNode.left != null) {
            printRightBoundaryOfTree(rootNode.left);
            System.out.print(rootNode.data);
        } else {
            //Do not do anything for Leaf Nodes
        }
    }

    private static void printLeavesOfTree(TreeNode rootNode) {

        if (rootNode == null) {
            return;
        }

        printLeavesOfTree(rootNode.left);
        if (rootNode.left == null && rootNode.right == null) {
            System.out.print(rootNode.data + " ");
        }
        printLeavesOfTree(rootNode.right);
    }

    private static void printLeftBoundaryOfTree(TreeNode rootNode) {

        if (rootNode == null) {
            return;
        }

        if (rootNode.left != null) {
            System.out.print(rootNode.data + " ");
            printLeftBoundaryOfTree(rootNode.left);
        } else if (rootNode.right != null) {
            System.out.print(rootNode.data + " ");
            printLeftBoundaryOfTree(rootNode.right);
        } else {
            //Do Nothing for Leaf nodes here
        }
    }
}
