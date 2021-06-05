package trees.binarysearchtree;

public class BinarySearchTree {

    class Node {

        int data;
        Node left, right;

        public Node (int data) {
            this.data = data;
            this.left = this.right = null;
        }
    }

    Node rootNode;

    public BinarySearchTree () {
        rootNode = null;
    }

    public Node getRootNode() {
        return this.rootNode;
    }

    private Node insertNode (Node rootNode, int data) {

        if (rootNode == null) {
            Node node = new Node (data);
            return node;
        }

        if (rootNode.data > data) {
            rootNode.left = insertNode (rootNode.left, data);
        } else if (rootNode.data < data) {
            rootNode.right = insertNode (rootNode.right, data);
        } else {
            System.out.println("Duplicates not allowed");
        }
        return rootNode;
    }

    public void insertNode (int data) {
        this.rootNode = this.insertNode(this.rootNode, data);
    }

    private void inOrderTraversal (Node rootNode) {

        if (rootNode == null) {
            return;
        }

        inOrderTraversal (rootNode.left);
        System.out.print (rootNode.data + " ");
        inOrderTraversal (rootNode.right);
    }

    public void inOrderTraversal () {
        this.inOrderTraversal(this.rootNode);
    }


}
