package heap;

public class MinHeapImplementation {

    int size;
    int[] heapArr = new int[1000];

    public void insertNewValue (int val) {
        heapArr[size] = val;

        int index = size;
        int parent = (index - 1) / 2;

        while (parent >= 0 && heapArr[parent] > heapArr[index]) {
            int temp = heapArr[parent];
            heapArr[parent] = heapArr[index];
            heapArr[index] = temp;

            temp = parent;
            index = parent;
            parent = (temp - 1) / 2;
        }
        size++;
    }

    public int getMin() {
        if (size > 0) {
            return heapArr[0];
        }
        return Integer.MAX_VALUE;
    }

    public int removeMin() {
        int min = heapArr[0];
        heapArr[0] = heapArr[size - 1];
        size = size - 1;
        minHeapify (0);
        return min;
    }

    private void minHeapify(int index) {
        int left, right;
        left = 2 * index + 1;
        right = 2 * index + 2;

        int minimum = index;
        if (left < this.size && heapArr[left] < heapArr[minimum]) {
            minimum = left;
        }

        if (right < this.size && heapArr[right] < heapArr[minimum]) {
            minimum = right;
        }

        if (minimum != index) {
            int temp = heapArr[minimum];
            heapArr[minimum] = heapArr[index];
            heapArr[index] = temp;

            minHeapify(minimum);
        }
    }

    public void buildMinHeap(int[] arr) {

        this.heapArr = arr;
        this.size = arr.length;

        for (int i = this.size / 2 - 1; i >= 0; i--) {
            minHeapify(i);
        }
    }

    public static void main(String[] args) {

        MinHeapImplementation heap = new MinHeapImplementation();

        int[] arr = {10, 7, 11, 30, 20, 38, 2, 45};

        System.out.println("Minimum Value : [" + heap.getMin() + "]");
        heap.insertNewValue(arr[0]);
        heap.insertNewValue(arr[1]);
        heap.insertNewValue(arr[2]);
        System.out.println("Minimum Value : [" + heap.getMin() + "]");
        heap.insertNewValue(arr[3]);
        heap.insertNewValue(arr[4]);
        System.out.println("Minimum Value : [" + heap.getMin() + "]");
        heap.insertNewValue(arr[5]);
        System.out.println("Minimum Value : [" + heap.getMin() + "]");
        heap.insertNewValue(arr[6]);
        heap.insertNewValue(arr[7]);
        System.out.println("Minimum Value : [" + heap.getMin() + "]");

        heap.removeMin();
        System.out.println("Minimum Value : [" + heap.getMin() + "]");
    }
}
