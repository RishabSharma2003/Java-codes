public class _9palinrome {
    public static void main(String[] args) {
        System.out.println(pal("racecar"));
    }
    public static boolean pal(String s) {
        if(s.length()==0||s.length()==1)return true;
        if(s.charAt(0)==s.charAt(s.length()-1)){
            return pal(s.substring(1, s.length()-1));
        }
        return false;
    }
}
