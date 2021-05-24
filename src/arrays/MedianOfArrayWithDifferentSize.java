package arrays;

public class MedianOfArrayWithDifferentSize {

    public static void main(String[] args) {

        int[] A = {-5, 3, 6, 12, 15};
        int[] B = {-12, -10, -6, -3, 4, 10};
        System.out.println(findMedianOfSortedArrayDifferentSize(A, B, A.length, B.length));
    }

    public static int findMedianOfSortedArrayDifferentSize (int[] A, int[] B, int m, int n) {

        int i = 0, j = 0, count;
        int m1 = -1, m2 = -1;

        if ((m + n) % 2 == 1) {

            //Odd
            for (count = 0; count <= (m + n) / 2; count++) {

                if (i != m && j != n) {
                    m1 = A[i] > B[j] ? B[j++] : A[i++];
                } else if (i < m) {
                    m1 = A[i++];
                } else {
                    m1 = B[j++];
                }
            }
            return m1;
        } else {

            //Even
            for (count = 0; count <= (m + n) / 2; count++) {

                m1 = m2;
                if (i != m && j != n) {
                    m2 = A[i] > B[j] ? B[j++] : A[i++];
                } else if (i < m) {
                    m2 = A[i++];
                } else {
                    m2 = B[j++];
                }
            }
            return (m1 + m2) / 2;
        }
    }
}
