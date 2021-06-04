package linkedlist;

import java.util.HashMap;
import java.util.Map;

public class RemoveDuplicatesFromUnSortedLL extends LinkedListUtil{

    public static void main(String[] args) {

        RemoveDuplicatesFromUnSortedLL linkedListUtil = new RemoveDuplicatesFromUnSortedLL();
        Node rootNode = null;
        rootNode = linkedListUtil.insertAtEndRecursive(rootNode, 1);
        rootNode = linkedListUtil.insertAtEndRecursive(rootNode, 1);
        rootNode = linkedListUtil.insertAtEndRecursive(rootNode, 3);
        rootNode = linkedListUtil.insertAtEndRecursive(rootNode, 1);
        rootNode = linkedListUtil.insertAtEndRecursive(rootNode, 2);
        rootNode = linkedListUtil.insertAtEndRecursive(rootNode, 2);
        rootNode = linkedListUtil.insertAtEndRecursive(rootNode, 3);
        rootNode = linkedListUtil.insertAtEndRecursive(rootNode, 4);
        rootNode = linkedListUtil.insertAtEndRecursive(rootNode, 4);
        linkedListUtil.printLinkedListRecursive(rootNode);
        rootNode = linkedListUtil.removeDuplicatesUsingHashMap(rootNode);
        linkedListUtil.printLinkedListRecursive(rootNode);
    }

    public Node removeDuplicatesUsingHashMap (Node rootNode) {

        if (rootNode == null || rootNode.next == null) {
            return null;
        }

        Map<Integer, Integer> traversalMap = new HashMap<>();

        Node tempNode = rootNode;
        Node prevNode = null;

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
        return rootNode;
    }
}
