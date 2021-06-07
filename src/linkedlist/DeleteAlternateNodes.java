package linkedlist;

public class DeleteAlternateNodes implements LinkedListUtil{

    public static void main(String[] args) {
        DeleteAlternateNodes linkedListUtil = new DeleteAlternateNodes();
        ListNode headNode = null;
        headNode = linkedListUtil.insertAtEndIterative(headNode, 1);
        headNode = linkedListUtil.insertAtEndIterative(headNode, 2);
        headNode = linkedListUtil.insertAtEndIterative(headNode, 3);
        headNode = linkedListUtil.insertAtEndIterative(headNode, 4);
        headNode = linkedListUtil.insertAtEndIterative(headNode, 5);
        linkedListUtil.printLinkedListIterative(headNode);
        headNode = linkedListUtil.deleteAlternateNodes(headNode);
        linkedListUtil.printLinkedListIterative(headNode);
    }

    public ListNode deleteAlternateNodes (ListNode headNode) {

        if (headNode == null || headNode.next == null) {
            return headNode;
        }

        ListNode currentNode = headNode;

        while (currentNode != null && currentNode.next != null) {

            ListNode tempNode = currentNode.next;
            currentNode.next = tempNode.next;
            currentNode = currentNode.next;
        }

        return headNode;
    }
}
