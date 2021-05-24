package trees.binarytrees;

import com.sun.source.tree.Tree;
import trees.binarytrees.BinaryTree.TreeNode;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class ZigZagTraversal {

    static boolean isLeftToRight = false;

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

        System.out.println("Height of Tree : " + heightOfTree(rootNode));
        printZigZaGLevelOrderRecursion(rootNode);
        System.out.println();
        printZigZagOrderUsingQueueAndStack(rootNode);
        System.out.println();
        printZigZagOrderUsing2Stack(rootNode);
    }

    public static void printZigZagOrderUsing2Stack (TreeNode rootNode) {

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

    public static void printZigZagOrderUsingQueueAndStack (TreeNode rootNode) {

        if (rootNode == null) {
            return;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(rootNode);

        Stack<TreeNode> stack = new Stack<>();
        boolean isLeftToRight = false;

        while (!queue.isEmpty()) {

            int nodeCount = queue.size();

            while (nodeCount > 0) {

                TreeNode temp = queue.poll();

                if (isLeftToRight) {
                    System.out.print(temp.data + " ");
                } else {
                    stack.push(temp);
                }

                if (temp.left != null) {
                    queue.offer(temp.left);
                }

                if (temp.right != null) {
                    queue.offer(temp.right);
                }
                nodeCount--;
            }

            if (!isLeftToRight) {
                while (!stack.isEmpty()) {
                    TreeNode node = stack.pop();
                    System.out.print(node.data + " ");
                }
            }
            isLeftToRight = !isLeftToRight;
        }
    }

    public static void printCurrentLevel (TreeNode node, int level) {

        if (node == null) {
            return;
        }

        if (level == 1) {
            System.out.print (node.data + " ");
        } else if (level > 1) {

            if (isLeftToRight) {
                printCurrentLevel(node.left, level - 1);
                printCurrentLevel(node.right, level - 1);
            } else {
                printCurrentLevel(node.right, level - 1);
                printCurrentLevel(node.left, level - 1);
            }
        }
    }
    public static void printZigZaGLevelOrderRecursion (TreeNode root) {

        if (root == null) {
            return;
        }

        int heightOfTree = heightOfTree(root);
        for (int i = 1; i <= heightOfTree; i++) {
            printCurrentLevel(root, i);
            isLeftToRight = !isLeftToRight;
        }
    }
    public static int heightOfTree (TreeNode root) {

        if (root == null) {
            return 0;
        }

        int lHeight = heightOfTree (root.left);
        int rHeight = heightOfTree (root.right);

        return 1 + Math.max (lHeight, rHeight);
    }
}
