import java.util.Arrays;

public class BubbleSort2 {
    public static void main(String[] args) {
        int[] arr = {3, 5, 4, 1, 2, 6};
        /**
         * 核心代码，比较两个相邻数大小，符合条件则交换位置
         */
        for (int i = 0; i < args.length; i++) {
            // 增加判断是否进行交换的标记，默认没有交换数据，设为true
            boolean flag = true;
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    // 修改标记
                    flag = false;
                }
            }
            // 没有元素交换，可以结束排序
            if (flag) break;
        }
        Arrays.stream(arr).forEach(System.out::print);
    }
}
