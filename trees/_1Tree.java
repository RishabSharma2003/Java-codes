import java.util.*;
public class _1Tree {
    public static void main(String[] args) {
        treeNode<Integer>root=takeLevelWise();
        //print(root);
    }
    //take input
    public static treeNode<Integer> takeInput(){
        Scanner sc=new Scanner(System.in);
        System.out.println("enter the node data");
        int n=sc.nextInt();
        treeNode<Integer>root=new treeNode(n);
        System.out.println("enter the no of child node "+n);
        int childCount=sc.nextInt();
        while(childCount-->0){
            treeNode<Integer>child=takeInput();
            root.children.add(child);
        }
        return root;
    }
    //take input level wise
    public static treeNode<Integer> takeLevelWise() {
        Scanner sc=new Scanner(System.in);
        System.out.println("enter the data");
        int rootdata=sc.nextInt();
        Queue<treeNode<Integer>>pendingNodes=new LinkedList<>();
        
        treeNode<Integer>root=new treeNode<>(rootdata);
        pendingNodes.add(root);
        while(!pendingNodes.isEmpty()){
            treeNode<Integer>frontNode=pendingNodes.peek();
            pendingNodes.remove();
            System.out.println("enter no of children of "+frontNode.data);
            int numChild=sc.nextInt();
            while(numChild-->0){
                System.out.println("enter child of "+frontNode.data);
                int child=sc.nextInt();
                treeNode<Integer>childNode=new treeNode<>(child);
                frontNode.children.add(childNode);
                pendingNodes.add(childNode); 
            }
        }
        return root;
    }
    //print
    public static void print(treeNode<Integer>x){
        String s=x.data+":";
        for(int i=0;i<x.children.size();i++){
            s=s+x.children.get(i).data+",";
        }
        System.out.println(s);
        for(int i=0;i<x.children.size();i++){
            print(x.children.get(i));
        }
    } 
    //count nodes
    public static int countNodes(treeNode<Integer> x) {
        //not a base case it is an edge case
        if(x==null)return 0;
        int count=1;
        for(int i=0;i<x.children.size();i++){
            count+=countNodes(x.children.get(i));
        }
        return count;
    }
    //largest
    public static int largest(treeNode<Integer>x){
        // not a base case
        if(x==null)return -1;
        int ans=x.data;
        for(int i=0;i<x.children.size();i++){
            int childLargest=largest(x.children.get(i));
            if(childLargest>ans)ans=childLargest;
        }
        return ans;
    }
    //at k
    public static void printAtK(treeNode<Integer>x,int k){
        if(k==0){
            System.out.print(x.data+" ");
            return;
        }
        for(int i=0;i<x.children.size();i++){
            printAtK(x.children.get(i), k-1);
        }
    }
}
class treeNode<T>{
    T data;
    ArrayList<treeNode<T>>children;
    
    treeNode(T data){
        this.data=data;
        children=new ArrayList<>();
    }
}