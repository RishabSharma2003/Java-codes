public class _2practice {
    public static void main(String[] args) {
        int arr[]={5,9,2,3,1,7};
        merge(arr, 0, arr.length-1);
        for(int i:arr)System.out.print(i+" ");
    }
    public static void merge(int []arr,int start,int end) {
        if(start>=end)return;
        int mid=(start+end)/2;
        merge(arr,start,mid);
        merge(arr,mid+1,end);
        merge(arr,start,mid,end);
    }
    public static void merge(int[]arr,int st,int mid,int ed) {
        int size=ed-st+1;
        int out[]=new int[size];
        int i=st,j=mid+1,k=0;
        while(i<=mid&&j<=ed){
            if(arr[i]<arr[j]){
                out[k++]=arr[i++];
            }else{
                out[k++]=arr[j++];
            }
        }while(j<=ed){
            out[k++]=arr[j++];
        }while(i<=mid){
            out[k++]=arr[i++];
        }

        int m=0;
        for(int x=st;x<=ed;x++)arr[x]=out[m++];
    }
}
