package linkedlist;

public class LengthOfTheLoop extends LinkedListUtil{

    public static void main(String[] args) {

        LengthOfTheLoop linkedListUtil = new LengthOfTheLoop();
        Node headNode = null;
        headNode = linkedListUtil.insertAtEndRecursive(headNode, 1);
        headNode = linkedListUtil.insertAtEndRecursive(headNode, 2);
        headNode = linkedListUtil.insertAtEndRecursive(headNode, 3);
        headNode = linkedListUtil.insertAtEndRecursive(headNode, 4);
        headNode = linkedListUtil.insertAtEndRecursive(headNode, 5);

        System.out.println("Length of Loop : " + linkedListUtil.lengthOfLoopInLinkedList(headNode));
        headNode.next.next.next.next.next = headNode.next;
        System.out.println("Length of Loop : " + linkedListUtil.lengthOfLoopInLinkedList(headNode));
    }

    public int lengthOfLoopInLinkedList (Node headNode) {

        if (headNode == null || headNode.next == null) {
            return 0;
        }

        boolean isLoopExists = false;
        Node fastPtr = headNode;
        Node slowPtr = headNode;

        while (fastPtr != null && fastPtr.next != null) {
            fastPtr = fastPtr.next.next;
            slowPtr = slowPtr.next;
            if (slowPtr == fastPtr) {
                isLoopExists = true;
                break;
            }
        }

        if (!isLoopExists) {
            return 0;
        } else {
            int length = 0;
            while (slowPtr.next != fastPtr) {
                slowPtr = slowPtr.next;
                length++;
            }
            return length + 1;
        }
    }
}
