package linkedlist;

public class UnionOfTwoLinkedList implements LinkedListUtil{

    public static void main(String[] args) {

        UnionOfTwoLinkedList linkedListUtil = new UnionOfTwoLinkedList();
        ListNode headNodeOne = null;
        headNodeOne = linkedListUtil.insertAtFrontBegin(headNodeOne, 37);
        headNodeOne = linkedListUtil.insertAtFrontBegin(headNodeOne, 8);
        headNodeOne = linkedListUtil.insertAtFrontBegin(headNodeOne, 13);
        headNodeOne = linkedListUtil.insertAtFrontBegin(headNodeOne, 18);

        ListNode headNodeTwo = null;
        headNodeTwo = linkedListUtil.insertAtFrontBegin(headNodeTwo, 18);
        headNodeTwo = linkedListUtil.insertAtFrontBegin(headNodeTwo, 14);
        headNodeTwo = linkedListUtil.insertAtFrontBegin(headNodeTwo, 8);

        linkedListUtil.printLinkedListIterative(headNodeOne);
        linkedListUtil.printLinkedListIterative(headNodeTwo);

        ListNode headNodeUnion = linkedListUtil.findUnionOfLinkedList (headNodeOne, headNodeTwo);
        System.out.print("Union of Linked List : ");
        linkedListUtil.printLinkedListIterative(headNodeUnion);
    }

    public ListNode findUnionOfLinkedList(ListNode headNodeOne, ListNode headNodeTwo) {

        ListNode sortedLLOne = this.sortLinkedList(headNodeOne);
        ListNode sortedLLTwo = this.sortLinkedList(headNodeTwo);

        return mergeLinkedListWithUnion (sortedLLOne, sortedLLTwo);
    }

    public ListNode mergeLinkedListWithUnion(ListNode sortedLLOne, ListNode sortedLLTwo) {

        ListNode tempNode = new ListNode();
        ListNode finalList = tempNode;

        while (sortedLLOne != null && sortedLLTwo != null) {

            if (sortedLLOne.data < sortedLLTwo.data) {
                tempNode.next = sortedLLOne;
                sortedLLOne = sortedLLOne.next;
            } else if (sortedLLOne.data > sortedLLTwo.data) {
                tempNode.next = sortedLLTwo;
                sortedLLTwo = sortedLLTwo.next;
            } else {
                tempNode.next = sortedLLOne;
                sortedLLOne = sortedLLOne.next;
                sortedLLTwo = sortedLLTwo.next;
            }
            tempNode = tempNode.next;
        }

        if (sortedLLOne != null) {
            tempNode.next = sortedLLOne;
        } else if (sortedLLTwo != null) {
            tempNode.next = sortedLLTwo;
        }

        return finalList.next;
    }
}
