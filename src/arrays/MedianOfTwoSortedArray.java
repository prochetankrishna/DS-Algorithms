package arrays;

public class MedianOfTwoSortedArray {

    public static void main(String[] args) {

        int[] A = {1, 12, 15, 26, 38};
        int[] B = {3, 13, 17, 30, 45};

        int n = A.length;
        System.out.println(findMedianUsingMergeProcedure(A, B, n));
        System.out.println(findMedianOptimized(A, B, 0, 0, n - 1, n - 1));
    }

    public static int findMedianOptimized (int[] A, int[] B, int startA, int startB, int endA, int endB) {

        if (endA - startA == 1) {

            return (Math.max(A[startA], B[startB]) + Math.min(A[endA], B[endB])) / 2;
        }

        int medianA = calculateMedian(A, startA, endA);
        int medianB = calculateMedian(B, startB, endB);

        if (medianA == medianB) {
            return medianA;
        } else if (medianA > medianB) {
            return findMedianOptimized(A, B, startA, (endB + startB + 1) / 2, (endA+ startA + 1) /2, endB);
        } else {
            return findMedianOptimized(A, B, (endA + startA + 1) / 2, startB, endA, (endB + startB + 1) /2) ;
        }
    }

    public static int calculateMedian (int[] arr, int start, int end) {

        int n = end - start + 1;

        if (n % 2 == 0) {

            return (arr[start + (n / 2)] + arr[start + (n/2 -1)]) / 2;
        } else {

            return arr[start + n /2] / 2;
        }
    }

    //SameSize
    public static int findMedianUsingMergeProcedure (int[] A, int[] B, int n) {

        int i = 0;
        int j = 0;
        int count;
        int medianA = -1;
        int medianB = -1;

        for (count = 0; count <= n; count++) {

            if (i == n) {
                medianA = medianB;
                medianB = B[0];
                break;
            }

            if (j == n) {
                medianA = medianB;
                medianB = A[0];
                break;
            }

            if (A[i] < B[j]) {
                medianA = medianB;
                medianB = A[i];
                i++;
            } else {
                medianA = medianB;
                medianB = B[j];
                j++;
            }
        }

        return (medianA + medianB) / 2;
    }
}
