public class _12removeDuplicates {
    public static void main(String[] args) {
        String s="xxxyyyzzzaaa";
        System.out.println(remove(s));
    }
    public static String remove(String s) {
        if(s.length()==1)return s;
        if(s.charAt(0)==s.charAt(1))return remove(s.substring(1));
        return s.charAt(0)+remove(s.substring(1));
    }
}
