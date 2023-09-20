public class _1queue {
    public static void main(String[] args) {
        queue q=new queue();
        int arr[]={10,20,30};
        for(int i:arr){
            try{
                q.enQueue(i);
            }
            catch(Exception e){}
        }
        
        try{
            while(!q.isEmpty()){
           System.out.println(q.deQueue());
           }
        }catch(Exception e){}
    }
}
class queue{
    private int data[];
    private int front;
    private int rear;
    private int size;
    queue(){
        data=new int[10];
        front=-1;
        rear=-1;
    }
    //size
    public int size(){return size;}

    //is empty
    public boolean isEmpty(){
        return size==0;
    }
 
    //add last
    public void enQueue(int val)throws queueFullException{
        if(size==data.length)throw new queueFullException();
        if(size==0){
            front=0;
        }
        rear++;
        //circular queue
        if(rear==data.length)rear=0;
        data[rear]=val;
        size++;
    }

    //del last
    public int deQueue()throws queueEmptyException{
        if(size==0)throw new queueEmptyException();
        int temp=data[front];
        front++;  
        size--;
        //circular queue
        if(front==data.length)front=0;
        if(size==0){
            front=-1;
            rear=-1;
        }
        return temp;
    }

    //front
    public int front()throws queueEmptyException{
        if(size==0)throw new queueEmptyException();
        return data[front];
    }
    
}


//queue empty exception
class queueEmptyException extends Exception{

}
//queue full exception
class queueFullException extends Exception{

}
