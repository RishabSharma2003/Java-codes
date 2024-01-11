import java.util.*;

public class _17printPermutation {
    public static void main(String[] args) {
        // Scanner sc=new Scanner(System.in);
        // String s=sc.nextLine();
        // permutation(s,"");


        String S="1,10,8";
        List<String> list=new ArrayList<>();
        p2(S,list,"");
        System.out.println(list);
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

    public static void p2(String s,List<String> list,String ans) {
        //int arr[]={1,10,8};
        //String S=Arrays.toString(arr).replace("[","").replace("]","").replace(" ","");
        //and s becomes 1,10,8 and u want 10 as a single digit where is , is seprator

        // if(s.length()==0){
        //     list.add(ans);
        //     return;
        // }
        int commaIndex = s.indexOf(',');

        //there is only one digit left so -1 comes
        if (commaIndex == -1) {
            //one include //one exclude
            list.add(ans + "," + s);
            list.add(ans);
        }else {
            String beforeComma = s.substring(0, commaIndex);
            p2(s.substring(commaIndex + 1), list, ans + "," + beforeComma);
            p2(s.substring(commaIndex + 1), list, ans);
        }
        
    }
}
