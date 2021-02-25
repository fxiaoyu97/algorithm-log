import java.util.Arrays;

public class BubbleSort {
    public static void main(String[] args) {
        int[] arr = {3, 5, 4, 1, 2, 6};
        /**
         * 核心代码，比较两个相邻数大小，符合条件则交换位置
         */
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int tmp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = tmp;
                }
            }
        }

        Arrays.stream(arr).forEach(System.out::print);
    }
}
