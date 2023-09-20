import java.sql.PseudoColumnUsage;
import java.util.*;
public class _7countZeros {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        System.out.println(noOfZeros(n));
    }
    public static int noOfZeros(int n){
        // if(n<10){
        //     if(n==0)return 1;
        //     else return 0;
        // }
        // if(n%10==0) return 1+noOfZeros(n/10);
        // else return noOfZeros(n/10);


        if(n<10){
            if(n==0)return 1;
            else return 0;
        }
        int smallAns=noOfZeros(n/10);
        if(n%10==0)return smallAns+1;
        return smallAns;
    }
}
