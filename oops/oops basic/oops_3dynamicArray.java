import java.util.*;
public class oops_3dynamicArray {
    public static void main(String[] args) {
        DynamicArray a=new DynamicArray();
        for(int i=0;i<100;i++){
            a.add(i+10);
        }
        System.out.println(a.size());
        //System.out.println(a.get(2));
        while(!a.isEmpty()){
            System.out.println(a.size());
            a.removeLast();
        }
        
    }
}


class DynamicArray{
    int data[];
    int nextElementIndex;
    DynamicArray(){
        data=new int[5];
        nextElementIndex=0;
    }


    public int size(){
        return nextElementIndex;
    }
    public boolean isEmpty(){
        return nextElementIndex==0;
    }
    public int get(int i){
        if(i>=nextElementIndex){
            //throw error
            return -1;
        }
        return data[i];
    }
    public void set(int i,int ele){
        if(i>=nextElementIndex){
            //throw error
            return;
        }
        data[i]=ele;
    }
    public void removeLast(){
        if(nextElementIndex==0)return;
        data[nextElementIndex-1]=0;
        nextElementIndex--;
    }
    private void doubleCapacity(){
        int temp[]=data;
        data=new int[data.length*2];
        for(int i=0;i<nextElementIndex;i++)data[i]=temp[i];
    }
    public void add(int ele){
        if(nextElementIndex==data.length){
            doubleCapacity();
        }
        data[nextElementIndex]=ele;
        nextElementIndex++;
    }
}