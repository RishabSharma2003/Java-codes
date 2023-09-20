public class exception_1 {
    public static void main(String[] args){
        //handle the exception using try catch

        try{
            System.out.println(fact(-12));
            System.out.print(devide(10,0));
            System.out.println("hi");
        }
        // catch(DEVIDEByZeroException e){
        //     System.out.println(e);
        // }
        // catch(negativeNUMBERexception e){
        //     System.out.println("NEGATIVE NO ENTERED");
        // }
        catch(Exception e){
            System.out.println(e);
        }
        System.out.println("main");
    }//throws keyword is used to throw an exception from where it come

    
    public static int fact(int n)throws negativeNUMBERexception{
        int ans=1;
        if(n<=0)throw new negativeNUMBERexception();
        for(int i=2;i<=n;i++)ans*=i;
        return ans;
    }

    public static int devide(int a,int b)throws DEVIDEByZeroException{
        if(b==0){
            //throw new ArithmeticException();
            throw new DEVIDEByZeroException();
        }
        return a/b;
    }
}
class DEVIDEByZeroException extends Exception{
}
class negativeNUMBERexception extends Exception{
}
