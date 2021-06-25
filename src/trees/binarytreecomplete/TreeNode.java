package trees.binarytreecomplete;

public class TreeNode {

    public int data;
    public TreeNode left, right;

    public TreeNode() {}

    public TreeNode(int data) {
        this.data = data;
        this.left = this.right = null;
    }

    @Override
    public String toString() {
        return "TreeNode{" +
                "data=" + data +
                ", left=" + left +
                ", right=" + right +
                '}';
    }
}