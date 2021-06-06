package linkedlist;

import java.util.Stack;

public class CheckIfLLIsPalindrome implements LinkedListUtil{

    public static void main(String[] args) {

        CheckIfLLIsPalindrome linkedListUtil = new CheckIfLLIsPalindrome();
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
        headNodeFour = linkedListUtil.insertAtEndIterative(headNodeFour, 3);
        headNodeFour = linkedListUtil.insertAtEndIterative(headNodeFour, 2);
        headNodeFour = linkedListUtil.insertAtEndIterative(headNodeFour, 1);

        System.out.println(linkedListUtil.checkIfLLIsPalindrome(headNodeOne));
        System.out.println(linkedListUtil.checkIfLLIsPalindrome(headNodeTwo));
        System.out.println(linkedListUtil.checkIfLLIsPalindrome(headNodeThree));
        System.out.println(linkedListUtil.checkIfLLIsPalindrome(headNodeFour));
    }

    public boolean checkIfLLIsPalindrome (ListNode headNode) {

        if (headNode == null || headNode.next == null) {
            return true;
        }

        ListNode slowPtr = headNode;
        ListNode fastPtr = headNode;

        Stack<ListNode> stack = new Stack<>();
        stack.push(slowPtr);
        while (fastPtr.next != null && fastPtr.next.next != null) {
            slowPtr = slowPtr.next;
            fastPtr = fastPtr.next.next;

            stack.push(slowPtr);
        }

        if (fastPtr.next == null) {
            stack.pop();
        }
        ListNode startSecondHalf = slowPtr.next;

        while (startSecondHalf != null) {
            if (startSecondHalf.data != stack.peek().data) {
                return false;
            }
            startSecondHalf = startSecondHalf.next;
            stack.pop();
        }
        return true;
    }
}
