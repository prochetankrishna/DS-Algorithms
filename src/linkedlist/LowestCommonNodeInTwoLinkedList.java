package linkedlist;

import java.sql.SQLOutput;

public class LowestCommonNodeInTwoLinkedList extends IntersectionOfTwoLinkedList{

    public static void main(String[] args) {

        LowestCommonNodeInTwoLinkedList linkedListUtil = new LowestCommonNodeInTwoLinkedList();

        Node rootNodeOne = null;
        rootNodeOne = linkedListUtil.insertAtFrontBegin(rootNodeOne, 37);
        rootNodeOne = linkedListUtil.insertAtFrontBegin(rootNodeOne, 8);
        rootNodeOne = linkedListUtil.insertAtFrontBegin(rootNodeOne, 13);
        rootNodeOne = linkedListUtil.insertAtFrontBegin(rootNodeOne, 18);

        Node rootNodeTwo = null;
        rootNodeTwo = linkedListUtil.insertAtFrontBegin(rootNodeTwo, 18);
        rootNodeTwo = linkedListUtil.insertAtFrontBegin(rootNodeTwo, 14);
        rootNodeTwo = linkedListUtil.insertAtFrontBegin(rootNodeTwo, 8);

        System.out.print("Linked List 1 : ");
        linkedListUtil.printLinkedListIterative(rootNodeOne);

        System.out.print("Linked List 2 : ");
        linkedListUtil.printLinkedListIterative(rootNodeTwo);

        Node lowestCommonNode = linkedListUtil.findLowestCommonInBothLinkedList(rootNodeOne, rootNodeTwo);
        if (lowestCommonNode != null) {
            System.out.println("Lowest Common Node : " + lowestCommonNode.data);
        } else {
            System.out.println("No Common Node Exists !");
        }

    }

    public Node findLowestCommonInBothLinkedList (Node rootNodeOne, Node rootNodeTwo) {

        Node intersectionOfTwoLinkedList = this.findIntersectionOfTwoLinkedList(rootNodeOne, rootNodeTwo);
        System.out.print("Intersection of Two Linked List : " );
        this.printLinkedListIterative(intersectionOfTwoLinkedList);

        if (intersectionOfTwoLinkedList != null) {
            intersectionOfTwoLinkedList.next = null;
            return intersectionOfTwoLinkedList;
        } else {
            return null;
        }
    }
}
