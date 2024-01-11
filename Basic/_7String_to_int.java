public class _7String_to_int {
    public static void main(String[] args) {
        // use Integer.parseInt(s) instead
        String s = "34257";

        int n = res(s, 0);
        System.out.println(n);
    }

    public static int res(String s, int n) {
        if (s.length() == 0)
            return n / 10;
        int number = s.charAt(0) - '0';
        return res(s.substring(1), (n + number) * 10);
    }
}
