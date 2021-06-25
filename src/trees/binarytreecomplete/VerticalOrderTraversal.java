package trees.binarytreecomplete;


import trees.binarytreecomplete.interfaces.BinaryTreeUtil;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

class Value {
    int min, max;
}

public class VerticalOrderTraversal implements BinaryTreeUtil {

    public static void main(String[] args) {

        VerticalOrderTraversal binaryTreeUtil = new VerticalOrderTraversal();
        TreeNode rootNode = binaryTreeUtil.getNewNode(1);
        rootNode.left = binaryTreeUtil.getNewNode(2);
        rootNode.right = binaryTreeUtil.getNewNode(3);
        rootNode.left.left = binaryTreeUtil.getNewNode(4);
        rootNode.left.right = binaryTreeUtil.getNewNode(5);
        rootNode.right.left = binaryTreeUtil.getNewNode(6);
        rootNode.right.right = binaryTreeUtil.getNewNode(7);
        rootNode.right.left.right = binaryTreeUtil.getNewNode(8);
        rootNode.right.right.right = binaryTreeUtil.getNewNode(9);

        binaryTreeUtil.printVerticalOrder(rootNode);
        System.out.println();
        binaryTreeUtil.printVerticalOrderUsingMap(rootNode);
    }

    public void printVerticalOrderUsingMap (TreeNode rootNode) {

        if (rootNode == null) {
            return;
        }

        int horizontalDistance = 0;
        Map<Integer, List<Integer>> map = new TreeMap<>();
        performVerticalOrderOperation(rootNode, 0, map);

        System.out.println("Vertical Order : ");
        for (Integer horizontalDistanceFromMap : map.keySet()) {
            System.out.println(map.get(horizontalDistanceFromMap));
        }

    }

    public void performVerticalOrderOperation (TreeNode rootNode, int horizontalDistance, Map<Integer, List<Integer>> map) {

        if (rootNode == null) {
            return;
        }

        if (map.get(horizontalDistance) == null) {
            List<Integer> nodeList = new LinkedList<>();
            nodeList.add(rootNode.data);
            map.put (horizontalDistance, nodeList);
        } else {
            map.get (horizontalDistance).add(rootNode.data);
        }

        performVerticalOrderOperation(rootNode.left, horizontalDistance - 1, map);
        performVerticalOrderOperation(rootNode.right, horizontalDistance + 1, map);
    }

    public void printVerticalOrder (TreeNode rootNode) {

        if (rootNode == null) {
            return;
        }

        Value value = new Value();
        findMinMax(rootNode, value, value, 0);

        System.out.println("Vertical Order : ");
        for (int i = value.min; i <= value.max; i++) {
            printVerticalLine (rootNode, i, 0);
            System.out.println();
        }
    }

    private void printVerticalLine(TreeNode rootNode, int lineNumber, int horizontalDistance) {

        if (rootNode == null) {
            return;
        }

        if (horizontalDistance == lineNumber) {
            System.out.print(rootNode.data + " ");
        }

        printVerticalLine(rootNode.left, lineNumber, horizontalDistance - 1);
        printVerticalLine(rootNode.right, lineNumber, horizontalDistance + 1);
    }

    public void findMinMax (TreeNode rootNode, Value valueMin, Value valueMax, int horizontalDistance) {

        if (rootNode == null) {
            return;
        }

        if (horizontalDistance < valueMin.min) {
            valueMin.min = horizontalDistance;
        } else if (horizontalDistance > valueMax.max) {
            valueMax.max = horizontalDistance;
        }

        findMinMax (rootNode.left, valueMin, valueMax, horizontalDistance - 1);
        findMinMax (rootNode.right, valueMin, valueMax, horizontalDistance + 1);
    }
}
