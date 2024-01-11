public class _22editDistance {
    public static void main(String[] args) {
        //de is cooman is this string
        System.out.println(ED("adef","gbde"));
    }
    public static int ED(String s1,String s2) {
        //jitne letter bachge utne delete operation kerne padege
        if(s1.length()==0)return s2.length();
        if(s2.length()==0)return s1.length();
        if(s1.charAt(0)==s2.charAt(0)){
            System.out.println(s1+" "+s2);
            return ED(s1.substring(1),s2.substring(1));
        }
        else{
            //hum s1 ke correspnding operation ker rahe h s2 ko const rakhke
            //s1 gh s2 igh
            //insert
            int op1=ED(s1,s2.substring(1));
            //s1 xgrt s2 rt delete x&gv'
            //del
            int op2=ED(s1.substring(1),s2);
            // s1 abc s2 dbc replace a with c 
            //subsitute
            int op3=ED(s1.substring(1),s2.substring(1));
            return 1+Math.min(op1,Math.min(op2,op3));
        }
    }
}
