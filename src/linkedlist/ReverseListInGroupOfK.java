package linkedlist;

import java.util.Stack;

public class ReverseListInGroupOfK implements LinkedListUtil{

    public static void main(String[] args) {
        ReverseListInGroupOfK linkedListUtil = new ReverseListInGroupOfK();

        ListNode headNodeOne = null;
        headNodeOne = linkedListUtil.insertAtEndIterative(headNodeOne, 4);
        headNodeOne = linkedListUtil.insertAtEndIterative(headNodeOne, 6);
        headNodeOne = linkedListUtil.insertAtEndIterative(headNodeOne, 5);
        headNodeOne = linkedListUtil.insertAtEndIterative(headNodeOne, 3);
        headNodeOne = linkedListUtil.insertAtEndIterative(headNodeOne, 2);
        headNodeOne = linkedListUtil.insertAtEndIterative(headNodeOne, 1);
        headNodeOne = linkedListUtil.insertAtEndIterative(headNodeOne, 10);
        headNodeOne = linkedListUtil.insertAtEndIterative(headNodeOne, 12);
        linkedListUtil.printLinkedListIterative(headNodeOne);
        headNodeOne = linkedListUtil.reverseLinkedListInGroupOfK(headNodeOne, 3);
        linkedListUtil.printLinkedListIterative(headNodeOne);
        headNodeOne = linkedListUtil.reverseListInGroupOfKUsingStack(headNodeOne, 3);
        linkedListUtil.printLinkedListIterative(headNodeOne);
    }

    public ListNode reverseLinkedListInGroupOfK (ListNode headNode, int K) {

        if (headNode == null) {
            return null;
        }

        if (K <= 1) {
            return headNode;
        }

        int count = 0;
        ListNode currentNode = headNode;
        ListNode nextNode = null;
        ListNode prevNode = null;

        while (count < K && currentNode != null) {
            nextNode = currentNode.next;
            currentNode.next = prevNode;
            prevNode = currentNode;
            currentNode = nextNode;
            count++;
        }

        if (nextNode != null) {
            headNode.next = reverseLinkedListInGroupOfK(nextNode, K);
        }
        return prevNode;
    }

    public ListNode reverseListInGroupOfKUsingStack (ListNode headNode, int K) {

        if (headNode == null) {
            return null;
        }

        if (K <= 1) {
            return headNode;
        }

        Stack<ListNode> stack = new Stack<>();
        ListNode currentNode = headNode;
        ListNode prevNode = null;

        while (currentNode != null) {

            int count = 0;
            while (currentNode != null && count < K) {
                stack.push(currentNode);
                currentNode = currentNode.next;
                count++;
            }

            while (!stack.isEmpty()) {

                if (prevNode == null) {
                    prevNode = stack.pop();
                    headNode = prevNode;
                } else {
                    prevNode.next = stack.pop();
                    prevNode = prevNode.next;
                }
            }
        }

        prevNode.next = null;
        return headNode;
    }
}
