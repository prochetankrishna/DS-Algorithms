package trees.binarytrees;

import trees.binarytrees.BinaryTree.*;

import java.util.Stack;

public class PostOrderTraversal {

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

        postOrderTraversal(rootNode);
        System.out.println();
        postOrderIterative2Stacks(rootNode);
        System.out.println();
    }

    public static void postOrderIterative1Stacks (TreeNode root) {

        if (root == null) {
            return;
        }

        Stack<TreeNode> stack = new Stack<>();
        TreeNode tempNode = root;

        while (true) {

            while (tempNode != null) {

                if (tempNode.right != null) {
                    stack.push(tempNode.right);
                }
                stack.push(tempNode);
                tempNode = tempNode.left;
            }

            //TO BE CONTINUED
        }
    }

    public static void postOrderIterative2Stacks (TreeNode root) {

        if (root == null) {
            return;
        }

        Stack<TreeNode> s1 = new Stack<>();
        Stack<TreeNode> s2 = new Stack<>();

        s1.push(root);

        while (!s1.isEmpty()) {

            TreeNode temp = s1.pop();
            s2.push(temp);

            if (temp.left != null) {
                s1.push(temp.left);
            }

            if (temp.right != null) {
                s1.push(temp.right);
            }
        }

        while (!s2.isEmpty()) {
            TreeNode temp = s2.pop();
            System.out.print(temp.data + " ");
        }
    }
    public static void postOrderTraversal (TreeNode root) {

        if (root == null) {
            return;
        }

        postOrderTraversal(root.left);
        postOrderTraversal(root.right);
        System.out.print(root.data + " ");
    }
}
