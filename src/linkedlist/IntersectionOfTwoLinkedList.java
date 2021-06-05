package linkedlist;

public class IntersectionOfTwoLinkedList extends LinkedListUtil{

    public static void main(String[] args) {

        IntersectionOfTwoLinkedList linkedListUtil = new IntersectionOfTwoLinkedList();
        ListNode rootNodeOne = null;
        rootNodeOne = linkedListUtil.insertAtFrontBegin(rootNodeOne, 37);
        rootNodeOne = linkedListUtil.insertAtFrontBegin(rootNodeOne, 8);
        rootNodeOne = linkedListUtil.insertAtFrontBegin(rootNodeOne, 13);
        rootNodeOne = linkedListUtil.insertAtFrontBegin(rootNodeOne, 18);

        ListNode rootNodeTwo = null;
        rootNodeTwo = linkedListUtil.insertAtFrontBegin(rootNodeTwo, 18);
        rootNodeTwo = linkedListUtil.insertAtFrontBegin(rootNodeTwo, 14);
        rootNodeTwo = linkedListUtil.insertAtFrontBegin(rootNodeTwo, 8);

        linkedListUtil.printLinkedListIterative(rootNodeOne);
        linkedListUtil.printLinkedListIterative(rootNodeTwo);

        ListNode intersectionRootNode = linkedListUtil.findIntersectionOfTwoLinkedList (rootNodeOne, rootNodeTwo);
        System.out.print("Intersection of Linked List : ");
        linkedListUtil.printLinkedListIterative(intersectionRootNode);
    }

    public ListNode findIntersectionOfTwoLinkedList(ListNode rootNodeOne, ListNode rootNodeTwo) {

        ListNode sortedLLOne = this.sortLinkedList(rootNodeOne);
        ListNode sortedLLTwo = this.sortLinkedList(rootNodeTwo);

        return mergeLinkedListWithIntersection (sortedLLOne, sortedLLTwo);
    }

    public ListNode mergeLinkedListWithIntersection(ListNode sortedLLOne, ListNode sortedLLTwo) {

        ListNode tempNode = new ListNode();
        ListNode finalList = tempNode;

        while (sortedLLOne != null && sortedLLTwo != null) {
            if (sortedLLOne.data < sortedLLTwo.data) {
                sortedLLOne = sortedLLOne.next;
            } else if (sortedLLOne.data > sortedLLTwo.data) {
                sortedLLTwo = sortedLLTwo.next;
            } else {
                tempNode.next = sortedLLOne;
                sortedLLOne = sortedLLOne.next;
                sortedLLTwo = sortedLLTwo.next;
                tempNode = tempNode.next;
            }
        }
        tempNode.next = null;
        return finalList.next;
    }


}
