public class _7makeNoGreater {
    public static void main(String[] args) {
        int n = 3;
        String s = "5443211";
        String ans = "";
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) - '0' >= n && s.charAt(i + 1) - '0' < n) {
                ans += s.charAt(i);
                ans += n;
            } else {
                ans += s.charAt(i);
            }
        }
        System.out.println(ans);
    }
}
