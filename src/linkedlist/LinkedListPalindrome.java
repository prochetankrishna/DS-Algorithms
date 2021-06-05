package linkedlist;

import java.util.Stack;

public class LinkedListPalindrome {

    public static void main(String[] args) {

        LinkedList<Character> linkedList = new LinkedList<>();
        linkedList.insertAtBeginning('R');
        linkedList.insertAtBeginning('A');
        linkedList.insertAtBeginning('D');
        linkedList.insertAtBeginning('A');
        linkedList.insertAtBeginning('R');

        linkedList.printLinkedList();
        if (checkPalindrome(linkedList)) {
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

    private static boolean checkPalindrome (LinkedList <Character> linkedList) {

        if (linkedList.head == null) {
            return true;
        }

        Stack<Character> stack = new Stack<>();
        LinkedList<Character>.LinkNode<Character> temp = linkedList.getHead();

        while (temp != null) {
            stack.push (temp.data);
            temp = temp.next;
        }

        temp = linkedList.getHead();
        while (temp != null) {
            if (temp.data.equals(stack.peek())) {
                stack.pop();
                temp = temp.next;
            } else {
                return false;
            }
        }
        return true;
    }
}
