import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class _5goodSubArray {
    public static void main(String[] args) {
        int k=3;
        int arr[]={1 ,2 ,1 ,2 ,3};

        List<String> list=new ArrayList<>();
        String x=Arrays.toString(arr).replace("[","").replace("]","").replace(",","").replace(" ","");

        for(int i=0;i<arr.length;i++){
            for(int j=i+1;j<arr.length+1;j++){
                String s=x.substring(i, j);
                check(s,k,list);
            }
        }
        System.out.println(list);
    }
    public static void check(String s,int k,List<String> list) {
        HashMap<Character,Integer> map=new HashMap<>();
        for(int i=0;i<s.length();i++){
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0)+1);
        }
        if(map.size()==k)list.add(s);
    }
}
