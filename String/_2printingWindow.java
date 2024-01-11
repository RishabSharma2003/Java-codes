public class _2printingWindow {
    public static void main(String[] args) {
        String s="welcometojava";

        int k=3;//3 substring

        String ans="";
        for(int i=0;i<k;i++)ans+=s.charAt(i);
        System.out.println(ans);

        for(int i=k;i<s.length();i++){
            ans+=s.charAt(i);
            ans=ans.substring(1,ans.length());
            System.out.println(ans);
        }
    }
}
