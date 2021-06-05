package trees.binarytreecomplete;

public class RightViewOfBinaryTree implements BinaryTreeUtil{

    int maxLevel;

    public static void main(String[] args) {

        RightViewOfBinaryTree binaryTreeUtil = new RightViewOfBinaryTree();
        TreeNode rootNode = binaryTreeUtil.getNewNode(2);
        rootNode.left = binaryTreeUtil.getNewNode(7);
        rootNode.right = binaryTreeUtil.getNewNode(5);
        rootNode.left.left = binaryTreeUtil.getNewNode(2);
        rootNode.left.right = binaryTreeUtil.getNewNode(6);
        rootNode.left.right.left = binaryTreeUtil.getNewNode(5);
        rootNode.left.right.right = binaryTreeUtil.getNewNode(11);
        rootNode.right.right = binaryTreeUtil.getNewNode(9);
        rootNode.right.right.left = binaryTreeUtil.getNewNode(4);


        System.out.print("Right View Of Tree : ");
        binaryTreeUtil.maxLevel = 0;
        binaryTreeUtil.printRightViewOfTree(rootNode, 0);
        System.out.println();
    }

    public void printRightViewOfTree (TreeNode rootNode, int currentLevel) {

        if (rootNode == null) {
            return;
        }

        if (currentLevel >= maxLevel) {
            System.out.print(rootNode.data + " ");
            maxLevel++;
        }

        printRightViewOfTree(rootNode.right, currentLevel + 1);
        printRightViewOfTree(rootNode.left, currentLevel + 1);
    }
}
