package trees.binarytrees;

import com.sun.source.tree.Tree;
import trees.binarytrees.BinaryTreeWithParentNode.TreeNode;

import java.util.HashMap;
import java.util.Map;

public class LowestCommonAncestorParent {

    public static void main(String[] args) {

        TreeNode rootNode = new TreeNode(3);

        rootNode.left = new TreeNode(5);
        rootNode.left.parent = rootNode;
        rootNode.right = new TreeNode(1);
        rootNode.right.parent = rootNode;

        rootNode.left.left = new TreeNode(6);
        rootNode.left.left.parent = rootNode.left;
        rootNode.left.right = new TreeNode(2);
        rootNode.left.right.parent = rootNode.left;

        rootNode.left.right.left = new TreeNode(7);
        rootNode.left.right.left.parent = rootNode.left.right;
        rootNode.left.right.right = new TreeNode(4);
        rootNode.left.right.right.parent = rootNode.left.right;

        rootNode.right.left = new TreeNode(0);
        rootNode.right.left.parent = rootNode.right;
        rootNode.right.right = new TreeNode(8);
        rootNode.right.right.parent = rootNode.right;

        TreeNode lowestCommonAncestor = findLowestCommonAncestor(rootNode.left.right.right, rootNode.right.right);
        if (lowestCommonAncestor == null) {
            System.out.println("LCA doesn't exists !");
        } else {
            System.out.println("LCA [" + lowestCommonAncestor.data + "]");
        }
    }

    public static TreeNode findLowestCommonAncestor (TreeNode nodeOne, TreeNode nodeTwo) {

        if (nodeOne == null || nodeTwo == null) {
            return null;
        }

        Map<TreeNode, Boolean> ancestorMap = new HashMap<>();
        while (nodeOne != null) {
            ancestorMap.put(nodeOne, Boolean.TRUE);
            nodeOne = nodeOne.parent;
        }

        while (nodeTwo != null) {

            if (ancestorMap.containsKey(nodeTwo)) {
                return nodeTwo;
            }
            nodeTwo = nodeTwo.parent;
        }
        return null;
    }
}
