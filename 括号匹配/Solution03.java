import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution03 {
    static int get(String str) {
        int index;
        int count = 0;
        while ((index = str.indexOf("()")) != -1) {
            count++;
            String left = "";
            String right = "";
            if (index != 0) {
                left = str.substring(0, index);
            }
            if (index + 2 < str.length()) {
                right = str.substring(index + 2);
            }
            str = left + right;
        }
        if (str.length() == 0) {
            return count;
        } else {
            return -1;
        }

    }

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String str;
        while ((str = bf.readLine()) != null) {
            char[] chars = str.toCharArray();
            String newStr = "";
            for (int i = 0; i < chars.length; i++) {
                if (chars[i] == '(' || chars[i] == ')') {
                    newStr = newStr + chars[i];
                }
            }
            System.out.println(get(newStr));
        }
    }
}
