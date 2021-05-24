package trees.binarytrees;

import java.util.Arrays;

public class PrintPostOrderFromPreAndInOrder {

    static int preOrderIndex = 0;
    public static void main(String[] args) {

        int[] preOrder = {1, 2, 4, 5, 3, 6};
        int[] inOrder = {4, 2, 5, 1, 3, 6};

        printPostOrderTraversal(inOrder, preOrder, 0, preOrder.length - 1);
    }


    public static void printPostOrderTraversal (int[] inOrder, int[] preOrder, int inStart, int inEnd) {

        if (inStart > inEnd) {
            return;
        }

        int inOrderIndex = linearSearch(inOrder, inStart, inEnd, preOrder[preOrderIndex++]);

        printPostOrderTraversal(inOrder, preOrder, inStart, inOrderIndex - 1);
        printPostOrderTraversal(inOrder, preOrder, inOrderIndex + 1, inEnd);

        System.out.print(inOrder[inOrderIndex] + " ");
    }

    public static int linearSearch (int[] arr, int low, int high, int key) {

        for (int i = low; i <= high; i++) {
            if (arr[i] == key) {
                return i;
            }
        }
        return -1;
    }
}
