package trees.binarytreecomplete;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class WidthLevel {
    int width;
    int level;

    public WidthLevel(int width, int level) {
        this.width = width;
        this.level = level;
    }
}
public class WidthAtAllLevel implements BinaryTreeUtil{

    public static void main(String[] args) {
        WidthAtAllLevel binaryTreeUtil = new WidthAtAllLevel();
        TreeNode rootNode = binaryTreeUtil.getNewNode(2);
        rootNode.left = binaryTreeUtil.getNewNode(7);
        rootNode.right = binaryTreeUtil.getNewNode(5);
        rootNode.left.left = binaryTreeUtil.getNewNode(2);
        rootNode.left.right = binaryTreeUtil.getNewNode(6);
        rootNode.left.right.left = binaryTreeUtil.getNewNode(5);
        rootNode.left.right.right = binaryTreeUtil.getNewNode(11);
        rootNode.right.right = binaryTreeUtil.getNewNode(9);
        rootNode.right.right.left = binaryTreeUtil.getNewNode(4);
        binaryTreeUtil.printLevelOrderTraversalLineByLine(rootNode);
        System.out.println();
        List<WidthLevel> widthLevelList = binaryTreeUtil.maximumWidthOfBinaryTree(rootNode);
        widthLevelList.forEach(widthLevel -> {
            System.out.println("Level : " + widthLevel.level + ", Width : " + widthLevel.width);
        });

        int widthOfLevel = binaryTreeUtil.getWidthOfALevel(rootNode, 3);
        System.out.println("Width of Level [3] : " + widthOfLevel);

    }

    public List<WidthLevel> maximumWidthOfBinaryTree (TreeNode rootNode) {

        List<WidthLevel> widthLevelList = new LinkedList<>();
        if (rootNode == null) {
            return widthLevelList;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(rootNode);

        int level = 1;
        while (!queue.isEmpty()) {

            int queueSize = queue.size();
            widthLevelList.add(new WidthLevel(queueSize, level++));
            for (int i = 1; i <= queueSize; i++) {

                TreeNode tempNode = queue.poll();

                if(tempNode.left != null) {
                    queue.offer(tempNode.left);
                }

                if(tempNode.right != null) {
                    queue.offer(tempNode.right);
                }
            }
        }
        return widthLevelList;
    }

    public int getWidthOfALevel (TreeNode rootNode, int level) {

        if (rootNode == null) {
            return 0;
        }

        if (level == 1) {
            return 1;
        }

        return getWidthOfALevel(rootNode.left, level - 1) + getWidthOfALevel(rootNode.right, level - 1);
    }
}
