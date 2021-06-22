package linkedlist;

class ListNode {
    int data;
    ListNode next;

    public ListNode() {};

    public ListNode(int data) {
        this.data = data;
        this.next = null;
    }
}

interface LinkedListUtil {

    private ListNode getNewNode (int data) {
        ListNode newNode = new ListNode (data);
        return newNode;
    }

    public default ListNode insertAtFrontBegin (ListNode headNode, int data) {

        ListNode newNode = getNewNode(data);
        newNode.next = headNode;
        return newNode;
    }

    public default ListNode insertAtEndIterative (ListNode headNode, int data) {

        if (headNode == null) {
            return getNewNode(data);
        } else {
            ListNode tempNode = headNode;
            while (tempNode.next != null) {
                tempNode = tempNode.next;
            }
            tempNode.next = getNewNode(data);
        }
        return headNode;
    }

    public default ListNode insertAtEndRecursive (ListNode headNode, int data) {

        if (headNode == null) {
            return getNewNode(data);
        } else {
            headNode.next = insertAtEndRecursive(headNode.next, data);
        }
        return headNode;
    }

    public default void printLinkedListRecursive (ListNode headNode) {

        if (headNode == null) {
            System.out.println();
            return;
        }
        System.out.print(headNode.data + " ");
        printLinkedListRecursive(headNode.next);
    }

    public default ListNode insertNodeAtPositionRecursive (ListNode headNode, int position, int data) {

        if (position < 1) {
            System.out.println("Position cannot be less than 1");
            return headNode;
        }

        if (headNode == null && position > 1) {
            System.out.println("Position is greater than the length of the list.");
            return headNode;
        }

        if (headNode == null && position == 1) {
            return getNewNode(data);
        }

        if (position == 1) {
            ListNode newNode = getNewNode(data);
            newNode.next = headNode;
            return newNode;
        }

        headNode.next = insertNodeAtPositionRecursive(headNode.next, position - 1, data);
        return headNode;
    }

    public default ListNode insertNodeAtPositionIterative (ListNode headNode, int position, int data) {

        if (position < 1) {
            System.out.println("Position cannot be less than 1");
            return headNode;
        }

        if (position == 1) {
            ListNode newNode = getNewNode(data);
            newNode.next = headNode;
            return newNode;
        } else {
            ListNode tempNode = headNode;
            while (position-- != 0 && tempNode != null) {
                if (position == 1) {
                    ListNode newNode = getNewNode(data);
                    newNode.next = tempNode.next;
                    tempNode.next = newNode;
                    break;
                }
                tempNode = tempNode.next;
            }
            if (position != 1) {
                System.out.println("Position is greater than the length of list");
            }
        }
        return headNode;
    }

    public default ListNode deleteLastNodeIterative (ListNode headNode) {

        if (headNode == null || headNode.next == null) {
            return null;
        }

        ListNode tempNode = headNode;
        while (tempNode.next.next != null) {
            tempNode = tempNode.next;
        }
        tempNode.next = null;
        return headNode;
    }

    public default ListNode deleteFirstNode (ListNode headNode) {

        if (headNode == null || headNode.next == null) {
            return null;
        }
        return headNode.next;
    }

    public default ListNode deleteNodeAtPositionRecursive (ListNode headNode, int position) {

        if (position < 0) {
            System.out.println("Position can't be negative");
            return headNode;
        }

        if (headNode == null && position > 1) {
            System.out.println("Position is greater than the length of the List");
            return headNode;
        }

        if (position == 1) {
            return headNode.next;
        }

        headNode.next = deleteNodeAtPositionRecursive(headNode.next, position - 1);
        return headNode;
    }

    public default ListNode deleteNodeAtPositionIterative (ListNode headNode, int position) {

        if (position < 0) {
            System.out.println("Position can't be negative");
            return headNode;
        }

        if (headNode == null) {
            return null;
        }

        if (position == 1) {
            return headNode.next;
        }

        ListNode tempNode = headNode;
        while (position-- != 2) {
            tempNode = tempNode.next;
        }

        if (tempNode == null || tempNode.next == null) {
            System.out.println("Position is greater than the length of the list");
            return headNode;
        }

        ListNode nextNode = tempNode.next.next;
        tempNode.next = nextNode;
        return headNode;
    }

    public default int lengthOfLinkedListRecursive (ListNode headNode) {

        if (headNode == null) {
            return 0;
        }
        return 1 + lengthOfLinkedListRecursive(headNode.next);
    }

    public default int lengthOfLinkedListIterative (ListNode headNode) {

        if (headNode == null) {
            return 0;
        }
        ListNode tempNode = headNode;
        int count = 0;
        while (tempNode != null) {
            count++;
            tempNode = tempNode.next;
        }
        return count;
    }

    public default boolean searchInLinkedListRecursive (ListNode headNode, int key) {

        if (headNode == null) {
            return false;
        }

        if (headNode.data == key) {
            return true;
        }
        return searchInLinkedListRecursive(headNode.next, key);
    }

    public default boolean searchInLinkedListIterative (ListNode headNode, int key) {

        if (headNode == null) {
            return false;
        }

        if (headNode.data == key) {
            return true;
        }

        ListNode tempNode = headNode;
        while (tempNode != null) {
            if (tempNode.data == key) {
                return true;
            }
            tempNode = tempNode.next;
        }
        return false;
    }

    public default ListNode reverseLinkedListRecursive (ListNode headNode) {

        if (headNode == null || headNode.next == null) {
            return headNode;
        }

        ListNode tempNode = this.reverseLinkedListRecursive(headNode.next);
        headNode.next.next = headNode;
        headNode.next = null;

        return tempNode;
    }

    public default ListNode reverseLinkedListIterative (ListNode headNode) {

        if (headNode == null || headNode.next == null) {
            return headNode;
        }

        ListNode prevNode = null;
        ListNode currentNode = headNode;
        ListNode nextNode = null;

        while (currentNode != null) {
            nextNode = currentNode.next;
            currentNode.next = prevNode;
            prevNode = currentNode;
            currentNode = nextNode;
        }
        return prevNode;
    }

    public default ListNode getMiddleNodeOfLinkedList (ListNode headNode) {

        if (headNode == null) {
            return headNode;
        }

        ListNode fastPtr = headNode.next;
        ListNode slowPtr = headNode;

        while (fastPtr != null && fastPtr.next != null) {

            fastPtr = fastPtr.next.next;
            slowPtr = slowPtr.next;
        }
        return slowPtr;
    }

    public default ListNode sortLinkedList (ListNode headNode) {

        if (headNode == null || headNode.next == null) {
            return headNode;
        }

        ListNode middleNode = this.getMiddleNodeOfLinkedList(headNode);
        ListNode secondHalf = middleNode.next;
        middleNode.next = null;

        return performMergeAndSort (sortLinkedList(headNode), sortLinkedList(secondHalf));
    }

    public default ListNode performMergeAndSort (ListNode firstHalf, ListNode secondHalf) {

        ListNode tempNode = new ListNode();
        ListNode result = tempNode;

        while (firstHalf != null && secondHalf != null) {

            if (firstHalf.data < secondHalf.data) {
                tempNode.next = firstHalf;
                firstHalf = firstHalf.next;
            } else if (firstHalf.data > secondHalf.data){
                tempNode.next = secondHalf;
                secondHalf = secondHalf.next;
            }
            //Remove Duplicates
//            else {
//                //Equal
//                tempNode.next = firstHalf;
//                firstHalf = firstHalf.next;
//                secondHalf = secondHalf.next;
//            }
            tempNode = tempNode.next;
        }

        if (firstHalf != null) {
            tempNode.next = firstHalf;
        } else {
            tempNode.next = secondHalf;
        }
        return result.next;
    }

    public default void printLinkedListIterative (ListNode headNode) {

        if (headNode == null) {
            return;
        }

        ListNode tempNode = headNode;
        while (tempNode != null) {
            System.out.print(tempNode.data + " ");
            tempNode = tempNode.next;
        }
        System.out.println();
    }
    
    public default ListNode deleteMiddleOfLL (ListNode headNode) {

        if (headNode == null || headNode.next == null) {
            return null;
        }

        ListNode slowPtr = headNode;
        ListNode fastPtr = headNode;
        ListNode prevSlowPtr = headNode;

        while (fastPtr != null && fastPtr.next != null) {
            prevSlowPtr = slowPtr;
            slowPtr = slowPtr.next;
            fastPtr = fastPtr.next.next;
        }

        prevSlowPtr.next = slowPtr.next;
        return headNode;
    }
}

public class LinkedListADT implements LinkedListUtil{

    public static void main(String[] args) {

        ListNode headNode = null;
        LinkedListADT linkedListUtil = new LinkedListADT();
        headNode = linkedListUtil.insertAtEndIterative(headNode, 12);
        headNode = linkedListUtil.insertAtEndRecursive(headNode, 99);
        headNode = linkedListUtil.insertAtEndIterative(headNode, 37);
        linkedListUtil.printLinkedListRecursive(headNode);
        headNode = linkedListUtil.insertAtEndIterative(headNode, 48);
        linkedListUtil.printLinkedListIterative(headNode);
        headNode = linkedListUtil.insertAtFrontBegin(headNode, 33);
        linkedListUtil.printLinkedListRecursive(headNode);
        headNode = linkedListUtil.insertNodeAtPositionRecursive(headNode, 1, 45);
        linkedListUtil.printLinkedListRecursive(headNode);
        headNode = linkedListUtil.insertNodeAtPositionRecursive(headNode, 0, 45);
        headNode = linkedListUtil.insertNodeAtPositionRecursive(headNode, 10, 45);
        headNode = linkedListUtil.insertNodeAtPositionRecursive(headNode, 3, 101);
        linkedListUtil.printLinkedListRecursive(headNode);
        headNode = linkedListUtil.insertNodeAtPositionIterative(headNode, 10, 56);
        headNode = linkedListUtil.insertNodeAtPositionIterative(headNode, -3, 56);
        headNode = linkedListUtil.insertNodeAtPositionIterative(headNode, 6, 56);
        linkedListUtil.printLinkedListRecursive(headNode);
        headNode = linkedListUtil.deleteLastNodeIterative(headNode);
        linkedListUtil.printLinkedListIterative(headNode);
        headNode = linkedListUtil.deleteFirstNode(headNode);
        linkedListUtil.printLinkedListIterative(headNode);
        headNode = linkedListUtil.deleteNodeAtPositionIterative(headNode, 6);
        linkedListUtil.printLinkedListIterative(headNode);
        System.out.println(linkedListUtil.lengthOfLinkedListRecursive(headNode));
        System.out.println(linkedListUtil.lengthOfLinkedListIterative(headNode));
        System.out.println(linkedListUtil.searchInLinkedListIterative(headNode, 25));
        System.out.println(linkedListUtil.searchInLinkedListRecursive(headNode, 25));
        System.out.println(linkedListUtil.searchInLinkedListIterative(headNode, 56));
        System.out.println(linkedListUtil.searchInLinkedListRecursive(headNode, 56));
        linkedListUtil.printLinkedListIterative(headNode);
        headNode = linkedListUtil.reverseLinkedListRecursive(headNode);
        linkedListUtil.printLinkedListIterative(headNode);
        headNode = linkedListUtil.reverseLinkedListIterative(headNode);
        linkedListUtil.printLinkedListIterative(headNode);
        System.out.println("Value of Middle ListNode is : " + linkedListUtil.getMiddleNodeOfLinkedList(headNode).data);
        headNode = linkedListUtil.insertAtFrontBegin(headNode,12);
        linkedListUtil.printLinkedListRecursive(headNode);
        headNode = linkedListUtil.deleteMiddleOfLL(headNode);
        linkedListUtil.printLinkedListRecursive(headNode);
    }
}
