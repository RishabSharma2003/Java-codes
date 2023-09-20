public class _23knapSack {
    public static void main(String[] args) {
        int[]weights={6,1,2,4,5};
        int[]values={10,5,4,8,6};
        int maxWeight=5;
        //max value v=5+8(value)
        System.out.println(knapsack(weights,values,maxWeight,0));
    }
    //max value
    public static int knapsack(int[]weights,int[]values,int maxWeight,int i) {
        //i==weights.length we have scanned all weights
        //weights.length we cant add any more
        if(i==weights.length||weights.length==0)return 0;
        if(weights[i]>maxWeight)return knapsack(weights,values,maxWeight,i+1);
        else{
            //include
            int op1=values[i]+knapsack(weights,values,maxWeight-weights[i],i+1);
            int op2=knapsack(weights,values,maxWeight,i+1);
            return Math.max(op1,op2);
        }
    }
}
