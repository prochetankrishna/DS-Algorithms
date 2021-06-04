package trees.binarytreecomplete;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

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

    public void preOrderTraversalRecursion (TreeNode rootNode) {

        if (rootNode == null) {
            return;
        }
        System.out.print(rootNode.data + " ");
        preOrderTraversalRecursion(rootNode.left);
        preOrderTraversalRecursion(rootNode.right);
    }

    public void preOrderTraversalIterative (TreeNode rootNode) {

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

    public void inOrderTraversalRecursion (TreeNode rootNode) {

        if (rootNode == null) {
            return;
        }
        inOrderTraversalRecursion(rootNode.left);
        System.out.print(rootNode.data + " ");
        inOrderTraversalRecursion(rootNode.right);
    }

    public void inOrderTraversalIterative (TreeNode rootNode) {

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

    public void postOrderTraversalRecursive (TreeNode rootNode) {

        if (rootNode == null) {
            return;
        }
        postOrderTraversalRecursive(rootNode.left);
        postOrderTraversalRecursive(rootNode.right);
        System.out.print(rootNode.data + " ");
    }

    public void postOrderTraversalIterative (TreeNode rootNode) {

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

    public void printElementsAtGivenLevel (TreeNode rootNode, int level) {

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

    public void printLevelOrderTraversalRecursive (TreeNode rootNode) {

        int heightOfTree = this.getHeightOfTree(rootNode);

        for (int i = 0; i <= heightOfTree; i++) {
            printElementsAtGivenLevel(rootNode, i);
        }
    }

    public void printLevelOrderTraversalIterative (TreeNode rootNode) {

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

    public void reverseLevelOrderTraversalRecursive (TreeNode rootNode) {

        if (rootNode == null) {
            return;
        }

        int heightOfTree = this.getHeightOfTree(rootNode);

        for (int i = heightOfTree; i >= 0; i--) {
            printElementsAtGivenLevel(rootNode, i);
        }
    }

    public void reverseLevelOrderTraversalIterative (TreeNode rootNode) {

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

    public void printLevelOrderTraversalLineByLine (TreeNode rootNode) {

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

    int maxLevel;
    public void printLeftViewOfTree (TreeNode rootNode, int currentLevel) {

        if (rootNode == null) {
            return;
        }

        if (currentLevel >= maxLevel) {
            System.out.print(rootNode.data + " ");
            maxLevel++;
        }

        printLeftViewOfTree(rootNode.left, currentLevel + 1);
        printLeftViewOfTree(rootNode.right, currentLevel + 1);
    }

    public void printRightViewOfTree (TreeNode rootNode, int currentLevel) {

        if (rootNode == null) {
            return;
        }

        if (currentLevel >= maxLevel) {
            System.out.print(rootNode.data + " ");
            maxLevel++;
        }

        printLeftViewOfTree(rootNode.right, currentLevel + 1);
        printLeftViewOfTree(rootNode.left, currentLevel + 1);

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

        System.out.print("PREORDER RECURSION: ");
        binaryTreeUtil.preOrderTraversalRecursion(rootNode);
        System.out.println();

        System.out.print("PREORDER ITERATIVE: ");
        binaryTreeUtil.preOrderTraversalIterative(rootNode);
        System.out.println();

        System.out.print("INORDER RECURSIVE: ");
        binaryTreeUtil.inOrderTraversalRecursion(rootNode);
        System.out.println();

        System.out.print("INORDER ITERATIVE: ");
        binaryTreeUtil.inOrderTraversalIterative(rootNode);
        System.out.println();

        System.out.print("POSTORDER RECURSIVE: ");
        binaryTreeUtil.postOrderTraversalRecursive(rootNode);
        System.out.println();

        System.out.print("POSTORDER ITERATIVE: ");
        binaryTreeUtil.postOrderTraversalIterative(rootNode);
        System.out.println();

        System.out.println("Sum of all Nodes : " + binaryTreeUtil.findSumOfAllNodes(rootNode));

        System.out.println("Difference BW Even and Odd Level : " +
                binaryTreeUtil.findDifferenceAtEvenAndOddLevelRecursive(rootNode));
        System.out.println("Difference BW Even and Odd Level : " +
                binaryTreeUtil.findDifferenceAtEvenAndOddLevelIterative(rootNode));

        System.out.println("Total Number of Nodes : " + binaryTreeUtil.getTotalNumberOfNodes(rootNode));

        System.out.println("Total Number of Leaf Nodes : " + binaryTreeUtil.getTotalNumberOfLeafNodes(rootNode));

        System.out.println("Height of Tree : " + binaryTreeUtil.getHeightOfTree(rootNode));

        System.out.println("Print Tree At Level : 4");
        binaryTreeUtil.printElementsAtGivenLevel(rootNode, 4);

        System.out.print("Level Order Traversal Recursive : ");
        binaryTreeUtil.printLevelOrderTraversalRecursive(rootNode);
        System.out.println();

        System.out.print("Level Order Traversal Iterative : ");
        binaryTreeUtil.printLevelOrderTraversalIterative(rootNode);
        System.out.println();

        System.out.print("Reverse Level Order Traversal Recursion : ");
        binaryTreeUtil.reverseLevelOrderTraversalRecursive(rootNode);
        System.out.println();

        System.out.print("Reverse Level Order Traversal Iterative : ");
        binaryTreeUtil.reverseLevelOrderTraversalIterative(rootNode);
        System.out.println();

        System.out.println("Level Order Traversal Line by Line : ");
        binaryTreeUtil.printLevelOrderTraversalLineByLine(rootNode);
        System.out.println();

        System.out.print("Left View Of Tree : ");
        binaryTreeUtil.maxLevel = 0;
        binaryTreeUtil.printLeftViewOfTree(rootNode, 0);
        System.out.println();

        System.out.print("Right View Of Tree : ");
        binaryTreeUtil.maxLevel = 0;
        binaryTreeUtil.printRightViewOfTree(rootNode, 0);
        System.out.println();

    }
}
