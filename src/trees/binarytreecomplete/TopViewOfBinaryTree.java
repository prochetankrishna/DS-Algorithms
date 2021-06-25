package trees.binarytreecomplete;

import trees.binarytreecomplete.interfaces.BinaryTreeUtil;

import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.TreeMap;

public class TopViewOfBinaryTree implements BinaryTreeUtil {

    public static void main(String[] args) {

        TopViewOfBinaryTree binaryTreeUtil = new TopViewOfBinaryTree();
        TreeNode rootNode = binaryTreeUtil.getNewNode(4);
        rootNode.left = binaryTreeUtil.getNewNode(5);
        rootNode.right = binaryTreeUtil.getNewNode(2);
        rootNode.right.left = binaryTreeUtil.getNewNode(3);
        rootNode.right.right = binaryTreeUtil.getNewNode(1);
        rootNode.right.left.left = binaryTreeUtil.getNewNode(6);
        rootNode.right.left.right = binaryTreeUtil.getNewNode(7);

        binaryTreeUtil.printTopViewOfBinaryTree(rootNode);
    }

    public static void printTopViewOfBinaryTree (TreeNode rootNode) {

        if (rootNode == null) {
            return;
        }

        class QueueNode {
            TreeNode node;
            int horizontalDistance;

            public QueueNode(TreeNode node, int horizontalDistance) {
                this.node = node;
                this.horizontalDistance = horizontalDistance;
            }
        }

        Queue<QueueNode> queue = new LinkedList<>();
        Map<Integer, TreeNode> topViewMap = new TreeMap<>();

        queue.offer(new QueueNode(rootNode, 0));

        while (!queue.isEmpty()) {

            QueueNode currentNode = queue.poll();

            if (!topViewMap.containsKey(currentNode.horizontalDistance)) {
                topViewMap.put(currentNode.horizontalDistance, currentNode.node);
            }

            if (currentNode.node.left != null) {
                queue.offer(new QueueNode(currentNode.node.left, currentNode.horizontalDistance - 1));
            }

            if (currentNode.node.right != null) {
                queue.offer(new QueueNode(currentNode.node.right, currentNode.horizontalDistance + 1));
            }
        }
        System.out.println("Top View : ");
        for (Integer horizontalDifference : topViewMap.keySet()) {
            System.out.print(topViewMap.get(horizontalDifference).data + " ");
        }

    }

}
