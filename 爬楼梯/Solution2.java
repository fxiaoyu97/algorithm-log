import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
/**
 * 之所以比递归快，是因为递归存在重复计算的问题
 */
public class Solution2 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String str;
        while ((str = bufferedReader.readLine()) != null) {
            int n = Integer.parseInt(str);
            int[] count = new int[n+1];
            count[1] = 1;
            count[2] = 2;
            for (int i = 3; i <= n; i++) {
                count[i] = count[i - 1] + count[i - 2];
            }
            System.out.println(count[n]);
        }
    }
}
