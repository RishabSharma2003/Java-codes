import java.util.*;
public class _1priorityQueue {
    public static void main(String[] args) {
        Priority_Queue<String> pq=new Priority_Queue<>();
        pq.insert("abc", 5);
        pq.insert("df", 2);
        pq.insert("xuz", 3);
        pq.insert("nm", 6);
        pq.insert("yr", 1);

        while (!pq.isEmpty()) {
            System.out.println(pq.removeMin());
        }
    }
}


class Priority_Queue<T>{
    //Element for type class T and to get priority of ele
    private ArrayList<Element<T>> heap;

    Priority_Queue(){
        heap=new ArrayList<>();
    }

    //insert
    public void insert(T value,int priority){
        //added at last
        Element<T> e=new Element<>(value, priority);
        heap.add(e);

        //process of upheapify goes here
        //compare the ele with it parent
        int childIdx=heap.size()-1;
        int parentIdx=(childIdx-1)/2;
        //comapre if childidx priority is lesser(minheap) than parent then swap on basis of priority
        while(childIdx>0){
            if(heap.get(childIdx).priority<heap.get(parentIdx).priority){
                Element<T> temp=heap.get(childIdx);
                heap.set(childIdx,heap.get(parentIdx));
                heap.set(parentIdx,temp);

                childIdx=parentIdx;
                parentIdx=(childIdx-1)/2;
            }else{
                return;
            }
        }

    }
    //get
    public T getMin(){
        return heap.get(0).value;
    }
    //remove
    public T removeMin(){
        if(isEmpty())return null;

        //getted the value
        Element<T> removed=heap.get(0);
        T ans=removed.value;

        //putted last val to first and removed last value
        heap.set(0,heap.get(heap.size()-1));
        heap.remove(heap.size()-1);

        int parentIdx=0;
        int childIdxLEFT=2*parentIdx+1;
        int childIdxRIGHT=2*parentIdx+2;

        while(childIdxLEFT<heap.size()){
            int minIdx=parentIdx;
            //dono me se jo prority kam h uski value uper rahegi 
            //if child prority is 30 and 70 to 30 uperjega parent ki jagh
            if(heap.get(childIdxLEFT).priority<heap.get(minIdx).priority){
                //calculating min
                minIdx=childIdxLEFT;
            }//if right child exist then only compare
            if(childIdxRIGHT<heap.size() && heap.get(childIdxRIGHT).priority<heap.get(minIdx).priority){
                //calculating min if it is at right
                minIdx=childIdxRIGHT;
            }

            //swap with parent
            Element<T> temp=heap.get(parentIdx);
            heap.set(parentIdx,heap.get(minIdx));
            heap.set(minIdx, temp);

            if (parentIdx==minIdx){
                //apni sahi pos per pauch gaya h before reaching the end point
                return ans;
            }
            parentIdx=minIdx;
            childIdxLEFT=2*parentIdx+1;
            childIdxRIGHT=2*parentIdx+2;
        }


        //returned
        return ans;
    }
    //size
    public int size(){
        return heap.size();
    }
    //is empty
    public boolean isEmpty(){
        if(size()==0) {
            return true;
        }
        return false;
    }

}
class Element<T>{
    T value;
    int priority;

    public Element(T value,int priority){
        this.value=value;
        this.priority=priority;
    }
}
