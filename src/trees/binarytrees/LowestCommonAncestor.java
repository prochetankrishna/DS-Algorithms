package trees.binarytrees;

import com.sun.source.tree.Tree;
import trees.binarytrees.BinaryTree.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class LowestCommonAncestor {

    static List<Integer> pathOne = new ArrayList<>();
    static List<Integer> pathTwo = new ArrayList<>();

    static boolean isNodeOneVisited = false;
    static boolean isNodeTwoVisited = false;

    public static void main(String[] args) {

        BinaryTree binaryTree = new BinaryTree();
        TreeNode rootNode = binaryTree.getHeadNode();

        rootNode = new BinaryTree.TreeNode(3);
        rootNode.left = new BinaryTree.TreeNode(5);
        rootNode.right = new BinaryTree.TreeNode(1);

        rootNode.left.left = new BinaryTree.TreeNode(6);
        rootNode.left.right = new BinaryTree.TreeNode(2);

        rootNode.right.left = new BinaryTree.TreeNode(0);
        rootNode.right.right = new BinaryTree.TreeNode(8);

        rootNode.left.right.left = new BinaryTree.TreeNode(7);
        rootNode.left.right.right = new BinaryTree.TreeNode(4);

        System.out.println(findLowestCommonAncestor (rootNode, 5, 4));
        TreeNode lowestCommonAncestor = findLCAOptimized(rootNode, 5, 4);
        if (lowestCommonAncestor != null) {
            System.out.println("LCA : [" + lowestCommonAncestor.data + "]");
        } else {
            System.out.println("Lowest Common Ancestor Doesn't Exists !!");
        }
    }

    public static TreeNode findLCAOptimizedUtil (TreeNode rootNode, int nodeOne, int nodeTwo) {

        if (rootNode == null) {
            return null;
        }

        TreeNode temp = null;

        if (rootNode.data == nodeOne) {
            temp = rootNode;
            isNodeOneVisited = true;
        }

        if (rootNode.data == nodeTwo) {
            temp = rootNode;
            isNodeTwoVisited = true;
        }

        if (temp != null) {
            return temp;
        }

        TreeNode leftLCA = findLCAOptimizedUtil (rootNode.left, nodeOne, nodeTwo);
        TreeNode rightLCA = findLCAOptimizedUtil (rootNode.right, nodeOne, nodeTwo);

        if (leftLCA != null && rightLCA != null) {
            return rootNode;
        }

        return leftLCA != null ? leftLCA : rightLCA;
    }

    public static TreeNode findLCAOptimized (TreeNode rootNode, int nodeOne, int nodeTwo) {

        isNodeOneVisited = false;
        isNodeTwoVisited = false;

        TreeNode lowestCommonAncestor = findLCAOptimizedUtil (rootNode, nodeOne, nodeTwo);

        if (isNodeOneVisited && isNodeTwoVisited) {
            return lowestCommonAncestor;
        } else {
            return null;
        }
    }
    public static int performLowestCommonAncestor (TreeNode rootNode, int nodeOne, int nodeTwo) {

        if (rootNode == null) {
            return -1;
        }

        if (!findPath(rootNode, nodeOne, pathOne) || !findPath(rootNode, nodeTwo, pathTwo)) {
            return -1;
        }

        int i;
        for (i = 0; i < pathOne.size() && i < pathTwo.size(); i++) {

            if (!pathOne.get(i).equals(pathTwo.get(i))) {
                break;
            }
        }
        return pathOne.get(i - 1);
    }

    public static boolean findPath (TreeNode rootNode, int node, List<Integer> path) {

        if (rootNode == null) {
            return false;
        }

        path.add (rootNode.data);
        if (rootNode.data == node) {
            return true;
        }

        if (rootNode.left != null && findPath (rootNode.left, node, path)) {
            return true;
        }

        if (rootNode.right != null && findPath (rootNode.right, node, path)) {
            return true;
        }

        path.remove (path.size() - 1);
        return false;
    }

    public static int findLowestCommonAncestor (TreeNode rootNode, int nodeOne, int nodeTwo) {

        if (rootNode == null) {
            return -1;
        }
        pathOne.clear();
        pathTwo.clear();
        return performLowestCommonAncestor (rootNode, nodeOne, nodeTwo);
    }


}
