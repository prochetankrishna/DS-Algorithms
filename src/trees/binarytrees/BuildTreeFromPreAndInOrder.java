package trees.binarytrees;

import trees.binarytrees.BinaryTree.TreeNode;

public class BuildTreeFromPreAndInOrder {

    public static int preOrderIndex = 0;

    public static void main(String[] args) {

        int[] preOrder = {1, 2, 4, 5, 3, 6};
        int[] inOrder = {4, 2, 5, 1, 3, 6};

        TreeNode builtTree = buildTree(preOrder, inOrder, 0, inOrder.length - 1);
        PostOrderTraversal.postOrderTraversal(builtTree);
    }

    public static TreeNode buildTree (int[] preOrder, int[] inOrder, int inStart, int inEnd) {

        if (inStart > inEnd) {
            return null;
        }

        TreeNode tempNode = new TreeNode(preOrder[preOrderIndex++]);

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
}
