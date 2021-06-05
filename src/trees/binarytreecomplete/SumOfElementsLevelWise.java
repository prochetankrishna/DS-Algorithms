package trees.binarytreecomplete;

import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.TreeMap;

public class SumOfElementsLevelWise implements BinaryTreeUtil{

    public static void main(String[] args) {

        SumOfElementsLevelWise binaryTreeUtil = new SumOfElementsLevelWise();
        TreeNode rootNode = binaryTreeUtil.getNewNode(2);
        rootNode.left = binaryTreeUtil.getNewNode(7);
        rootNode.right = binaryTreeUtil.getNewNode(5);

        rootNode.left.left = binaryTreeUtil.getNewNode(2);
        rootNode.left.right = binaryTreeUtil.getNewNode(6);
        rootNode.left.right.left = binaryTreeUtil.getNewNode(5);
        rootNode.left.right.right = binaryTreeUtil.getNewNode(11);

        rootNode.right.right = binaryTreeUtil.getNewNode(9);
        rootNode.right.right.left = binaryTreeUtil.getNewNode(4);

        binaryTreeUtil.printSumOfNodesLevelWise(rootNode);
    }

    public void printSumOfNodesLevelWise (TreeNode rootNode) {

        if (rootNode == null) {
            return;
        }

        Map<Integer, Integer> sumMap = new TreeMap<>();
        Queue<TreeNode> queue = new LinkedList<>();
        int currentLevel = 0;
        queue.offer(rootNode);

        while (!queue.isEmpty()) {

            int queueSize = queue.size();
            int sum = 0;
            while (queueSize > 0) {
                TreeNode tempNode = queue.poll();
                sum += tempNode.data;

                if (tempNode.left != null) {
                    queue.offer(tempNode.left);
                }

                if (tempNode.right != null) {
                    queue.offer(tempNode.right);
                }

                queueSize--;
            }
            sumMap.put(currentLevel++, sum);
        }

        for (Integer currentLevelFromMap : sumMap.keySet()) {
            System.out.println("For Level : [" + currentLevel + "], SUM : [" + sumMap.get(currentLevelFromMap) + "]");
        }
    }
}
