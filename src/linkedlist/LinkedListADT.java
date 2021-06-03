package linkedlist;

import java.sql.SQLOutput;

class Node {
    int data;
    Node next;

    public Node() {};

    public Node(int data) {
        this.data = data;
        this.next = null;
    }
}

class LinkedListUtil {

    private Node getNewNode (int data) {
        Node newNode = new Node (data);
        return newNode;
    }

    public Node insertAtFrontBegin (Node rootNode, int data) {

        Node newNode = getNewNode(data);
        newNode.next = rootNode;
        return newNode;
    }

    public Node insertAtEndIterative (Node rootNode, int data) {

        if (rootNode == null) {
            return getNewNode(data);
        } else {
            Node tempNode = rootNode;
            while (tempNode.next != null) {
                tempNode = tempNode.next;
            }
            tempNode.next = getNewNode(data);
        }
        return rootNode;
    }

    public Node insertAtEndRecursive (Node rootNode, int data) {

        if (rootNode == null) {
            return getNewNode(data);
        } else {
            rootNode.next = insertAtEndRecursive(rootNode.next, data);
        }
        return rootNode;
    }

    public void printLinkedListRecursive (Node rootNode) {

        if (rootNode == null) {
            System.out.println();
            return;
        }
        System.out.print(rootNode.data + " ");
        printLinkedListRecursive(rootNode.next);
    }

    public Node insertNodeAtPositionRecursive (Node rootNode, int position, int data) {

        if (position < 1) {
            System.out.println("Position cannot be less than 1");
            return rootNode;
        }

        if (rootNode == null && position > 1) {
            System.out.println("Position is greater than the length of the list.");
            return rootNode;
        }

        if (rootNode == null && position == 1) {
            return getNewNode(data);
        }

        if (position == 1) {
            Node newNode = getNewNode(data);
            newNode.next = rootNode;
            return newNode;
        }

        rootNode.next = insertNodeAtPositionRecursive(rootNode.next, position - 1, data);
        return rootNode;
    }

    public Node insertNodeAtPositionIterative (Node rootNode, int position, int data) {

        if (position < 1) {
            System.out.println("Position cannot be less than 1");
            return rootNode;
        }

        if (position == 1) {
            Node newNode = getNewNode(data);
            newNode.next = rootNode;
            return newNode;
        } else {
            Node tempNode = rootNode;
            while (position-- != 0 && tempNode != null) {
                if (position == 1) {
                    Node newNode = getNewNode(data);
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
        return rootNode;
    }

    public Node deleteLastNodeIterative (Node rootNode) {

        if (rootNode == null || rootNode.next == null) {
            return null;
        }

        Node tempNode = rootNode;
        while (tempNode.next.next != null) {
            tempNode = tempNode.next;
        }
        tempNode.next = null;
        return rootNode;
    }

    public Node deleteFirstNode (Node rootNode) {

        if (rootNode == null || rootNode.next == null) {
            return null;
        }
        return rootNode.next;
    }

    public Node deleteNodeAtPositionRecursive (Node rootNode, int position) {

        if (position < 0) {
            System.out.println("Position can't be negative");
            return rootNode;
        }

        if (rootNode == null && position > 1) {
            System.out.println("Position is greater than the length of the List");
            return rootNode;
        }

        if (position == 1) {
            return rootNode.next;
        }

        rootNode.next = deleteNodeAtPositionRecursive(rootNode.next, position -1);
        return rootNode;
    }

    public Node deleteNodeAtPositionIterative (Node rootNode, int position) {

        if (position < 0) {
            System.out.println("Position can't be negative");
            return rootNode;
        }

        if (rootNode == null) {
            return null;
        }

        if (position == 1) {
            return rootNode.next;
        }

        Node tempNode = rootNode;
        while (position-- != 2) {
            tempNode = tempNode.next;
        }

        if (tempNode == null || tempNode.next == null) {
            System.out.println("Position is greater than the length of the list");
            return rootNode;
        }

        Node nextNode = tempNode.next.next;
        tempNode.next = nextNode;
        return rootNode;
    }

    public int lengthOfLinkedListRecursive (Node rootNode) {

        if (rootNode == null) {
            return 0;
        }
        return 1 + lengthOfLinkedListRecursive(rootNode.next);
    }

    public int lengthOfLinkedListIterative (Node rootNode) {

        if (rootNode == null) {
            return 0;
        }
        Node tempNode = rootNode;
        int count = 0;
        while (tempNode != null) {
            count++;
            tempNode = tempNode.next;
        }
        return count;
    }

    public boolean searchInLinkedListRecursive (Node rootNode, int key) {

        if (rootNode == null) {
            return false;
        }

        if (rootNode.data == key) {
            return true;
        }
        return searchInLinkedListRecursive(rootNode.next, key);
    }

    public boolean searchInLinkedListIterative (Node rootNode, int key) {

        if (rootNode == null) {
            return false;
        }

        if (rootNode.data == key) {
            return true;
        }

        Node tempNode = rootNode;
        while (tempNode != null) {
            if (tempNode.data == key) {
                return true;
            }
            tempNode = tempNode.next;
        }
        return false;
    }

    public Node reverseLinkedListRecursive (Node rootNode) {

        if (rootNode == null || rootNode.next == null) {
            return rootNode;
        }

        Node tempNode = this.reverseLinkedListRecursive(rootNode.next);
        rootNode.next.next = rootNode;
        rootNode.next = null;

        return tempNode;
    }

    public Node reverseLinkedListIterative (Node rootNode) {

        if (rootNode == null || rootNode.next == null) {
            return rootNode;
        }

        Node prevNode = null;
        Node currentNode = rootNode;
        Node nextNode = null;

        while (currentNode != null) {
            nextNode = currentNode.next;
            currentNode.next = prevNode;
            prevNode = currentNode;
            currentNode = nextNode;
        }
        return prevNode;
    }

    public Node getMiddleNodeOfLinkedList (Node rootNode) {

        if (rootNode == null) {
            return rootNode;
        }

        Node fastPtr = rootNode.next;
        Node slowPtr = rootNode;

        while (fastPtr != null && fastPtr.next != null) {

            fastPtr = fastPtr.next.next;
            slowPtr = slowPtr.next;
        }
        return slowPtr;
    }

    public Node sortLinkedList (Node rootNode) {

        if (rootNode == null || rootNode.next == null) {
            return rootNode;
        }

        Node middleNode = this.getMiddleNodeOfLinkedList(rootNode);
        Node secondHalf = middleNode.next;
        middleNode.next = null;

        return performMergeAndSort (sortLinkedList(rootNode), sortLinkedList(secondHalf));
    }

    public Node performMergeAndSort (Node firstHalf, Node secondHalf) {

        Node tempNode = new Node();
        Node result = tempNode;

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

    public void printLinkedListIterative (Node rootNode) {

        if (rootNode == null) {
            return;
        }

        Node tempNode = rootNode;
        while (tempNode != null) {
            System.out.print(tempNode.data + " ");
            tempNode = tempNode.next;
        }
        System.out.println();
    }
}

public class LinkedListADT {

    public static void main(String[] args) {

        Node rootNode = null;
        LinkedListUtil linkedListUtil = new LinkedListUtil();
        rootNode = linkedListUtil.insertAtEndIterative(rootNode, 12);
        rootNode = linkedListUtil.insertAtEndRecursive(rootNode, 99);
        rootNode = linkedListUtil.insertAtEndIterative(rootNode, 37);
        linkedListUtil.printLinkedListRecursive(rootNode);
        rootNode = linkedListUtil.insertAtEndIterative(rootNode, 48);
        linkedListUtil.printLinkedListIterative(rootNode);
        rootNode = linkedListUtil.insertAtFrontBegin(rootNode, 33);
        linkedListUtil.printLinkedListRecursive(rootNode);
        rootNode = linkedListUtil.insertNodeAtPositionRecursive(rootNode, 1, 45);
        linkedListUtil.printLinkedListRecursive(rootNode);
        rootNode = linkedListUtil.insertNodeAtPositionRecursive(rootNode, 0, 45);
        rootNode = linkedListUtil.insertNodeAtPositionRecursive(rootNode, 10, 45);
        rootNode = linkedListUtil.insertNodeAtPositionRecursive(rootNode, 3, 101);
        linkedListUtil.printLinkedListRecursive(rootNode);
        rootNode = linkedListUtil.insertNodeAtPositionIterative(rootNode, 10, 56);
        rootNode = linkedListUtil.insertNodeAtPositionIterative(rootNode, -3, 56);
        rootNode = linkedListUtil.insertNodeAtPositionIterative(rootNode, 6, 56);
        linkedListUtil.printLinkedListRecursive(rootNode);
        rootNode = linkedListUtil.deleteLastNodeIterative(rootNode);
        linkedListUtil.printLinkedListIterative(rootNode);
        rootNode = linkedListUtil.deleteFirstNode(rootNode);
        linkedListUtil.printLinkedListIterative(rootNode);
        rootNode = linkedListUtil.deleteNodeAtPositionIterative(rootNode, 6);
        linkedListUtil.printLinkedListIterative(rootNode);
        System.out.println(linkedListUtil.lengthOfLinkedListRecursive(rootNode));
        System.out.println(linkedListUtil.lengthOfLinkedListIterative(rootNode));
        System.out.println(linkedListUtil.searchInLinkedListIterative(rootNode, 25));
        System.out.println(linkedListUtil.searchInLinkedListRecursive(rootNode, 25));
        System.out.println(linkedListUtil.searchInLinkedListIterative(rootNode, 56));
        System.out.println(linkedListUtil.searchInLinkedListRecursive(rootNode, 56));
        linkedListUtil.printLinkedListIterative(rootNode);
        rootNode = linkedListUtil.reverseLinkedListRecursive(rootNode);
        linkedListUtil.printLinkedListIterative(rootNode);
        rootNode = linkedListUtil.reverseLinkedListIterative(rootNode);
        linkedListUtil.printLinkedListIterative(rootNode);
        System.out.println("Value of Middle Node is : " + linkedListUtil.getMiddleNodeOfLinkedList(rootNode).data);
        rootNode = linkedListUtil.insertAtFrontBegin(rootNode,12);
        linkedListUtil.printLinkedListRecursive(rootNode);
        rootNode = linkedListUtil.sortLinkedList(rootNode);
        linkedListUtil.printLinkedListRecursive(rootNode);
    }
}
