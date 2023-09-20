import java.util.*;
public class _1palindrome_recursion {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String s="malayalam";
        System.out.println(pal(s,0,s.length()-1));
    }
    public static boolean pal(String s,int i,int j) {
        if(s.charAt(i)!=s.charAt(j)){
            return false;
        }
        if(i<j)pal(s,i+1,j-1);
        return true;
    }
}
