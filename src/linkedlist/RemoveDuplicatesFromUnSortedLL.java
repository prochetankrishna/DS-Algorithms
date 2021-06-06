package linkedlist;

import java.util.HashMap;
import java.util.Map;

public class RemoveDuplicatesFromUnSortedLL implements LinkedListUtil{

    public static void main(String[] args) {

        RemoveDuplicatesFromUnSortedLL linkedListUtil = new RemoveDuplicatesFromUnSortedLL();
        ListNode headNode = null;
        headNode = linkedListUtil.insertAtEndRecursive(headNode, 1);
        headNode = linkedListUtil.insertAtEndRecursive(headNode, 1);
        headNode = linkedListUtil.insertAtEndRecursive(headNode, 3);
        headNode = linkedListUtil.insertAtEndRecursive(headNode, 1);
        headNode = linkedListUtil.insertAtEndRecursive(headNode, 2);
        headNode = linkedListUtil.insertAtEndRecursive(headNode, 2);
        headNode = linkedListUtil.insertAtEndRecursive(headNode, 3);
        headNode = linkedListUtil.insertAtEndRecursive(headNode, 4);
        headNode = linkedListUtil.insertAtEndRecursive(headNode, 4);
        linkedListUtil.printLinkedListRecursive(headNode);
        headNode = linkedListUtil.removeDuplicatesUsingHashMap(headNode);
        linkedListUtil.printLinkedListRecursive(headNode);
    }

    public ListNode removeDuplicatesUsingHashMap (ListNode headNode) {

        if (headNode == null || headNode.next == null) {
            return null;
        }

        Map<Integer, Integer> traversalMap = new HashMap<>();

        ListNode tempNode = headNode;
        ListNode prevNode = null;

        while (tempNode != null) {

            if (!traversalMap.containsKey(tempNode.data)) {
                traversalMap.put(tempNode.data, 1);
                prevNode= tempNode;
                tempNode = tempNode.next;
            } else {
                prevNode.next = tempNode.next;
                tempNode = tempNode.next;
            }
        }
        return headNode;
    }
}
