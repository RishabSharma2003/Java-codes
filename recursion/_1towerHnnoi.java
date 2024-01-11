public class _1towerHnnoi {
    public static void main(String[] args) {
        toh(3,'a','b','c');
    }



                            //1,a,b,c print n==1
                //2,a,c,b   //1,a,c,b print n==1
                            //1,c,a,b print n==1
 
    //3,a,b,c   //2,a,b,c   print as n==1

                           //1,b,c,a print n==1
                //2,b,a,c  //1,b,a,c print n==1
                           //1,a,b,c print n==1



    public static void toh(int n,char start,char mid,char end){
        if(n<=0){
            System.out.println("illegal entry");
        }
        else if(n==1){
            //this work as base case
            System.out.println("move disk from "+start+" to "+end);
            return;
        }
        toh(n-1,start,end,mid);
        toh(1,start,mid,end);
        toh(n-1,mid,start,end);
    }
}
