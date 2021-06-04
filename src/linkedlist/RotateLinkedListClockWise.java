package linkedlist;

public class RotateLinkedListClockWise extends LinkedListUtil {

    public static void main(String[] args) {

        RotateLinkedListClockWise linkedListUtil = new RotateLinkedListClockWise();
        Node rootNode = null;
        rootNode = linkedListUtil.insertAtEndRecursive(rootNode, 1);
        rootNode = linkedListUtil.insertAtEndRecursive(rootNode, 2);
        rootNode = linkedListUtil.insertAtEndRecursive(rootNode, 3);
        rootNode = linkedListUtil.insertAtEndRecursive(rootNode, 4);
        rootNode = linkedListUtil.insertAtEndRecursive(rootNode, 5);

        linkedListUtil.printLinkedListRecursive(rootNode);
        rootNode = linkedListUtil.rotateLinkedListClockWise(rootNode, 1);
        linkedListUtil.printLinkedListIterative(rootNode);
    }

    public Node rotateLinkedListClockWise (Node rootNode, int numberOfRotations) {

        if (numberOfRotations <= 0) {
            return rootNode;
        }

        int sizeOfLinkedList = this.lengthOfLinkedListIterative(rootNode);
        numberOfRotations = numberOfRotations % sizeOfLinkedList;

        if (numberOfRotations == 0) {
            return rootNode;
        }

        Node tempNode = rootNode;
        int i = 1;

        while (i < sizeOfLinkedList - numberOfRotations) {
            tempNode = tempNode.next;
            i++;
        }

        Node nextNode = tempNode.next;
        Node newRootNode = nextNode;
        tempNode.next = null;

        while (nextNode.next != null) {
            nextNode = nextNode.next;
        }

        nextNode.next = rootNode;
        return newRootNode;
    }
}
