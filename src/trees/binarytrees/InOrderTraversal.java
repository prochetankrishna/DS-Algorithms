package trees.binarytrees;

import java.util.Stack;
import trees.binarytrees.BinaryTree.*;

public class InOrderTraversal {

    public static void main(String[] args) {

        BinaryTree binaryTree = new BinaryTree();
        TreeNode rootNode = binaryTree.getHeadNode();

        rootNode = new BinaryTree.TreeNode(1);
        rootNode.left = new BinaryTree.TreeNode(2);
        rootNode.right = new BinaryTree.TreeNode(3);

        rootNode.left.left = new BinaryTree.TreeNode(4);
        rootNode.left.right = new BinaryTree.TreeNode(5);

        rootNode.right.left = new BinaryTree.TreeNode(6);
        rootNode.right.right = new BinaryTree.TreeNode(7);

        inOrderTraversalRecursive(rootNode);
        System.out.println();
        inOrderIterative(rootNode);
        System.out.println();
        inOrderIterative2(rootNode);
        System.out.println();
    }

    public static void inOrderIterative2 (TreeNode root) {

        if (root == null) return;

        Stack <TreeNode> stack = new Stack<>();
        TreeNode current = root;

        while (current != null || !stack.isEmpty()) {

            if (current != null) {
                stack.push(current);
                current = current.left;
            } else {
                current = stack.pop();
                System.out.print(current.data + " ");
                current = current.right;
            }
        }
    }


    public static void inOrderIterative (TreeNode root) {

        if (root == null) {
            return;
        }

        Stack<TreeNode> stack = new Stack<>();
        TreeNode current = root;

        while (current != null || !stack.isEmpty()) {

            while (current != null) {
                stack.push (current);
                current = current.left;
            }

            current = stack.pop();
            System.out.print(current.data + " ");
            current = current.right;
        }
    }

    public static void inOrderTraversalRecursive (TreeNode root) {

        if (root == null) {
            return;
        }

        inOrderTraversalRecursive(root.left);
        System.out.print(root.data + " ");
        inOrderTraversalRecursive(root.right);
    }
}
