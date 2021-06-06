package linkedlist;

public class RotateLinkedListAntiClockWise implements LinkedListUtil{

    public static void main(String[] args) {

        RotateLinkedListAntiClockWise linkedListUtil = new RotateLinkedListAntiClockWise();
        ListNode headNode = null;
        headNode = linkedListUtil.insertAtEndRecursive(headNode, 1);
        headNode = linkedListUtil.insertAtEndRecursive(headNode, 2);
        headNode = linkedListUtil.insertAtEndRecursive(headNode, 3);
        headNode = linkedListUtil.insertAtEndRecursive(headNode, 4);
        headNode = linkedListUtil.insertAtEndRecursive(headNode, 5);
        linkedListUtil.printLinkedListRecursive(headNode);
        headNode = linkedListUtil.rotateLinkedListAntiClockWise(headNode, 1);
        linkedListUtil.printLinkedListIterative(headNode);
    }

    private ListNode rotateLinkedListAntiClockWise(ListNode headNode, int numberOfRotations) {

        if (headNode == null || numberOfRotations < 0) {
            return headNode;
        }

        int sizeOfLinkedList = this.lengthOfLinkedListIterative(headNode);
        numberOfRotations = numberOfRotations % sizeOfLinkedList;
        if (numberOfRotations == 0) {
            return headNode;
        }

        int i = 1;
        ListNode tempNode = headNode;
        while (i < numberOfRotations) {
            tempNode = tempNode.next;
            i++;
        }

        ListNode newRootNode = tempNode.next;
        tempNode.next = null;

        ListNode nextNode = newRootNode;
        while (nextNode.next != null) {
            nextNode = nextNode.next;
        }

        nextNode.next = headNode;
        return newRootNode;
    }
}
