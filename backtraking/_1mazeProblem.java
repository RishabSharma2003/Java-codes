public class _1mazeProblem {
    public static void main(String[] args) {
        int maze[][]={{1,1,0},{1,1,0},{1,1,1}};
        ratinMaze(maze);
    }
    public static void ratinMaze(int [][]maze){
        int n=maze.length;
        int path[][]=new int[n][n];
        System.out.println(isPathThere(maze,0,0,n,path));
        //printall(maze,0,0,n,path);
    }
    public static boolean isPathThere(int maze[][],int i,int j,int n,int path[][]){
        if(i==-1||i==n||j==-1||j==n||path[i][j]==1||maze[i][j]==0){
            return false;
        }
        //destination path
        if(i==n-1&&j==n-1){
            path[i][j]=1;
            for(int r=0;r<n;r++){
                for(int c=0;c<n;c++){
                    System.out.print(path[r][c]+" ");
                }
                System.out.println();
            }
            return true;
        }
        //include the cell in current path
        path[i][j]=1;
        //top
        if(isPathThere(maze, i-1, j, n, path))return true;
        //isPathThere(maze, i-1, j, n, path);
        //right
        if(isPathThere(maze, i, j+1, n, path))return true;
        //isPathThere(maze, i, j+1, n, path);
        //down
        if(isPathThere(maze, i+1, j, n, path))return true;
        //isPathThere(maze, i+1, j, n, path);
        //left
        if(isPathThere(maze, i, j-1, n, path))return true;
        //isPathThere(maze, i, j-1, n, path);
        return false;
    }

    // public static void printall(int maze[][],int i,int j,int n,int path[][]){
    //     if(i==-1||i==n||j==-1||j==n||path[i][j]==1||maze[i][j]==0){
    //         return;
    //     }



    //     for(int r=0;r<n;r++){
    //         for(int c=0;c<n;c++){
    //             System.out.print(path[r][c]+" ");
    //         }
    //     System.out.println();
    //     }
    //     System.out.println("*******");



    //     //destination path
    //     if(i==n-1&&j==n-1){
    //         path[i][j]=1;
    //         for(int r=0;r<n;r++){
    //             for(int c=0;c<n;c++){
    //                 System.out.print(path[r][c]+" ");
    //             }
    //             System.out.println();
    //         }
    //         path[i][j]=0;
    //         System.out.println();
    //         return;
    //     }
    //     //include the cell in current path
    //     path[i][j]=1;
    //     //top
    //     printall(maze, i-1, j, n, path);
    //     //right
    //     printall(maze, i, j+1, n, path);
    //     //down;
    //     printall(maze, i+1, j, n, path);
    //     //left
    //     printall(maze, i, j-1, n, path);
    //     path[i][j]=0;
    // }
}
