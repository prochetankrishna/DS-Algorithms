package linkedlist;

public class CheckIfFirstAndSecondHalfMatch implements LinkedListUtil{

    public static void main(String[] args) {
        
        CheckIfFirstAndSecondHalfMatch linkedListUtil = new CheckIfFirstAndSecondHalfMatch();
        ListNode headNodeOne = null;
        headNodeOne = linkedListUtil.insertAtEndIterative(headNodeOne, 1);
        headNodeOne = linkedListUtil.insertAtEndIterative(headNodeOne, 2);
        headNodeOne = linkedListUtil.insertAtEndIterative(headNodeOne, 3);
        headNodeOne = linkedListUtil.insertAtEndIterative(headNodeOne, 4);
        headNodeOne = linkedListUtil.insertAtEndIterative(headNodeOne, 5);

        ListNode headNodeTwo = null;
        headNodeTwo = linkedListUtil.insertAtEndIterative(headNodeTwo, 1);
        headNodeTwo = linkedListUtil.insertAtEndIterative(headNodeTwo, 2);
        headNodeTwo = linkedListUtil.insertAtEndIterative(headNodeTwo, 3);
        headNodeTwo = linkedListUtil.insertAtEndIterative(headNodeTwo, 1);
        headNodeTwo = linkedListUtil.insertAtEndIterative(headNodeTwo, 2);

        ListNode headNodeThree = null;
        headNodeThree = linkedListUtil.insertAtEndIterative(headNodeThree, 1);
        headNodeThree = linkedListUtil.insertAtEndIterative(headNodeThree, 2);
        headNodeThree = linkedListUtil.insertAtEndIterative(headNodeThree, 3);
        headNodeThree = linkedListUtil.insertAtEndIterative(headNodeThree, 1);
        headNodeThree = linkedListUtil.insertAtEndIterative(headNodeThree, 2);
        headNodeThree = linkedListUtil.insertAtEndIterative(headNodeThree, 3);

        ListNode headNodeFour = null;
        headNodeFour = linkedListUtil.insertAtEndIterative(headNodeFour, 1);
        headNodeFour = linkedListUtil.insertAtEndIterative(headNodeFour, 2);
        headNodeFour = linkedListUtil.insertAtEndIterative(headNodeFour, 1);
        headNodeFour = linkedListUtil.insertAtEndIterative(headNodeFour, 2);

        System.out.println(linkedListUtil.isFirstAndSecondHalfSame(headNodeOne));
        System.out.println(linkedListUtil.isFirstAndSecondHalfSame(headNodeTwo));
        System.out.println(linkedListUtil.isFirstAndSecondHalfSame(headNodeThree));
        System.out.println(linkedListUtil.isFirstAndSecondHalfSame(headNodeFour));

    }

    public boolean isFirstAndSecondHalfSame (ListNode headNode) {

        if (headNode == null || headNode.next == null) {
            return true;
        }

        ListNode middleNode = getMiddleNodeOfLinkedList(headNode);
        //System.out.println("Value of Middle Node : [" + middleNode.data + "]");
        //this.printLinkedListIterative(headNode);
        ListNode startFirstHalf = headNode;
        ListNode startSecondHalf = middleNode.next;

        while (startSecondHalf != null) {
            if (startFirstHalf.data != startSecondHalf.data) {
                return false;
            }
            startFirstHalf = startFirstHalf.next;
            startSecondHalf = startSecondHalf.next;
        }
        return true;
    }
}
