import java.util.Arrays;

public class _1fibo {
    public static void main(String[] args){
        //memorization top down approach
        System.out.println(fib(10));
        //DP(avoid recursion) bottom up approach
        System.out.println(fibDP(10));
    }
    public static int fib(int n) {
        int a[]=new int[n+1];
        Arrays.fill(a,-1);
        //recursive function below
        return fib(n,a);
    }
    public static int fib(int n,int[]a){
        if(n==0||n==1){
            a[n]=n;
            return a[n];
        }
        if(a[n]!=-1){
            return a[n];
        }
        a[n]=fib(n-1, a)+fib(n-2, a);
        return a[n];
    }

    // 2nd approach 

    public static int fibDP(int n){
        int storage[]=new int [n+1];
        storage[0]=0;
        storage[1]=1;
        for(int i=2;i<storage.length;i++){
            storage[i]=storage[i-1]+storage[i-2];
        }
        return storage[n];
    }
}
