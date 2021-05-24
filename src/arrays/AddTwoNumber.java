package arrays;

class ListNode {

    int val;
    ListNode next;
    ListNode () {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

public class AddTwoNumber {

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        long numberOne = generateNumberFromList (l1);
        System.out.println(numberOne);
        long numberTwo = generateNumberFromList (l2);
        System.out.println(numberTwo);
        long sum = numberOne + numberTwo;
        System.out.println(sum);
        ListNode result =  generateListFromNumber(sum);
        System.out.println(generateNumberFromList(result));
        return result;
    }

    public static ListNode generateListFromNumber (long number) {

        ListNode resultNode = new ListNode();
        String numberToString = String.valueOf(number);
        for (int i = 0; i < numberToString.length() ; i++) {
            ListNode currentDigitNode = new ListNode(Integer.parseInt(String.valueOf(numberToString.charAt(i))), resultNode.next);
            resultNode.next = currentDigitNode;
        }
        return resultNode.next;
    }
    public static long generateNumberFromList (ListNode node) {

        long number = 0;
        int currentPosition = 0;
        while (node != null) {
            number += Math.pow(10.0, Double.valueOf(currentPosition)) * node.val;
            currentPosition++;
            node = node.next;
        }
        return number;
    }

    public static void main(String[] args) {

        ListNode numberOne = new ListNode(1);
        numberOne.next = new ListNode(9);
        numberOne.next.next = new ListNode(9);
        numberOne.next.next.next = new ListNode(9);
        numberOne.next.next.next.next = new ListNode(9);
        numberOne.next.next.next.next.next = new ListNode(9);
        numberOne.next.next.next.next.next.next = new ListNode(9);
        numberOne.next.next.next.next.next.next.next = new ListNode(9);
        numberOne.next.next.next.next.next.next.next.next = new ListNode(9);
        numberOne.next.next.next.next.next.next.next.next.next = new ListNode(9);

        ListNode numberTwo = new ListNode(9);
//        numberTwo.next = new ListNode(9);
//        numberTwo.next.next = new ListNode(9);
//        numberTwo.next.next.next = new ListNode(9);

        addTwoNumbers(numberTwo, numberOne);
    }
}
