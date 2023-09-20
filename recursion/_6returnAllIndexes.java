public class _6returnAllIndexes {
    public static void main(String[] args) {
        int arr[]={5,6,5,5,6,5};
        int output[]=allIndex(arr,0,5);
        for(int i:output){
            System.out.print(i+" ");
        }
    }
    public static int[] allIndex(int[] a,int i,int x) {
        if(i==a.length){
            int output[]=new int[0];
            return output;
        }
        int []smallAns=allIndex(a, i+1, x);
        if(a[i]==x){
            int output[]=new int[smallAns.length+1];
            output[0]=i;
            for(int n=1;n<output.length;n++){
                output[n]=smallAns[n-1];
            }
            return output;
        }
        return smallAns;
    }
}
