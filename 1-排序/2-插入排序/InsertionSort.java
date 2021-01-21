import java.util.Arrays;

public class InsertionSort {
    public static void main(String[] args) {
        int[] arr = {1, 2, 8, 3, 5, 4, 7, 6};
        for (int i = 1; i < arr.length; i++) {
            int value = arr[i];
            int k = i - 1;
            for (; k >= 0; k--) {
                // 插入数据到指定位置
                if (arr[k] > value) {
                    arr[k + 1] = arr[k];
                } else {
                    break;
                }
            }
            arr[k + 1] = value;
        }
        Arrays.stream(arr).forEach(System.out::print);
    }
}
