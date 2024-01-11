import java.util.HashMap;

public class _9LPS {
    public static void main(String[] args) {
        String str="abcdcba";
        String s="#";
        for(int i=0;i<str.length();i++)s+=str.charAt(i)+"#";

        System.out.println(s);
        int max=-1;
        String ans="";

        for(int i=0;i<s.length();i++){
            int left=i-1,right=i+1;
            while(left!=-1&&right!=s.length()){
                if(s.charAt(left)==s.charAt(right)){
                    if(right-left>max){
                        max=right-left;
                        ans=s.substring(left,right+1);
                    }
                    left--;right++;
                }
                else break;
            }
        }
        ans=ans.replace("#","");
        System.out.println(ans);

    }
}
