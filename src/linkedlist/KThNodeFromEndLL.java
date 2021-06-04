package linkedlist;

public class KThNodeFromEndLL extends LinkedListUtil{

    public static void main(String[] args) {
        KThNodeFromEndLL linkedListUtil = new KThNodeFromEndLL();
        Node rootNode = null;
        rootNode = linkedListUtil.insertAtEndRecursive(rootNode, 1);
        rootNode = linkedListUtil.insertAtEndRecursive(rootNode, 2);
        rootNode = linkedListUtil.insertAtEndRecursive(rootNode, 3);
        rootNode = linkedListUtil.insertAtEndRecursive(rootNode, 4);
        rootNode = linkedListUtil.insertAtEndRecursive(rootNode, 5);
        linkedListUtil.printLinkedListRecursive(rootNode);
        Node kThNode = linkedListUtil.findKthNodeFromEndOptimized (rootNode, 3);

        if (kThNode == null) {
            System.out.println("Not Found");
        } else {
            System.out.println("KTH NODE : [" + kThNode.data + "]");
        }
    }

    public Node findKthNodeFromEndOptimized (Node rootNode, int K) {

        if (rootNode == null) {
            return null;
        }

        if (K <= 0) {
            System.out.println("K is Too Small");
            return null;
        }

        Node tempNodeOne, tempNodeTwo;
        tempNodeOne = tempNodeTwo = rootNode;

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

    private Node findKThNodeFromEndLength (Node rootNode, int K) {

        if (rootNode == null) {
            return null;
        }

        if (K <= 0) {
            System.out.println("K is Too Small");
            return null;
        }

        int lengthOfLL = lengthOfLinkedListIterative(rootNode);

        if (K > lengthOfLL) {
            System.out.println("K is large");
            return null;
        }

        Node tempNode = rootNode;
        int i = 1;
        while (i <= lengthOfLL - K) {
            tempNode = tempNode.next;
            i++;
        }

        tempNode.next = null;
        return tempNode;
    }

    private Node findKThNodeFromEndReverse(Node rootNode, int K) {

        if (rootNode == null) {
            return null;
        }

        if (K <= 0) {
            System.out.println("K is Too Small");
            return null;
        }

        Node reverseNode = this.reverseLinkedListRecursive(rootNode);
        Node tempNode = reverseNode;
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
