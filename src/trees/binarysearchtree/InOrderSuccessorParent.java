package trees.binarysearchtree;

public class InOrderSuccessorParent {

    class BSTNode {

        int data;
        BSTNode left, right, parent;

        public BSTNode(int data) {
            this.data = data;
            this.left = this.right = this.parent = null;
        }
    }
    public BSTNode insertNode (BSTNode node, int data) {

        if (node == null) {
            return new BSTNode(data);
        } else {
            BSTNode tempNode = null;
            if (node.data >= data) {
                tempNode = insertNode (node.left, data);
                node.left = tempNode;
                tempNode.parent = node;
            } else {
                tempNode = insertNode (node.right, data);
                node.right = tempNode;
                tempNode.parent = node;
            }
            return node;
        }
    }

    public BSTNode inOrderSuccessor (BSTNode rootNode, BSTNode node) {

        if (rootNode == null) {
            return null;
        }

        if (node == null) {
            return null;
        }

        if (node.right != null) {
            return findMinimumInBST(node.right);
        }


        while (node.parent != null && node.parent.left != node) {
            node = node.parent;
        }
        return node.parent;
    }

    public BSTNode findMinimumInBST (BSTNode rootNode) {

        if (rootNode == null) {
            return null;
        }
        BSTNode tempNode = rootNode;
        while (tempNode.left != null) {
            tempNode = tempNode.left;
        }
        return tempNode;
    }

    public void inOrderTraversal (BSTNode rootNode) {
        if (rootNode == null) {
            return;
        }
        inOrderTraversal (rootNode.left);
        System.out.print(rootNode.data + " ");
        inOrderTraversal (rootNode.right);
    }

    public static void main(String[] args) {

        BSTNode rootNode = null;
        InOrderSuccessorParent binarySearchTree = new InOrderSuccessorParent();
        rootNode = binarySearchTree.insertNode(rootNode, 20);
        rootNode = binarySearchTree.insertNode(rootNode, 8);
        rootNode = binarySearchTree.insertNode(rootNode, 22);
        rootNode = binarySearchTree.insertNode(rootNode, 4);
        rootNode = binarySearchTree.insertNode(rootNode, 12);
        rootNode = binarySearchTree.insertNode(rootNode, 10);
        rootNode = binarySearchTree.insertNode(rootNode, 14);

        binarySearchTree.inOrderTraversal(rootNode);
        System.out.println();

        BSTNode nodeOne = rootNode.left.right.right;
        BSTNode nodeTwo = rootNode.right;
        BSTNode nodeThree = rootNode.left.right.left;

        BSTNode inOrderOne = binarySearchTree.inOrderSuccessor(rootNode, nodeOne);
        if (inOrderOne != null) {
            System.out.println("InOrder Successor of Node : " + nodeOne.data + " is : " + inOrderOne.data);
        } else {
            System.out.println("InOrder Successor of Node : " + nodeOne.data + " is : " + null);
        }

        BSTNode inOrderTwo = binarySearchTree.inOrderSuccessor(rootNode, nodeTwo);
        if (inOrderTwo != null) {
            System.out.println("InOrder Successor of Node : " + nodeTwo.data + " is : " + inOrderTwo.data);
        } else {
            System.out.println("InOrder Successor of Node : " + nodeTwo.data + " is : " + null);
        }

        BSTNode inOrderThree = binarySearchTree.inOrderSuccessor(rootNode, nodeThree);
        if (inOrderThree != null) {
            System.out.println("InOrder Successor of Node : " + nodeThree.data + " is : " + inOrderThree.data);
        } else {
            System.out.println("InOrder Successor of Node : " + nodeThree.data + " is : " + null);
        }
    }
}
