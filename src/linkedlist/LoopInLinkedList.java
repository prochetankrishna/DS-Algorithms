package linkedlist;

public class LoopInLinkedList extends LinkedListUtil{

    public static void main(String[] args) {

        LoopInLinkedList linkedListUtil = new LoopInLinkedList();
        Node headNode = null;
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

    public boolean isLoopExistsInLL (Node headNode) {

        if (headNode == null) {
            return false;
        }

        Node fastPtr = headNode;
        Node slowPtr = headNode;

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
