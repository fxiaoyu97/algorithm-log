public class MergeSort {
    public static void main(String[] args) {
        int[] arr = {3, 5, 4, 1, 2, 6};

        arr = merge(arr, 0, arr.length - 1);
        for (int i : arr) {
            System.out.print(i);
        }
    }

    public static int[] merge(int[] a, int start, int end) {

        int[] temp = new int[end - start + 1];
        if (start >= end) {
            temp[0] = a[end];
            return temp;
        }
        int middle = (start + end) / 2;
        // 排序的数据包含middle位，即a[middle]
        int[] left = merge(a, start, middle);
        int[] right = merge(a, middle + 1, end);

        int i = 0;
        int j = 0;
        int k = 0;

        while (i < left.length && j < right.length) {
            if (left[i] <= right[j]) {
                temp[k++] = left[i++];
            } else {
                temp[k++] = right[j++];
            }
        }
        
        while (i < left.length) {
            temp[k++] = left[i++];
        }
        while (j < right.length) {
            temp[k++] = right[j++];
        }
        return temp;
    }
}
