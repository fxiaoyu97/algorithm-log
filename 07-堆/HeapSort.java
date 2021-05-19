public class HeapSort {
    public void initUp(int[] a) {
        int len = a.length;
        for (int i = 1; i < len; i++) {
            int current = i;
            int parent = i >> 1;
            while (parent >= 0) {
                if (a[parent] >= a[current]) {
                    break;
                }
                int temp = a[current];
                a[current] = a[parent];
                a[parent] = temp;
                current = parent;
            }
        }
    }

    public void initDown(int[] a) {
        int len = a.length;
        for (int i = (len - 1) >> 1; i >= 0; i--) {
            heapify(a, i, len);
        }
    }

    public void sort(int[] a) {
        int len = a.length;
        initDown(a);
        for (int i = len - 1; i > 0; i--) {
            swap(a, 0, i);
            heapify(a, 0, i);
        }
    }

    private void heapify(int[] a, int i, int n) {
        int current = i;
        while (true) {
            int max = current;
            if ((current << 1) < n && a[current << 1] > a[max]) {
                max = current << 1;
            }
            if ((current << 1) + 1 < n && a[current << 1 + 1] > a[max]) {
                max = current << 1 + 1;
            }
            if (max == current) {
                break;
            }
            swap(a, current, max);
            current = max;
        }
    }

    private void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    public static void main(String[] args) {
        int[] arr = {3, 5, 4, 1, 2, 6};
        new HeapSort().sort(arr);
        Arrays.stream(arr).forEach(System.out::print);
    }
}
