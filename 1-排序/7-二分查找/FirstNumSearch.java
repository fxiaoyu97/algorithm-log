
/**
 * 在一个有重复数据的数组中，查找某个数值第一次出现的位置
 *
 * @since 2021-02-20
 */
public class FirstNumSearch {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 3, 4, 5, 5, 6, 6, 6, 7, 8, 8};
        System.out.println(search(arr, 0, arr.length - 1, 6));
        System.out.println(search2(arr, 0, arr.length - 1, 6));
    }

    /**
     * 查找value第一次出现的位置
     * 
     * @param arr 数组
     * @param left 其实位置
     * @param right 结束位置
     * @param value 要查找的值
     * @return 查找结果
     */
    public static int search(int[] arr, int left, int right, int value) {
        while (left <= right) {
            int mid = left + ((right - left) >> 1);
            if (arr[mid] > value) {
                right = mid - 1;
            } else if (arr[mid] < value) {
                left = mid + 1;
            } else {
                if (mid == 0 || arr[mid - 1] != value) {
                    return mid;
                } else {
                    right = mid - 1;
                }
            }
        }
        return -1;
    }

    /**
     * 更加简洁的方法
     * 
     * @param arr 数组
     * @param left 左前起始位置
     * @param right 右边终止位置
     * @param value 查找的值
     * @return 查找的位置
     */
    public static int search2(int[] arr, int left, int right, int value) {
        while (left <= right) {
            int mid = left + ((right - left) >> 1);
            if (arr[mid] >= value) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        if (arr[left] == value) {
            return left;
        }
        return -1;
    }
}
