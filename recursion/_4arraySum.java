public class _4arraySum {
    public static void main(String[] args) {
        int arr[]={2,3,5,-3,5,1};
        System.out.println(sumOfArray(arr,0));
    }
    public static int sumOfArray(int []a,int i) {
        if(i==a.length)return 0;
        return a[i]+sumOfArray(a, i+1);
    }
}
