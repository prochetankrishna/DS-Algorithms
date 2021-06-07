package trees.binarytreecomplete;

import java.util.LinkedList;
import java.util.Queue;

public class MaximumWidth implements BinaryTreeUtil{

    public static void main(String[] args) {
        MaximumWidth binaryTreeUtil = new MaximumWidth();
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
        System.out.println("Maximum Width : " + binaryTreeUtil.maximumWidthOfBinaryTree(rootNode));
    }

    public int maximumWidthOfBinaryTree (TreeNode rootNode) {

        if (rootNode == null) {
            return 0;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(rootNode);

        int maxWidth = 0;
        while (!queue.isEmpty()) {

            int queueSize = queue.size();
            if (queueSize > maxWidth) {
                maxWidth = queueSize;
            }

            for (int i = 1; i <= queueSize; i++) {

                TreeNode tempNode = queue.poll();

                if(tempNode.left != null) {
                    queue.offer(tempNode.left);
                }

                if(tempNode.right != null) {
                    queue.offer(tempNode.right);
                }
            }
        }
        return maxWidth;
    }
}
