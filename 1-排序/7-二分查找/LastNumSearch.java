/**
 * 在一个有重复数据的数组中，查找某个数值最后一次出现的位置
 *
 * @since 2021-02-19
 */
public class LastNumSearch {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 3, 4, 5, 5, 6, 6, 6, 7, 8, 8};
        System.out.println(search(arr, 0, arr.length - 1, 6));
        System.out.println(search2(arr, 0, arr.length - 1, 6));
    }

    /**
     * 查找指定值最后一次出现的位置
     * 
     * @param arr 数组
     * @param left 查找范围左边起始位置
     * @param right 查找范围右边终止位置
     * @param value 要查找的值
     * @return 查找的结果
     */
    private static int search(int[] arr, int left, int right, int value) {
        while (left <= right) {
            int mid = left + ((right - left) >> 1);
            if (arr[mid] > value) {
                right = mid - 1;
            } else if (arr[mid] < value) {
                left = mid + 1;
            } else {
                if (mid == arr.length - 1 || arr[mid + 1] != value) {
                    return mid;
                } else {
                    left = mid + 1;
                }
            }
        }
        return -1;
    }

    /**
     * 查找指定值最后一次出现的位置
     *
     * @param arr 数组
     * @param left 查找范围左边起始位置
     * @param right 查找范围右边终止位置
     * @param value 要查找的值
     * @return 查找的结果
     */
    private static int search2(int[] arr, int left, int right, int value) {
        while (left <= right) {
            int mid = left + ((right - left) >> 1);
            if (arr[mid] <= value) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        if (arr[right] == value) {
            return right;
        }
        return -1;
    }
}
