package trees.binarytrees;

public class BinaryTree {

    public TreeNode root;

    static class TreeNode {

        int data;
        TreeNode left;
        TreeNode right;

        public TreeNode () {

        }

        public TreeNode (int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    public BinaryTree () {
        root = null;
    }

    public TreeNode getHeadNode () {
        return this.root;
    }
}
