import java.util.*;
public class _1binaryTree {
    public static void main(String[] args) {
        // binaryTreeNode<Integer>root=takeLevelWise();
        // System.out.println(isBal(root));
        //printDetailed(root);

        int in[]={4,2,5,1,3,7};
        int pre[]={1,2,4,5,3,7};
        binaryTreeNode<Integer>root=makeTree(in,pre);
        printDetailed(root);
    }

    //take input level wise
    public static binaryTreeNode<Integer> takeLevelWise() {
        Scanner sc=new Scanner(System.in);
        Queue<binaryTreeNode<Integer>>pendingNodes=new LinkedList<>();
        System .out.println("enter the data");
        int rootData=sc.nextInt();
        if(rootData==-1)return null;
        binaryTreeNode<Integer>root=new binaryTreeNode(rootData);
        pendingNodes.add(root);
        while(!pendingNodes.isEmpty()){
            binaryTreeNode<Integer> frontNode=pendingNodes.peek();
            pendingNodes.remove();
            System.out.println("enter the left child of "+frontNode.data);
            int leftChild=sc.nextInt();
            if(leftChild!=-1){
                binaryTreeNode<Integer> l=new binaryTreeNode(leftChild);
                frontNode.left=l;
                pendingNodes.add(l); 
            }


            System.out.println("enter the right child of "+frontNode.data);
            int rightChild=sc.nextInt();
            if(rightChild!=-1){
                binaryTreeNode<Integer> l=new binaryTreeNode(rightChild);
                frontNode.right=l;
                pendingNodes.add(l); 
            }
        }
        return root;
    }

    //take input
    public static binaryTreeNode<Integer>takeInput(){
        Scanner sc=new Scanner(System.in);
        System.out.println("enter the root data");
        int rootData=sc.nextInt();
        if(rootData==-1)return null;
        binaryTreeNode<Integer> root=new binaryTreeNode(rootData);
        binaryTreeNode<Integer> leftchild=takeInput();
        binaryTreeNode<Integer> rightchild=takeInput();
        root.left=leftchild;
        root.right=rightchild;
        return root;
    }
    
    //take input better
    public static binaryTreeNode<Integer> takeInputBetter(boolean Root,int parentData,boolean left){
        if(Root){
            System.out.println("Enter the rootData");
        }else{
            if(left){
                System.out.println("enter the left child of "+parentData);
            }else{
                System.out.println("enter the right child of "+parentData);
            }
        }
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        if(n==-1)return null;
        binaryTreeNode<Integer> root=new binaryTreeNode<>(n);
        binaryTreeNode<Integer> leftchild=takeInputBetter(false,n,true);
        binaryTreeNode<Integer> rightchild=takeInputBetter(false,n,false);
        root.left=leftchild;
        root.right=rightchild;
        return root;
    }
    
    //no of nodes
    public static int countNodes(binaryTreeNode<Integer> x){
        if(x==null)return 0;
        int leftcount=countNodes(x.left);
        int rightcount=countNodes(x.right);
        return 1+leftcount+rightcount;


        // if(x==null)return 0;
        // int count=1;
        // count+=countNodes(x.left);
        // count+=countNodes(x.right);
        // return count;
    }
    
    //get sum
    public static int sumNodes(binaryTreeNode<Integer> x){
        if(x==null)return 0;
        return x.data+sumNodes(x.left)+sumNodes(x.right);
    }

    //print detailed
    public static void printDetailed(binaryTreeNode<Integer>x) {
        if(x==null)return;
        System.out.print(x.data+":"); 
        if(x.left!=null)System.out.print("L"+x.left.data+",");
        if(x.right!=null)System.out.print("R"+x.right.data);
        System.out.println();
        printDetailed(x.left);
        printDetailed(x.right);
    }

    //max node
    public static int maxNode(binaryTreeNode<Integer>x){
        if(x==null)return -1;
        //int leftMax=maxNode(x.left);
        //int rigthMax=maxNode(x.right);

        return Math.max(x.data,(Math.max(maxNode(x.left),maxNode(x.right))));
    }
    
    //height
    public static int heigth(binaryTreeNode<Integer>x){
        if(x==null)return 0;
        return 1+Math.max(heigth(x.left),heigth(x.right));
    }
    
    //diameter
    public static int diameter(binaryTreeNode<Integer>x){
        if(x==null)return 0;
        int heightOfPaticularNode=heigth(x.left)+heigth(x.right);
        //going for left of heigth of left node
        int at_left=diameter(x.left);
        //going for right of heigth of right node
        int at_right=diameter(x.right);
        return Math.max(heightOfPaticularNode,Math.max(at_left,at_right));
    }

    //leaf node count
    public static int leafNodeCount(binaryTreeNode<Integer>x){
        if(x==null)return 0;
        if(x.left==null&&x.right==null)return 1;
        return leafNodeCount(x.left)+leafNodeCount(x.right);
    }

    //node at depth k
    public static void nodeAtDepthK(binaryTreeNode<Integer>x,int k){
        if(x==null)return;
        if(k==0){
            System.out.print(x.data+" ");
            return;
        }
        nodeAtDepthK(x.left,k-1);
        nodeAtDepthK(x.right,k-1);
    }
    
    //change node to level in inorer fasion
    public static void levelNode(binaryTreeNode<Integer>x,int level){
        if(x==null)return;
        x.data=level;
        levelNode(x.left,level+1);
        levelNode(x.right,level+1);

        // levelNode(root, 0);
        // inOrder(root);
    }
    
    //remove leaf nodes
    public static binaryTreeNode<Integer> removeLeaf(binaryTreeNode<Integer>x){
        if(x==null)return null;
        if(x.left==null&&x.right==null){
            return null;
        }
        x.left=removeLeaf(x.left);
        x.right=removeLeaf(x.right);
        return x;
    }
     
    //mirror binary tree
    public static void mirror(binaryTreeNode<Integer>x){
        if(x==null)return;
        mirror(x.left);
        mirror(x.right);
        binaryTreeNode<Integer> temp=x.left;
        x.left=x.right;
        x.right=temp;
    }
    
    //is balanced
    public static boolean isBal(binaryTreeNode<Integer>x){
        if(x==null)return true;
        int LeftHeight=heigth(x.left);
        int RightHeight=heigth(x.right);
        if(Math.abs(LeftHeight-RightHeight)>1)return false;
        return isBal(x.left)&&isBal(x.right);
    }




    //preorder
    public static void preOrder(binaryTreeNode<Integer>x){
        if(x==null)return;
        System.out.print(x.data+" ");

        preOrder(x.left);
        preOrder(x.right);
    }
    //inorder
    public static void inOrder(binaryTreeNode<Integer>x){
        if(x==null)return;
        inOrder(x.left);
  
        System.out.print(x.data+" ");

        inOrder(x.right);
    }
    //postorder
    public static void postOrder(binaryTreeNode<Integer>x){
        if(x==null)return;
        postOrder(x.left);
        postOrder(x.right);

        System.out.print(x.data+" ");
    }



    //make tree from inorder and preorder
    public static binaryTreeNode<Integer> makeTree(int in[],int pre[]){
        return makeTreeHelper(in,pre,0,in.length-1,0,pre.length-1);
    }
    public static binaryTreeNode<Integer> makeTreeHelper(int in[],int pre[],int inS,int inE,int preS,int preE){
        if(inS>inE)return null;
        int rootData=pre[preS];
        int rootIdx=-1;
        for(int i=inS;i<=inE;i++)if(in[i]==rootData)rootIdx=i;
        int LinS=inS;
        int LinE=rootIdx-1;
        int RinS=rootIdx+1;
        int RinE=inE;

        int LpreS=preS+1;
        int LpreE=LinE-LinS+LpreS;
        int RpreS=LpreE+1;
        int RpreE=preE;
        
        binaryTreeNode<Integer> root=new binaryTreeNode(rootData);
        System.out.println("ROOTDATA "+rootData);
        //in
        System.out.print("LEFT in ");
        for(int i=LinS;i<=LinE;i++){
            System.out.print(in[i]+" ");
        }
        System.out.println();
        System.out.print("RIGHT in ");
        for(int i=RinS;i<=RinE;i++){
            System.out.print(in[i]+" ");
        }
        //pre
        System.out.println();
        System.out.print("LEFT pre ");
        for(int i=LpreS;i<=LpreE;i++){
            System.out.print(pre[i]+" ");
        }
        System.out.println();
        System.out.print("RIGHT pre ");
        for(int i=RpreS;i<=RpreE;i++){
            System.out.print(pre[i]+" ");
        }

        System.out.println();
        System.out.println("LinS "+LinS+" LinE "+LinE+" LpreS "+LpreS+" LpreE "+LpreE);
        System.out.println("RinS "+RinS+" RinE "+RinE+" RpreS "+RpreS+" RpreE "+RpreE);
        root.left=makeTreeHelper(in, pre, LinS, LinE, LpreS, LpreE);
        root.right=makeTreeHelper(in, pre, RinS, RinE, RpreS, RpreE);
        return root;

        // int in[]={4,2,5,1,3,7};
        // int pre[]={1,2,4,5,3,7};
        // binaryTreeNode<Integer>root=makeTree(in,pre);
        // printDetailed(root);
    }
}
class binaryTreeNode<T>{
    T data;
    binaryTreeNode<T> left;
    binaryTreeNode<T> right;
    binaryTreeNode(T data){
        this.data=data;
    }
}