package trees.binarytreecomplete;

import trees.binarytreecomplete.interfaces.BinaryTreeUtil;

import java.util.Stack;

public class CheckWhetherTwoTreesAreIdentical implements BinaryTreeUtil {

    public static void main(String[] args) {
        
        CheckWhetherTwoTreesAreIdentical binaryTreeUtil = new CheckWhetherTwoTreesAreIdentical();
        
        TreeNode rootNodeOne = binaryTreeUtil.getNewNode(1);
        rootNodeOne.left = binaryTreeUtil.getNewNode(2);
        rootNodeOne.right = binaryTreeUtil.getNewNode(3);
        rootNodeOne.left.left = binaryTreeUtil.getNewNode(4);
        rootNodeOne.left.right = binaryTreeUtil.getNewNode(5);
        rootNodeOne.right.left = binaryTreeUtil.getNewNode(6);
        rootNodeOne.right.right = binaryTreeUtil.getNewNode(7);

        TreeNode rootNodeTwo = binaryTreeUtil.getNewNode(1);
        rootNodeTwo.left = binaryTreeUtil.getNewNode(2);
        rootNodeTwo.right = binaryTreeUtil.getNewNode(3);
        rootNodeTwo.left.left = binaryTreeUtil.getNewNode(4);
        rootNodeTwo.left.right = binaryTreeUtil.getNewNode(5);
        rootNodeTwo.right.left = binaryTreeUtil.getNewNode(6);
        rootNodeTwo.right.right = binaryTreeUtil.getNewNode(7);

        System.out.println("Are Both Trees Identical ? : " + binaryTreeUtil.checkWhetherTwoTreesAreIdenticalRecursive(rootNodeOne, rootNodeTwo));
        System.out.println("Are Both Trees Identical ? : " + binaryTreeUtil.checkWhetherTwoTreesAreIdenticalIterative(rootNodeOne, rootNodeTwo));

    }

    public boolean checkWhetherTwoTreesAreIdenticalRecursive (TreeNode rootNodeOne, TreeNode rootNodeTwo) {

        if (rootNodeOne == null && rootNodeTwo == null) {
            return true;
        }

        if (rootNodeOne == null && rootNodeTwo != null) {
            return false;
        }

        if (rootNodeOne != null && rootNodeTwo == null) {
            return false;
        }

        if (rootNodeOne.data == rootNodeTwo.data) {
            return checkWhetherTwoTreesAreIdenticalRecursive(rootNodeOne.left, rootNodeTwo.left) &&
                    checkWhetherTwoTreesAreIdenticalRecursive(rootNodeOne.right, rootNodeTwo.right);
        } else {
            return false;
        }
    }

    public boolean checkWhetherTwoTreesAreIdenticalIterative (TreeNode rootNodeOne, TreeNode rootNodeTwo) {

        if (rootNodeOne == null && rootNodeTwo == null) {
            return true;
        }

        if (rootNodeOne == null && rootNodeTwo != null) {
            return false;
        }

        if (rootNodeOne != null && rootNodeTwo == null) {
            return false;
        }

        Stack<TreeNode> stackForTreeOne = new Stack<>();
        stackForTreeOne.push(rootNodeOne);

        Stack<TreeNode> stackForTreeTwo = new Stack<>();
        stackForTreeTwo.push(rootNodeTwo);

        while (!stackForTreeOne.isEmpty() && !stackForTreeTwo.isEmpty()) {

            TreeNode tempNodeOne = stackForTreeOne.pop();
            TreeNode tempNodeTwo = stackForTreeTwo.pop();
            if (tempNodeOne.data != tempNodeTwo.data) {
                return false;
            }

            if ((tempNodeOne.left != null && tempNodeTwo.left == null) ||
                    (tempNodeOne.left == null && tempNodeTwo.left != null))  {
                return false;
            } else if (tempNodeOne.left != null && tempNodeTwo.left != null){
                stackForTreeOne.push(tempNodeOne.left);
                stackForTreeTwo.push(tempNodeTwo.left);
            }

            if ((tempNodeOne.right != null && tempNodeTwo.right == null) ||
                    (tempNodeOne.right == null && tempNodeTwo.right != null)) {
                return false;
            } else if (tempNodeOne.right != null && tempNodeTwo.right != null){
                stackForTreeOne.push(tempNodeOne.right);
                stackForTreeTwo.push(tempNodeTwo.right);
            }
        }
        return true;
    }
}
