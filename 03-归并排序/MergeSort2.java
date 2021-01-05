public class MergeSort2 {
    public static void main(String[] args) {
        int[] arr = {8, 3, 5, 4, 1, 2, 6};
        merge(arr, 0, arr.length);
        for (int i : arr) {
            System.out.print(i);
        }
    }

    public static void merge(int[] a, int start, int end) {
        if (start + 1 >= end) {
            return;
        }
        int middle = (start + end) / 2;
        // 排序的数据不包含middle位，即不对a[middle]处理
        merge(a, start, middle);
        merge(a, middle, end);

        int[] left = new int[middle - start + 1];
        int[] right = new int[end - middle + 1];
        left[middle - start] = Integer.MAX_VALUE;
        right[end - middle] = Integer.MAX_VALUE;

        int i = 0;
        int j = 0;
        int k = start;
        for (int l = 0; l < middle - start; l++) {
            left[l] = a[start + l];
        }
        for (int l = 0; l < end - middle; l++) {
            right[l] = a[middle + l];
        }

        for (int l = start; l < end; l++) {
            if (left[i] <= right[j]) {
                a[l] = left[i++];
            } else {
                a[l] = right[j++];
            }
        }
    }
}
