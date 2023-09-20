import java.util.*;
public class _replaceCharWithX {
    public static void main(String[] args) {
        System.out.println("enter the string");
        Scanner sc=new Scanner(System.in);
        String s=sc.next();

        System.out.println("enter the char which do u want to replace with x");
        char c=sc.next().charAt(0);
        System.out.println(replace(s,0,c));
    }
    public static String replace(String s,int i,char c){
        if(s.length()==i)return "";
        String ans="";
        if(s.charAt(i)==c){
            ans+='x';
        }else ans+=s.charAt(i);
        String smallAns=replace(s,i+1,c);
        return ans+smallAns;
    }
}
