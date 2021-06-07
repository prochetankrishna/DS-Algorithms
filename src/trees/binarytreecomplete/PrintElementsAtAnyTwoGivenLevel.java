package trees.binarytreecomplete;

import java.util.LinkedList;
import java.util.Queue;

public class PrintElementsAtAnyTwoGivenLevel implements BinaryTreeUtil{

    public static void main(String[] args) {

        PrintElementsAtAnyTwoGivenLevel binaryTreeUtil = new PrintElementsAtAnyTwoGivenLevel();
        TreeNode rootNode = binaryTreeUtil.getNewNode(2);
        rootNode.left = binaryTreeUtil.getNewNode(7);
        rootNode.right = binaryTreeUtil.getNewNode(5);
        rootNode.left.left = binaryTreeUtil.getNewNode(2);
        rootNode.left.right = binaryTreeUtil.getNewNode(6);
        rootNode.left.right.left = binaryTreeUtil.getNewNode(5);
        rootNode.left.right.right = binaryTreeUtil.getNewNode(11);
        rootNode.right.right = binaryTreeUtil.getNewNode(9);
        rootNode.right.right.left = binaryTreeUtil.getNewNode(4);
        binaryTreeUtil.printLevelOrderTraversalLineByLine(rootNode);
        System.out.println();
        binaryTreeUtil.printElementsAtGivenLevel(rootNode, 3, 6);
    }

    public void printElementsAtGivenLevel (TreeNode rootNode, int startLevel, int endLevel) {

        if (rootNode == null) {
            return;
        }

        if (startLevel < 1) {
            return;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(rootNode);
        int currentLevel = 1;
        while (!queue.isEmpty()) {

            if (currentLevel > endLevel) {
                break;
            }
            int queueSize = queue.size();

            for (int i = 1; i <= queueSize; i++) {

                TreeNode tempNode = queue.poll();
                if (currentLevel >= startLevel && currentLevel <= endLevel) {
                    System.out.print(tempNode.data + " ");
                }

                if (tempNode.left != null) {
                    queue.offer(tempNode.left);
                }

                if (tempNode.right != null) {
                    queue.offer(tempNode.right);
                }
            }
            currentLevel++;
        }
    }
}
