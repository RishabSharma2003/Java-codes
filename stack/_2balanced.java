import java.util.*;
public class _2balanced {
    public static void main(String[] args) {
        //String s="[(a+b)+{(c+d)*(e/f)}]";//true
        //String s="[(a+b)+{(c+d)*(e/f)]}";//false
        String s = "while (i < n) { sum += i; i++; }";
        Stack<Character> st=new Stack<>();
        
        for(int i=0;i<s.length();i++){
            char ch=s.charAt(i);

            if(ch=='('||ch=='{'||ch=='['){
                st.push(ch);
            }else if(ch==')'){
                boolean val=check(st,'(');
                if(val==false){
                    System.out.println("false");
                    return;
                }
            }else if(ch==']'){
                boolean val=check(st,'[');
                if(val==false){
                    System.out.println("false");
                    return;
                }
            }else if(ch=='}'){
                boolean val=check(st,'{');
                if(val==false){
                    System.out.println("false");
                    return;
                }
            }
        }
        if(!st.isEmpty())System.out.println("false");
        else System.out.println("true");
        
    }

    public static boolean check(Stack<Character> st,char ch){
        if(st.size()==0)return false;
        else if(st.peek()!=ch)return false;
        st.pop();
        return true;
    }
}