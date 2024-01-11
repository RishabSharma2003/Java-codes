public class _3bubble {
    public static void main(String[] args) {
        int arr[]={4,5,8,3,6,2};
        for(int i=0;i<arr.length;i++){
            for(int j=0;j<arr.length-1-i;j++){
                if(arr[j]>arr[j+1]){
                    int temp=arr[j];
                    arr[j]=arr[j+1];
                    arr[j+1]=temp;
                }
            }
        }
        for(int i:arr)System.out.print(i+" ");
    }
}
