public class _2minStepsTo1 {
    public static void main(String[] args) {
        System.out.println(minStepsDP(6));
    }

    public static int minSteps(int n){
        if(n==1)return 0;
        int opt1=minSteps(n-1);
        int opt2=100;
        if(n%2==0){
            opt2=minSteps(n/2);
        }
        int opt3=100;
        if(n%3==0){
            opt3=minSteps(n/3);
        }
        return 1+Math.min(opt1,Math.min(opt2,opt3));
    }

    public static int minSteps1(int n){
        if(n==1)return 0;
        int op1=minSteps1(n-1);
        int minstep=op1;
        if(n%3==0){
            int op2=minSteps1(n/3);
            if(op2<minstep)minstep=op2;
        }
        if(n%2==0){
            int op3=minSteps1(n/2);
            if(op3<minstep)minstep=op3;
        }
        return minstep+1;
    }

    // memorization
    public static int minStepsM(int n){
        int a[]=new int[n+1];
        return minStepsM(n,a);
    }
    public static int minStepsM(int n,int []a){
        if(n==1)return 0;

        if(a[n]!=0)return a[n];

        int op1=minStepsM(n-1,a);
        int minstep=op1;
        if(n%3==0){
            int op2=minStepsM(n/3,a);
            if(op2<minstep)minstep=op2;
        }
        if(n%2==0){
            int op3=minStepsM(n/2,a);
            if(op3<minstep)minstep=op3;
        }
        a[n]=minstep+1;
        return a[n];
    }

    //dp
    public static int minStepsDP(int n){
        int a[]=new int[n+1];
        a[1]=0;//a[2]=1;a[3]=1;
        for(int i=2;i<=n;i++){
            int min=a[i-1];
            
            if(i%3==0){
                if(min>a[i/3]){
                    min=a[i/3];
                }
            }

            if(i%2==0){
                if(min>a[i/2]){
                    min=a[i/2];
                }
            }

            a[i]=1+min;
        }
        return a[n];
    }
}
