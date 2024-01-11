import java.util.*;

public class _1Tree {
    public static void main(String[] args) {

        TreeNode<Integer> root = takeInputLevelWise();
        // System.out.println(countNodes(root));
        //System.out.println(height(root));
        // printAtK(root, 2);
        // System.out.println(countLeaf(root));
        // preorder(root);
        postorder(root);
        print(root);
    }

    // take input
    public static TreeNode<Integer> takeInput() {
        int n;
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter next node data");
        n = sc.nextInt();
        TreeNode<Integer> root = new TreeNode<>(n);
        System.out.println("Enter the no of childern of " + n);
        int childCount = sc.nextInt();

        for (int i = 1; i <= childCount; i++) {
            TreeNode<Integer> child = takeInput();
            root.children.add(child);
        }

        return root;
    }

    // print
    public static void print(TreeNode<Integer> root) {
        String s = root.data + ":";

        for (int i = 0; i < root.children.size(); i++) {
            String child = root.children.get(i).data + "";
            s += child + ",";
        }
        System.out.println(s);
        for (int i = 0; i < root.children.size(); i++) {
            // recursion
            print(root.children.get(i));
        }
    }

    // take input level wise
    public static TreeNode<Integer> takeInputLevelWise() {
        System.out.println("Enter the Data");
        Scanner sc = new Scanner(System.in);

        int rootData = sc.nextInt();
        Queue<TreeNode<Integer>> pendingNodes = new LinkedList<>();
        TreeNode<Integer> root = new TreeNode<>(rootData);

        pendingNodes.add(root);

        while (!pendingNodes.isEmpty()) {
            TreeNode<Integer> frontNode = pendingNodes.remove();

            System.out.println("Enter the the no of children of " + frontNode.data);
            int numChildren = sc.nextInt();
            for (int i = 0; i < numChildren; i++) {
                System.out.println("Enter the " + (i + 1) + " th child of " + frontNode.data);
                int child = sc.nextInt();

                TreeNode<Integer> childNode = new TreeNode<>(child);
                frontNode.children.add(childNode);
                pendingNodes.add(childNode);
            }
        }
        return root;
    }

    // count nodes
    public static int countNodes(TreeNode<Integer> root) {
        if (root == null)
            return 0;// this is not a base | case base case is for loop
        int count = 1;
        for (int i = 0; i < root.children.size(); i++) {
            count += countNodes(root.children.get(i));
        }
        return count;
    }

    // find max
    public static int largest(TreeNode<Integer> root) {
        if (root == null)
            return Integer.MIN_VALUE;// edge case not base case

        int ans = root.data;
        for (int i = 0; i < root.children.size(); i++) {
            int childLargest = largest(root.children.get(i));
            ans = Math.max(ans, childLargest);
        }
        return ans;
    }

    // find max
    public static int height(TreeNode<Integer> root) {
        if (root == null)
            return 0;// edge case not base case

        int maxChildHeight = 0;
        for (int i = 0; i < root.children.size(); i++) {
            int childHeight = height(root.children.get(i));
            maxChildHeight = Math.max(maxChildHeight, childHeight);
        }

        return maxChildHeight + 1;
    }

    //print at K
    public static void printAtK(TreeNode<Integer> root,int k){
        if(k==0)System.out.print(root.data+"|");

        if(k>0){
            for(int i=0;i<root.children.size();i++){
                printAtK(root.children.get(i), k-1);
            }
        }
    }

    //count leaf nodes
    public static int countLeaf(TreeNode<Integer> root) {
        if(root.children.size()==0)return 1;//base

        int countOfLeaf=0;
        for(int i=0;i<root.children.size();i++){
            countOfLeaf+=countLeaf(root.children.get(i));
        }

        return countOfLeaf;
    }
    
    //tree traversal
    //PREORDER
    public static void preorder(TreeNode<Integer> root){
        System.out.print(root.data+" ");
        //print mid then left to right
        for(int i=0;i<root.children.size();i++){
            preorder(root.children.get(i));
        }
    }
    //POSTORDER
    public static void postorder(TreeNode<Integer> root){
        if(root==null)return;
        //print left then right and then mid
        for(int i=0;i<root.children.size();i++){
            postorder(root.children.get(i));
        }

        System.out.print(root.data + " ");
    }
    
}

class TreeNode<T> {
    T data;
    ArrayList<TreeNode<T>> children;

    // constructor
    TreeNode(T data) {
        this.data = data;
        children = new ArrayList<>();
    }
}
