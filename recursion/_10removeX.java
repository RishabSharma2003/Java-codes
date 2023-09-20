public class _10removeX {
    public static void main(String[] args) {
        System.out.println(remove("xabxxbcx"));
    }
    public static String remove(String s){
        // if(s.length()==0)return "";
        // String ans="";
        // if(s.charAt(0)!='x'){
        //     ans+=s.charAt(0);
        // }
        // String samllAns=remove(s.substring(1));
        // return ans+samllAns;

        if(s.length()==0)return "";
        String smallAns=remove(s.substring(1));
        String ans="";
        if(s.charAt(0)!='x'){
            ans+=s.charAt(0);
        }
        return ans+smallAns;
    }
}
