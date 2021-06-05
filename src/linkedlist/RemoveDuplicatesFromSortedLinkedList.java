package linkedlist;

public class RemoveDuplicatesFromSortedLinkedList extends LinkedListUtil{

    public static void main(String[] args) {

        RemoveDuplicatesFromSortedLinkedList linkedListUtil = new RemoveDuplicatesFromSortedLinkedList();

        ListNode headNode = null;
        headNode = linkedListUtil.insertAtFrontBegin(headNode, 45);
        headNode = linkedListUtil.insertAtFrontBegin(headNode, 45);
        headNode = linkedListUtil.insertAtFrontBegin(headNode, 37);
        headNode = linkedListUtil.insertAtFrontBegin(headNode, 37);
        headNode = linkedListUtil.insertAtFrontBegin(headNode, 34);
        headNode = linkedListUtil.insertAtFrontBegin(headNode, 13);
        headNode = linkedListUtil.insertAtFrontBegin(headNode, 8);
        headNode = linkedListUtil.insertAtFrontBegin(headNode, 8);
        headNode = linkedListUtil.insertAtFrontBegin(headNode, 8);

        System.out.print("Linked List : ");
        linkedListUtil.printLinkedListIterative(headNode);


        ListNode uniqueLinkedList = linkedListUtil.removeDuplicatesFromSortedLinkedListIterative(headNode);
        System.out.print("Unique Linked List : ");
        linkedListUtil.printLinkedListIterative(uniqueLinkedList);
    }

    public ListNode removeDuplicatesFromSortedLinkedListIterative (ListNode headNode) {

        if (headNode == null || headNode.next == null) {
            return headNode;
        }

        ListNode tempNode = headNode;

        while (tempNode != null && tempNode.next != null) {
            if (tempNode.data == tempNode.next.data) {
                tempNode.next = tempNode.next.next;
            } else {
                tempNode = tempNode.next;
            }

        }
        return headNode;
    }

    public ListNode removeDuplicatesFromSortedLinkedListRecursive (ListNode headNode) {

        if (headNode == null || headNode.next == null) {
            return headNode;
        }

        if (headNode.data == headNode.next.data) {
            headNode.next = headNode.next.next;
            removeDuplicatesFromSortedLinkedListRecursive(headNode);
        } else {
            removeDuplicatesFromSortedLinkedListRecursive(headNode.next);
        }
        return headNode;
    }
}
