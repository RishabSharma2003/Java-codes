public class _2queue {
    public static void main(String[] args) {
        int arr[]={10,20,30,40};
        queueLL<Integer>q=new queueLL<>();
        for(int i:arr)q.enqueue(i);
        while(!q.isEmpty()){
            try {
                System.out.println(q.dequeue());
            } catch (Exception e) {}
        }
    }
}
class queueLL<T>{
    private node<T> front;
    private node<T> rear;
    int size;
    queueLL(){
        front=null;
        rear=null;
        size=0;
    }

    //size;
    public int size(){
        return size;
    }
    
    //is empty
    public boolean isEmpty(){
        return size==0;
    }

    //insert at last
    public void enqueue(T ele){
        node<T> newnode=new node<>(ele);
        size++;
        if(rear==null){
            front=newnode;
            rear=newnode;
        }else{
            rear.next=newnode;
            rear=newnode;
        }
    }

    //front
    public T front()throws queueEmptyException{
        if(front==null)throw new queueEmptyException();
        return front.data;
    }
    
    //remove from first
    public T dequeue()throws queueEmptyException{
        if(front==null)throw new queueEmptyException();
        T temp=front.data;
        front=front.next;
        if(front==null)rear=null;
        size--;
        return temp;
    }

}
class node<T>{
    T data;
    node<T> next;
    node(T data){
        this.data=data;
    }
}