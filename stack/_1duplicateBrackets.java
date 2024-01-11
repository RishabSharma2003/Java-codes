import java.util.*;
public class _1duplicateBrackets {
    public static void main(String[]a){
        Stack <Character> st=new Stack<>();
        String s="(a+b)+((c+d))";
        //if true there is dulpicacy
        System.out.println(isDuplicate(s,st));

    }
    public static boolean isDuplicate(String s,Stack<Character> st){
        boolean flag=false;
        for(int i=0;i<s.length();i++){
            char ch=s.charAt(i);
            if(ch!=')'){
                st.push(ch);
            }else{
                if(st.peek()=='(')return true;
                while(st.peek()!='(')st.pop();
                st.pop();
            }
        }
        return flag;
    }

}
