public class _13coin {
    public static void main(String[] args) {
        tossVriation(2,"");
    }
    public static void tossVriation(int n,String ans) {
        if(n==0){
            System.out.println(ans);
            return;
        }
        tossVriation(n-1,ans+'H');
        tossVriation(n-1,ans+'T');
    }
}
