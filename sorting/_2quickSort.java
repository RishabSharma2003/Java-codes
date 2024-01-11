public class _2quickSort {
    //better as no additional array
    public static void main(String[] args) {
        int a[]={5,8,7,2,3,1,9};
        quickSort(a, 0, a.length-1);
        for(int i:a)System.out.print(i+" "); 
    }
    public static void quickSort(int[] arr,int si,int ed) {
        if(si>=ed)return;

        int Pidx= partition(arr,si,ed);
        quickSort(arr, si,Pidx-1);//left
        quickSort(arr,Pidx+1,ed);//right
    }
    public static int partition(int []arr,int si,int ed) {
        //end vale ele ko pivot man rahe h
        int pivot=arr[ed];
        int i=si-1;// to make a space for ele  samaller than pivot

        for(int j=si;j<ed;j++){
            if(arr[j]<=pivot){
                i++;
                //swap
                int temp=arr[j];
                arr[j]=arr[i];
                arr[i]=temp;
            }
        }
        //place the last pivot ele at its correct position
        i++;
        arr[ed]=arr[i];
        arr[i]=pivot;
        return i;
    }





    // public static void quickSort(int []a,int si,int ed){
    //     if(si>=ed)return;
    //     int p=partition(a,si,ed);
    //     quickSort(a, si,p-1);
    //     quickSort(a, p+1, ed);
    // }
    // public static int partition(int[] a,int si,int ed) {
    //     int pivot=a[si];
    //     int countSmaller=0;
    //     //remember to put si+1 in place of si kyoki usse to compare kerke koi fayda nahi h
    //     for(int i=si+1;i<=ed;i++){
    //         if(a[i]<=pivot)countSmaller++;
    //     }
    //     int pivotIdx=si+countSmaller;
    //     //swap
    //     a[si]=a[pivotIdx];
    //     a[pivotIdx]=pivot;

    //     int i=si;
    //     int j=ed;
    //     //dono me se ek bhi pivot per pauch gya i will stop
    //     while(i<pivotIdx&&j>pivotIdx){
    //         if(a[i]<=pivotIdx)i++;
    //         else if(a[j]>pivotIdx)j--;
    //         else{
    //             int temp=a[i];
    //             a[i]=a[j];
    //             a[j]=temp;
    //             i++;j--;
    //         }
    //     }
    //     return pivotIdx;
    // }
}
