package linkedlist;

public class LoopInLinkedList implements LinkedListUtil{

    public static void main(String[] args) {

        LoopInLinkedList linkedListUtil = new LoopInLinkedList();
        ListNode headNode = null;
        headNode = linkedListUtil.insertAtEndRecursive(headNode, 1);
        headNode = linkedListUtil.insertAtEndRecursive(headNode, 2);
        headNode = linkedListUtil.insertAtEndRecursive(headNode, 3);
        headNode = linkedListUtil.insertAtEndRecursive(headNode, 4);
        headNode = linkedListUtil.insertAtEndRecursive(headNode, 5);
        linkedListUtil.printLinkedListIterative(headNode);

        headNode.next.next.next.next.next = headNode.next;
        //linkedListUtil.printLinkedListIterative(headNode);
        System.out.println("Loop Exists ? : " + linkedListUtil.isLoopExistsInLL(headNode));
    }

    public boolean isLoopExistsInLL (ListNode headNode) {

        if (headNode == null) {
            return false;
        }

        ListNode fastPtr = headNode;
        ListNode slowPtr = headNode;

        while (fastPtr != null && fastPtr.next != null) {

            slowPtr = slowPtr.next;
            fastPtr = fastPtr.next.next;

            if (slowPtr == fastPtr) {
                return true;
            }
        }
        return false;
    }
}
