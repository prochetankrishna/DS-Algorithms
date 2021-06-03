package linkedlist;

public class IntersectionOfTwoLinkedList extends LinkedListUtil{

    public static void main(String[] args) {

        IntersectionOfTwoLinkedList linkedListUtil = new IntersectionOfTwoLinkedList();
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

        Node intersectionRootNode = linkedListUtil.findIntersectionOfTwoLinkedList (rootNodeOne, rootNodeTwo);
        System.out.print("Intersection of Linked List : ");
        linkedListUtil.printLinkedListIterative(intersectionRootNode);
    }

    public Node findIntersectionOfTwoLinkedList(Node rootNodeOne, Node rootNodeTwo) {

        Node sortedLLOne = this.sortLinkedList(rootNodeOne);
        Node sortedLLTwo = this.sortLinkedList(rootNodeTwo);

        return mergeLinkedListWithIntersection (sortedLLOne, sortedLLTwo);
    }

    public Node mergeLinkedListWithIntersection(Node sortedLLOne, Node sortedLLTwo) {

        Node tempNode = new Node();
        Node finalList = tempNode;

        while (sortedLLOne != null && sortedLLTwo != null) {
            if (sortedLLOne.data < sortedLLTwo.data) {
                sortedLLOne = sortedLLOne.next;
            } else if (sortedLLOne.data > sortedLLTwo.data) {
                sortedLLTwo = sortedLLTwo.next;
            } else {
                tempNode.next = sortedLLOne;
                sortedLLOne = sortedLLOne.next;
                sortedLLTwo = sortedLLTwo.next;
                tempNode = tempNode.next;
            }
        }
        tempNode.next = null;
        return finalList.next;
    }


}
