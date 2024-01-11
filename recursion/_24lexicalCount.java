public class _24lexicalCount {
    public static void main(String[] args) {
        print(1000,0);

        for (int i = 1; i <= 9; i++)
            dfs(i, 1000);
    }

    public static void dfs(int i,int n){
        if(i>n)return;
        System.out.println(i);
        for(int j=0;j<9;j++){
            dfs(10*i+j,n);
        }
    }

    public static void print(int n, int curr) {
        if (curr > n)
            return;
        System.out.println(curr);
        int i = 0;
        if (curr == 0)
            i = 1;
        for (; i <= 9; i++) {
            print(n, curr * 10 + i);
        }

    }

}
