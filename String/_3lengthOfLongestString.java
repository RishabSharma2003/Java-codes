public class _3lengthOfLongestString {
    public static void main(String[] args) {
        String s="Welcome to chitkara rajpura campus";

        int max=longest(s,0,-1,0);
        System.out.println(max);
    }
    public static int longest(String s,int i,int max,int back) {
        if(i==s.length())return max;
        if(s.charAt(i)==' '){
            max=Math.max(max,i-back);
            back=i+1;
        }
        return longest(s, i+1, max, back);
        
    }
}
