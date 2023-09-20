import java.util.*;
public class _8gometricSum {
    public static void main(String[] args) {
        //1 + 1/2 + 1/4 + 1/8 + ... + 1/(2^k)
        Scanner sc=new Scanner(System.in);
        int k=sc.nextInt();
        System.out.println(sum(k));
    }
    public static double sum(int k) {
        // if(k==0)return 1;
        // return sum(k-1)+1/(Math.pow(2,k));

        if(k==0)return 1;
        double smallSum=sum(k-1);
        return smallSum+1/(Math.pow(2,k));
    }
}
