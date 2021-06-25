package trees.binarytreecomplete;

import trees.binarytreecomplete.interfaces.BinaryTreeUtil;

import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.TreeMap;

public class BottomViewOfBinaryTree implements BinaryTreeUtil {

    public static void main(String[] args) {

        BottomViewOfBinaryTree binaryTreeUtil = new BottomViewOfBinaryTree();

        TreeNode rootNode = binaryTreeUtil.getNewNode(20);
        rootNode.left = binaryTreeUtil.getNewNode(8);
        rootNode.right = binaryTreeUtil.getNewNode(22);
        rootNode.left.left = binaryTreeUtil.getNewNode(5);
        rootNode.left.right = binaryTreeUtil.getNewNode(3);
        rootNode.right.left = binaryTreeUtil.getNewNode(4);
        rootNode.right.right = binaryTreeUtil.getNewNode(25);
        rootNode.left.right.left = binaryTreeUtil.getNewNode(10);
        rootNode.left.right.right = binaryTreeUtil.getNewNode(14);

        printBottomViewOfBinaryTree(rootNode);
    }

    public static void printBottomViewOfBinaryTree (TreeNode rootNode) {

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
        Map<Integer, TreeNode> bottomViewMap = new TreeMap<>();

        queue.offer(new QueueNode(rootNode, 0));

        while (!queue.isEmpty()) {

            QueueNode currentNode = queue.poll();

            bottomViewMap.put(currentNode.horizontalDistance, currentNode.node);

            if (currentNode.node.left != null) {
                queue.offer(new QueueNode(currentNode.node.left, currentNode.horizontalDistance - 1));
            }

            if (currentNode.node.right != null) {
                queue.offer(new QueueNode(currentNode.node.right, currentNode.horizontalDistance + 1));
            }
        }
        System.out.println("Bottom View : ");
        for (Integer horizontalDifference : bottomViewMap.keySet()) {
            System.out.print(bottomViewMap.get(horizontalDifference).data + " ");
        }

    }

}
