import java.util.*;
public class _16parenthesisGeneration {
    public static void main(String[] args) {
        System.out.print(parenthesis_leetcode(3));
    }
    public static List<String> parenthesis_leetcode(int n){
        List<String> l=new ArrayList<>();
        parentesis(3,0,0,"",l);
        return l;
    }
    public static void parentesis(int n,int opening,int closing,String ans,List<String> l) {
        if(opening==n&&closing==n){
            l.add(ans);
            //System.out.println(ans);
            return;
        }
        if(opening<n)parentesis(n,opening+1,closing,ans+'(',l);
        if(closing<opening)parentesis(n,opening,closing+1,ans+')',l);
    }
}
