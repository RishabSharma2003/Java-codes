public class _18mazePath {
    public static void main(String[] args) {
        int n=3;
        int m=3;
        //int this we only have to move horizontal&vertical
        printPath(n-1,m-1,0,0,"");
    }
    public static void printPath(int er,int ec,int i,int j,String ans) {
        //er end row
        //ec end col
        //i current row
        //j current col
        
        // if(er==i&&j==ec){
        //     System.out.println(ans);
        //     return;
        // }
        // if(i+1!=er+1)printPath(er,ec,i+1,j,ans+'H');
        // if(j+1!=ec+1)printPath(er,ec,i,j+1,ans+'V');

        if(er==i&&j==ec){
            System.out.println(ans);
            return;
        }
        if(i>er||j>ec)return;
        printPath(er,ec,i+1,j,ans+'H');
        printPath(er,ec,i,j+1,ans+'V');
    }
}
