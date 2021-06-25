package trees.binarytreecomplete.construction;

import trees.binarytreecomplete.TreeNode;
import trees.binarytreecomplete.interfaces.BinaryTreeUtil;

import java.util.HashMap;
import java.util.Map;

public class ConstructTreeFromInOrderAndPreOrder implements BinaryTreeUtil {

    static int preOrderIndex = 0;
    public static void main(String[] args) {

        ConstructTreeFromInOrderAndPreOrder constructTreeFromInOrderAndPreOrder = new ConstructTreeFromInOrderAndPreOrder();
        int[] preOrder = {1, 2, 4, 5, 3, 6};
        int[] inOrder = {4, 2, 5, 1, 3, 6};

        TreeNode rootNode = constructTreeFromInOrderAndPreOrder.buildTreeFromInOrderAndPreOrder(preOrder, inOrder);
        System.out.println("Level Order Traversal : ");
        constructTreeFromInOrderAndPreOrder.printLevelOrderTraversalLineByLine(rootNode);

    }

    public TreeNode buildTreeFromInOrderAndPreOrder(int[] preOrder, int[] inOrder) {

        Map<Integer, Integer> inOrderIndexMap = new HashMap<>();
        for (int i = 0 ; i < inOrder.length; i++) {
            inOrderIndexMap.put(inOrder[i], i);
        }
        return buildTreeFromInOrderAndPreOrderUtil(preOrder, inOrder, 0, inOrder.length - 1, inOrderIndexMap);
    }
    public TreeNode buildTreeFromInOrderAndPreOrderUtil(int[] preOrder, int[] inOrder, int inStart, int inEnd,
                                                        Map<Integer, Integer> inOrderIndexMap) {

        if (inStart > inEnd) {
            return null;
        }

        TreeNode tempNode = new TreeNode(preOrder[preOrderIndex++]);

        if (inStart == inEnd) {
            return tempNode;
        }

        int inOrderIndex = inOrderIndexMap.get(tempNode.data);

        tempNode.left = buildTreeFromInOrderAndPreOrderUtil(preOrder, inOrder, inStart, inOrderIndex - 1, inOrderIndexMap);
        tempNode.right = buildTreeFromInOrderAndPreOrderUtil(preOrder, inOrder, inOrderIndex + 1, inEnd, inOrderIndexMap);
        return tempNode;
    }
}
