import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

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
