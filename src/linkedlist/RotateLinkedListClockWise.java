package linkedlist;

public class RotateLinkedListClockWise implements LinkedListUtil {

    public static void main(String[] args) {

        RotateLinkedListClockWise linkedListUtil = new RotateLinkedListClockWise();
        ListNode headNode = null;
        headNode = linkedListUtil.insertAtEndRecursive(headNode, 1);
        headNode = linkedListUtil.insertAtEndRecursive(headNode, 2);
        headNode = linkedListUtil.insertAtEndRecursive(headNode, 3);
        headNode = linkedListUtil.insertAtEndRecursive(headNode, 4);
        headNode = linkedListUtil.insertAtEndRecursive(headNode, 5);

        linkedListUtil.printLinkedListRecursive(headNode);
        headNode = linkedListUtil.rotateLinkedListClockWise(headNode, 1);
        linkedListUtil.printLinkedListIterative(headNode);
    }

    public ListNode rotateLinkedListClockWise (ListNode headNode, int numberOfRotations) {

        if (numberOfRotations <= 0) {
            return headNode;
        }

        int sizeOfLinkedList = this.lengthOfLinkedListIterative(headNode);
        numberOfRotations = numberOfRotations % sizeOfLinkedList;

        if (numberOfRotations == 0) {
            return headNode;
        }

        ListNode tempNode = headNode;
        int i = 1;

        while (i < sizeOfLinkedList - numberOfRotations) {
            tempNode = tempNode.next;
            i++;
        }

        ListNode nextNode = tempNode.next;
        ListNode newHeadNode = nextNode;
        tempNode.next = null;

        while (nextNode.next != null) {
            nextNode = nextNode.next;
        }

        nextNode.next = headNode;
        return newHeadNode;
    }
}
