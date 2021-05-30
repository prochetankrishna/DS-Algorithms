package trees.binarysearchtree;

import java.util.Stack;

public class BSTInsertionAndDeletion {

    class BSTNode {

        int data;
        BSTNode left, right;

        public BSTNode(int data) {
            this.data = data;
            this.left = this.right = null;
        }
    }

    BSTNode rootNode;

    public BSTInsertionAndDeletion() {
        this.rootNode = null;
    }

    public BSTNode insertNode (BSTNode rootNode, int data) {

        if (rootNode == null) {
            BSTNode tempNode = new BSTNode(data);
            rootNode = tempNode;
            return rootNode;
        }

        if (rootNode.data > data) {
            rootNode.left = insertNode(rootNode.left, data);
        } else {
            rootNode.right = insertNode(rootNode.right, data);
        }
        return rootNode;
    }

    public void insertNode (int data) {

        this.rootNode = this.insertNode(this.rootNode, data);
    }

    public void preOrderTraversal (BSTNode rootNode) {

        if (rootNode == null) {
            return;
        }

        Stack<BSTNode> stack = new Stack<>();
        stack.push (rootNode);

        while (!stack.isEmpty()) {
            BSTNode tempNode = stack.pop();
            System.out.print(tempNode.data + " ");

            if (tempNode.right != null) {
                stack.push (tempNode.right);
            }

            if (tempNode.left != null) {
                stack.push (tempNode.left);
            }
        }
    }

    public void inOrderTraversal (BSTNode rootNode) {

        if (rootNode == null) {
            return;
        }

        Stack<BSTNode> stack = new Stack<>();
        BSTNode currentNode = rootNode;

        while (currentNode != null || !stack.isEmpty()) {

            while (currentNode != null) {
                stack.push (currentNode);
                currentNode = currentNode.left;
            }

            if (!stack.isEmpty()) {
                BSTNode tempNode = stack.pop();
                System.out.print(tempNode.data + " ");
                currentNode = tempNode.right;
            }
        }
    }

    public void postOrderTraversal (BSTNode rootNode) {

        if (rootNode == null) {
            return;
        }

        Stack<BSTNode> stackOne = new Stack<>();
        Stack<BSTNode> stackTwo = new Stack<>();

        stackOne.push (rootNode);

        while (!stackOne.isEmpty()) {

            BSTNode tempNode = stackOne.pop();
            stackTwo.push(tempNode);

            if (tempNode.left != null) {
                stackOne.push (tempNode.left);
            }

            if (tempNode.right != null) {
                stackOne.push (tempNode.right);
            }
        }

        while (!stackTwo.isEmpty()) {
            BSTNode tempNode = stackTwo.pop();
            System.out.print(tempNode.data + " ");
        }
    }

    public static void main(String[] args) {

        BSTInsertionAndDeletion bstTree = new BSTInsertionAndDeletion();
        bstTree.insertNode(8);
        bstTree.insertNode(3);
        bstTree.insertNode(10);
        bstTree.insertNode(1);
        bstTree.insertNode(6);
        bstTree.insertNode(14);
        bstTree.insertNode(4);
        bstTree.insertNode(7);
        bstTree.insertNode(13);

        bstTree.preOrderTraversal(bstTree.rootNode);
        System.out.println();
        bstTree.inOrderTraversal(bstTree.rootNode);
        System.out.println();
        bstTree.postOrderTraversal(bstTree.rootNode);
        System.out.println();
    }
}
