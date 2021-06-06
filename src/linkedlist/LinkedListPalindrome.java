package linkedlist;

import java.util.Stack;

public class LinkedListPalindrome implements LinkedListUtil{

    public static void main(String[] args) {

        LinkedListPalindrome linkedListUtil = new LinkedListPalindrome();
        ListNode headNode = null;
        headNode = linkedListUtil.insertAtEndIterative(headNode, 1);
        headNode = linkedListUtil.insertAtEndIterative(headNode, 2);
        headNode = linkedListUtil.insertAtEndIterative(headNode, 3);
        headNode = linkedListUtil.insertAtEndIterative(headNode, 2);
        headNode = linkedListUtil.insertAtEndIterative(headNode, 1);

        linkedListUtil.printLinkedListIterative(headNode);
        if (checkPalindrome(headNode)) {
            System.out.println("Linked List is Palindrome");
        } else {
            System.out.println("Linked List is not Palindrome");
        }
    }

    /*private static boolean checkPalindromeWithoutExtraSpace (LinkedList <Character> linkedList) {

        LinkedList<Character>.LinkNode<Character> slowPtr = linkedList.getHead();
        LinkedList<Character>.LinkNode<Character> fastPtr = linkedList.getHead();
        LinkedList<Character>.LinkNode<Character> prevOfSlowPtr = linkedList.getHead();
        LinkedList<Character>.LinkNode<Character> midNode = null; //Odd Size List

        if (linkedList.getHead() != null && linkedList.getHead().next != null) {

            while (fastPtr != null && fastPtr.next != null) {
                fastPtr = fastPtr.next.next;
                prevOfSlowPtr = slowPtr;
                slowPtr = slowPtr.next;
            }

            //Odd Size list
            if (fastPtr != null) {
                midNode = slowPtr;
                slowPtr = slowPtr.next;
            }


        }
    }*/

    private static boolean checkPalindrome (ListNode headNode) {

        if (headNode == null) {
            return true;
        }

        Stack<Integer> stack = new Stack<>();
        ListNode temp = headNode;

        while (temp != null) {
            stack.push (temp.data);
            temp = temp.next;
        }

        temp = headNode;
        while (temp != null) {
            if (temp.data == stack.peek()) {
                stack.pop();
                temp = temp.next;
            } else {
                return false;
            }
        }
        return true;
    }
}
