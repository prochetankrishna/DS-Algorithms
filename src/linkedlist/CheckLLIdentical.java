package linkedlist;

public class CheckLLIdentical extends LinkedListUtil{

    public static void main(String[] args) {
        CheckLLIdentical linkedListUtil = new CheckLLIdentical();

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
        headNodeTwo = linkedListUtil.insertAtEndIterative(headNodeTwo, 2);
        headNodeTwo = linkedListUtil.insertAtEndIterative(headNodeTwo, 1);

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
        headNodeFour = linkedListUtil.insertAtEndIterative(headNodeFour, 3);
        headNodeFour = linkedListUtil.insertAtEndIterative(headNodeFour, 1);
        headNodeFour = linkedListUtil.insertAtEndIterative(headNodeFour, 2);
        headNodeFour = linkedListUtil.insertAtEndIterative(headNodeFour, 3);

        System.out.println(linkedListUtil.isLLIdentical(headNodeOne, headNodeTwo));
        System.out.println(linkedListUtil.isLLIdentical(headNodeThree, headNodeFour));
    }

    public boolean isLLIdentical (ListNode headNodeOne, ListNode headNodeTwo) {

        while (headNodeOne != null && headNodeTwo != null) {
            if (headNodeOne.data != headNodeTwo.data) {
                return false;
            }
            headNodeOne = headNodeOne.next;
            headNodeTwo = headNodeTwo.next;
        }

        return (headNodeTwo == null && headNodeTwo == null);
    }
}
