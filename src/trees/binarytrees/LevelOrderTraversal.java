package trees.binarytrees;

import trees.binarytrees.BinaryTree.*;

import java.util.LinkedList;
import java.util.Queue;

public class LevelOrderTraversal {

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

        System.out.println("Height Of Tree : " + heightOfTree(rootNode));
        printLevelOrderTraversal(rootNode);
        System.out.println();
        levelOrderTraversalQueue(rootNode);
        System.out.println();
        System.out.println("***************************************");
        printLevelOrderLevelByLevel(rootNode);
        System.out.println("***************************************");
        printLevelOrderLineByLineUsing2Queue(rootNode);
        System.out.println("***************************************");
    }

    public static int heightOfTree (TreeNode root) {

        if (root == null) {
            return 0;
        }

        int lHeight = heightOfTree(root.left);
        int rHeight = heightOfTree(root.right);

        return 1 + Math.max(lHeight, rHeight);
    }

    public static void printLevelOrderTraversal (TreeNode root) {

        int heightOfTree = heightOfTree(root);
        for (int i = 1; i <= heightOfTree; i++) {
            printCurrentLevel(root, i);
        }
    }

    public static void printCurrentLevel (TreeNode root, int level) {

        if (level == 1) {
            System.out.print(root.data + " ");
        } else if (level > 1) {

            printCurrentLevel(root.left, level - 1);
            printCurrentLevel(root.right, level - 1);
        }
    }

    public static void levelOrderTraversalQueue (TreeNode root) {

        if (root == null) {
            return;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            TreeNode tempNode = queue.poll();
            System.out.print(tempNode.data + " ");

            if (tempNode.left != null) {
                queue.offer(tempNode.left);
            }

            if (tempNode.right != null) {
                queue.offer(tempNode.right);
            }
        }
    }

    public static void printLevelOrderLevelByLevel (TreeNode root) {

        if (root == null) {
            return;
        }

        Queue <TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (true) {

            int nodeCount = queue.size();
            if (nodeCount == 0) {
                break;
            }

            while (nodeCount > 0) {

                TreeNode tempNode = queue.poll();
                System.out.print(tempNode.data + " ");

                if (tempNode.left != null) {
                    queue.offer(tempNode.left);
                }

                if (tempNode.right != null) {
                    queue.offer(tempNode.right);
                }
                nodeCount--;
            }
            System.out.println();
        }
    }

    public static void printLevelOrderLineByLineUsing2Queue (TreeNode root) {

        if (root == null) {
            return;
        }

        Queue<TreeNode> queueOne = new LinkedList<>();
        Queue<TreeNode> queueTwo = new LinkedList<>();

        queueOne.offer(root);

        while (!queueOne.isEmpty() || !queueTwo.isEmpty()) {

            while (!queueOne.isEmpty()) {

                if (queueOne.peek().left != null) {
                    queueTwo.offer(queueOne.peek().left);
                }

                if (queueOne.peek().right != null) {
                    queueTwo.offer(queueOne.peek().right);
                }

                System.out.print(queueOne.peek().data + " ");
                queueOne.remove();
            }
            System.out.println();

            while (!queueTwo.isEmpty()) {

                if (queueTwo.peek().left != null) {
                    queueOne.offer(queueTwo.peek().left);
                }

                if (queueTwo.peek().right != null) {
                    queueOne.offer(queueTwo.peek().right);
                }

                System.out.print(queueTwo.peek().data + " ");
                queueTwo.remove();
            }
            System.out.println();
        }
    }


}
