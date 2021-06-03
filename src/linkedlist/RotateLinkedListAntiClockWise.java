package linkedlist;

public class RotateLinkedListAntiClockWise extends LinkedListUtil{

    public static void main(String[] args) {

        RotateLinkedListAntiClockWise linkedListUtil = new RotateLinkedListAntiClockWise();
        Node rootNode = null;
        rootNode = linkedListUtil.insertAtEndRecursive(rootNode, 12);
        rootNode = linkedListUtil.insertAtEndRecursive(rootNode, 99);
        rootNode = linkedListUtil.insertAtEndRecursive(rootNode, 37);
        rootNode = linkedListUtil.insertAtEndRecursive(rootNode, 8);
        rootNode = linkedListUtil.insertAtEndRecursive(rootNode, 18);
        linkedListUtil.printLinkedListRecursive(rootNode);
        rootNode = linkedListUtil.rotateLinkedListAntiClockWise(rootNode, 2);
        linkedListUtil.printLinkedListIterative(rootNode);
    }

    private Node rotateLinkedListAntiClockWise(Node rootNode, int numberOfRotations) {

        if (rootNode == null || numberOfRotations < 0) {
            return rootNode;
        }

        int sizeOfLinkedList = this.lengthOfLinkedListIterative(rootNode);
        numberOfRotations = numberOfRotations % sizeOfLinkedList;
        if (numberOfRotations == 0) {
            return rootNode;
        }

        int i = 1;
        Node tempNode = rootNode;
        while (i < numberOfRotations) {
            tempNode = tempNode.next;
            i++;
        }

        Node newRootNode = tempNode.next;
        tempNode.next = null;

        Node nextNode = newRootNode;
        while (nextNode.next != null) {
            nextNode = nextNode.next;
        }

        nextNode.next = rootNode;
        return newRootNode;
    }
}
