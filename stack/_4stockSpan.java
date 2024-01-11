import java.util.*;
public class _4stockSpan{
    public static void main(String[] args) {
        int arr[]={2,3,4,2,3,1,2,3,11,7,2,3,5,8,4};
        int span[]=new int[arr.length];
        Stack<Integer> st=new Stack<>();
        st.push(0);
        span[0]=1;

        for(int i=1;i<arr.length;i++){
            while(st.size()>0&&arr[i]>arr[st.peek()])st.pop();
            if(st.size()==0){
                span[i]=i+1;
            }else{
                span[i]=i-st.peek();
            }
            st.push(i);
        }

        for(int i=0;i<arr.length;i++)System.out.print(arr[i]+" ");
        System.out.println();
        for(int i=0;i<arr.length;i++)System.out.print(i+" ");
        System.out.println();
        for(int i=0;i<arr.length;i++)System.out.print(span[i]+" ");
    }
}