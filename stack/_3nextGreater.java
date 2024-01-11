import java.util.*;
public class _3nextGreater {
    public static void main(String[] args) {
        int arr[]={3,6,1,2,10,4,5,1,2,3};
        int nge[]=new int[arr.length];
        Stack<Integer> st=new Stack<>();
        st.push(arr[arr.length-1]);
        nge[arr.length-1]=-1;

        for(int i=0;i<arr.length;i++){
            System.out.print(arr[i]+" ");
        }System.out.println();

        for(int i=arr.length-2;i>=0;i--){
            while(st.size()>0&&st.peek()<=arr[i]){
                st.pop();
            }
            if(st.size()==0){
                nge[i]=-1;
            }else{
                nge[i]=st.peek();
            }
            st.push(arr[i]);
        }

        for(int i=0;i<arr.length;i++){
            System.out.print(nge[i]+" ");
        }

    }
}
