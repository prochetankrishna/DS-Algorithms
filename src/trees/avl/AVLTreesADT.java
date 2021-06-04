package trees.avl;

class AVLNode {

    int data;
    AVLNode left, right;

    public AVLNode () {};

    public AVLNode(int data) {
        this.data = data;
        this.left = this.right = null;
    }
}

public class AVLTreesADT {

    public static void main(String[] args) {

        AVLTreesADT avlTreeUtil = new AVLTreesADT();
        AVLNode rootNode = null;

        int[] insertionOrder = {55, 66, 77, 15, 11, 33, 22, 35, 25, 44, 88, 99};
        for (int i = 0; i < insertionOrder.length; i++) {
//            System.out.println();
//            System.out.println("######" + "Inserting Node : " + insertionOrder[i] + "######");
            rootNode = avlTreeUtil.insertInAVLTreeRecursive(rootNode, insertionOrder[i]);
//            System.out.print("INORDER TRAVERSAL : ");
//            avlTreeUtil.inOrderTraversal(rootNode);
//            System.out.println();
        }
        avlTreeUtil.inOrderTraversal(rootNode);
        System.out.println();
        rootNode = avlTreeUtil.deleteNode(rootNode, 33);
        avlTreeUtil.inOrderTraversal(rootNode);
    }

    public AVLNode insertInAVLTreeRecursive (AVLNode rootNode, int data) {

        if (rootNode == null) {
            AVLNode newNode = new AVLNode(data);
            return newNode;
        }

        if (rootNode.data > data) {
            rootNode.left = insertInAVLTreeRecursive(rootNode.left, data);
        } else if (rootNode.data < data) {
            rootNode.right = insertInAVLTreeRecursive(rootNode.right, data);
        } else {
            System.out.println("No Duplicates Allowed");
            return rootNode;
        }

        int balanceFactor = getBalanceFactor(rootNode);

        if (balanceFactor > 1 && data < rootNode.left.data) {
            //System.out.println("Performing Right Rotation for Node : " + rootNode.data);
            return rightRotate(rootNode);
        } else if (balanceFactor < - 1 && data > rootNode.right.data) {
            //System.out.println("Performing Left Rotation for Node : " + rootNode.data);
            return leftRotate(rootNode);
        } else if (balanceFactor > 1 && data > rootNode.left.data) {
            //System.out.println("Performing Left Rotation for Node : " + rootNode.left.data);
            rootNode.left = leftRotate(rootNode.left);
            //System.out.println("Performing Right Rotation for Node : " + rootNode.data);
            return rightRotate(rootNode);
        } else if (balanceFactor < -1 && data < rootNode.right.data) {
            //System.out.println("Performing Right Rotation for Node : " + rootNode.right.data);
            rootNode.right = rightRotate(rootNode.right);
            //System.out.println("Performing Left Rotation for Node : " + rootNode.data);
            return leftRotate(rootNode);
        }
        return rootNode;
    }

    public AVLNode deleteNode (AVLNode rootNode, int data) {

        if (rootNode == null) {
            return null;
        } else if (rootNode.data > data) {
            rootNode.left = deleteNode(rootNode.left, data);
        } else if (rootNode.data < data) {
            rootNode.right = deleteNode(rootNode.right, data);
        } else {

            if (rootNode.left == null) {
                return rootNode.right;
            } else if (rootNode.right == null) {
                return rootNode.left;
            } else {
                AVLNode minValueNode = findMinValueNode(rootNode.right);
                rootNode.data = minValueNode.data;
                rootNode.right = deleteNode(rootNode.right, minValueNode.data);
            }
        }

        int balanceFactor = getBalanceFactor(rootNode);

        if (balanceFactor == 2 && getBalanceFactor(rootNode.left) >= 0) {
            return rightRotate(rootNode);
        } else if (balanceFactor == 2 && getBalanceFactor(rootNode.left) == -1) {
            rootNode.left = leftRotate(rootNode.left);
            return rightRotate(rootNode);
        } else if (balanceFactor == -2 && getBalanceFactor(rootNode.right) <= 0) {
            return leftRotate(rootNode);
        } else if (balanceFactor == -2 && getBalanceFactor(rootNode.right) == 1) {
            rootNode.right = rightRotate(rootNode.right);
            return leftRotate(rootNode);
        }
        return rootNode;
    }

    public int heightOfTree (AVLNode rootNode) {

        if (rootNode == null) {
            return 0;
        }

        return 1 + Math.max (heightOfTree(rootNode.left), heightOfTree(rootNode.right));
    }

    public int getBalanceFactor (AVLNode rootNode) {

        if (rootNode == null) {
            return -1;
        }

//        System.out.println(heightOfTree(rootNode.right));
//        System.out.println(heightOfTree(rootNode.left));

        return heightOfTree(rootNode.left) - heightOfTree(rootNode.right);
    }

    public AVLNode leftRotate (AVLNode X) {

        AVLNode Y = X.right;
        AVLNode T2 = Y.left;

        Y.left = X;
        X.right = T2;
        return Y;
    }

    public AVLNode rightRotate (AVLNode Y) {

        AVLNode X = Y.left;
        AVLNode T2 = X.right;

        X.right = Y;
        Y.left = T2;
        return X;
    }

    public void inOrderTraversal (AVLNode rootNode) {

        if(rootNode == null) {
            return;
        }

        inOrderTraversal(rootNode.left);
        System.out.print(rootNode.data + " ");
        inOrderTraversal(rootNode.right);
    }

    public AVLNode findMinValueNode (AVLNode rootNode) {

        if (rootNode == null) {
            return null;
        }

        AVLNode tempNode = rootNode;
        while (tempNode.left != null) {
            tempNode = tempNode.left;
        }
        return tempNode;
    }
}
