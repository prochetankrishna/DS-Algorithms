package linkedlist;

public class PairWiseSwapByChangingLinks implements LinkedListUtil{

    public static void main(String[] args) {
        PairWiseSwapByChangingLinks linkedListUtil = new PairWiseSwapByChangingLinks();
        ListNode headNode = null;
        headNode = linkedListUtil.insertAtEndIterative(headNode, 1);
        headNode = linkedListUtil.insertAtEndIterative(headNode, 2);
        headNode = linkedListUtil.insertAtEndIterative(headNode, 3);
        headNode = linkedListUtil.insertAtEndIterative(headNode, 4);
        headNode = linkedListUtil.insertAtEndIterative(headNode, 5);
        linkedListUtil.printLinkedListIterative(headNode);
        headNode = linkedListUtil.pairWiseSwapByChangingLinks(headNode);
        linkedListUtil.printLinkedListIterative(headNode);
    }

    public ListNode pairWiseSwapByChangingLinks (ListNode headNode) {

        if (headNode == null || headNode.next == null) {
            return headNode;
        }

        ListNode prevNode = headNode;
        ListNode currentNode = headNode.next;

        //Change Head
        headNode = currentNode;

        while (true) {
            ListNode nextNode = currentNode.next;
            currentNode.next = prevNode;

            if (nextNode == null || nextNode.next == null) {
                prevNode.next = nextNode;
                break;
            }

            // Change next of previous to next next
            prevNode.next = nextNode.next;

            // Update previous and curr
            prevNode = nextNode;
            currentNode = prevNode.next;
        }
        return headNode;
    }

    /*
    static Node pairWiseSwap(Node head)
{

    // If linked list is empty or there is only
    // one node in list
    if (head == null || head.next == null)
        return head;

    // Fix the head and its next explicitly to
    // avoid many if else in while loop
    Node curr = head.next.next;
    Node prev = head;
    head = head.next;
    head.next = prev;

    // Fix remaining nodes
    while (curr != null && curr.next != null)
    {
        prev.next = curr.next;
        prev = curr;
        Node next = curr.next.next;
        curr.next.next = curr;
        curr = next;
    }

    prev.next = curr;

    return head;
}
     */
}
