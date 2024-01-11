import java.util.*;
public class _2celebrity{
    public static void main(String[] args) {
        int arr[][]={{0,1,1,1},
                     {1,0,1,0},
                     {0,0,0,0},
                     {1,1,1,0}};
        Stack<Integer> st=new Stack<>();

        for(int i=0;i<arr.length;i++){
            st.push(i);
        }

        while(st.size()>=2){
            int i=st.pop();
            int j=st.pop();

            if(arr[i][j]==1){
                //if i konws j then i is not celebrity
                st.push(j);
            }else{
                //if i dosn't know j then j is not celebrity
                st.push(i);
            }
        }

        int he_can_be_celebrity=st.pop();

        for(int i=0;i<arr.length;i++){
            if(i!=he_can_be_celebrity){
                if(arr[i][he_can_be_celebrity]==0||arr[he_can_be_celebrity][i]==1){
                    System.out.println("none");return;
                }
            }
        }
        System.out.println(he_can_be_celebrity);

    }

}