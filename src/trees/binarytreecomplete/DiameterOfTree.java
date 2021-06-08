package trees.binarytreecomplete;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class DiameterOfTree implements BinaryTreeUtil{

    int diameter;
    public static void main(String[] args) {
        DiameterOfTree binaryTreeUtil = new DiameterOfTree();
        TreeNode rootNode = binaryTreeUtil.getNewNode(2);
        rootNode.left = binaryTreeUtil.getNewNode(7);
        rootNode.right = binaryTreeUtil.getNewNode(5);
        rootNode.left.left = binaryTreeUtil.getNewNode(2);
        rootNode.left.right = binaryTreeUtil.getNewNode(6);
        rootNode.left.right.left = binaryTreeUtil.getNewNode(5);
        rootNode.left.right.right = binaryTreeUtil.getNewNode(11);
        rootNode.right.right = binaryTreeUtil.getNewNode(9);
        rootNode.right.right.left = binaryTreeUtil.getNewNode(4);
        binaryTreeUtil.printLevelOrderTraversalLineByLine(rootNode);
        System.out.println();

        System.out.println("Diameter : " + binaryTreeUtil.diameterOfBinaryTree(rootNode));
    }

    public int diameterOfBinaryTree (TreeNode rootNode) {

        if (rootNode == null) {
            return 0;
        }

        int leftHeight = this.getHeightOfTree(rootNode.left);
        int rightHeight = this.getHeightOfTree(rootNode.right);


        int leftDiameter = diameterOfBinaryTree(rootNode.left);
        int rightDiameter = diameterOfBinaryTree(rootNode.right);

        return Math.max(leftHeight + rightHeight + 1, Math.max(leftDiameter, rightDiameter));
    }

    @Override
    public int getHeightOfTree (TreeNode rootNode) {

        if (rootNode == null) {
            return 0;
        }

        int lHeight = getHeightOfTree(rootNode.left);
        int rHeight = getHeightOfTree(rootNode.right);

        return 1 + Math.max (lHeight, rHeight);
    }
}
