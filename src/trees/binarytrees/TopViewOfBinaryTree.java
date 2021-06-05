package trees.binarytrees;

import trees.binarytrees.BinaryTree.TreeNode;

import java.sql.SQLOutput;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.TreeMap;

public class TopViewOfBinaryTree {

    public static void main(String[] args) {

        BinaryTree binaryTree = new BinaryTree();
        TreeNode rootNode = binaryTree.getHeadNode();

        rootNode = new TreeNode(4);
        rootNode.left = new TreeNode(5);
        rootNode.right = new TreeNode(2);

        rootNode.right.left = new TreeNode(3);
        rootNode.right.right = new TreeNode(1);

        rootNode.right.left.left = new TreeNode(6);
        rootNode.right.left.right = new TreeNode(7);

        printTopViewOfBinaryTree(rootNode);
    }

    public static void printTopViewOfBinaryTree (TreeNode rootNode) {

        if (rootNode == null) {
            return;
        }

        class QueueNode {
            TreeNode node;
            int horizontalDifference;

            public QueueNode(TreeNode node, int horizontalDifference) {
                this.node = node;
                this.horizontalDifference = horizontalDifference;
            }
        }

        Queue<QueueNode> queue = new LinkedList<>();
        Map<Integer, TreeNode> topViewMap = new TreeMap<>();

        queue.offer(new QueueNode(rootNode, 0));

        while (!queue.isEmpty()) {

            QueueNode currentNode = queue.poll();

            if (!topViewMap.containsKey(currentNode.horizontalDifference)) {
                topViewMap.put(currentNode.horizontalDifference, currentNode.node);
            }

            if (currentNode.node.left != null) {
                queue.offer(new QueueNode(currentNode.node.left, currentNode.horizontalDifference - 1));
            }

            if (currentNode.node.right != null) {
                queue.offer(new QueueNode(currentNode.node.right, currentNode.horizontalDifference +1));
            }
        }
        System.out.println("Top View : ");
        for (Integer horizontalDifference : topViewMap.keySet()) {
            System.out.print(topViewMap.get(horizontalDifference).data + " ");
        }

    }

}
