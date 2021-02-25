
/**
 * 在一个无重复数据的数组中，查找指定值的位置，不存在时返回-1
 *
 * @since 2021-02-19
 */
public class SimpleBinarySearch {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6};
        System.out.println(search(arr, arr.length, 3));
        System.out.println(recursiveSearch(arr, 0, arr.length - 1, 6));
    }

    /**
     * 查找指定值的位置
     * 
     * @param arr 存放数据的数组
     * @param n 数组的长度
     * @param value 查找的值的大小
     * @return 查找到位置信息，-1表示该值不在数组中存在
     */
    public static int search(int[] arr, int n, int value) {
        int left = 0;
        int right = n - 1;
        while (left <= right) {
            int mid = left + ((right - left) >> 1);
            if (arr[mid] == value) {
                return mid;
            } else if (arr[mid] > value) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return -1;
    }

    /**
     * 递归解法
     * 
     * @param arr 数组
     * @param left 左边界
     * @param right 右边界
     * @param value 查找的值
     * @return 查找的结果
     */
    public static int recursiveSearch(int[] arr, int left, int right, int value) {
        if (left > right) {
            return -1;
        }
        int mid = left + ((right - left) >> 1);
        if (arr[mid] == value) {
            return mid;
        } else if (arr[mid] > value) {
            return recursiveSearch(arr, left, mid - 1, value);
        } else {
            return recursiveSearch(arr, mid + 1, right, value);
        }
    }
}
