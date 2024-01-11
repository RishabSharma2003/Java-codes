public class _8findIndex {
    public static void main(String[] args) {
        String s = "ABCABCBABCABBCABCABAC";
        String pattern = "ABCAB";
        int j = 0, idx = 0;

        for (int i = 0; i <= s.length(); i++) {
            if (j == pattern.length()) {
                System.out.println(idx);
                j = 0;
            } else if (i == s.length()) {
                // nahi to error de dega niche vali condition ke liye
                break;
            } else if (s.charAt(i) == s.charAt(j)) {
                j++;
            } else {
                idx = i + 1;
                j = 0;
            }
        }
        System.out.println("end");

    }
}
