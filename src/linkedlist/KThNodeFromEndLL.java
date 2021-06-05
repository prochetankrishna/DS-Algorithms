package linkedlist;

public class KThNodeFromEndLL extends LinkedListUtil{

    public static void main(String[] args) {
        KThNodeFromEndLL linkedListUtil = new KThNodeFromEndLL();
        ListNode headNode = null;
        headNode = linkedListUtil.insertAtEndRecursive(headNode, 1);
        headNode = linkedListUtil.insertAtEndRecursive(headNode, 2);
        headNode = linkedListUtil.insertAtEndRecursive(headNode, 3);
        headNode = linkedListUtil.insertAtEndRecursive(headNode, 4);
        headNode = linkedListUtil.insertAtEndRecursive(headNode, 5);
        linkedListUtil.printLinkedListRecursive(headNode);
        ListNode kThNode = linkedListUtil.findKthNodeFromEndOptimized (headNode, 3);

        if (kThNode == null) {
            System.out.println("Not Found");
        } else {
            System.out.println("KTH ListNode : [" + kThNode.data + "]");
        }
    }

    public ListNode findKthNodeFromEndOptimized (ListNode headNode, int K) {

        if (headNode == null) {
            return null;
        }

        if (K <= 0) {
            System.out.println("K is Too Small");
            return null;
        }

        ListNode tempNodeOne, tempNodeTwo;
        tempNodeOne = tempNodeTwo = headNode;

        for (int i = 1; i < K; i++) {
            tempNodeTwo = tempNodeTwo.next;
            if (tempNodeTwo == null) {
                System.out.println("K is Too large");
                return null;
            }
        }

        while (tempNodeTwo.next != null) {
            tempNodeOne = tempNodeOne.next;
            tempNodeTwo = tempNodeTwo.next;
        }

        tempNodeOne.next = null;
        return tempNodeOne;
    }

    private ListNode findKThNodeFromEndLength (ListNode headNode, int K) {

        if (headNode == null) {
            return null;
        }

        if (K <= 0) {
            System.out.println("K is Too Small");
            return null;
        }

        int lengthOfLL = lengthOfLinkedListIterative(headNode);

        if (K > lengthOfLL) {
            System.out.println("K is large");
            return null;
        }

        ListNode tempNode = headNode;
        int i = 1;
        while (i <= lengthOfLL - K) {
            tempNode = tempNode.next;
            i++;
        }

        tempNode.next = null;
        return tempNode;
    }

    private ListNode findKThNodeFromEndReverse(ListNode headNode, int K) {

        if (headNode == null) {
            return null;
        }

        if (K <= 0) {
            System.out.println("K is Too Small");
            return null;
        }

        ListNode reverseNode = this.reverseLinkedListRecursive(headNode);
        ListNode tempNode = reverseNode;
        int i = 1;
        while (i < K) {
            if (tempNode.next == null) {
                System.out.println("K is too Large");
                return null;
            }
            tempNode = tempNode.next;
            i++;
        }

        tempNode.next = null;
        return tempNode;
    }
}
