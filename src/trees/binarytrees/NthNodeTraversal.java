package trees.binarytrees;

import trees.binarytrees.BinaryTree.TreeNode;

public class NthNodeTraversal {

    public static int countForPreOrder = 0;
    public static int countForInOrder = 0;
    public static int countForPostOrder = 0;

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

        PreOrderTraversal.preOrderTraversalRecursive(rootNode);
        System.out.println();
        nthNodeInPreOrderTraversal(rootNode, 5);

        InOrderTraversal.inOrderTraversalRecursive(rootNode);
        System.out.println();
        nthNodeInInOrderTraversal(rootNode, 5);

        PostOrderTraversal.postOrderTraversal(rootNode);
        System.out.println();
        nthNodeInPostOrderTraversal(rootNode, 5);
    }

    public static void nthNodeInPreOrderTraversal (TreeNode root, int n) {

        if (root == null) {
            return;
        }

        if (countForPreOrder <= n) {

            countForPreOrder++;
            if (countForPreOrder == n) {
                System.out.println("PREORDER - Nth [" + n + "] Node : " + root.data);
            }

            nthNodeInPreOrderTraversal(root.left, n);
            nthNodeInPreOrderTraversal(root.right, n);
        }
    }

    public static void nthNodeInInOrderTraversal (TreeNode root, int n) {

        if (root == null) {
            return;
        }

        if (countForInOrder <= n) {

            nthNodeInInOrderTraversal(root.left, n);
            countForInOrder++;

            if (countForInOrder == n) {
                System.out.println("INORDER - Nth [" + n + "] Node : " + root.data);
            }

            nthNodeInInOrderTraversal(root.right, n);
        }
    }

    public static void nthNodeInPostOrderTraversal (TreeNode root, int n) {

        if (root == null) {
            return;
        }

        if (countForPostOrder <= n) {

            nthNodeInPostOrderTraversal(root.left, n);
            nthNodeInPostOrderTraversal(root.right, n);

            countForPostOrder++;
            if (countForPostOrder == n) {
                System.out.println("POSTORDER - Nth [" + n + "] Node : " + root.data);
            }
        }
    }
}
