package mit;

public class PeakFinding {

    public static void main(String[] args) {

        int[] arr = new int[]{1, 3, 20, 4, 1, 0};
        //System.out.println("Peak Element : " + find1DPeakNaive(arr));
        System.out.println(findPeak(arr, arr.length));
    }

    public static int findPeakUtil (int[] arr, int low, int high, int n) {

        int mid = low + (high - low) / 2;
        System.out.println("MID : " + mid);

        if ((mid == 0 || arr[mid - 1] <= arr[mid]) && (mid == n - 1 || arr[mid + 1] <= arr[mid])) {
            return mid;
        } else if (mid > 0 && arr[mid - 1] > arr[mid]) {
            return findPeakUtil(arr, low, mid - 1 , n);
        } else {
            return findPeakUtil(arr, mid + 1, high, n);
        }
    }

    public static int findPeak(int[] arr, int n)
    {
        return findPeakUtil(arr, 0, n - 1, n);
    }

    public static int find1DPeakNaive (int[] arr) {

        if (arr.length == 1) {
            return arr[0];
        } else if (arr[0] > arr[1]) {
            return arr[0];
        } else if (arr[arr.length - 1] > arr[arr.length - 2]) {
            return arr[arr.length - 1];
        }

        for (int i = 1; i < arr.length - 1; i++) {
            if ((arr[i] > arr[i - 1]) && arr[i] > arr[i + 1]) {
                return arr[i];
            }
        }
        return -1;
    }
}
