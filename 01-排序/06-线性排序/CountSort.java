import java.util.Arrays;

public class CountSort {

    public static void main(String[] args) {
        int[] arr = {8, 3, 5, 6, 1, 3, 7, 6};
        countingSort(arr, arr.length);
        Arrays.stream(arr).forEach(System.out::print);
    }

    /**
     * 计数排序
     * 
     * @param a 数组
     * @param n 数组大小
     */
    public static void countingSort(int[] a, int n) {
        if (n <= 1) {
            return;
        }

        // 查找数组中数据的范围
        int max = a[0];
        for (int i = 1; i < n; i++) {
            if (max < a[i]) {
                max = a[i];
            }
        }

        // 申请一个计数数组,下标大小[0,max]
        int[] c = new int[max + 1];
        for (int i = 0; i <= max; i++) {
            c[i] = 0;
        }

        // 计算每个元素的个数，放入c中
        for (int i = 0; i < n; i++) {
            c[a[i]]++;
        }

        // 依次累加
        for (int i = 1; i <= max; i++) {
            c[i] = c[i - 1] + c[i];
        }

        // 临时数组r，存放排序以后的结果
        int[] r = new int[n];

        // 计数排序的关键步骤
        for (int i = n - 1; i >= 0; i--) {
            int index = c[a[i]] - 1;
            r[index] = a[i];
            c[a[i]]--;
        }

        // 结果拷贝给a数组
        for (int i = 0; i < n; i++) {
            a[i] = r[i];
        }
    }
}
