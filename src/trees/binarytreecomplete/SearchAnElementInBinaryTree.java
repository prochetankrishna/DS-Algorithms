package trees.binarytreecomplete;

import java.util.LinkedList;
import java.util.Queue;

public class SearchAnElementInBinaryTree implements BinaryTreeUtil{

    public static void main(String[] args) {
        SearchAnElementInBinaryTree binaryTreeUtil = new SearchAnElementInBinaryTree();
        TreeNode rootNode = binaryTreeUtil.getNewNode(2);
        rootNode.left = binaryTreeUtil.getNewNode(7);
        rootNode.right = binaryTreeUtil.getNewNode(5);

        rootNode.left.left = binaryTreeUtil.getNewNode(12);
        rootNode.left.right = binaryTreeUtil.getNewNode(6);
        rootNode.left.right.left = binaryTreeUtil.getNewNode(5);
        rootNode.left.right.right = binaryTreeUtil.getNewNode(11);

        rootNode.right.right = binaryTreeUtil.getNewNode(9);
        rootNode.right.right.left = binaryTreeUtil.getNewNode(4);

        TreeNode searchedNodeRecursion = binaryTreeUtil.searchAnElementInBinaryTreeRecursive(rootNode, 5);
        if (searchedNodeRecursion == null) {
            System.out.println("Not Found !!");
        } else {
            System.out.println("Found : " + searchedNodeRecursion.data);
        }

        TreeNode searchedNodeIteration = binaryTreeUtil.searchAnElementInBinaryTreeIterative(rootNode, 5);
        if (searchedNodeIteration == null) {
            System.out.println("Not Found !!");
        } else {
            System.out.println("Found : " + searchedNodeIteration.data);
        }
    }

    public TreeNode searchAnElementInBinaryTreeRecursive (TreeNode rootNode, int key) {

        if (rootNode == null) {
            return null;
        }

        if (rootNode.data == key) {
            return rootNode;
        }

        TreeNode searchedNodeInLeft = searchAnElementInBinaryTreeRecursive(rootNode.left, key);
        return searchedNodeInLeft != null ? searchedNodeInLeft : searchAnElementInBinaryTreeRecursive(rootNode.right, key);
    }

    public TreeNode searchAnElementInBinaryTreeIterative (TreeNode rootNode, int key) {

        if (rootNode == null) {
            return null;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(rootNode);

        while (!queue.isEmpty()) {

            TreeNode tempNode = queue.poll();
            if (tempNode.data == key) {
                return tempNode;
            }

            if (tempNode.left != null) {
                queue.offer(tempNode.left);
            }

            if (tempNode.right != null) {
                queue.offer(tempNode.right);
            }
        }
        return null;
    }
}
