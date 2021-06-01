package trees.binarytrees;

public class InOrderSuccessor {

    class Node {

        int data;
        Node left, right;

        public Node() {
        }

        public Node(int data) {
            this.data = data;
            this.left = this.right = null;
        }
    }

    private Node temp = new Node();

    private Node findLeftMostNode (Node rootNode) {

        if (rootNode == null) {
            return null;
        }

        Node tempNode = rootNode;
        while (tempNode.left != null) {
            tempNode = tempNode.left;
        }
        return tempNode;
    }

    private Node findRightMostNode (Node rootNode) {

        if (rootNode == null) {
            return null;
        }

        Node tempNode = rootNode;
        while (tempNode.right != null) {
            tempNode = tempNode.right;
        }
        return tempNode;
    }

    private Node findInOrderSuccessor (Node rootNode, Node X) {

        if (rootNode == null) {
            return null;
        }

        if (X == null) {
            return null;
        }

        if (X.right != null) {
            return findLeftMostNode(X.right);
        }

        Node rightMostNodeOfTree = findRightMostNode(rootNode);

        if (rightMostNodeOfTree == X) { //You can compare data also
            return null;
        }

        return findInOrderSuccessorRecursive (rootNode, X);
    }

    private Node findInOrderSuccessorRecursive (Node rootNode, Node X) {

        if (rootNode == null) {
            return null;
        }

        Node tempLeft = findInOrderSuccessorRecursive(rootNode.left, X);
        Node tempRight = findInOrderSuccessorRecursive(rootNode.right, X);

        if (rootNode == X || (temp = findInOrderSuccessorRecursive(rootNode.left,X))!=null ||
                (temp = findInOrderSuccessorRecursive(rootNode.right,X))!=null)
        {
            if (temp!=null)
            {
                if (rootNode.left == temp)
                {
                    return null;
                }
            }
            return rootNode;
        }
        return null;
    }
}
