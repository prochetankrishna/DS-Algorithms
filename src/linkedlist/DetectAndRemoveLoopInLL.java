package linkedlist;

public class DetectAndRemoveLoopInLL implements LinkedListUtil{

    public static void main(String[] args) {

        DetectAndRemoveLoopInLL linkedListUtil = new DetectAndRemoveLoopInLL();
        ListNode headNode = null;
        headNode = linkedListUtil.insertAtEndRecursive(headNode, 1);
        headNode = linkedListUtil.insertAtEndRecursive(headNode, 2);
        headNode = linkedListUtil.insertAtEndRecursive(headNode, 3);
        headNode = linkedListUtil.insertAtEndRecursive(headNode, 4);
        headNode = linkedListUtil.insertAtEndRecursive(headNode, 5);

        linkedListUtil.printLinkedListIterative(headNode);
        headNode.next.next.next.next.next = headNode.next;
        headNode = linkedListUtil.findAndRemoveLoopInLL(headNode);
        linkedListUtil.printLinkedListIterative(headNode);
    }

    public ListNode findAndRemoveLoopInLL (ListNode headNode) {

        if (headNode == null) {
            return null;
        }

        ListNode fastPtr = headNode;
        ListNode slowPtr = headNode;

        while (fastPtr != null && fastPtr.next != null) {

            System.out.println("FastPTR : [" + fastPtr.data + "], SlowPTR : [" + slowPtr.data + "]");
            fastPtr = fastPtr.next.next;
            slowPtr = slowPtr.next;

            if (slowPtr == fastPtr) {
                break;
            }
        }

        //Loop Exists
        if (slowPtr == fastPtr) {
            System.out.println("FastPTR : [" + fastPtr.data + "], SlowPTR : [" + slowPtr.data + "]");
            //Edge Case i.e. Circular LL
            if (fastPtr == headNode) {
                while (slowPtr.next != fastPtr) {
                    slowPtr = slowPtr.next;
                }
                slowPtr.next = null;
            } else {
                //Loop anywhere in the middle and not Circular LL
                slowPtr = headNode;
                while (slowPtr.next != fastPtr.next) {
                    slowPtr = slowPtr.next;
                    fastPtr = fastPtr.next;
                }
                fastPtr.next = null;
            }
        }
        return headNode;
    }
}
