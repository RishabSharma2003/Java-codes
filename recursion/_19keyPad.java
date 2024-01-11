public class _19keyPad {
    static String[] key={"","abc","def","ghi","jkl","mno","pqr","stu","vwx","yz"};
    public static void main(String[] args) {
        keyAns("12","");
    }
    public static void keyAns(String s,String ans) {
        if(s.length()==0){
            System.out.println(ans);
            return;
        }
        char ch=s.charAt(0);
        //0->48
        //1->49
        //2->50
        //3->51
        //4->52
        //5->53
        //49-48=1(idx)
        String pressKey=key[ch-'0'];
        System.out.println("pressedKey "+pressKey);
        for(int i=0;i<pressKey.length();i++){
            keyAns(s.substring(1),ans+pressKey.charAt(i));
        }
    }
}
