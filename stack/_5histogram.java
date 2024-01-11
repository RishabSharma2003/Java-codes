import java.util.Stack;

public class _5histogram {
    public static void main(String[] args) {
        int arr[]={8,2,10,12,7,0,10,8};
        int rb[]=new int[arr.length];//next smaller index on right
        Stack<Integer> st1=new Stack<>();
        st1.push(arr.length-1);
        rb[arr.length-1]=arr.length;
        for(int i=arr.length-2;i>=0;i--){
            while(st1.size()>0&&arr[i]<arr[st1.peek()]){
                st1.pop();
            }
            if(st1.size()==0){
                rb[i]=arr.length;
            }else{
                rb[i]=st1.peek();
            }
            st1.push(i);
        }

        for(int i=0;i<arr.length;i++)System.out.print(rb[i]+" ");
        System.out.println();

        int lb[]=new int[arr.length];//next smaller index on left
        Stack<Integer> st2=new Stack<>();
        st2.push(0);
        lb[0]=-1;
        for(int i=1;i<arr.length;i++){
            while(st2.size()>0&&arr[i]<arr[st2.peek()]){
                st2.pop();
            }
            if(st2.size()==0){
                lb[i]=-1;
            }else{
                lb[i]=st2.peek();
            }
            st2.push(i);
        }

        for(int i=0;i<arr.length;i++)System.out.print(lb[i]+" ");
        System.out.println();

        int maxarea=0;

        for(int i=0;i<arr.length;i++){
            int width=rb[i]-lb[i]-1;
            int area=width*arr[i];
            if(area>maxarea)maxarea=area;
        }
        System.out.println(maxarea);

    }
}
