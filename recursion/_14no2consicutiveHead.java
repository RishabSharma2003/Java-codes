public class _14no2consicutiveHead {
    public static void main(String[] args) {
        noTouchedHead(3,"");
    }
    //2 head ek sath nahi none chiye
    public static void noTouchedHead(int n,String ans) {
        // if(n==0){
        //     System.out.println(ans);
        //     return;
        // }
        // if(ans.length()==0){
        //     noTouchedHead(n-1,ans+'H');
        //     noTouchedHead(n-1,ans+'T');
        // }
        // else if(ans.charAt(ans.length()-1)!='H'){
        //     noTouchedHead(n-1,ans+'H');
        //     noTouchedHead(n-1,ans+'T');
        // }
        // else {noTouchedHead(n-1,ans+'T');}


        if(n==0){
            System.out.println(ans);
            return;
        }
        if(ans.length()==0||(ans.charAt(ans.length()-1)!='H')){
            noTouchedHead(n-1,ans+'H');
        }
        noTouchedHead(n-1,ans+'T');

    }
}
