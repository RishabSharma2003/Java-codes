public class _4selection {
    public static void main(String[] args) {
        int arr[]={6,4,8,7,3};
        for(int i=0;i<arr.length;i++){
            int minidx=i;
            for(int j=i+1;j<arr.length;j++){
                if(arr[j]<arr[minidx])minidx=j;
            }
            int temp=arr[i];
            arr[i]=arr[minidx];
            arr[minidx]=temp;
        }

        for(int i:arr)System.out.print(i+" ");
    }
}
