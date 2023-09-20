public class _17printPermutation {
    public static void main(String[] args) {
        permutation("abac","");


        // String s="a";
        // System.out.println(s.substring(1));
    }
    public static void permutation(String s,String ans) {
        if(s.length()==0){
            System.out.println(ans);
            return;
        }
        for(int i=0;i<s.length();i++){
            //for no repetition
            boolean flag=false;
            //we try to do call for last duplicate char
            //if char is peresent further then iterate not do recursive call
            for(int j=i+1;j<s.length();j++){
                if(s.charAt(i)==s.charAt(j))flag=true;
            }
            if(!flag){
                String string=s.substring(0,i)+s.substring(i+1);
                permutation(string,ans+s.charAt(i));
            }
        }
    }
}
