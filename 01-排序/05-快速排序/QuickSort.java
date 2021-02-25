public class QuickSort {
    public static void main(String[] args) {
        int[] arr = {8, 3, 5, 4, 1, 2, 7, 6};
        quick_sort(arr, 0, arr.length - 1);
        for (int i : arr) {
            System.out.print(i);
        }
    }

    /**
     * 快速排序主体内容
     *
     * @param a 排序数组
     * @param start 起始位置
     * @param end 终止位置
     */
    private static void quick_sort(int[] a, int start, int end) {
        if (start >= end) {
            return;
        }

        int pivot = partition3(a, start, end);
        quick_sort(a, start, pivot - 1);
        quick_sort(a, pivot + 1, end);
    }

    /**
     * 查找区分点的方法
     *
     * @param a
     * @param start
     * @param end
     * @return
     */
    private static int partition(int[] a, int start, int end) {
        int value = a[end];
        int i = start;
        int j = end - 1;
        // 相反方向的两个游标
        while (i < j) {
            if (a[i] <= value) {
                i++;
            }
            if (a[j] >= value) {
                j--;
            }
            if (a[i] > value && a[j] < value) {
                int temp = a[i];
                a[i++] = a[j];
                a[j++] = temp;
            }
        }
        if (a[i] > value) {
            a[end] = a[j];
            a[j] = value;
            return j;
        }
        a[end] = a[j + 1];
        a[j + 1] = value;
        return j + 1;
    }

    private static int partition2(int[] a, int start, int end) {
        int value = a[end];
        int i = start;
        int j = start;
        // 相同方向的两个游标
        while (j < end && i < end) {
            if (a[i] <= value) {
                i++;
            }
            if (a[j] >= value) {
                j++;
            }
            if (a[i] > value && a[j] < value) {
                int temp = a[i];
                a[i] = a[j];
                a[j] = temp;
            }
        }
        a[end] = a[i];
        a[i] = value;
        return i;
    }

    private static int partition3(int[] a, int start, int end) {
        int value = a[end];
        int i = start;
        int j = end;

        // 相反方向的两个游标，优化代码版
        while (i < j) {
            while (i < j && a[i] <= value) {
                i++;
            }
            a[j] = a[i];
            while (i < j && a[j] >= value) {
                j--;
            }
            a[i] = a[j];
        }
        a[i] = value;
        return i;
    }
}
