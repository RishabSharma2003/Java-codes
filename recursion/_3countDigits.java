import java.util.*;
public class _3countDigits {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        System.out.println(count(n));
    }
    public static int count(int n) {
        if(n==0)return 0;
        return 1+count(n/10);
    }
}
