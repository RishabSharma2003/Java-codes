public class _1maxScoreOfWords{
    public static void main(String[] args) {
        String[] words={"dog","cat","dad","good"};
        char letters[]={'a','b','c','d','d','d','g','o','o'};
        int FreqArray_Of_Letters[]=new int[26];
        for(int i=0;i<letters.length;i++){
            FreqArray_Of_Letters[letters[i]-'a']++;
        }
        int score[]={1,0,9,5,0,0,3,0,0,0,0,0,0,0,2,0,0,0,0,0,0,0,0,0,0,0};
        System.out.println(solution(words,FreqArray_Of_Letters,score,0,""));
    }

    public static int solution(String[] words,int FreqArray_Of_Letters[],int score[],int idx,String ans) {
        if(idx==words.length){
            System.out.println(ans);
            return 0;
        }
        //ignore
        int ans1=0+solution(words,FreqArray_Of_Letters,score,idx+1,ans+"ignore "+words[idx]+" score "+0+"**");

        //include
        int scoreWord=0;
        String wordAtIdx=words[idx];
        boolean flag=true;//yes call can be made

        for(char i:wordAtIdx.toCharArray()){
            if(FreqArray_Of_Letters[i-'a']==0){
                flag=false;//skip the word as it is not in FreqArray_Of_Letters
            }
            FreqArray_Of_Letters[i-'a']--;
            scoreWord+=score[i-'a'];
        }

        int ans2=0;
        if(flag){
            ans2=scoreWord+solution(words,FreqArray_Of_Letters,score,idx+1,ans+"added "+words[idx]+" score "+scoreWord+"**");
        }
        for(char i:wordAtIdx.toCharArray()){
            FreqArray_Of_Letters[i-'a']++;
        }
        return Math.max(ans1, ans2);
        
        
    }
}