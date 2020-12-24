import java.util.Scanner;

public class Solution1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        if (scanner.hasNext()){
            int n = scanner.nextInt();
            System.out.println(calculate(n));
        }
    }

    public static int calculate(int n) {
        if (n==1)
            return 1;
        if (n==2)
            return 2;
        return calculate(n - 1) + calculate(n - 2);
    }
}
