package trees.binarytreecomplete;

import trees.binarytreecomplete.interfaces.BinaryTreeUtil;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class VerticalSumOfBinaryTree implements BinaryTreeUtil {

    public static void main(String[] args) {

        VerticalSumOfBinaryTree binaryTreeUtil = new VerticalSumOfBinaryTree();
        TreeNode rootNode = binaryTreeUtil.getNewNode(2);
        rootNode.left = binaryTreeUtil.getNewNode(7);
        rootNode.right = binaryTreeUtil.getNewNode(5);

        rootNode.left.left = binaryTreeUtil.getNewNode(2);
        rootNode.left.right = binaryTreeUtil.getNewNode(6);
        rootNode.left.right.left = binaryTreeUtil.getNewNode(5);
        rootNode.left.right.right = binaryTreeUtil.getNewNode(11);

        rootNode.right.right = binaryTreeUtil.getNewNode(9);
        rootNode.right.right.left = binaryTreeUtil.getNewNode(4);

        binaryTreeUtil.printVerticalSum(rootNode);
    }

    public void printVerticalSum (TreeNode rootNode) {

        if (rootNode == null) {
            return;
        }

        int horizontalDistance = 0;
        Map<Integer, List<Integer>> map = new TreeMap<>();
        performVerticalOrderOperation(rootNode, horizontalDistance, map);

        for (Integer horizontalDistanceFromMap : map.keySet()) {

            List<Integer> nodeList = map.get(horizontalDistanceFromMap);
            int sum = 0;
            for (Integer eachNode : nodeList) {
                sum += eachNode;
            }
            System.out.println("For Vertical Line : [" + horizontalDistanceFromMap + "] -> SUM : [" + sum + "]");
        }
    }

    public void performVerticalOrderOperation (TreeNode rootNode, int horizontalDistance, Map<Integer, List<Integer>> map) {

        if (rootNode == null) {
            return;
        }

        if (!map.containsKey(horizontalDistance)) {
            List<Integer> nodeList = new LinkedList<>();
            nodeList.add (rootNode.data);
            map.put (horizontalDistance, nodeList);
        } else {
            map.get(horizontalDistance).add(rootNode.data);
        }

        performVerticalOrderOperation(rootNode.left, horizontalDistance - 1, map);
        performVerticalOrderOperation(rootNode.right, horizontalDistance  + 1, map);
    }
}
