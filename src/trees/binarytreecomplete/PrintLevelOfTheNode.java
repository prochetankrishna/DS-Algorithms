package trees.binarytreecomplete;

public class PrintLevelOfTheNode extends BinaryTreeUtil{

    int currentLevel;

    public static void main(String[] args) {

        PrintLevelOfTheNode binaryTreeUtil = new PrintLevelOfTheNode();
        TreeNode rootNode = binaryTreeUtil.getNewNode(2);
        rootNode.left = binaryTreeUtil.getNewNode(7);
        rootNode.right = binaryTreeUtil.getNewNode(5);
        rootNode.left.left = binaryTreeUtil.getNewNode(2);
        rootNode.left.right = binaryTreeUtil.getNewNode(6);
        rootNode.left.right.left = binaryTreeUtil.getNewNode(5);
        rootNode.left.right.right = binaryTreeUtil.getNewNode(11);
        rootNode.right.right = binaryTreeUtil.getNewNode(9);
        rootNode.right.right.left = binaryTreeUtil.getNewNode(4);

        System.out.println("Level Order Traversal Line by Line : ");
        binaryTreeUtil.printLevelOrderTraversalLineByLine(rootNode);
        System.out.println();

        binaryTreeUtil.currentLevel = 1;
        System.out.println("Level : " + binaryTreeUtil.getLevelOfTheNodeIfExists(rootNode, 11, binaryTreeUtil.currentLevel));
    }

    public int getLevelOfTheNodeIfExists (TreeNode rootNode, int key, int currentLevel) {

        if (rootNode == null) {
            return -1;
        }

        if (rootNode.data == key) {
            return currentLevel;
        }

        int leftSearchedLevel = getLevelOfTheNodeIfExists(rootNode.left, key, currentLevel + 1);

        return leftSearchedLevel != -1 ? leftSearchedLevel : getLevelOfTheNodeIfExists(rootNode.right, key, currentLevel + 1);
    }
}
