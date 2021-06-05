package trees.binarytreecomplete;

import java.util.LinkedList;
import java.util.Queue;

public class MirrorTreeConversion implements BinaryTreeUtil{

    public static void main(String[] args) {

        MirrorTreeConversion binaryTreeUtil = new MirrorTreeConversion();
        TreeNode rootNode = binaryTreeUtil.getNewNode(8);
        rootNode.left = binaryTreeUtil.getNewNode(3);
        rootNode.right = binaryTreeUtil.getNewNode(10);
        rootNode.left.left = binaryTreeUtil.getNewNode(1);
        rootNode.left.right = binaryTreeUtil.getNewNode(6);
        rootNode.left.right.left = binaryTreeUtil.getNewNode(4);
        rootNode.left.right.right = binaryTreeUtil.getNewNode(7);
        rootNode.right.right = binaryTreeUtil.getNewNode(14);
        rootNode.right.right.left = binaryTreeUtil.getNewNode(13);

        System.out.print("INORDER : ");
        binaryTreeUtil.inOrderTraversalRecursion(rootNode);
        System.out.println();

        TreeNode rootNodeOne = rootNode;
        TreeNode rootNodeTwo = rootNode;

        rootNodeOne = binaryTreeUtil.createMirrorTreeRecursive(rootNodeOne);

        System.out.print("INORDER : ");
        binaryTreeUtil.inOrderTraversalRecursion(rootNodeOne);
        System.out.println();

        rootNodeTwo = binaryTreeUtil.createMirrorTreeIterative(rootNodeTwo);

        System.out.print("INORDER : ");
        binaryTreeUtil.inOrderTraversalRecursion(rootNodeTwo);
        System.out.println();
    }

    public TreeNode createMirrorTreeRecursive (TreeNode rootNode) {

        if (rootNode == null) {
            return null;
        }

        TreeNode tempNode = rootNode.left;
        rootNode.left = rootNode.right;
        rootNode.right = tempNode;

        createMirrorTreeRecursive(rootNode.left);
        createMirrorTreeRecursive(rootNode.right);

        return rootNode;
    }

    public TreeNode createMirrorTreeIterative (TreeNode rootNode) {

        if (rootNode == null) {
            return rootNode;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer (rootNode);

        while (!queue.isEmpty()) {

            TreeNode currentNode = queue.poll();

            TreeNode tempNode = currentNode.left;
            currentNode.left = currentNode.right;
            currentNode.right = tempNode;

            if (currentNode.left != null) {
                queue.offer(currentNode.left);
            }

            if (currentNode.right != null) {
                queue.offer(currentNode.right);
            }
        }
        return rootNode;
    }
}
