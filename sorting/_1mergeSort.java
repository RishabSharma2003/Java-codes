public class _1mergeSort {
    public static void main(String[] args) {
        int a[]={2, 6, 8 ,5 ,4 ,3, 9};
        mergeSort(a, 0, a.length-1);
        for(int i:a)System.out.print(i+" ");
    }
    public static void mergeSort(int a[],int si,int ed) {
        if(si<=ed)return;
        //< for that ase if we do not have any ele(emp array)
        int mid=(si+ed)/2;
        mergeSort(a, si, mid);
        mergeSort(a, mid+1, ed);
        merge(a, si, mid, ed);
    }
    public static void merge(int[] a,int si,int mid,int ed) {
        int size=ed-si+1;//10th idx -8th idx is 2 but it has 3 ele so +1
        int i=si,j=mid+1,k=0;
        int output[]=new int[size];
        while(i<=mid&&j<=ed){
            if(a[i]>=a[j]){
                output[k++]=a[j++];
            }else{
                output[k++]=a[i++];
            }

        }
        while(i<=mid){
            output[k++]=a[i++];
        }
        while(j<=ed){
            output[k++]=a[j++];
        }
        int m=0;
        for(int x=si;x<=ed;x++)a[x]=output[m++];
    }
}
