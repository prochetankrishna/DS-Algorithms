package trees.binarytrees;

import trees.binarytrees.BinaryTree.TreeNode;

import java.util.HashMap;

public class BuildTreeFromPreAndInOrder {

    public static int preOrderIndexIterative = 0;
    public static int preOrderIndexRecursive = 0;

    public static void main(String[] args) {

        int[] preOrder = {1, 2, 4, 5, 3, 6};
        int[] inOrder = {4, 2, 5, 1, 3, 6};

        TreeNode builtTree = buildTree(preOrder, inOrder, 0, inOrder.length - 1);
        PostOrderTraversal.postOrderTraversal(builtTree);
        System.out.println();
        TreeNode builtTreeUsingRecursion = buildTreeRecursive(preOrder, inOrder, 0, inOrder.length - 1);
        PostOrderTraversal.postOrderTraversal(builtTreeUsingRecursion);
    }

    public static TreeNode buildTree (int[] preOrder, int[] inOrder, int inStart, int inEnd) {

        if (inStart > inEnd) {
            return null;
        }

        TreeNode tempNode = new TreeNode(preOrder[preOrderIndexIterative++]);

        if (inStart == inEnd) {
            return tempNode;
        }

        int inOrderIndex = linearSearch(inOrder, inStart, inEnd, tempNode.data);

        tempNode.left = buildTree(preOrder, inOrder, inStart, inOrderIndex - 1);
        tempNode.right = buildTree(preOrder, inOrder, inOrderIndex + 1, inEnd);

        return tempNode;
    }

    public static int linearSearch (int[] arr, int low, int high, int key) {

        for (int i = low; i <= high; i++) {
            if (arr[i] == key) {
                return i;
            }
        }
        return -1;
    }

    public static TreeNode buildTreeRecursive (int[] preOrder, int[] inOrder, int inStart, int inEnd) {

        HashMap<Integer, Integer> inOrderTraversalMap = new HashMap<>();
        for (int i = 0; i < inOrder.length; i++) {
            inOrderTraversalMap.put (inOrder[i], i);
        }

        return buildTreeRecursiveUtil(preOrder, inStart, inEnd, inOrderTraversalMap);
    }

    private static TreeNode buildTreeRecursiveUtil(int[] preOrder, int inStart, int inEnd,
                                                   HashMap<Integer, Integer> inOrderTraversalMap) {

        if (inStart > inEnd) {
            return null;
        }

        TreeNode node = new TreeNode (preOrder[preOrderIndexRecursive++]);

        if (inStart == inEnd) {
            return node;
        }

        int inIndex = inOrderTraversalMap.get (node.data);

        node.left = buildTreeRecursiveUtil(preOrder, inStart, inIndex - 1, inOrderTraversalMap);
        node.right = buildTreeRecursiveUtil(preOrder, inIndex + 1, inEnd, inOrderTraversalMap);

        return node;
    }
}
