public class _15boardStep {
    public static void main(String[] args) {
        System.out.println(boardPath(4,0,""));
    }

    public static int boardPath(int n,int curr,String ans) {
        if(curr==n){
            System.out.print(ans+" ");
            return 1;
        }
        if(curr>n)return 0;

        // int fs=boardPath(n, curr+1, ans+1);
        // int sp=boardPath(n, curr+2, ans+2);
        // int tp=boardPath(n, curr+3, ans+3);
        // return fs+sp+tp;

        int count=0;
        for(int step=1;step<=3;step++){
            count =count+boardPath(n, curr+step, ans+step);
        }
        //for result
        return count;
    }
}
