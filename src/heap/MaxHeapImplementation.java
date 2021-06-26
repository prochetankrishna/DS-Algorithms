package heap;

public class MaxHeapImplementation {

    int size;
    int[] heapArr = new int[1000];

    public void insertNewValue (int val) {
        heapArr[size] = val;

        int index = size;
        int parent = (index - 1) / 2;

        while (parent >= 0 && heapArr[parent] < heapArr[index]) {
            int temp = heapArr[parent];
            heapArr[parent] = heapArr[index];
            heapArr[index] = temp;

            temp = parent;
            index = parent;
            parent = (temp - 1) / 2;
        }
        size++;
    }

    public int getMax() {
        if (size > 0) {
            return heapArr[0];
        }
        return Integer.MIN_VALUE;
    }

    public int removeMax() {
        int max = heapArr[0];
        heapArr[0] = heapArr[size - 1];
        size = size - 1;
        maxHeapify (0);
        return max;
    }

    private void maxHeapify(int index) {
        int left, right;
        left = 2 * index + 1;
        right = 2 * index + 2;

        int maximum = index;
        if (left < this.size && heapArr[left] > heapArr[maximum]) {
            maximum = left;
        }

        if (right < this.size && heapArr[right] > heapArr[maximum]) {
            maximum = right;
        }

        if (maximum != index) {
            int temp = heapArr[maximum];
            heapArr[maximum] = heapArr[index];
            heapArr[index] = temp;

            maxHeapify(maximum);
        }
    }

    public void buildMaxHeap(int[] arr) {

        this.heapArr = arr;
        this.size = arr.length;

        for (int i = this.size / 2 - 1; i >= 0; i--) {
            maxHeapify(i);
        }
    }

    public static void main(String[] args) {

        MaxHeapImplementation heap = new MaxHeapImplementation();

        int[] arr = {10, 7, 11, 30, 20, 38, 2, 45};

        System.out.println("Maximum Value : [" + heap.getMax() + "]");
        heap.insertNewValue(arr[0]);
        heap.insertNewValue(arr[1]);
        heap.insertNewValue(arr[2]);
        System.out.println("Maximum Value : [" + heap.getMax() + "]");
        heap.insertNewValue(arr[3]);
        heap.insertNewValue(arr[4]);
        System.out.println("Maximum Value : [" + heap.getMax() + "]");
        heap.insertNewValue(arr[5]);
        System.out.println("Maximum Value : [" + heap.getMax() + "]");
        heap.insertNewValue(arr[6]);
        heap.insertNewValue(arr[7]);
        System.out.println("Maximum Value : [" + heap.getMax() + "]");

        heap.removeMax();
        System.out.println("Maximum Value : [" + heap.getMax() + "]");
    }
}
