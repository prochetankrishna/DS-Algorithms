package trees.binarytrees;

import trees.binarytrees.BinaryTree.*;

import java.util.Stack;

public class PreOrderTraversal {

    public static void main(String[] args) {

        BinaryTree binaryTree = new BinaryTree();
        TreeNode rootNode = binaryTree.getHeadNode();

        rootNode = new TreeNode(1);
        rootNode.left = new TreeNode(2);
        rootNode.right = new TreeNode(3);

        rootNode.left.left = new TreeNode(4);
        rootNode.left.right = new TreeNode(5);

        rootNode.right.left = new TreeNode(6);
        rootNode.right.right = new TreeNode(7);

        preOrderTraversalRecursive(rootNode);
        System.out.println();
        preOrderIterative(rootNode);
        System.out.println();
        preOrderIterativeOptimized(rootNode);
        System.out.println();
    }

    public static void preOrderIterativeOptimized (TreeNode root) {

        if (root == null) {
            return;
        }

        Stack<TreeNode> stack = new Stack<>();
        TreeNode current = root;

        while (current != null || !stack.isEmpty()) {

            while (current != null) {
                System.out.print(current.data + " ");

                if (current.right != null) {
                    stack.push(current.right);
                }

                current = current.left;
            }

            if (!stack.isEmpty()) {
                current = stack.pop();
            }
        }
    }

    public static void preOrderIterative (TreeNode root) {

        if (root == null) {
            return;
        }

        Stack<TreeNode> stack = new Stack<>();
        TreeNode temp;

        stack.push(root);

        while (!stack.isEmpty()) {
            temp = stack.peek();
            System.out.print(temp.data + " ");
            stack.pop();

            if (temp.right != null) {
                stack.push(temp.right);
            }

            if (temp.left != null) {
                stack.push(temp.left);
            }
        }
    }

    public static void preOrderTraversalRecursive (TreeNode root) {

        if (root == null) {
            return;
        }

        System.out.print(root.data + " ");
        preOrderTraversalRecursive(root.left);
        preOrderTraversalRecursive(root.right);
    }
}
