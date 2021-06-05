package linkedlist;


public class LowestCommonNodeInTwoLinkedList extends IntersectionOfTwoLinkedList{

    public static void main(String[] args) {

        LowestCommonNodeInTwoLinkedList linkedListUtil = new LowestCommonNodeInTwoLinkedList();

        ListNode headNodeOne = null;
        headNodeOne = linkedListUtil.insertAtFrontBegin(headNodeOne, 37);
        headNodeOne = linkedListUtil.insertAtFrontBegin(headNodeOne, 8);
        headNodeOne = linkedListUtil.insertAtFrontBegin(headNodeOne, 13);
        headNodeOne = linkedListUtil.insertAtFrontBegin(headNodeOne, 18);

        ListNode headNodeTwo = null;
        headNodeTwo = linkedListUtil.insertAtFrontBegin(headNodeTwo, 18);
        headNodeTwo = linkedListUtil.insertAtFrontBegin(headNodeTwo, 14);
        headNodeTwo = linkedListUtil.insertAtFrontBegin(headNodeTwo, 8);

        System.out.print("Linked List 1 : ");
        linkedListUtil.printLinkedListIterative(headNodeOne);

        System.out.print("Linked List 2 : ");
        linkedListUtil.printLinkedListIterative(headNodeTwo);

        ListNode lowestCommonNode = linkedListUtil.findLowestCommonInBothLinkedList(headNodeOne, headNodeTwo);
        if (lowestCommonNode != null) {
            System.out.println("Lowest Common ListNode : " + lowestCommonNode.data);
        } else {
            System.out.println("No Common ListNode Exists !");
        }

    }

    public ListNode findLowestCommonInBothLinkedList (ListNode headNodeOne, ListNode headNodeTwo) {

        ListNode intersectionOfTwoLinkedList = this.findIntersectionOfTwoLinkedList(headNodeOne, headNodeTwo);
        System.out.print("Intersection of Two Linked List : " );
        this.printLinkedListIterative(intersectionOfTwoLinkedList);

        if (intersectionOfTwoLinkedList != null) {
            intersectionOfTwoLinkedList.next = null;
            return intersectionOfTwoLinkedList;
        } else {
            return null;
        }
    }
}
