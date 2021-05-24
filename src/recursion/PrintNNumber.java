package recursion;

public class PrintNNumber {

    public static void main(String[] args) {
        printNNumbersIncreasingOrder(7);
        System.out.println();
        printNNumbersDecreasingOrder(7);
        System.out.println();
    }

    public static void printNNumbersIncreasingOrder (int n) {

        if (n == 0) {
            return;
        }

        printNNumbersIncreasingOrder(n - 1);
        System.out.print(n + " ");
    }

    public static void printNNumbersDecreasingOrder (int n) {

        if (n == 0) {
            return;
        }

        System.out.print(n + " ");
        printNNumbersDecreasingOrder(n - 1);
    }
}
