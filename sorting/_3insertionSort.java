public class _3insertionSort{
    public static void main(String[] args) {
        int arr[]={4,1,2,5,3};
        insertion(arr);
    }
    public static void insertion(int[] arr) {
        for(int i=1;i<arr.length;i++){
            int curr=arr[i];
            int prev=i-1;
            //finding correct pos to insert
            while (prev>=0&&arr[prev]>curr) {
                arr[prev+1]=arr[prev];
                prev--;
            }
            //insert at correct pos
            arr[prev+1]=curr;
        }
        for(int i:arr)System.out.print(i+" ");
    }
}