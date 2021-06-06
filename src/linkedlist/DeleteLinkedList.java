package linkedlist;

public class DeleteLinkedList implements LinkedListUtil{

    public static void main(String[] args) {

        DeleteLinkedList linkedListUtil = new DeleteLinkedList();
        ListNode headNodeOne = null;
        headNodeOne = linkedListUtil.insertAtEndIterative(headNodeOne, 1);
        headNodeOne = linkedListUtil.insertAtEndIterative(headNodeOne, 2);
        headNodeOne = linkedListUtil.insertAtEndIterative(headNodeOne, 3);
        headNodeOne = linkedListUtil.insertAtEndIterative(headNodeOne, 4);
        headNodeOne = linkedListUtil.insertAtEndIterative(headNodeOne, 5);

    }

    public void deleteLinkedList (ListNode headNode) {

        headNode = null;
    }
}
