package trees.binarytreecomplete;

import trees.binarytreecomplete.interfaces.BinaryTreeUtil;

public class BinaryTreeApp implements BinaryTreeUtil {

    public static void main(String[] args) {

        BinaryTreeApp binaryTreeApp = new BinaryTreeApp();
        TreeNode rootNode = binaryTreeApp.getNewNode(2);
        rootNode.left = binaryTreeApp.getNewNode(7);
        rootNode.right = binaryTreeApp.getNewNode(5);
        rootNode.left.left = binaryTreeApp.getNewNode(2);
        rootNode.left.right = binaryTreeApp.getNewNode(6);
        rootNode.left.right.left = binaryTreeApp.getNewNode(5);
        rootNode.left.right.right = binaryTreeApp.getNewNode(11);
        rootNode.right.right = binaryTreeApp.getNewNode(9);
        rootNode.right.right.left = binaryTreeApp.getNewNode(4);

        System.out.print("PREORDER RECURSION: ");
        binaryTreeApp.preOrderTraversalRecursion(rootNode);
        System.out.println();

        System.out.print("PREORDER ITERATIVE: ");
        binaryTreeApp.preOrderTraversalIterative(rootNode);
        System.out.println();

        System.out.print("INORDER RECURSIVE: ");
        binaryTreeApp.inOrderTraversalRecursion(rootNode);
        System.out.println();

        System.out.print("INORDER ITERATIVE: ");
        binaryTreeApp.inOrderTraversalIterative(rootNode);
        System.out.println();

        System.out.print("POSTORDER RECURSIVE: ");
        binaryTreeApp.postOrderTraversalRecursive(rootNode);
        System.out.println();

        System.out.print("POSTORDER ITERATIVE: ");
        binaryTreeApp.postOrderTraversalIterative(rootNode);
        System.out.println();

        System.out.println("Sum of all Nodes : " + binaryTreeApp.findSumOfAllNodes(rootNode));

        System.out.println("Difference BW Even and Odd Level : " +
                binaryTreeApp.findDifferenceAtEvenAndOddLevelRecursive(rootNode));
        System.out.println("Difference BW Even and Odd Level : " +
                binaryTreeApp.findDifferenceAtEvenAndOddLevelIterative(rootNode));

        System.out.println("Total Number of Nodes : " + binaryTreeApp.getTotalNumberOfNodes(rootNode));

        System.out.println("Total Number of Leaf Nodes : " + binaryTreeApp.getTotalNumberOfLeafNodes(rootNode));

        System.out.println("Height of Tree : " + binaryTreeApp.getHeightOfTree(rootNode));
        System.out.println("Height of Tree : " + binaryTreeApp.getHeightOfTreeIterative(rootNode));

        System.out.println("Print Tree At Level : 4");
        binaryTreeApp.printElementsAtGivenLevel(rootNode, 4);

        System.out.print("Level Order Traversal Recursive : ");
        binaryTreeApp.printLevelOrderTraversalRecursive(rootNode);
        System.out.println();

        System.out.print("Level Order Traversal Iterative : ");
        binaryTreeApp.printLevelOrderTraversalIterative(rootNode);
        System.out.println();

        System.out.print("Reverse Level Order Traversal Recursion : ");
        binaryTreeApp.reverseLevelOrderTraversalRecursive(rootNode);
        System.out.println();

        System.out.print("Reverse Level Order Traversal Iterative : ");
        binaryTreeApp.reverseLevelOrderTraversalIterative(rootNode);
        System.out.println();

        System.out.println("Level Order Traversal Line by Line : ");
        binaryTreeApp.printLevelOrderTraversalLineByLine(rootNode);
        System.out.println();
    }
}
