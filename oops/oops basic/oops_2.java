import java.util.*;
public class oops_2 {
    public static void main(String[] args) {
        //fraction class
        Scanner sc=new Scanner(System.in);
        fraction f1=new fraction(2,3);
        //f1.increment();
        fraction f2=new fraction(5,3);
        // f1.add(f2);
        // f1.print();
        //fraction f3=fraction.add(f1,f2);
    }
}


class fraction{
    int numerator;
    int denominator;
    fraction(int numerator,int denominator){
        if(denominator==0){
            //throw error
            denominator=1;
        }
        this.numerator=numerator;
        this.denominator=denominator;
        simplify();
    }

    //private
    private void simplify(){
        int gcd=1;
        int smaller=Math.max(numerator,denominator);
        for(int i=2;i<=smaller;i++){
            if(numerator%i==0&&denominator%i==0)gcd=i;
        }
        numerator=numerator/gcd;
        denominator=denominator/gcd;
    }
    public void increment(){
        numerator=numerator+denominator;
        simplify();
    }
    public void setNumerator(int num){
        if(num==0){
            //throw
            return;
        }
        this.numerator=num;
        simplify();
    }
    public void setDenominator(int num){
        if(num==0){
            //throw
            return;
        }
        this.denominator=num;
        simplify();
    }
    public void add(fraction f2){
        //first fraction is that at which func is called
        //second fraction is passed
        this.numerator=this.numerator*f2.denominator+f2.numerator+this.denominator;
        this.denominator=this.denominator+f2.denominator;
        simplify();
    }
    public fraction add(fraction a1,fraction a2){
        int newNum=a1.numerator*a2.denominator+a2.numerator+a1.denominator;
        int newdenom=a1.denominator+a2.denominator;
        fraction a3=new fraction(newNum, newdenom);
        return a3;
    }
    public void print(){
        System.out.println(numerator+"/"+denominator);
    }
}
