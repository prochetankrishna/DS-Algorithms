package linkedlist;

public class UnionOfTwoLinkedList extends LinkedListUtil{

    public static void main(String[] args) {

        UnionOfTwoLinkedList linkedListUtil = new UnionOfTwoLinkedList();
        Node rootNodeOne = null;
        rootNodeOne = linkedListUtil.insertAtFrontBegin(rootNodeOne, 37);
        rootNodeOne = linkedListUtil.insertAtFrontBegin(rootNodeOne, 8);
        rootNodeOne = linkedListUtil.insertAtFrontBegin(rootNodeOne, 13);
        rootNodeOne = linkedListUtil.insertAtFrontBegin(rootNodeOne, 18);

        Node rootNodeTwo = null;
        rootNodeTwo = linkedListUtil.insertAtFrontBegin(rootNodeTwo, 18);
        rootNodeTwo = linkedListUtil.insertAtFrontBegin(rootNodeTwo, 14);
        rootNodeTwo = linkedListUtil.insertAtFrontBegin(rootNodeTwo, 8);

        linkedListUtil.printLinkedListIterative(rootNodeOne);
        linkedListUtil.printLinkedListIterative(rootNodeTwo);

        Node rootNodeUnion = linkedListUtil.findUnionOfLinkedList (rootNodeOne, rootNodeTwo);
        System.out.print("Union of Linked List : ");
        linkedListUtil.printLinkedListIterative(rootNodeUnion);
    }

    public Node findUnionOfLinkedList(Node rootNodeOne, Node rootNodeTwo) {

        Node sortedLLOne = this.sortLinkedList(rootNodeOne);
        Node sortedLLTwo = this.sortLinkedList(rootNodeTwo);

        return mergeLinkedListWithUnion (sortedLLOne, sortedLLTwo);
    }

    public Node mergeLinkedListWithUnion(Node sortedLLOne, Node sortedLLTwo) {

        Node tempNode = new Node();
        Node finalList = tempNode;

        while (sortedLLOne != null && sortedLLTwo != null) {

            if (sortedLLOne.data < sortedLLTwo.data) {
                tempNode.next = sortedLLOne;
                sortedLLOne = sortedLLOne.next;
            } else if (sortedLLOne.data > sortedLLTwo.data) {
                tempNode.next = sortedLLTwo;
                sortedLLTwo = sortedLLTwo.next;
            } else {
                tempNode.next = sortedLLOne;
                sortedLLOne = sortedLLOne.next;
                sortedLLTwo = sortedLLTwo.next;
            }
            tempNode = tempNode.next;
        }

        if (sortedLLOne != null) {
            tempNode.next = sortedLLOne;
        } else if (sortedLLTwo != null) {
            tempNode.next = sortedLLTwo;
        }

        return finalList.next;
    }
}
