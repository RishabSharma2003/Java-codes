public class _2josepProblem {
    public static void main(String[] args) {
        //har 5 me se 3rd person ko mar do
        System.out.println(josep(6,3));
    }
    public static int josep(int n,int k) {
        if(n==1)return 0;
        int x=josep(n-1, k);
        int y=(x+k)%n;
        System.out.println("x "+x+" y=("+x+"+"+k+")%"+n+" "+y);
        return y;
        
    }

}
