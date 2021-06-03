package linkedlist;

public class RemoveDuplicatesFromSortedLinkedList extends LinkedListUtil{

    public static void main(String[] args) {

        RemoveDuplicatesFromSortedLinkedList linkedListUtil = new RemoveDuplicatesFromSortedLinkedList();

        Node rootNode = null;
        rootNode = linkedListUtil.insertAtFrontBegin(rootNode, 45);
        rootNode = linkedListUtil.insertAtFrontBegin(rootNode, 45);
        rootNode = linkedListUtil.insertAtFrontBegin(rootNode, 37);
        rootNode = linkedListUtil.insertAtFrontBegin(rootNode, 37);
        rootNode = linkedListUtil.insertAtFrontBegin(rootNode, 34);
        rootNode = linkedListUtil.insertAtFrontBegin(rootNode, 13);
        rootNode = linkedListUtil.insertAtFrontBegin(rootNode, 8);
        rootNode = linkedListUtil.insertAtFrontBegin(rootNode, 8);
        rootNode = linkedListUtil.insertAtFrontBegin(rootNode, 8);

        System.out.print("Linked List : ");
        linkedListUtil.printLinkedListIterative(rootNode);


        Node uniqueLinkedList = linkedListUtil.removeDuplicatesFromSortedLinkedListIterative(rootNode);
        System.out.print("Unique Linked List : ");
        linkedListUtil.printLinkedListIterative(uniqueLinkedList);
    }

    public Node removeDuplicatesFromSortedLinkedListIterative (Node rootNode) {

        if (rootNode == null || rootNode.next == null) {
            return rootNode;
        }

        Node tempNode = rootNode;

        while (tempNode != null && tempNode.next != null) {
            if (tempNode.data == tempNode.next.data) {
                tempNode.next = tempNode.next.next;
            } else {
                tempNode = tempNode.next;
            }

        }
        return rootNode;
    }

    public Node removeDuplicatesFromSortedLinkedListRecursive (Node rootNode) {

        if (rootNode == null || rootNode.next == null) {
            return rootNode;
        }

        if (rootNode.data == rootNode.next.data) {
            rootNode.next = rootNode.next.next;
            removeDuplicatesFromSortedLinkedListRecursive(rootNode);
        } else {
            removeDuplicatesFromSortedLinkedListRecursive(rootNode.next);
        }
        return rootNode;
    }
}
