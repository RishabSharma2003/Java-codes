public class _8binary_to_number {
    public static void main(String[] args) {
        int n = 101;
        String s = n + "";

        int ans = result(s, 0);
        System.out.println(ans);
    }

    public static int result(String s, int count_of_power) {
        if (s.length() == 0)
            return 0;
        char ch = s.charAt(0);
        if (ch == '1') {
            int ans = (int) Math.pow(2, count_of_power);
            System.out.println(ans);
            return ans + result(s.substring(1), count_of_power + 1);
        } else
            return result(s.substring(1), count_of_power + 1);
    }
}
