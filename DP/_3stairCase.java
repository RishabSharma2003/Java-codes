public class _3stairCase {
    public static void main(String[] args) {
        System.out.print(stairCaseDP(10));
    }

    public static int stairCase(int n){
        if(n<0)return 0;
        if(n==0)return 1;
        return stairCase(n-1)+stairCase(n-2)+stairCase(n-3);
        
    }
    //dp
    public static int stairCaseDP(int n) {
        int a[]=new int[n+1];
        a[0]=1;a[1]=1;a[2]=2;
        for(int i=3;i<=n;i++){
            a[i]=a[i-1]+a[i-2]+a[i-3];
        }return a[n];
    }
}
