import java.util.*;
public class _1priorityQueue {
    public static void main(String[] args) {
        //pQueue x=new pQueue();
        // x.heap.add(4);
        // x.heap.add(5);
        // x.heap.add(10);
        // x.heap.add(8);
        // x.heap.add(15);
        // x.heap.add(20);
        // x.heap.add(35);
        // x.print();
        // x.removeMin();
        // x.print();
        

        //HEAP SORT
        pQueue pq=new pQueue();
        int arr[]={5,1,9,2,0};
        for(int i=0;i<arr.length;i++){
            pq.insert(arr[i]);
        }
        while(!pq.isEmpty()){
            System.out.print(pq.removeMin()+" ");
        }
    }
}
class pQueue {
    //min priority queue
    ArrayList<Integer> heap;
    pQueue(){
        heap=new ArrayList<>();
    }
    public boolean isEmpty(){
        return heap.size()==0;
    }
    public int size(){
        return heap.size();
    }
    public int getMin(){
        // if(isEmpty()){
        //     throw new priorityQueueException();
        // }
        return heap.get(0);
    }
    public void print(){
        System.out.println(heap);
    }
    public void insert(int ele){    
        heap.add(ele);
        int childIdx=this.size()-1;
        int parentIdx=(childIdx-1)/2;
        while(childIdx>0){
            if(heap.get(childIdx)<heap.get(parentIdx)){
            int temp=heap.get(childIdx);
            heap.set(childIdx,heap.get(parentIdx));
            heap.set(parentIdx,temp);
            //repeat
            childIdx=parentIdx;
            parentIdx=(childIdx-1)/2;
            }else{
                return;
            }
        }
    }
    public int removeMin(){
        // if(isEmpty()){
        //     throw new priorityQueueException();
        // }
        int temp=heap.get(0);
        heap.set(0,heap.get(size()-1));
        heap.remove(size()-1);
        int index=0;
        int minIdx=index;
        int leftChildIdx=1;
        int rightChildIdx=2;
        while(leftChildIdx<size()){
            if(heap.get(index)>heap.get(leftChildIdx)){
                minIdx=leftChildIdx;
            }
            //if right child exist
            if(rightChildIdx<size())if(heap.get(minIdx)>heap.get(rightChildIdx)){
                minIdx=rightChildIdx;
            }
            //same priority
            if(minIdx==index)break;
            int temp1=heap.get(index);
            heap.set(index,heap.get(minIdx));
            heap.set(minIdx,temp1);
            index=minIdx;
            leftChildIdx=2*index+1;
            rightChildIdx=2*index+2;
        }
        return temp;
    }
}

class priorityQueueException extends Exception{}