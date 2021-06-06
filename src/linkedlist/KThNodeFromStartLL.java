package linkedlist;

public class KThNodeFromStartLL implements LinkedListUtil{

    public static void main(String[] args) {

        KThNodeFromStartLL linkedListUtil = new KThNodeFromStartLL();
        ListNode headNode = null;
        headNode = linkedListUtil.insertAtEndRecursive(headNode, 1);
        headNode = linkedListUtil.insertAtEndRecursive(headNode, 2);
        headNode = linkedListUtil.insertAtEndRecursive(headNode, 3);
        headNode = linkedListUtil.insertAtEndRecursive(headNode, 4);
        headNode = linkedListUtil.insertAtEndRecursive(headNode, 5);
        linkedListUtil.printLinkedListRecursive(headNode);
        ListNode kThNode = linkedListUtil.findKThNodeFromStart (headNode, 5);

        if (kThNode == null) {
            System.out.println("Not Found");
        } else {
            System.out.println("KTH ListNode : [" + kThNode.data + "]");
        }
    }

    public ListNode findKThNodeFromStart(ListNode headNode, int K) {

        if (headNode == null) {
            return null;
        }

        if (K <= 0) {
            System.out.println("Invalid Position K Too Small");
            return null;
        }

        ListNode tempNode = headNode;
        int i = 1;

        while (i < K) {
            if (tempNode.next == null) {
                System.out.println("Position K is greater than the Length of LL");
                return null;
            }
            tempNode = tempNode.next;
            i++;
        }

        tempNode.next = null;
        return tempNode;
    }
}
