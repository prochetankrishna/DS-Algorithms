package trees.binarytrees;

import trees.binarytrees.BinaryTree.TreeNode;

import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.TreeMap;

public class BottomViewOfBinaryTree {

    public static void main(String[] args) {

        BinaryTree binaryTree = new BinaryTree();
        TreeNode rootNode = binaryTree.getHeadNode();

        rootNode = new TreeNode(20);
        rootNode.left = new TreeNode(8);
        rootNode.right = new TreeNode(22);

        rootNode.left.left = new TreeNode(5);
        rootNode.left.right = new TreeNode(3);

        rootNode.right.left = new TreeNode(4);
        rootNode.right.right = new TreeNode(25);

        rootNode.left.right.left = new TreeNode(10);
        rootNode.left.right.right = new TreeNode(14);
        printBottomViewOfBinaryTree(rootNode);
    }

    public static void printBottomViewOfBinaryTree (TreeNode rootNode) {

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
        Map<Integer, TreeNode> bottomViewMap = new TreeMap<>();

        queue.offer(new QueueNode(rootNode, 0));

        while (!queue.isEmpty()) {

            QueueNode currentNode = queue.poll();

            bottomViewMap.put(currentNode.horizontalDifference, currentNode.node);

            if (currentNode.node.left != null) {
                queue.offer(new QueueNode(currentNode.node.left, currentNode.horizontalDifference - 1));
            }

            if (currentNode.node.right != null) {
                queue.offer(new QueueNode(currentNode.node.right, currentNode.horizontalDifference +1));
            }
        }
        System.out.println("Bottom View : ");
        for (Integer horizontalDifference : bottomViewMap.keySet()) {
            System.out.print(bottomViewMap.get(horizontalDifference).data + " ");
        }

    }

}
