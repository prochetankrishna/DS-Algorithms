package trees.binarytrees;

import trees.binarytrees.BinaryTree.TreeNode;

import java.util.HashMap;
import java.util.Map;

public class BuildTreeFromInAndPostOrder {

    static Map<Integer, Integer> map = new HashMap<>();
    static int postOrderIndex;
    static int postOrderIndexRecursive;

    public static void main(String[] args) {

        int in[] = { 4, 8, 2, 5, 1, 6, 3, 7 };
        int post[] = { 8, 4, 5, 2, 6, 7, 3, 1 };

        TreeNode binaryTree = buildTree(in, post);
        PreOrderTraversal.preOrderTraversalRecursive(binaryTree);
        System.out.println();
        TreeNode binaryTreeRecursive = buildTreeRecursive(in, post, 0, in.length - 1);
        PreOrderTraversal.preOrderTraversalRecursive(binaryTreeRecursive);
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

    public static TreeNode buildTreeRecursive (int[] inOrder, int[] postOrder, int inStart, int inEnd) {

        HashMap <Integer, Integer> inOrderTraversalMap = new HashMap<>();

        for (int i = inStart; i <= inEnd; i++) {
            inOrderTraversalMap.put (inOrder[i], i);
        }

        postOrderIndexRecursive = inEnd;
        return buildTreeRecursiveUtil(postOrder, inStart, inEnd, inOrderTraversalMap);
    }

    private static TreeNode buildTreeRecursiveUtil(int[] postOrder, int inStart, int inEnd,
                                                   HashMap<Integer, Integer> inOrderTraversalMap) {

        if (inStart > inEnd) {
            return null;
        }

        TreeNode node = new TreeNode (postOrder[postOrderIndexRecursive--]);

        if (inStart == inEnd) {
            return node;
        }

        int inIndex = inOrderTraversalMap.get (node.data);

        node.right = buildTreeRecursiveUtil(postOrder, inIndex + 1, inEnd, inOrderTraversalMap);
        node.left = buildTreeRecursiveUtil(postOrder, inStart, inIndex - 1, inOrderTraversalMap);

        return node;
    }
}
