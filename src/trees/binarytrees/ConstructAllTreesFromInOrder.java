package trees.binarytrees;

import java.util.ArrayList;
import java.util.List;

public class ConstructAllTreesFromInOrder {

    Node rootNode;

    public void printPreOrderTraversal (Node rootNode) {

        if (rootNode == null) {
            return;
        }

        System.out.print(rootNode.data + " ");
        printPreOrderTraversal(rootNode.left);
        printPreOrderTraversal(rootNode.right);
    }

    public List<Node> getTrees (int[] arr, int start, int end) {

        List<Node> binaryTrees = new ArrayList<>();

        if (start > end) {
            binaryTrees.add(null);
            return binaryTrees;
        }

        for (int i = start; i <= end; i++) {

            List<Node> leftSubtrees = getTrees (arr, start, i - 1);
            List<Node> rightSubtrees = getTrees (arr, i + 1, end);

            for (int j = 0; j < leftSubtrees.size(); j++) {
                for (int k = 0; k < rightSubtrees.size(); k++) {

                    Node tempNode = new Node (arr[i]);
                    tempNode.left = leftSubtrees.get(j);
                    tempNode.right = rightSubtrees.get(k);
                    binaryTrees.add(tempNode);
                }
            }
        }
        return binaryTrees;
    }

    public static void main(String[] args) {

        ConstructAllTreesFromInOrder helperObject = new ConstructAllTreesFromInOrder();
        int[] inOrder = {4, 5, 7};
        List<Node> binaryTrees = helperObject.getTrees(inOrder, 0, inOrder.length - 1);

        for (Node eachNode : binaryTrees) {
            helperObject.printPreOrderTraversal(eachNode);
            System.out.println();
        }
    }
}

class Node {

    int data;
    Node left, right;

    public Node (int data) {
        this.data = data;
        this.left = this.right = null;
    }
}

