package linkedlist;

public class PairwiseSwapElementsChangingData implements LinkedListUtil{

    public static void main(String[] args) {
        PairwiseSwapElementsChangingData linkedListUtil = new PairwiseSwapElementsChangingData();
        ListNode headNode = null;
        headNode = linkedListUtil.insertAtEndIterative(headNode, 1);
        headNode = linkedListUtil.insertAtEndIterative(headNode, 2);
        headNode = linkedListUtil.insertAtEndIterative(headNode, 3);
        headNode = linkedListUtil.insertAtEndIterative(headNode, 4);
        headNode = linkedListUtil.insertAtEndIterative(headNode, 5);
        headNode = linkedListUtil.insertAtEndIterative(headNode, 6);

        linkedListUtil.printLinkedListIterative(headNode);
        linkedListUtil.swapPairWiseInLL(headNode);
        linkedListUtil.printLinkedListIterative(headNode);
    }

    public void swapPairWiseInLL (ListNode headNode) {

        if (headNode == null || headNode.next == null) {
            return;
        }

        ListNode tempNode = headNode;
        while (tempNode != null && tempNode.next != null) {
            int data = tempNode.next.data;
            tempNode.next.data = tempNode.data;
            tempNode.data = data;

            tempNode = tempNode.next.next;
        }
    }
}
