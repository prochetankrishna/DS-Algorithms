package trees.binarysearchtree;

import trees.binarysearchtree.BinarySearchTree.Node;

import java.util.HashMap;
import java.util.Map;

public class InOrderSuccessorInBST {

    public static void main(String[] args) {

        int searchForNodeValue = 14;
        int[] arr = {20, 8, 22, 4, 12, 10, 14};
        BinarySearchTree binarySearchTree = new BinarySearchTree();

        for (int i = 0; i < arr.length; i++) {
            binarySearchTree.insertNode(arr[i]);
        }

        Node rootNode = binarySearchTree.getRootNode();
        Node foundNode = findElementInBST(rootNode, searchForNodeValue);

        Node inOrderSuccessor = findInOrderSuccessor(rootNode, foundNode);
        Node inOrderSuccessorFromData = findInOrderSuccessorWithData(rootNode, searchForNodeValue);

        if (inOrderSuccessor == null) {
            System.out.println("No InOrderSuccessor Exists");
        } else {
            System.out.println("InOrder Successor Exists with value : [" + inOrderSuccessor.data + "]");
        }

        if (inOrderSuccessorFromData == null) {
            System.out.println("No InOrderSuccessor Exists");
        } else {
            System.out.println("InOrder Successor Exists with value : [" + inOrderSuccessorFromData.data + "]");
        }
    }

    public static Node findInOrderSuccessorWithData (Node rootNode, int data) {

        if (rootNode == null) {
            return null;
        }

        Node successor = null;

        while (rootNode != null) {

            if (rootNode.data > data) {

                successor = rootNode;
                rootNode = rootNode.left;
            } else if (rootNode.data < data) {

                rootNode = rootNode.right;
            } else {

                if (rootNode.right != null) {
                    return findMinimumNode (rootNode.right);
                } else {
                    break;
                }
            }
        }
        return successor;
    }

    public static Node findInOrderSuccessor (Node rootNode, Node node) {

        if (rootNode == null || node == null) {
            return null;
        }

        if (node.right != null) {
            return findMinimumNode(node.right);
        }

        Node successor = null;

        while (rootNode != null) {

            if (rootNode.data > node.data) {

                successor = rootNode;
                rootNode = rootNode.left;
            } else if (rootNode.data < node.data) {

                rootNode = rootNode.right;
            } else {
                break;
            }
        }
        return successor;
    }

    //Util Function
    //Leftmost Node in this tree will contains node with lowest value
    public static Node findMinimumNode (Node node) {

        while (node.left != null) {
            node = node.left;
        }
        return node;
    }
    //Util Function
    public static Node findElementInBST (Node rootNode, int data) {

        if (rootNode == null) {
            return null;
        }

        if (rootNode.data == data) {
            return rootNode;
        } else if (rootNode.data < data) {
            return findElementInBST(rootNode.right, data);
        } else {
            return findElementInBST(rootNode.left, data);
        }
    }
}
