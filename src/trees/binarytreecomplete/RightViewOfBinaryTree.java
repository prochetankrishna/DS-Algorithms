package trees.binarytreecomplete;

import java.util.LinkedList;
import java.util.Queue;

public class RightViewOfBinaryTree implements BinaryTreeUtil{

    int maxLevel;

    public static void main(String[] args) {

        RightViewOfBinaryTree binaryTreeUtil = new RightViewOfBinaryTree();
        TreeNode rootNode = binaryTreeUtil.getNewNode(2);
        rootNode.left = binaryTreeUtil.getNewNode(7);
        rootNode.right = binaryTreeUtil.getNewNode(5);
        rootNode.left.left = binaryTreeUtil.getNewNode(2);
        rootNode.left.right = binaryTreeUtil.getNewNode(6);
        rootNode.left.right.left = binaryTreeUtil.getNewNode(5);
        rootNode.left.right.right = binaryTreeUtil.getNewNode(11);
        rootNode.right.right = binaryTreeUtil.getNewNode(9);
        rootNode.right.right.left = binaryTreeUtil.getNewNode(4);


        System.out.print("Right View Of Tree : ");
        binaryTreeUtil.maxLevel = 0;
        binaryTreeUtil.printRightViewOfTreeRecursive(rootNode, 0);
        System.out.println();
        System.out.print("Right View Of Tree : ");
        binaryTreeUtil.printRightViewOfTreeIterative(rootNode);
    }

    public void printRightViewOfTreeRecursive (TreeNode rootNode, int currentLevel) {

        if (rootNode == null) {
            return;
        }

        if (currentLevel >= maxLevel) {
            System.out.print(rootNode.data + " ");
            maxLevel++;
        }

        printRightViewOfTreeRecursive(rootNode.right, currentLevel + 1);
        printRightViewOfTreeRecursive(rootNode.left, currentLevel + 1);
    }

    public void printRightViewOfTreeIterative (TreeNode rootNode) {

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
