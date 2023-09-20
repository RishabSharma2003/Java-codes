public class _5lastIndexOfNumber {
    public static void main(String[] args) {
        int arr[]={5,5,6,5,6};
        System.out.println(lastIdx(arr,0,5));
    }
    public static int lastIdx(int []a,int i,int x) {
        // int option=-1;
        // if(i==a.length)return -1;
        // if(a[i]==x)option=i;
        // return Math.max(option,lastIdx(a,i+1,x));


        if(i==a.length)return -1;
        int smallAns=lastIdx(a,i+1, x);
        if(smallAns!=-1)return smallAns;
        if(a[i]==x)return i;
        else return -1;
    }
}
