import java.util.*;
public class _21largestCommonSubsequence {
    public static void main(String[] args) {
        ArrayList<String> list=new ArrayList<>();
        System.out.println(LCS("adgei","abegi","",list));
        System.out.print(list);
    }
    public static int LCS(String s1,String s2,String ans,ArrayList<String>list) {
        //agar s1 ki length 0 hai aur s2 ki length 0 nahi h tab s2 ke ele ka kuch use nahi isliye return 0
        if(s1.length()==0||s2.length()==0)return 0;
        if(s1.charAt(0)==s2.charAt(0)){
            ans=ans+s1.charAt(0);
            if(!list.contains(ans))list.add(ans);
            return 1+LCS(s1.substring(1),s2.substring(1),ans,list);
        }
        else{
            int op1=LCS(s1.substring(1),s2,ans,list);
            int op2=LCS(s1,s2.substring(1),ans,list);
            int op3=LCS(s1.substring(1),s2.substring(1),ans,list);
            return Math.max(op1,Math.max(op2,op3));
        }
    }
}
