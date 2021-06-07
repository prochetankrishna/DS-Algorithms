package linkedlist;

public class MoveLastNodeToFront implements LinkedListUtil {

    public static void main(String[] args) {
        MoveLastNodeToFront linkedListUtil = new MoveLastNodeToFront();
        ListNode headNode = null;
        headNode = linkedListUtil.insertAtEndIterative(headNode, 1);
        headNode = linkedListUtil.insertAtEndIterative(headNode, 2);
        headNode = linkedListUtil.insertAtEndIterative(headNode, 3);
        headNode = linkedListUtil.insertAtEndIterative(headNode, 4);
        headNode = linkedListUtil.insertAtEndIterative(headNode, 5);
        linkedListUtil.printLinkedListIterative(headNode);
        headNode = linkedListUtil.moveLastNodeToFront(headNode);
        linkedListUtil.printLinkedListIterative(headNode);
    }

    public ListNode moveLastNodeToFront (ListNode headNode) {

        if (headNode == null || headNode.next == null) {
            return headNode;
        }

        ListNode currentNode = headNode;

        while (currentNode.next.next != null) {
            currentNode = currentNode.next;
        }

        currentNode.next.next = headNode.next;
        headNode.next = null;

        ListNode newHead = currentNode.next;
        currentNode.next = headNode;
        return newHead;
    }
}
