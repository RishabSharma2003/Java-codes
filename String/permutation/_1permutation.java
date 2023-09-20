import java.util.Scanner;



public class _1permutation {
    public static void main(String[] args) {
        //given a string check weather they are permutaion or not
        Scanner sc=new Scanner(System.in);
        String str1=sc.next();
        String str2=sc.next();
        
        A check=new A();
        System.out.print(check.checkPermutation(str1,str2));
    }
}
class A{
    public boolean checkPermutation(String str1,String str2){
        int NO_OF_CHAR=256;
        
        //for str1
        int arr1[]=new int[NO_OF_CHAR];
        //for str2
        int arr2[]=new int[NO_OF_CHAR];
        
        for(int i=0;i<str1.length()&&i<str2.length();i++){
            arr1[str1.charAt(i)]++;
            arr2[str2.charAt(i)]++;
        }

        if(str1.length()!=str2.length())return false;

        for(int i=0;i<NO_OF_CHAR;i++){
            if(arr1[i]!=arr2[i])return false;
        }

        return true;
    }
}
