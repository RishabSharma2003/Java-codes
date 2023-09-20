import java.util.ArrayList;
import java.util.HashMap;

public class _1removeDuplicates {
    public static void main(String[] args){
        int a[]={1,3,4,2,2,2,10000,3,2};
        ArrayList<Integer> output=removeDuplicates(a);
        System.out.print(output);
    }

    public static ArrayList<Integer> removeDuplicates(int []a){
        ArrayList<Integer> output=new ArrayList<>();
        HashMap<Integer,Boolean> seen=new HashMap<>();
        for(int i=0;i<a.length;i++){
            //if it is already present then we are skipping it
            if(seen.containsKey(a[i]))continue;
            output.add(a[i]);
            seen.put(a[i],true);
        }
        return output;
    }
}
