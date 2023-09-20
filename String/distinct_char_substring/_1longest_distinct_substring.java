import java.util.Scanner;
public class _1longest_distinct_substring {
    public static void main(String[] args) {
        //given a string find the longest distinct substring time complexity 2n

        Scanner sc=new Scanner(System.in);
        String s=sc.next();

        System.out.print(longestSubstringLengthOfDistinctChar(s));
    }
    public static int longestSubstringLengthOfDistinctChar(String s){

        if(s.length()==0)return 0;

        int maxLen=1;

        for(int i=0;i<s.length()-1;i++){
            //we have take size of 128 as 127(0-127)contain space so string can also contain a space
            boolean isVisited[]=new boolean[128];
            isVisited[s.charAt(i)]=true;

            for(int j=i+1;j<s.length();j++){
                if(isVisited[s.charAt(j)])break;

                isVisited[s.charAt(j)]=true;
                //+1 as we are working on idexes
                maxLen=Math.max(maxLen,j-i+1);
            }
        }
        return maxLen;
    }
}
