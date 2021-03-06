package trees.binarytreecomplete.interfaces;

import trees.binarytreecomplete.TreeNode;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public interface BinaryTreeUtil {

    public default TreeNode getNewNode (int data) {
        return new TreeNode(data);
    }

    public default void preOrderTraversalRecursion (TreeNode rootNode) {

        if (rootNode == null) {
            return;
        }
        System.out.print(rootNode.data + " ");
        preOrderTraversalRecursion(rootNode.left);
        preOrderTraversalRecursion(rootNode.right);
    }

    public default void preOrderTraversalIterative (TreeNode rootNode) {

        if (rootNode == null) {
            return;
        }

        Stack<TreeNode> stack = new Stack<>();
        stack.push(rootNode);

        while (!stack.isEmpty()) {

            TreeNode tempNode = stack.pop();
            System.out.print(tempNode.data + " ");

            if (tempNode.right != null) {
                stack.push (tempNode.right);
            }

            if (tempNode.left != null) {
                stack.push (tempNode.left);
            }
        }
    }

    public default void inOrderTraversalRecursion (TreeNode rootNode) {

        if (rootNode == null) {
            return;
        }
        inOrderTraversalRecursion(rootNode.left);
        System.out.print(rootNode.data + " ");
        inOrderTraversalRecursion(rootNode.right);
    }

    public default void inOrderTraversalIterative (TreeNode rootNode) {

        if (rootNode == null) {
            return;
        }

        Stack<TreeNode> stack = new Stack<>();
        TreeNode currentNode = rootNode;

        while (currentNode != null || !stack.isEmpty()) {

            while (currentNode != null) {

                stack.push(currentNode);
                currentNode = currentNode.left;
            }

            if (!stack.isEmpty()) {
                currentNode = stack.pop();
                System.out.print(currentNode.data + " ");
                currentNode = currentNode.right;
            }
        }
    }

    public default void postOrderTraversalRecursive (TreeNode rootNode) {

        if (rootNode == null) {
            return;
        }
        postOrderTraversalRecursive(rootNode.left);
        postOrderTraversalRecursive(rootNode.right);
        System.out.print(rootNode.data + " ");
    }

    public default void postOrderTraversalIterative (TreeNode rootNode) {

        if (rootNode == null) {
            return;
        }

        Stack<TreeNode> stackOne = new Stack<>();
        Stack<TreeNode> stackTwo = new Stack<>();

        stackOne.push(rootNode);

        while (!stackOne.isEmpty()) {

            TreeNode temp = stackOne.pop();
            stackTwo.push(temp);

            if (temp.left != null) {
                stackOne.push(temp.left);
            }

            if (temp.right != null) {
                stackOne.push(temp.right);
            }

        }

        while (!stackTwo.isEmpty()) {
            System.out.print(stackTwo.pop().data + " ");
        }
    }

    public default int findSumOfAllNodes (TreeNode rootNode) {

        if (rootNode == null) {
            return 0;
        }

        return rootNode.data + findSumOfAllNodes(rootNode.left) + findSumOfAllNodes(rootNode.right);
    }

    public default int findDifferenceAtEvenAndOddLevelRecursive (TreeNode rootNode) {

        if (rootNode == null) {
            return 0;
        }

        return rootNode.data - findDifferenceAtEvenAndOddLevelRecursive(rootNode.left) -
                findDifferenceAtEvenAndOddLevelRecursive(rootNode.right);
    }

    public default int findDifferenceAtEvenAndOddLevelIterative (TreeNode rootNode) {

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

                //System.out.print(tempNode.data + " ");
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
            //System.out.println();
        }
        return (oddSum - evenSum);
    }

    public default int getTotalNumberOfNodes (TreeNode rootNode) {

        if (rootNode == null) {
            return 0;
        }

        return 1 + getTotalNumberOfNodes(rootNode.left) + getTotalNumberOfNodes(rootNode.right);
    }

    public default int getTotalNumberOfLeafNodes (TreeNode rootNode) {

        if (rootNode == null) {
            return 0;
        }

        if (rootNode.left == null && rootNode.right == null) {
            return 1;
        }

        return getTotalNumberOfLeafNodes(rootNode.left) + getTotalNumberOfLeafNodes(rootNode.right);
    }

    public default int getHeightOfTree (TreeNode rootNode) {

        if (rootNode == null) {
            return -1;
        }

        int leftHeight = getHeightOfTree(rootNode.left);
        int rightHeight = getHeightOfTree(rootNode.right);

        return 1 + Math.max(leftHeight, rightHeight);
    }

    public default int getHeightOfTreeIterative (TreeNode rootNode) {

        if (rootNode == null) {
            return -1;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(rootNode);
        int numberOfLevel = -1;

        while (!queue.isEmpty()) {

            int queueSize = queue.size();
            numberOfLevel++;

            while (queueSize > 0) {
                TreeNode tempNode = queue.poll();

                if (tempNode.left != null) {
                    queue.offer(tempNode.left);
                }

                if (tempNode.right != null) {
                    queue.offer (tempNode.right);
                }
                queueSize--;
            }
        }
        return numberOfLevel;
    }


    public default void printElementsAtGivenLevel (TreeNode rootNode, int level) {

        if (rootNode == null) {
            return;
        }

        if (level == 0) {
            System.out.print(rootNode.data + " ");
            return;
        }

        printElementsAtGivenLevel(rootNode.left, level - 1);
        printElementsAtGivenLevel(rootNode.right, level - 1);
    }

    public default void printLevelOrderTraversalRecursive (TreeNode rootNode) {

        int heightOfTree = this.getHeightOfTree(rootNode);

        for (int i = 0; i <= heightOfTree; i++) {
            printElementsAtGivenLevel(rootNode, i);
        }
    }

    public default void printLevelOrderTraversalIterative (TreeNode rootNode) {

        if (rootNode == null) {
            return;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(rootNode);

        while (!queue.isEmpty()) {

            int queueSize = queue.size();

            while (queueSize > 0) {

                TreeNode currentNode = queue.poll();
                System.out.print(currentNode.data + " ");

                if (currentNode.left != null) {
                    queue.offer(currentNode.left);
                }

                if (currentNode.right != null) {
                    queue.offer(currentNode.right);
                }

                queueSize--;
            }
        }
    }

    public default void reverseLevelOrderTraversalRecursive (TreeNode rootNode) {

        if (rootNode == null) {
            return;
        }

        int heightOfTree = this.getHeightOfTree(rootNode);

        for (int i = heightOfTree; i >= 0; i--) {
            printElementsAtGivenLevel(rootNode, i);
        }
    }

    public default void reverseLevelOrderTraversalIterative (TreeNode rootNode) {

        if (rootNode == null) {
            return;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        Stack<TreeNode> stack = new Stack<>();
        queue.offer(rootNode);

        while (!queue.isEmpty()) {

            int queueSize = queue.size();

            while (queueSize > 0) {

                TreeNode currentNode = queue.poll();
                stack.push (currentNode);

                if (currentNode.right != null) {
                    queue.offer(currentNode.right);
                }

                if (currentNode.left != null) {
                    queue.offer(currentNode.left);
                }

                queueSize--;
            }
        }

        while (!stack.isEmpty()) {
            System.out.print(stack.pop().data + " ");
        }
    }

    public default void printLevelOrderTraversalLineByLine (TreeNode rootNode) {

        if (rootNode == null) {
            return;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(rootNode);

        while (!queue.isEmpty()) {

            int queueSize = queue.size();

            while (queueSize > 0) {

                TreeNode currentNode = queue.poll();
                System.out.print(currentNode.data + " ");

                if (currentNode.left != null) {
                    queue.offer(currentNode.left);
                }

                if (currentNode.right != null) {
                    queue.offer(currentNode.right);
                }

                queueSize--;
            }
            System.out.println();
        }
    }
}