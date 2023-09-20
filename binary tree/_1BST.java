import java.util.*;

//4
//2    6
//1  3   5   7
public class _1BST {
    public static void main(String[] args) {
        
    }

    // make BST from sorted array
    public static binaryTreeNode<Integer> makeBST(int arr[]) {
        return makeBSThelper(arr, 0, arr.length - 1);
    }
    public static binaryTreeNode<Integer> makeBSThelper(int arr[], int start, int end) {
        if (start > end)
            return null;
        int mid = (start + end) / 2;
        binaryTreeNode<Integer> temp = new binaryTreeNode(arr[mid]);
        temp.left = makeBSThelper(arr, start, mid - 1);
        temp.right = makeBSThelper(arr, mid + 1, end);
        return temp;
    }

    // for min
    public static int minimum(binaryTreeNode<Integer> x) {
        if (x == null)
            return Integer.MAX_VALUE;
        return Math.min(x.data, Math.min(minimum(x.left), minimum(x.right)));
    }
    // for max
    public static int maximum(binaryTreeNode<Integer> x) {
        if (x == null)
            return Integer.MIN_VALUE;
        return Math.max(x.data, Math.max(maximum(x.left), maximum(x.right)));
    }
    // is BST or not
    public static boolean isBST(binaryTreeNode<Integer> x) {
        if (x == null)
            return true;
        int leftMax = maximum(x.left);
        if (leftMax >= x.data)
            return false;

        int rightMax = minimum(x.right);
        if (rightMax < x.data)
            return false;

        return isBST(x.left) && isBST(x.right);
    }

    // print b/w k1,k2
    public static void printBetweenK1K2(binaryTreeNode<Integer> x, int k1, int k2) {
        if (x == null)
            return;
        if (x.data >= k1 && x.data <= k2) {
            System.out.print(x.data + " ");
        }
        if (x.data > k1)
            printBetweenK1K2(x.left, k1, k2);
        if (x.data <= k2)
            printBetweenK1K2(x.right, k1, k2);
    }

    // find node
    public static int findNode(binaryTreeNode<Integer> x, int val) {
        if (x == null)
            return -1;
        if (x.data == val)
            return x.data;
        else if (x.data > val)
            return findNode(x.left, val);
        else
            return findNode(x.right, val);
    }

    // take input level wise
    public static binaryTreeNode<Integer> takeLevelWise() {
        Scanner sc = new Scanner(System.in);
        Queue<binaryTreeNode<Integer>> pendingNodes = new LinkedList<>();
        System.out.println("enter the data");
        int rootData = sc.nextInt();
        if (rootData == -1)
            return null;
        binaryTreeNode<Integer> root = new binaryTreeNode(rootData);
        pendingNodes.add(root);
        while (!pendingNodes.isEmpty()) {
            binaryTreeNode<Integer> frontNode = pendingNodes.peek();
            pendingNodes.remove();
            System.out.println("enter the left child of " + frontNode.data);
            int leftChild = sc.nextInt();
            if (leftChild != -1) {
                binaryTreeNode<Integer> l = new binaryTreeNode(leftChild);
                frontNode.left = l;
                pendingNodes.add(l);
            }

            System.out.println("enter the right child of " + frontNode.data);
            int rightChild = sc.nextInt();
            if (rightChild != -1) {
                binaryTreeNode<Integer> l = new binaryTreeNode(rightChild);
                frontNode.right = l;
                pendingNodes.add(l);
            }
        }
        return root;
    }

    // print detailed
    public static void printDetailed(binaryTreeNode<Integer> x) {
        if (x == null)
            return;
        System.out.print(x.data + ":");
        if (x.left != null)
            System.out.print("L" + x.left.data + ",");
        if (x.right != null)
            System.out.print("R" + x.right.data);
        System.out.println();
        printDetailed(x.left);
        printDetailed(x.right);
    }

    // IS BALANCED BETTER
    public static isBST2 isbalancedBST(binaryTreeNode<Integer> x) {
        if (x == null) {
            isBST2 ans = new isBST2(Integer.MAX_VALUE, Integer.MIN_VALUE, true);
            return ans;
        }
        // we have made a node name isBST2 which return min,max,bool
        isBST2 leftans = isbalancedBST(x.left);
        isBST2 rightans = isbalancedBST(x.right);

        int min = Math.min(x.data, Math.min(leftans.min, rightans.min));
        int max = Math.max(x.data, Math.max(leftans.max, rightans.max));
        boolean b = true;
        if (x.data <= leftans.max)
            b = false;
        if (x.data > rightans.min)
            b = false;
        if (!leftans.isbst)
            b = false;
        if (!rightans.isbst)
            b = false;
        isBST2 ans = new isBST2(min, max, b);
        return ans;
    }
    // IS BST BALANCED
    public static boolean isBST3(binaryTreeNode<Integer> x, int minRange, int maxRange) {
        if (x == null)
            return true;
        if (x.data < minRange || x.data > maxRange)
            return false;
        boolean bleft = isBST3(x.left, minRange, x.data - 1);
        boolean brigth = isBST3(x.right, x.data, maxRange);
        return bleft && brigth;
        // System.out.println(isBST3(root,-100, +100));
    }

    // get node path
    public static ArrayList<Integer> getNodePath(binaryTreeNode<Integer> x, int data) {
        if (x == null)
            return null;
        if (x.data == data) {
            ArrayList<Integer> output = new ArrayList<>();
            output.add(data);
            return output;
        }
        ArrayList<Integer> leftoutput = getNodePath(x.left, data);
        if (leftoutput != null) {
            leftoutput.add(x.data);
            return leftoutput;
        }
        ArrayList<Integer> rightoutput = getNodePath(x.right, data);
        if (rightoutput != null) {
            rightoutput.add(x.data);
            return rightoutput;
        }
        return null;
    }
}

class binaryTreeNode<T> {
    T data;
    binaryTreeNode<T> left;
    binaryTreeNode<T> right;

    binaryTreeNode(T data) {
        this.data = data;
    }
}

class isBST2 {
    int min;
    int max;
    boolean isbst;

    isBST2(int m1, int m2, boolean i) {
        min = m1;
        max = m2;
        isbst = i;
    }
}

class BinarySearchTree {
    public binaryTreeNode<Integer> root;
    
    //searching for data
    public boolean hasData(int data) {
        return hasDataHelper(data, root);
    }
    private boolean hasDataHelper(int data,binaryTreeNode<Integer>root){
        if(root==null)return false;
        if(root.data==data)return true;
        else if(root.data<data)return hasDataHelper(data, root.right);
        return hasDataHelper(data, root.left);
    }

    //insert data
    public void insertData(int data){
        root=insertData(data,root);
    }
    private binaryTreeNode<Integer> insertData(int data,binaryTreeNode<Integer>root){
        if(root==null){
            binaryTreeNode<Integer> newNode=new binaryTreeNode(data);
            return newNode;
        }
        if(root.data>data)root.left=insertData(data, root.left);
        else root.right=insertData(data, root.right);
        return root;
    }

    //delete data
    public void deleteData(int data){
        root=deleteData(data,root);
    }
    private binaryTreeNode<Integer> deleteData(int data,binaryTreeNode<Integer>root){
        if(root==null)return null;
        if(data<root.data)root.left=deleteData(data, root.left);
        else if(data>root.data)root.right=deleteData(data, root.right);
        else{
            if(root.left==null&&root.right==null)return null;
            else if(root.left==null)return root.right;
            else if(root.right==null)return root.left;
            else{
                binaryTreeNode<Integer>minNode=root.right;
                while(minNode.left!=null){
                    minNode=minNode.left;
                }
                root.data=minNode.data;
                //root.right for case 5 2 7
                root.right=deleteData(minNode.data,root.right);
            }
        }
        return root;
    }
     
    // BinarySearchTree bst=new BinarySearchTree();
    //     bst.insertData(4);
    //     bst.insertData(2);
    //     bst.insertData(6);
    //     bst.insertData(1);
    //     bst.insertData(3);
    //     bst.insertData(5);
    //     bst.insertData(7);
    //     //bst.printTree(bst.root);
    //     bst.deleteData(4);
    //     bst.printTree(bst.root);

    //print tree
    public void printTree(binaryTreeNode<Integer>root) {
        if (root == null)
            return;
        System.out.print(root.data + ":");
        if (root.left != null)
            System.out.print("L" + root.left.data + ",");
        if (root.right != null)
            System.out.print("R" + root.right.data);
        System.out.println();
        printTree(root.left);
        printTree(root.right);
    }
}
