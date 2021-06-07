package linkedlist;

public class SwapNodeByLinks implements LinkedListUtil{

    public static void main(String[] args) {
        SwapNodeByLinks linkedListUtil = new SwapNodeByLinks();
        ListNode headNode = null;
        headNode = linkedListUtil.insertAtEndIterative(headNode, 1);
        headNode = linkedListUtil.insertAtEndIterative(headNode, 2);
        headNode = linkedListUtil.insertAtEndIterative(headNode, 3);
        headNode = linkedListUtil.insertAtEndIterative(headNode, 4);
        headNode = linkedListUtil.insertAtEndIterative(headNode, 5);
        linkedListUtil.printLinkedListIterative(headNode);
        headNode = linkedListUtil.swapNodeByChangingLinks(headNode, 2, 3);
        linkedListUtil.printLinkedListIterative(headNode);
    }

    public ListNode swapNodeByChangingLinks (ListNode headNode, int elementX, int elementY) {

        if (headNode == null) {
            return null;
        }

        /*
        Case 1 : elementX and elementY are not adjacent
        Case 2 : Either elementX or elementY is the head of the list
        Case 3 : Either elementX or elementY is the tail of the list
        Case 4 : Either elementX or elementY or both of them doesn't exists in list
        Case 5 : Both elementX and elementY are same
         */

        //Case 5
        if (elementX == elementY) {
            return headNode;
        }

        ListNode prevNodeX = null;
        ListNode currentNodeX = headNode;
        while (currentNodeX != null && currentNodeX.data != elementX) {
            prevNodeX = currentNodeX;
            currentNodeX = currentNodeX.next;
        }

        ListNode prevNodeY = null;
        ListNode currentNodeY = headNode;
        while (currentNodeY != null && currentNodeY.data != elementY) {
            prevNodeY = currentNodeY;
            currentNodeY = currentNodeY.next;
        }

        //Case 4
        if (currentNodeX == null || currentNodeY == null) {
            return headNode;
        }

        //Check whether elementX is not the head
        if (prevNodeX != null) {
            prevNodeX.next = currentNodeY;
        } else {
            headNode = currentNodeY;
        }

        //Check whether elementY is not the head
        if (prevNodeY != null) {
            prevNodeY.next = currentNodeX;
        } else {
            headNode = currentNodeX;
        }

        ListNode tempNode = currentNodeX.next;
        currentNodeX.next = currentNodeY.next;
        currentNodeY.next = tempNode;

        return headNode;
    }
}
