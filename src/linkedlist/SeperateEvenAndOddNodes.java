package linkedlist;

public class SeperateEvenAndOddNodes implements LinkedListUtil{

    public static void main(String[] args) {
        SeperateEvenAndOddNodes linkedListUtil = new SeperateEvenAndOddNodes();
        ListNode headNode = null;
        headNode = linkedListUtil.insertAtEndIterative(headNode, 1);
        headNode = linkedListUtil.insertAtEndIterative(headNode, 2);
        headNode = linkedListUtil.insertAtEndIterative(headNode, 3);
        headNode = linkedListUtil.insertAtEndIterative(headNode, 4);
        headNode = linkedListUtil.insertAtEndIterative(headNode, 5);
        headNode = linkedListUtil.insertAtEndIterative(headNode, 6);
        headNode = linkedListUtil.insertAtEndIterative(headNode, 7);
        headNode = linkedListUtil.insertAtEndIterative(headNode, 8);
        headNode = linkedListUtil.insertAtEndIterative(headNode, 9);
        headNode = linkedListUtil.insertAtEndIterative(headNode, 10);
        headNode = linkedListUtil.insertAtEndIterative(headNode, 11);
        headNode = linkedListUtil.insertAtEndIterative(headNode, 12);
        headNode = linkedListUtil.insertAtEndIterative(headNode, 13);
        headNode = linkedListUtil.insertAtEndIterative(headNode, 14);
        linkedListUtil.printLinkedListRecursive(headNode);
        headNode = linkedListUtil.separateEvenAndOddList(headNode);
        linkedListUtil.printLinkedListRecursive(headNode);
    }

    public ListNode separateEvenAndOddList (ListNode headNode) {

        if (headNode == null || headNode.next == null) {
            return headNode;
        }

        ListNode currentNode = headNode;
        ListNode evenStartNode = null;
        ListNode evenEndNode = null;
        ListNode oddStartNode = null;
        ListNode oddEndNode = null;

        while (currentNode != null) {

            int data = currentNode.data;
            if (data % 2 == 0) {

                //Even
                if (evenStartNode == null) {
                    evenStartNode = currentNode;
                    evenEndNode = currentNode;
                } else {
                    evenEndNode.next = currentNode;
                    evenEndNode = evenEndNode.next;
                }
            } else {

                //Odd
                if (oddStartNode == null) {
                    oddStartNode = currentNode;
                    oddEndNode = currentNode;
                } else {
                    oddEndNode.next = currentNode;
                    oddEndNode = oddEndNode.next;
                }
            }
            currentNode = currentNode.next;
        }
        evenEndNode.next = oddStartNode;
        oddEndNode.next = null;
        return evenStartNode;
    }

}
