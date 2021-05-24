package trees.binarytrees;

import trees.binarytrees.BinaryTree.*;

import java.util.LinkedList;
import java.util.Queue;

public class RightViewOfBinaryTree {

    static int maxLevel = 0;

    public static void main(String[] args) {

        BinaryTree binaryTree = new BinaryTree();
        TreeNode rootNode = binaryTree.getHeadNode();

        rootNode = new BinaryTree.TreeNode(4);
        rootNode.left = new BinaryTree.TreeNode(5);
        rootNode.right = new BinaryTree.TreeNode(2);

        rootNode.right.left = new BinaryTree.TreeNode(3);
        rootNode.right.right = new BinaryTree.TreeNode(1);

        rootNode.right.left.left = new BinaryTree.TreeNode(6);
        rootNode.right.left.right = new BinaryTree.TreeNode(7);

        printRightView(rootNode, 1);
        System.out.println();
        printRightViewUsingQueue(rootNode);
        System.out.println();
    }

    public static void printRightView (TreeNode node, int level) {

        if (node == null) {
            return;
        }

        if (level > maxLevel) {
            System.out.print(node.data + " ");
            maxLevel = level;
        }

        printRightView(node.right, level + 1);
        printRightView(node.left, level + 1);
    }

    public static void printRightViewUsingQueue (TreeNode node) {

        if (node == null) {
            return;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(node);

        while (!queue.isEmpty()) {

            int nodeCount = queue.size();

            for (int i = 1; i <= nodeCount; i++) {

                TreeNode tempNode = queue.poll();

                if (i == 1) {
                    System.out.print(tempNode.data + " ");
                }

                if (tempNode.right != null) {
                    queue.offer(tempNode.right);
                }

                if (tempNode.left != null) {
                    queue.offer(tempNode.left);
                }
            }
        }
    }
}
