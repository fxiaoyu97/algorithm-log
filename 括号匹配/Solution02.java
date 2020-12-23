
import java.util.Scanner;

/**
 * 左右括号标记，使用两个变量分别记录左右括号的数量，如果最后数量相同则输出统计的数量，否则输出-1
 */
public class Solution02 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String str = in.nextLine();
        int i = str.length() - 1;
        int left = 0;
        int right = 0;
        while (i >= 0) {
            char c = str.charAt(i);
            if (c == ')') {
                ++right;
            } else if (c == '(') {
                ++left;
            }
            --i;
        }
        if (left == right) {
            System.out.println(left);
        } else {
            System.out.println(-1);
        }
    }
}
