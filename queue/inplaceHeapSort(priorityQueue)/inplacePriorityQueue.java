public class inplacePriorityQueue {
    public static void main(String[] args) {
        int arr[]={5,1,9,2,0,6};
        // yeh insertIntoVirtualHeap function arr ko heap me convert ker dega
        for(int i=0;i<arr.length;i++)insertIntoVirtualHeap(arr,i);
        // yeh function heap ko sort ker dega           remove hua ele array ke last me bhi to dalna h
        for(int i=0;i<arr.length;i++)arr[arr.length-1-i]=removefromVirtualHeap(arr,arr.length-i);
        //we get rev ans as we have to start put ele at from last idx as last idx is only free for that
        for(int i:arr)System.out.print(i+" ");
    }
    private static void insertIntoVirtualHeap(int []arr,int i){
        int childIdx=i;
        int parentIdx=(childIdx-1)/2;
        while(childIdx>0){
            if(arr[parentIdx]>arr[childIdx]){
                int temp=arr[parentIdx];
                arr[parentIdx]=arr[childIdx];
                arr[childIdx]=temp;

                //again

                childIdx=parentIdx;
                parentIdx=(childIdx-1)/2;   
            }
            else{
                return;
            }
        }
    }
    public static int removefromVirtualHeap(int []arr,int heapSize){
        //swapping 
        int temp1=arr[0];
        arr[0]=arr[heapSize-1];
        heapSize--;
        
        int index=0;
        int leftChildIdx=1;
        int rightChildIdx=2;
        while(leftChildIdx<heapSize){
            int minIdx=index;
            if(arr[index]>arr[leftChildIdx]){
                minIdx=leftChildIdx;
            }
            if(rightChildIdx<heapSize&&arr[minIdx]>arr[rightChildIdx]){
                minIdx=rightChildIdx;
            }
            if(minIdx==index)break;
            int temp=arr[index];
            arr[index]=arr[minIdx];
            arr[minIdx]=temp;
            index=minIdx;
            leftChildIdx=2*index+1;
            rightChildIdx=2*index+2;
        }
        System.out.println(temp1);
        return temp1;
    }
}
