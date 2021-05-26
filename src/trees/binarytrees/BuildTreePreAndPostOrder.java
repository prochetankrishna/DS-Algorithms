package trees.binarytrees;

import trees.binarytrees.BinaryTree.TreeNode;

public class BuildTreePreAndPostOrder {

    public static int preOrderIndex = 0;

    public static void main(String[] args) {

        int[] preOrder = {1, 2, 4, 8, 9, 5, 3, 6, 7};
        int[] postOrder = {8, 9, 4, 5, 2, 6, 7, 3, 1};

        TreeNode builtTree = buildTree(preOrder, postOrder, 0, postOrder.length - 1);
        InOrderTraversal.inOrderTraversalRecursive(builtTree);

    }

    public static TreeNode buildTree (int[] preOrder, int[] postOrder, int postStart, int postEnd) {

        if (preOrderIndex >= preOrder.length  || postStart > postEnd) {
            return null;
        }

        TreeNode node = new TreeNode (preOrder[preOrderIndex++]);

        if (postStart == postEnd || preOrderIndex >= preOrder.length) {
            return node;
        }

        int i;
        for (i = postStart; i <= postEnd; i++) {
            if (postOrder[i] == preOrder[preOrderIndex]) {
                break;
            }
        }

        if (i <= postEnd) {
            node.left = buildTree(preOrder, postOrder, postStart, i);
            node.right = buildTree(preOrder, postOrder, i + 1, postEnd);
        }
        return node;
    }
}
