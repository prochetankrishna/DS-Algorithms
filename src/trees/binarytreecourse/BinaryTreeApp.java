package trees.binarytreecourse;

import javax.swing.tree.TreeCellRenderer;
import java.util.LinkedList;
import java.util.Queue;

class TreeNode {

    int data;
    TreeNode left, right;

    public TreeNode() {}

    public TreeNode(int data) {
        this.data = data;
        this.left = this.right = null;
    }
}

class BinaryTreeUtil {

    public TreeNode getNewNode (int data) {
        return new TreeNode(data);
    }

    public void preOrderTraversal (TreeNode rootNode) {

        if (rootNode == null) {
            return;
        }
        System.out.print(rootNode.data + " ");
        preOrderTraversal(rootNode.left);
        preOrderTraversal(rootNode.right);
    }

    public void inOrderTraversal (TreeNode rootNode) {

        if (rootNode == null) {
            return;
        }
        inOrderTraversal(rootNode.left);
        System.out.print(rootNode.data + " ");
        inOrderTraversal(rootNode.right);
    }

    public void postOrderTraversal (TreeNode rootNode) {

        if (rootNode == null) {
            return;
        }
        postOrderTraversal(rootNode.left);
        postOrderTraversal(rootNode.right);
        System.out.print(rootNode.data + " ");
    }

    public int findSumOfAllNodes (TreeNode rootNode) {

        if (rootNode == null) {
            return 0;
        }

        return rootNode.data + findSumOfAllNodes(rootNode.left) + findSumOfAllNodes(rootNode.right);
    }

    public int findDifferenceAtEvenAndOddLevelRecursive (TreeNode rootNode) {

        if (rootNode == null) {
            return 0;
        }

        return rootNode.data - findDifferenceAtEvenAndOddLevelRecursive(rootNode.left) -
                findDifferenceAtEvenAndOddLevelRecursive(rootNode.right);
    }

    public int findDifferenceAtEvenAndOddLevelIterative (TreeNode rootNode) {

        if (rootNode == null) {
            return 0;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(rootNode);

        int currentLevel = 0;
        int evenSum = 0;
        int oddSum = 0;

        while (!queue.isEmpty()) {

            int queueSize = queue.size();
            currentLevel++;

            while (queueSize > 0) {
                TreeNode tempNode = queue.poll();

                if (currentLevel % 2 == 0) {
                    evenSum += tempNode.data;
                } else {
                    oddSum += tempNode.data;
                }

                if (tempNode.left != null) {
                    queue.offer(tempNode.left);
                }

                if (tempNode.right != null) {
                    queue.offer(tempNode.right);
                }

                queueSize--;
            }
        }
        return (oddSum - evenSum);
    }

    public int getTotalNumberOfNodes (TreeNode rootNode) {

        if (rootNode == null) {
            return 0;
        }

        return 1 + getTotalNumberOfNodes(rootNode.left) + getTotalNumberOfNodes(rootNode.right);
    }

    public int getTotalNumberOfLeafNodes (TreeNode rootNode) {

        if (rootNode == null) {
            return 0;
        }

        if (rootNode.left == null && rootNode.right == null) {
            return 1;
        }

        return getTotalNumberOfLeafNodes(rootNode.left) + getTotalNumberOfLeafNodes(rootNode.right);
    }

    public int getHeightOfTree (TreeNode rootNode) {

        if (rootNode == null) {
            return -1;
        }

        int leftHeight = getHeightOfTree(rootNode.left);
        int rightHeight = getHeightOfTree(rootNode.right);

        return 1 + Math.max(leftHeight, rightHeight);
    }
}
public class BinaryTreeApp {

    public static void main(String[] args) {

        BinaryTreeUtil binaryTreeUtil = new BinaryTreeUtil();
        TreeNode rootNode = binaryTreeUtil.getNewNode(2);
        rootNode.left = binaryTreeUtil.getNewNode(7);
        rootNode.right = binaryTreeUtil.getNewNode(5);
        rootNode.left.left = binaryTreeUtil.getNewNode(2);
        rootNode.left.right = binaryTreeUtil.getNewNode(6);
        rootNode.left.right.left = binaryTreeUtil.getNewNode(5);
        rootNode.left.right.right = binaryTreeUtil.getNewNode(11);
        rootNode.right.right = binaryTreeUtil.getNewNode(9);
        rootNode.right.right.left = binaryTreeUtil.getNewNode(4);

        System.out.print("PREORDER : ");
        binaryTreeUtil.preOrderTraversal(rootNode);
        System.out.println();

        System.out.print("INORDER : ");
        binaryTreeUtil.inOrderTraversal(rootNode);
        System.out.println();

        System.out.print("POSTORDER : ");
        binaryTreeUtil.postOrderTraversal(rootNode);
        System.out.println();

        System.out.println("Sum of all Nodes : " + binaryTreeUtil.findSumOfAllNodes(rootNode));

        System.out.println("Difference BW Even and Odd Level : " +
                binaryTreeUtil.findDifferenceAtEvenAndOddLevelRecursive(rootNode));
        System.out.println("Difference BW Even and Odd Level : " +
                binaryTreeUtil.findDifferenceAtEvenAndOddLevelIterative(rootNode));

        System.out.println("Total Number of Nodes : " + binaryTreeUtil.getTotalNumberOfNodes(rootNode));

        System.out.println("Total Number of Leaf Nodes : " + binaryTreeUtil.getTotalNumberOfLeafNodes(rootNode));

        System.out.println("Height of Tree : " + binaryTreeUtil.getHeightOfTree(rootNode));
    }
}
