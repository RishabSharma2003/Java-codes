import java.util.*;
public class _1reverseByWord {
    public static void main(String[] args) {
        String s="aaabbcddeeeee";
        // HashMap<Character,Integer> map=new HashMap<>();
        // for(char i:s.toCharArray()){
        //     map.put(i,map.getOrDefault(i,0)+1);
        // }
        // char c='0';
        // int max=0;
        // for(Map.Entry<Character,Integer> entry:map.entrySet()){
        //     if(entry.getValue()>max){
        //         c=entry.getKey();
        //         max=entry.getValue();
        //     }
        // }
        













        String res="";
    StringBuilder sb=new StringBuilder(res);
    HashMap<Character,Integer> map=new HashMap<>();
	for(char c:s.toCharArray()){
		map.put(c,map.getOrDefault(c,0)+1);
	}
	// for(Map.Entry<Character,Integer> entry:map.keySet()){
	// 	res+=entry.getKey();
	// 	res+=entry.getValue();
	// }
    for(Map.Entry<Character,Integer> entry:map.entrySet()){
            res+=entry.getKey();
		res+=entry.getValue();
        }
	System.out.println(res);
	}
    }
