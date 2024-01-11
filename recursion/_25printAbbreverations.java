public class _25printAbbreverations {
    public static void main(String[] args) {
        String s="pep";
        abbreverations(s,0,0,"");
    }
    public static void abbreverations(String s,int i,int count,String ans) {
        if(s.length()==i){
            if(count>0){
                                System.out.println(ans+count);
                return;
            }else{
                System.out.println(ans);
                return;
            }
        }
        abbreverations(s,i+1,count+1,ans);
        
        if(count==0)abbreverations(s,i+1,0,ans+s.charAt(i));
        else abbreverations(s,i+1,0,ans+count+s.charAt(i));

    }
}
