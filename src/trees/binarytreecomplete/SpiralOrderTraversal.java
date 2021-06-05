package trees.binarytreecomplete;

import trees.binarytrees.BinaryTree;

import java.util.Stack;

public class SpiralOrderTraversal implements BinaryTreeUtil{

    public static void main(String[] args) {
        SpiralOrderTraversal binaryTreeUtil = new SpiralOrderTraversal();
        TreeNode rootNode = binaryTreeUtil.getNewNode(2);
        rootNode.left = binaryTreeUtil.getNewNode(7);
        rootNode.right = binaryTreeUtil.getNewNode(5);

        rootNode.left.left = binaryTreeUtil.getNewNode(12);
        rootNode.left.right = binaryTreeUtil.getNewNode(6);
        rootNode.left.right.left = binaryTreeUtil.getNewNode(5);
        rootNode.left.right.right = binaryTreeUtil.getNewNode(11);

        rootNode.right.right = binaryTreeUtil.getNewNode(9);
        rootNode.right.right.left = binaryTreeUtil.getNewNode(4);

        binaryTreeUtil.printSpiralOrderOfBinaryTree(rootNode);
    }
    
    public void printSpiralOrderOfBinaryTree (TreeNode rootNode) {
        
        if (rootNode == null) {
            return;
        }

        Stack<TreeNode> leftToRightStack = new Stack<>();
        Stack<TreeNode> rightToLeftStack = new Stack<>();

        leftToRightStack.push(rootNode);

        while (!leftToRightStack.isEmpty() || !rightToLeftStack.isEmpty()) {

            while (!leftToRightStack.isEmpty()) {

                TreeNode temp = leftToRightStack.pop();
                System.out.print(temp.data + " ");

                if (temp.right != null) {
                    rightToLeftStack.push(temp.right);
                }

                if (temp.left != null) {
                    rightToLeftStack.push(temp.left);
                }
            }

            while (!rightToLeftStack.isEmpty()) {

                TreeNode temp = rightToLeftStack.pop();
                System.out.print(temp.data + " ");

                if (temp.left != null) {
                    leftToRightStack.push(temp.left);
                }

                if (temp.right != null) {
                    leftToRightStack.push(temp.right);
                }
            }
        }
    }
}
