package linkedlist;

public class KThNodeFromStartLL extends LinkedListUtil{

    public static void main(String[] args) {

        KThNodeFromStartLL linkedListUtil = new KThNodeFromStartLL();
        Node rootNode = null;
        rootNode = linkedListUtil.insertAtEndRecursive(rootNode, 1);
        rootNode = linkedListUtil.insertAtEndRecursive(rootNode, 2);
        rootNode = linkedListUtil.insertAtEndRecursive(rootNode, 3);
        rootNode = linkedListUtil.insertAtEndRecursive(rootNode, 4);
        rootNode = linkedListUtil.insertAtEndRecursive(rootNode, 5);
        linkedListUtil.printLinkedListRecursive(rootNode);
        Node kThNode = linkedListUtil.findKThNodeFromStart (rootNode, 5);

        if (kThNode == null) {
            System.out.println("Not Found");
        } else {
            System.out.println("KTH NODE : [" + kThNode.data + "]");
        }
    }

    public Node findKThNodeFromStart(Node rootNode, int K) {

        if (rootNode == null) {
            return null;
        }

        if (K <= 0) {
            System.out.println("Invalid Position K Too Small");
            return null;
        }

        Node tempNode = rootNode;
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
