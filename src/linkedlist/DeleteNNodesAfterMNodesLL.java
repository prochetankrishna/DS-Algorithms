package linkedlist;

public class DeleteNNodesAfterMNodesLL implements LinkedListUtil{

    public static void main(String[] args) {

        DeleteNNodesAfterMNodesLL linkedListUtil = new DeleteNNodesAfterMNodesLL();
        ListNode rootNode = null;
        rootNode = linkedListUtil.insertAtEndRecursive(rootNode, 1);
        rootNode = linkedListUtil.insertAtEndRecursive(rootNode, 2);
        rootNode = linkedListUtil.insertAtEndRecursive(rootNode, 3);
        rootNode = linkedListUtil.insertAtEndRecursive(rootNode, 4);
        rootNode = linkedListUtil.insertAtEndRecursive(rootNode, 5);

        linkedListUtil.printLinkedListRecursive(rootNode);
        rootNode = linkedListUtil.deleteNNodesAfterMNodes(rootNode, 1, 2);
        linkedListUtil.printLinkedListRecursive(rootNode);
    }

    private ListNode deleteNNodesAfterMNodes(ListNode rootNode, int M, int N) {

        if (rootNode == null) {
            return null;
        }

        //No Deletion required
        if (N == 0) {
            return rootNode;
        }

        if (M == 0 && N == 0) {
            return rootNode;
        }

        ListNode tempNodeOne = rootNode;
        ListNode tempNodeTwo = rootNode;

        int i = 0;
        //Traverse M Nodes
        while (i < M - 1) {
            tempNodeOne = tempNodeOne.next;
            i++;
        }

        tempNodeTwo = M == 0 ? tempNodeOne : tempNodeOne.next;

        int j = 0;
        //Delete Elements
        while (j < N) {
            if (tempNodeTwo == null) {
                System.out.println("Not Enough Elements To Delete !");
                return rootNode;
            }
            tempNodeTwo = tempNodeTwo.next;
            j++;
        }

        if (M == 0) {
            return tempNodeTwo;
        } else {
            tempNodeOne.next = tempNodeTwo;
        }
        return rootNode;
    }
}
