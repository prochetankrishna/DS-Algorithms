package linkedlist;

import java.util.List;

public class SplitLinkedListAlternatively implements LinkedListUtil{

    public static void main(String[] args) {
        SplitLinkedListAlternatively linkedListUtil = new SplitLinkedListAlternatively();
        ListNode headNode = null;
        headNode = linkedListUtil.insertAtFrontBegin(headNode, 1);
        headNode = linkedListUtil.insertAtFrontBegin(headNode, 2);
        headNode = linkedListUtil.insertAtFrontBegin(headNode, 3);
        headNode = linkedListUtil.insertAtFrontBegin(headNode, 4);
        headNode = linkedListUtil.insertAtFrontBegin(headNode, 5);
        headNode = linkedListUtil.insertAtFrontBegin(headNode, 6);
        headNode = linkedListUtil.insertAtFrontBegin(headNode, 7);
        headNode = linkedListUtil.insertAtFrontBegin(headNode, 8);
        headNode = linkedListUtil.insertAtFrontBegin(headNode, 9);

        linkedListUtil.printLinkedListIterative(headNode);
        linkedListUtil.splitLinkedListAlternatively(headNode);
    }

    public void splitLinkedListAlternatively (ListNode headNode) {

        if(headNode == null || headNode.next == null) {
            return;
        }

        ListNode headOne = null;
        ListNode headTwo = null;

        ListNode currentNodeOne = null;
        ListNode currentNodeTwo = null;

        ListNode currentNode = headNode;
        boolean isFirst = true;

        while (currentNode != null) {
            if (isFirst) {
                if(currentNodeOne == null) {
                    headOne = currentNode;
                    currentNodeOne = currentNode;
                } else {
                    currentNodeOne.next = currentNode;
                    currentNodeOne = currentNodeOne.next;
                }
                currentNode = currentNode.next;
                isFirst = false;
            } else {
                if(currentNodeTwo == null) {
                    headTwo = currentNode;
                    currentNodeTwo = currentNode;
                } else {
                    currentNodeTwo.next = currentNode;
                    currentNodeTwo = currentNodeTwo.next;
                }
                currentNode = currentNode.next;
                isFirst = true;
            }
        }

        currentNodeOne.next = null;
        currentNodeTwo.next = null;
        printLinkedListIterative(headOne);
        printLinkedListIterative(headTwo);
    }
}
