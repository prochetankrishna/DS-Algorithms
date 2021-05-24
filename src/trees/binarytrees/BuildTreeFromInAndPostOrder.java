package trees.binarytrees;

import trees.binarytrees.BinaryTree.TreeNode;

import java.util.HashMap;
import java.util.Map;

public class BuildTreeFromInAndPostOrder {

    static Map<Integer, Integer> map = new HashMap<>();
    static int postOrderIndex;

    public static void main(String[] args) {

        int in[] = { 4, 8, 2, 5, 1, 6, 3, 7 };
        int post[] = { 8, 4, 5, 2, 6, 7, 3, 1 };

        TreeNode binaryTree = buildTree(in, post);
        PreOrderTraversal.preOrderTraversalRecursive(binaryTree);
    }

    public static TreeNode buildTree (int[] inOrder, int[] postOrder) {

        int n = inOrder.length;
        for (int i = 0; i < n; i++) {
            map.put(inOrder[i], i);
        }

        postOrderIndex = n - 1;
        return buildTreeUtil(inOrder, postOrder, 0, n - 1);
    }

    public static TreeNode buildTreeUtil (int[] inOrder, int[] postOrder, int inStart, int inEnd) {

        if (inStart > inEnd) {
            return null;
        }

        TreeNode node = new TreeNode(postOrder[postOrderIndex--]);

        if (inStart == inEnd){
            return node;
        }

        int inOrderIndex = map.get (node.data);

        node.right = buildTreeUtil(inOrder, postOrder, inOrderIndex + 1, inEnd);
        node.left = buildTreeUtil(inOrder, postOrder, inStart, inOrderIndex - 1);

        return node;
    }
}
