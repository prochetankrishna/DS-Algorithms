package linkedlist;

public class ReverseListAlternativelyInGroupOfK implements LinkedListUtil{

    public static void main(String[] args) {
        ReverseListAlternativelyInGroupOfK linkedListUtil = new ReverseListAlternativelyInGroupOfK();
        ListNode headNode = null;
        headNode = linkedListUtil.insertAtEndIterative(headNode, 4);
        headNode = linkedListUtil.insertAtEndIterative(headNode, 6);
        headNode = linkedListUtil.insertAtEndIterative(headNode, 5);
        headNode = linkedListUtil.insertAtEndIterative(headNode, 3);
        headNode = linkedListUtil.insertAtEndIterative(headNode, 2);
        headNode = linkedListUtil.insertAtEndIterative(headNode, 1);
        headNode = linkedListUtil.insertAtEndIterative(headNode, 10);
        headNode = linkedListUtil.insertAtEndIterative(headNode, 12);
        headNode = linkedListUtil.insertAtEndIterative(headNode, 14);
        headNode = linkedListUtil.insertAtEndIterative(headNode, 16);
        headNode = linkedListUtil.insertAtEndIterative(headNode, 18);
        headNode = linkedListUtil.insertAtEndIterative(headNode, 20);
        headNode = linkedListUtil.insertAtEndIterative(headNode, 22);
        headNode = linkedListUtil.insertAtEndIterative(headNode, 24);
        linkedListUtil.printLinkedListRecursive(headNode);
        headNode = linkedListUtil.reverseAlternativelyInGroupOfK(headNode, 3);
        linkedListUtil.printLinkedListRecursive(headNode);
    }

    public ListNode reverseAlternativelyInGroupOfK (ListNode headNode, int K) {

        if (headNode == null || headNode.next == null) {
            return headNode;
        }

        if (K <= 0) {
            return headNode;
        }

        ListNode currentNode = headNode;
        ListNode nextNode = null;
        ListNode prevNode = null;

        int count = 0;
        while (count < K && currentNode != null) {
            nextNode = currentNode.next;
            currentNode.next = prevNode;
            prevNode = currentNode;
            currentNode = nextNode;
            count++;
        }

        count = 0;
        if (nextNode != null) {
            headNode.next = nextNode;
            currentNode = nextNode;
            while (currentNode != null && count < K - 1) {
                currentNode = currentNode.next;
                count++;
            }
            if (currentNode != null) {
                currentNode.next = reverseAlternativelyInGroupOfK(currentNode.next, K);
            }
        }
        return prevNode;
    }
}
