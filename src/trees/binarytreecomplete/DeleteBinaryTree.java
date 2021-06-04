package trees.binarytreecomplete;

import java.util.LinkedList;
import java.util.Queue;

public class DeleteBinaryTree extends BinaryTreeUtil{

    public static void main(String[] args) {

        DeleteBinaryTree binaryTreeUtil = new DeleteBinaryTree();
        TreeNode rootNode = binaryTreeUtil.getNewNode(8);
        rootNode.left = binaryTreeUtil.getNewNode(3);
        rootNode.right = binaryTreeUtil.getNewNode(10);
        rootNode.left.left = binaryTreeUtil.getNewNode(1);
        rootNode.left.right = binaryTreeUtil.getNewNode(6);
        rootNode.left.right.left = binaryTreeUtil.getNewNode(4);
        rootNode.left.right.right = binaryTreeUtil.getNewNode(7);
        rootNode.right.right = binaryTreeUtil.getNewNode(14);
        rootNode.right.right.left = binaryTreeUtil.getNewNode(13);

        binaryTreeUtil.deleteBinaryTreeIterative(rootNode);
    }

    public TreeNode deleteBinaryTreeRecursive (TreeNode rootNode) {

        if (rootNode == null) {
            return null;
        }

        rootNode.left = deleteBinaryTreeRecursive(rootNode.left);
        rootNode.right = deleteBinaryTreeRecursive(rootNode.right);

        System.out.println("Deleting Node : [" + rootNode.data + "]");
        rootNode = null;
        return null;
    }

    public TreeNode deleteBinaryTreeIterative (TreeNode rootNode) {

        if (rootNode == null) {
            return null;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(rootNode);

        while (!queue.isEmpty()) {

            TreeNode currentNode = queue.poll();

            if (currentNode.left != null) {
                queue.offer(currentNode.left);
            }

            if (currentNode.right != null) {
                queue.offer(currentNode.right);
            }

            System.out.println("Deleting Node : [" + currentNode.data + "]");
            currentNode = null;
        }
        rootNode = null;
        return null;
    }
}
