package linkedlist;

public class DeleteGreaterValuesOnRight implements LinkedListUtil{

    public static void main(String[] args) {

        DeleteGreaterValuesOnRight linkedListUtil = new DeleteGreaterValuesOnRight();
        ListNode headNode = null;
        headNode = linkedListUtil.insertAtEndIterative(headNode, 12);
        headNode = linkedListUtil.insertAtEndIterative(headNode, 99);
        headNode = linkedListUtil.insertAtEndIterative(headNode, 8);
        headNode = linkedListUtil.insertAtEndIterative(headNode, 39);
        headNode = linkedListUtil.insertAtEndIterative(headNode, 5);
        //headNode = linkedListUtil.insertAtEndIterative(headNode, 101);


        linkedListUtil.printLinkedListIterative(headNode);
        ListNode newListNode = linkedListUtil.deleteGreaterValuesOnRight(headNode);
        linkedListUtil.printLinkedListIterative(newListNode);
    }

    public ListNode deleteGreaterValuesOnRight (ListNode headNode) {

        if (headNode == null || headNode.next == null) {
            return headNode;
        }

        ListNode reversedNode = this.reverseLinkedListIterative(headNode);
        //printLinkedListIterative(reversedNode);

        ListNode currentNode = reversedNode;
        ListNode maximumNode = reversedNode;

        ListNode tempNode;
        while (currentNode != null && currentNode.next != null) {
            if (currentNode.next.data < maximumNode.data) {
                tempNode = currentNode.next;
                currentNode.next = tempNode.next;
                tempNode = null;
            } else {
                currentNode = currentNode.next;
                maximumNode = currentNode;
            }
        }
        ListNode resultList = this.reverseLinkedListRecursive(reversedNode);
        return resultList;
    }
}
