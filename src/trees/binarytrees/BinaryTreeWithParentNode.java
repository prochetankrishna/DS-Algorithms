package trees.binarytrees;

public class BinaryTreeWithParentNode {

    static class TreeNode {

        int data;
        TreeNode left;
        TreeNode right;
        TreeNode parent;

        public TreeNode (int data) {
            this.data = data;
            this.left = null;
            this.right = null;
            this.parent = null;
        }
    }
}
