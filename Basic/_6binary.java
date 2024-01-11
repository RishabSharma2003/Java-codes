import java.util.Scanner;

public class _6binary {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String ans = int_to_binary(n, "");
        int a = Integer.parseInt(ans);
        System.out.println(a);
    }

    public static String int_to_binary(int n, String ans) {
        if (n == 1)
            return "1" + ans;
        int rem = 1;
        if (n % 2 == 0)
            rem = 0;
        return int_to_binary(n / 2, rem + ans);
    }
}
