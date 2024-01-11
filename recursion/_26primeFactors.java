public class _26primeFactors {
    public static void main(String[] args){
        int n=200;
        while(n%2==0){
            System.out.println("2");
            n/=2;
        }
        //upper sare ke sare even nikal liye ab sird odd no bacha h n me 
        //so if n remain 23 it check for 3,5,7-----

        printPrimeFactors(n,3);
    }
    public static void printPrimeFactors(int n,int i) {
        if(n==1)return;
        if(n%i==0){
            //if(isPrime(i))System.out.println(i);
            //automatic prime no hi ayege bec i=3,5,7
            //i=9 hone se pehle 3 se devide ho chuka hoga
            System.out.println(i);
            printPrimeFactors(n/i,i);
        }
        else printPrimeFactors(n,i+2);  
    }
    public static boolean isPrime(int n){
        for(int i=2;i<=Math.sqrt(n);i++){
            if(n%i==0)return false;
        }
        return true;
    }
}
