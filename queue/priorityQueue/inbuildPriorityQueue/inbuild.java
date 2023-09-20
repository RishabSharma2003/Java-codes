import java.util.*;
public class inbuild {
    public static void main(String[] args) {
        PriorityQueue<Integer> pq=new PriorityQueue<>();
        //agar max comparator chiye use comparator Collections.reverseOrder() bakki sb same h
        //agar khud se banai hai queue to comaparator bhi khud se bana padega
        //PriorityQueue<Integer> pq=new PriorityQueue<>(Collections.reverseOrder());
        int arr[]={9,1,0,4,7,3};
        for(int i=0;i<arr.length;i++){
            pq.add(arr[i]);
        }
        //System.out.println(pq.element());
        while(!pq.isEmpty()){
            System.out.println(pq.remove());
        }
    }
}
