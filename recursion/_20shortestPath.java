public class _20shortestPath {
    public static void main(String[] args) {
        int arr[][]={{1,1,1},{4,5,2},{7,8,9}};
        //System.out.println(minCost(arr,0,0));
        int storage[][]=new int[arr.length][arr[0].length];
        for(int i=0;i<storage.length;i++){
            for(int j=0;j<storage[0].length;j++){
                storage[i][j]=-1;
            }
        }
        //System.out.println(minCostM(arr,0,0,storage));
        System.out.println(minCost(arr));
    }
    public static int minCost(int arr[][],int i,int j){
        if(i==arr.length-1&&j==arr[0].length-1){
            return arr[i][j];
        }
        if(i==arr.length||j==arr[0].length){
            return Integer.MAX_VALUE;
        }
        int opt1=minCost(arr,i,j+1);
        int opt2=minCost(arr,i+1,j+1);
        int opt3=minCost(arr,i+1,j);
    
        return arr[i][j]+Math.min(opt1,Math.min(opt2,opt3));
    }

    //memorization
    public static int minCostM(int arr[][],int i,int j,int storage[][]){
        if(i==arr.length-1&&j==arr[0].length-1){
            return arr[i][j];
        }
        if(i==arr.length||j==arr[0].length){
            return Integer.MAX_VALUE;
        }
        
        if(storage[i][j]!=-1){
            return storage[i][j];
        }

        int opt1=minCostM(arr,i,j+1,storage);
        int opt2=minCostM(arr,i+1,j+1,storage);
        int opt3=minCostM(arr,i+1,j,storage);

       storage[i][j]=arr[i][j]+Math.min(opt1,Math.min(opt2,opt3));
       return storage[i][j];
    }

    //DP
    public static int minCost(int arr[][]){
        int n=arr.length,m=arr[0].length;
        int storage[][]=new int[n][m];
        for(int i=0;i<storage.length;i++){
            for(int j=0;j<storage[0].length;j++){
                storage[i][j]=100;
            }
        }
        storage[n-1][m-1]=arr[n-1][m-1];
        //for row
        for(int i=n-2;i>=0;i--){
            storage[i][m-1]=arr[i][m-1]+storage[i+1][m-1];
        }
        //for col
        for(int j=m-2;j>=0;j--){
            storage[n-1][j]=arr[n-1][j]+storage[n-1][j+1];
        }
        //digonal
        for(int i=n-2;i>=0;i--){
            for(int j=m-2;j>=0;j--){
                storage[i][j]=arr[i][j]+Math.min(storage[i+1][j],Math.min(storage[i][j+1],storage[i+1][j+1]));
            }
        }
        // for(int i=0;i<n;i++){
        //     for(int j=0;j<m;j++){
        //         System.out.print(storage[i][j]+" ");
        //     }
        //     System.out.println();
        // }
        return storage[0][0];
    }
}
