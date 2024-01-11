import java.util.ArrayList;
import java.util.List;

public class _4noOfOccurencesOfTarget {
    public static void main(String[] args) {
        String text="abababababab";
        String target="ab";
        List<Integer> list=new ArrayList<>();

        find(text,target,0,list);
        if(list.isEmpty())System.out.println("-1");
        else System.out.println(list);
    
    }
    public static void find(String text,String target,int startIndex,List<Integer> list) {
        if(startIndex>=text.length())return;

        int idx=text.indexOf(target, startIndex);

        if(idx!=-1){
            list.add(idx);
            find(text,target,idx+1,list);
        }
        return;
    }
}
