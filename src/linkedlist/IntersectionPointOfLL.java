package linkedlist;

public class IntersectionPointOfLL implements LinkedListUtil{

    public static void main(String[] args) {
        IntersectionPointOfLL linkedListUtil = new IntersectionPointOfLL();

        ListNode headNodeOne = null;
        headNodeOne = linkedListUtil.insertAtEndIterative(headNodeOne, 4);
        headNodeOne = linkedListUtil.insertAtEndIterative(headNodeOne, 4);
        headNodeOne = linkedListUtil.insertAtEndIterative(headNodeOne, 5);
        headNodeOne = linkedListUtil.insertAtEndIterative(headNodeOne, 3);
        headNodeOne = linkedListUtil.insertAtEndIterative(headNodeOne, 2);
        headNodeOne = linkedListUtil.insertAtEndIterative(headNodeOne, 1);

        ListNode headNodeTwo = null;
        headNodeTwo = linkedListUtil.insertAtEndIterative(headNodeTwo, 1);
        headNodeTwo = linkedListUtil.insertAtEndIterative(headNodeTwo, 2);
        headNodeTwo = linkedListUtil.insertAtEndIterative(headNodeTwo, 3);
        headNodeTwo = linkedListUtil.insertAtEndIterative(headNodeTwo, 2);
        headNodeTwo = linkedListUtil.insertAtEndIterative(headNodeTwo, 1);

        ListNode intersectionNode = linkedListUtil.intersectionPointOfLinkedList(headNodeOne, headNodeTwo);
        if (intersectionNode != null) {
            System.out.println("Intersection Node  : [" + intersectionNode.data + "]");
        } else {
            System.out.println("No Intersection Node found !!");
        }
    }

    public ListNode intersectionPointOfLinkedList (ListNode headNodeOne, ListNode headNodeTwo) {

        if (headNodeOne == null && headNodeTwo == null) {
            return null;
        }

        if (headNodeOne == null || headNodeTwo == null) {
            return null;
        }

        int lengthOfLLOne = lengthOfLinkedListIterative(headNodeOne);
        int lengthOfLLTwo = lengthOfLinkedListIterative(headNodeTwo);

        ListNode currentHeadOne = headNodeOne;
        ListNode currentHeadTwo = headNodeTwo;

        if (lengthOfLLOne > lengthOfLLTwo) {
            int diff = lengthOfLLOne - lengthOfLLTwo;
            while (diff > 0) {
                currentHeadOne = currentHeadOne.next;
                diff--;
            }
        } else if (lengthOfLLOne < lengthOfLLTwo) {
            int diff = lengthOfLLTwo - lengthOfLLOne;
            while (diff > 0) {
                currentHeadTwo = currentHeadTwo.next;
                diff--;
            }
        }

        while (currentHeadOne != null && currentHeadTwo != null) {
            if (currentHeadOne.data == currentHeadTwo.data) {
                return currentHeadOne;
            }
            currentHeadOne = currentHeadOne.next;
            currentHeadTwo = currentHeadTwo.next;
        }

        return null;
    }
}
