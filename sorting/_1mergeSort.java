public class _1mergeSort {
    public static void main(String[] args) {
        int a[]={2, 6, 8 ,5 ,4 ,3, 9};
        mergeSort(a, 0, a.length-1);
        for(int i:a)System.out.print(i+" ");
    }
    public static void mergeSort(int arr[],int st,int ed) {
        if(st>=ed)return;
        int mid=(st+ed)/2;
        mergeSort(arr, st, mid);
        mergeSort(arr, mid+1,ed);
        merge(arr,st,mid,ed);
    }
    public static void merge(int[] arr,int st,int mid, int ed) {
        int n=ed-st+1;
        int i=st,j=mid+1,k=0;
        int output[]=new int[n];
        while(i<=mid&&j<=ed){
            if(arr[i]<arr[j])
                output[k++]=arr[i++];
            else  
                output[k++]=arr[j++];  
        }
        while(i<=mid){
            output[k++]=arr[i++];
        }
        while(j<=ed){
            output[k++]=arr[j++];
        }

        //for(int x=0;x<output.length;x++)arr[st++]=output[x];
        int m=0;
        for(int x=st;x<=ed;x++)arr[x]=output[m++];
    }
}
