import java.util.*;
public class _3KlargestElement {
    public static void main(String[] args) {
        int[]arr={2,15,8,9,12,13,20};
        //we need top 3 largest ele
        PriorityQueue<Integer> pq=Kmax(arr,3);
        System.out.println(pq);
    }
    public static PriorityQueue<Integer> Kmax(int arr[],int k) {
        PriorityQueue<Integer> pq=new PriorityQueue<>();
        int i=0;
        for(;i<k;i++)pq.add(arr[i]);
        for(;i<arr.length;i++){
            int min=pq.peek();
            if(min<arr[i]){
                pq.remove();
                pq.add(arr[i]);
            }
        }
        return pq;
    }
}
