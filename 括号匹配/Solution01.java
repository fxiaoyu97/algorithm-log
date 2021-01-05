
import java.util.Scanner;
import java.util.Stack;

/**
 * 使用栈解法，此处有一个遗留问题
 * 如果在出栈的时候，栈为空会抛异常，缺少判断，假如 （ 的数量比 ) 的数量少，那又会怎么样？
 */
public class Solution01 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String str = in.nextLine();
        int count = 0;
        int len = str.length() - 1;
        Stack stack = new Stack<String>();
        while (len >= 0) {
            char c = str.charAt(len);
            if (c == ')') {
                stack.push(c);
            } else if (c == '(') {
                stack.pop();
                ++count;
            }
            --len;
        }
        if (stack.isEmpty()) {
            System.out.println(count);
        } else {
            System.out.println(-1);
        }
    }
}
