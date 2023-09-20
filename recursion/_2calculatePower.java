import java.util.*;
public class _2calculatePower {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int x=sc.nextInt();
        int y=sc.nextInt();
        System.out.println(power(x,y));
    }
    public static int power(int x,int y) {
        if(x==0&&y==0)return 1;
        if(x==0)return 0;
        if(y==0)return 1;
        int smallAns=power(x, y/2);
        if(y%2==0)return smallAns*smallAns;
        return x*smallAns*smallAns;
    }
}
