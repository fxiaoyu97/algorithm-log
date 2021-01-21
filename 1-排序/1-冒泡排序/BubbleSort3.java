import java.util.Arrays;

public class BubbleSort3 {
    public static void main(String[] args) {
        int[] arr = {1, 2, 8, 3, 5, 4, 7, 6};
        /**
         * 核心代码，比较两个相邻数大小，符合条件则交换位置
         */
        // start标记需要比较的元素起始位置，标记前面的数字都是有序的
        int start = 0;
        for (int i = 0; i < arr.length; i++) {
            // 增加判断是否进行交换的标记，默认没有交换数据，设为true
            boolean flag = true;
            for (int j = start; j < arr.length - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    if (flag) {
                        start = j > 0 ? j - 1 : j;
                    }
                    // 修改结束标记
                    flag = false;
                }
            }
            if (flag) {
                break;
            }
        }

        Arrays.stream(arr).forEach(System.out::print);
    }
}
