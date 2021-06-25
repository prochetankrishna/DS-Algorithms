package trees.binarytreecomplete;

import trees.binarytreecomplete.interfaces.BinaryTreeUtil;

import java.util.LinkedList;
import java.util.Queue;

public class LeftViewOfBinaryTree implements BinaryTreeUtil {

    int maxLevel;

    public static void main(String[] args) {

        LeftViewOfBinaryTree binaryTreeUtil = new LeftViewOfBinaryTree();
        TreeNode rootNode = binaryTreeUtil.getNewNode(2);
        rootNode.left = binaryTreeUtil.getNewNode(7);
        rootNode.right = binaryTreeUtil.getNewNode(5);
        rootNode.left.left = binaryTreeUtil.getNewNode(2);
        rootNode.left.right = binaryTreeUtil.getNewNode(6);
        rootNode.left.right.left = binaryTreeUtil.getNewNode(5);
        rootNode.left.right.right = binaryTreeUtil.getNewNode(11);
        rootNode.right.right = binaryTreeUtil.getNewNode(9);
        rootNode.right.right.left = binaryTreeUtil.getNewNode(4);

        System.out.print("Left View Of Tree : ");
        binaryTreeUtil.maxLevel = 0;
        binaryTreeUtil.printLeftViewOfTreeRecursive(rootNode, 0);
        System.out.println();
        System.out.print("Left View Of Tree : ");
        binaryTreeUtil.printLeftViewOfTreeIterative(rootNode);
    }

    public void printLeftViewOfTreeRecursive (TreeNode rootNode, int currentLevel) {

        if (rootNode == null) {
            return;
        }

        if (currentLevel >= maxLevel) {
            System.out.print(rootNode.data + " ");
            maxLevel++;
        }

        printLeftViewOfTreeRecursive(rootNode.left, currentLevel + 1);
        printLeftViewOfTreeRecursive(rootNode.right, currentLevel + 1);
    }

    public void printLeftViewOfTreeIterative (TreeNode rootNode) {

        if (rootNode == null) {
            return;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(rootNode);

        while (!queue.isEmpty()) {

            int queueSize = queue.size();
            for (int i = 1; i <= queueSize; i++) {

                TreeNode tempNode = queue.poll();

                if (i == 1) {
                    System.out.print(tempNode.data + " ");
                }

                if (tempNode.left != null) {
                    queue.offer(tempNode.left);
                }

                if (tempNode.right != null) {
                    queue.offer(tempNode.right);
                }
            }
        }
    }
}
