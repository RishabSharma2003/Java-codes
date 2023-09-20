public class _1queen{
    public static void main(String[] args) {
        int n=4;
        int board[][]=new int[n][n];
        boolean digonal[]=new boolean[n*n-1];
        boolean Reversedigonal[]=new boolean[n*n-1];
        int ans[][]=new int[n][n];
        boolean cols[]=new boolean[n];
        queen(board,digonal,Reversedigonal,0,cols);
    }
    public static void queen(int [][]board,boolean []digonal,
            boolean []Reversedigonal,int row,boolean []cols) {

        
        if(row==board.length){
            for(int i=0;i<board.length;i++){
                for(int j=0;j<board.length;j++){
                    System.out.print(board[i][j]+" ");
                }
                System.out.println();
            }
            System.out.println("new");
            return;
        }

        for(int col=0;col<board.length;col++){
            if(cols[col]==false&&digonal[col+row]==false&&Reversedigonal[row-col+board.length-1]==false){
                cols[col]=true;
                digonal[row+col]=true;
                Reversedigonal[row-col+board.length-1]=true;
                board[row][col]=1;
                queen(board, digonal, Reversedigonal, row+1, cols);
                cols[col]=false;
                digonal[row+col]=false;
                Reversedigonal[row-col+board.length-1]=false;
                board[row][col]=0;
            }
        }
        
    }
}