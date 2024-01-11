import java.util.*;

public class _2BinaryTree {
    public static void main(String[] args) {

        // 1 2 3 4 5 6 7 -1 -1 -1 -1 -1 -1 -1 -1

        BinaryTreeNode<Integer> root = takeInputLevelWise();
        // printLevelWise(root);
        // System.out.println(countNodes(root));
        // System.out.println(sumNodes(root));
        // preorder(root);
        inorder(root);
        // postorder(root);
        // System.out.println(largestNode(root));
        // System.out.println(nodeGreaterThanX(root, 5));
        // System.out.println(height(root));
        // System.out.println(countLeaf(root));
        // depthK(root, 2);
        // System.out.println(presentOrNot(root, 7));
        // noSibling(root);
        // root = removeLeaf(root);
        // root=mirrorImage(root);
        // System.out.println(balancedOrNot(root));
        // balacncedTreeReturn ans=balancedBetter(root);
        // System.out.println(ans.isBal);
        // pair ans=diameterBetter(root);
        // System.out.println(ans.diameter);
        print(root);
    }

    // take level wise
    public static BinaryTreeNode<Integer> takeInputLevelWise() {
        Scanner sc = new Scanner(System.in);
        Queue<BinaryTreeNode<Integer>> pendingNodes = new LinkedList<>();

        System.out.println("Enter the Root data");

        int rootData = sc.nextInt();
        if (rootData == -1)
            return null;// base case

        BinaryTreeNode<Integer> root = new BinaryTreeNode<>(rootData);
        pendingNodes.add(root);

        while (!pendingNodes.isEmpty()) {
            BinaryTreeNode<Integer> font = pendingNodes.remove();

            System.out.println("Enter the Left childeren of " + font.data);

            int leftChild = sc.nextInt();
            if (leftChild != -1) {
                font.left = new BinaryTreeNode<>(leftChild);
                pendingNodes.add(font.left);
            }

            System.out.println("Enter the Right childeren of " + font.data);

            int rightChild = sc.nextInt();
            if (rightChild != -1) {
                font.right = new BinaryTreeNode<>(rightChild);
                pendingNodes.add(font.right);
            }
        }

        return root;

    }

    // print level wise
    public static void printLevelWise(BinaryTreeNode<Integer> root) {
        if (root == null)
            return;
        Queue<BinaryTreeNode<Integer>> pendiNodes = new LinkedList<>();

        pendiNodes.add(root);
        System.out.print(root.data + " ");

        while (!pendiNodes.isEmpty()) {
            BinaryTreeNode<Integer> font = pendiNodes.remove();

            if (font.left != null) {
                pendiNodes.add(font.left);
                System.out.print(font.left.data + " ");
            }
            if (font.right != null) {
                pendiNodes.add(font.right);
                System.out.print(font.right.data + " ");
            }
        }
    }

    // input
    public static BinaryTreeNode<Integer> takeInput() {
        System.out.println("Enter the root data");
        Scanner sc = new Scanner(System.in);

        int rootData = sc.nextInt();
        if (rootData == -1) {
            return null;
        }
        // enter the root data
        BinaryTreeNode<Integer> root = new BinaryTreeNode<>(rootData);

        root.left = takeInput();
        root.right = takeInput();

        return root;
    }

    // print
    public static void print(BinaryTreeNode<Integer> root) {
        if (root == null)
            return;

        String s = root.data + " ";

        if (root.left != null) {
            s += "L:" + root.left.data + ",";
        }
        if (root.right != null) {
            s += "R:" + root.right.data;
        }

        System.out.println(s);

        print(root.left);
        print(root.right);
    }

    // count nodes
    public static int countNodes(BinaryTreeNode<Integer> root) {
        if (root == null)
            return 0;// base

        // int count=0;
        // count+=countNodes(root.left);
        // count+=countNodes(root.right);

        // return 1+count;
        // one for current node

        return 1 + countNodes(root.left) + countNodes(root.right);
    }

    // sum of nodes
    public static int sumNodes(BinaryTreeNode<Integer> root) {
        if (root == null)
            return 0;// base
        int sum = root.data;

        return sum + sumNodes(root.left) + sumNodes(root.right);
    }

    // Tree traversal
    // preorder
    public static void preorder(BinaryTreeNode<Integer> root) {
        if (root == null)
            return;
        // root left right
        System.out.print(root.data + " ");
        preorder(root.left);
        preorder(root.right);
    }

    // inorder
    public static void inorder(BinaryTreeNode<Integer> root) {
        if (root == null)
            return;
        // left root right
        inorder(root.left);
        System.out.print(root.data + " ");
        inorder(root.right);
    }

    // postorder
    public static void postorder(BinaryTreeNode<Integer> root) {
        if (root == null)
            return;
        // left right root
        postorder(root.left);
        System.out.print(root.data + " ");
        postorder(root.right);
    }

    // largest node
    public static int largestNode(BinaryTreeNode<Integer> root) {
        if (root == null)
            return 0;
        int max = root.data;

        return Math.max(max, Math.max(largestNode(root.left), largestNode(root.right)));
    }

    // nodes greter than x
    public static int nodeGreaterThanX(BinaryTreeNode<Integer> root, int n) {
        if (root == null)
            return 0;
        int count = (root.data > n) ? 1 : 0;

        return count + nodeGreaterThanX(root.left, n) + nodeGreaterThanX(root.right, n);
    }

    // leaf node
    public static int countLeaf(BinaryTreeNode<Integer> root) {
        if (root == null)
            return 0;// base case

        if (root.left == null && root.right == null)
            return 1;
        return countLeaf(root.left) + countLeaf(root.right);
    }

    // print nodes at depth K
    public static void depthK(BinaryTreeNode<Integer> root, int k) {
        if (root == null)
            return;

        if (k == 0) {
            System.out.print(root.data + " ");
            return;
        }

        depthK(root.left, k - 1);
        depthK(root.right, k - 1);
    }

    // find x is present or not
    public static boolean presentOrNot(BinaryTreeNode<Integer> root, int x) {
        if (root == null)
            return false;
        if (root.data == x)
            return true;

        return presentOrNot(root.left, x) || presentOrNot(root.right, x);
    }

    // print without sibling
    public static void noSibling(BinaryTreeNode<Integer> root){
        if(root==null)return;

        if(root.left!=null&&root.right==null){
            System.out.print(root.left.data+" ");
        }
        if(root.right!=null&&root.left==null){
            System.out.print(root.right.data+" ");
        }
        // Sample Input 1:
        // 5 6 10 2 3 -1 -1 -1 -1 -1 9 -1 -1
        // Sample Output 1:
        // 9    
        // Sample Input 2:
        // 2 4 5 6 -1 -1 7 20 30 80 90 -1 8 9 -1 -1 -1 -1 -1 -1 -1 -1 -1 
        // Sample Output 2:
        // 6 8 7 9  
        noSibling(root.left);noSibling(root.right);
    }

    //remove leaf
    public static BinaryTreeNode<Integer> removeLeaf(BinaryTreeNode<Integer> root){
        if(root==null)return null;

        if(root.left==null&&root.right==null)return null;

        root.left=removeLeaf(root.left);
        root.right=removeLeaf(root.right);

        return root;
    }

    //form mirror image
    public static BinaryTreeNode<Integer> mirrorImage(BinaryTreeNode<Integer> root){
        if(root==null)return null;
    
        BinaryTreeNode<Integer> temp=root.left;
        //swapping
        root.left=(mirrorImage(root.right));
        root.right=(mirrorImage(temp));

        return root;
    }

    // height
    public static int height(BinaryTreeNode<Integer> root) {
        if (root == null)
            return 0;

        return 1 + Math.max(height(root.left), height(root.right));
    }

    //check balanced
    public static boolean balancedOrNot(BinaryTreeNode<Integer> root) {
        if (root == null)
            return true;
         
        int leftHeight=height(root.left);
        int rightHeight=height(root.right);
        if(Math.abs(leftHeight-rightHeight)>1)return false;

        boolean leftAns=balancedOrNot(root.left);
        boolean rightAns=balancedOrNot(root.right);

        return leftAns&&rightAns;
    }

    //check balanced better
    public static balacncedTreeReturn balancedBetter(BinaryTreeNode<Integer> root){
        if(root==null){
            int height=0;
            boolean isBalanced=true;
            balacncedTreeReturn ans=new balacncedTreeReturn();
            ans.height=height;
            ans.isBal=isBalanced;
            return ans;
        }

        balacncedTreeReturn leftAns=balancedBetter(root.left);
        balacncedTreeReturn rightAns=balancedBetter(root.right);

        boolean isBalanced=true;

        if(leftAns.isBal==false||rightAns.isBal==false)isBalanced=false;
        if(Math.abs(leftAns.height-rightAns.height)>1)isBalanced=false;

        balacncedTreeReturn ans=new balacncedTreeReturn();
        ans.height=Math.max(leftAns.height,rightAns.height)+1;
        ans.isBal=isBalanced;
        
        return ans;
    }

    //diameter
    public static int diameter(BinaryTreeNode<Integer> root){
        if(root==null)return 0;

        int leftHeight=height(root.left);
        int rightHeight=height(root.right);

        int op1=leftHeight+rightHeight;
        int op2=diameter(root.left);
        int op3=diameter(root.right);

        return Math.max(op1,Math.max(op2, op3));
    }

    //diameter better
    public static pair diameterBetter(BinaryTreeNode<Integer> root){
        if(root==null){
            pair ans=new pair(0, 0);
            return ans;
        }

        pair leftAns=diameterBetter(root.left);
        pair rightAns=diameterBetter(root.right);

        int currentDiameter=leftAns.height+rightAns.height;

        int diameter=Math.max(currentDiameter, Math.max(leftAns.diameter,rightAns.diameter));
        int height=Math.max(leftAns.height,rightAns.height)+1;

        pair ans=new pair(height, diameter);
        return ans;
    }

    //make a tree from preorder and inorder
    
}

class BinaryTreeNode<T> {
    T data;
    BinaryTreeNode<T> left;
    BinaryTreeNode<T> right;

    BinaryTreeNode(T data) {
        this.data = data;
    }
}

class balacncedTreeReturn{
    int height;
    boolean isBal;
}
class pair{
    int height;
    int diameter;
    pair(int height,int diameter){
        this.height=height;
        this.diameter=diameter;
    }
}