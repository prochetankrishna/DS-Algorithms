package trees.binarysearchtree;

import trees.binarysearchtree.BinarySearchTree.Node;

public class LowestCommonAncestor {

    public static void main(String[] args) {

        int[] arr = {50, 30, 20, 40, 70, 60, 80};
        BinarySearchTree binarySearchTree = new BinarySearchTree();

        for (int i = 0; i < arr.length; i++) {
            binarySearchTree.insertNode(arr[i]);
        }

        Node rootNode = binarySearchTree.getRootNode();

        Node lcaRecursive = findLCARecursive (rootNode, 20, 80);
        if (lcaRecursive != null) {
            System.out.println(lcaRecursive.data);
        } else {
            System.out.println("Not Found !!");
        }

        Node lcaIterative = findLCAIterative (rootNode, 20, 80);
        if (lcaIterative != null) {
            System.out.println(lcaIterative.data);
        } else {
            System.out.println("Not Found !!");
        }
    }

    public static Node findLCARecursive (Node node, int nodeOne, int nodeTwo) {

        if (node == null) {
            return null;
        }

        if (node.data > nodeOne && node.data > nodeTwo) {
            return findLCARecursive (node.left, nodeOne, nodeTwo);
        }

        if (node.data < nodeOne && node.data < nodeTwo) {
            return findLCARecursive (node.right, nodeOne, nodeTwo);
        }

        return node;
    }

    public static Node findLCAIterative (Node node, int nodeOne, int nodeTwo) {

        while (node != null) {

            if (node.data > nodeOne && node.data > nodeTwo) {
                node = node.left;
            } else if (node.data < nodeOne && node.data < nodeTwo) {
                node = node.right;
            } else {
                break;
            }
        }
        return node;
    }
}
