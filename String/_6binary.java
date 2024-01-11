public class _6binary {
    //You are given an integer A. Your task is to find the Ath number whose binary representation is a palindrome.
//Consider that the first number with a palindrome binary representation is 1, instead of 0. When counting these
//numbers, do not consider leading zeros in the binary representation.
// Write a Java program to solve this problem and find the Ath binary palindrome number.
    public static void main(String[] args) {
//Number 1 (binary: 1): This is the first number, and its binary representation is "1," which is a palindrome. So, we increment the count to 1.

// Number 2 (binary: 10): The binary representation is "10," which is not a palindrome.

// Number 3 (binary: 11): The binary representation is "11," which is a palindrome. We increment the count to 2.

// Number 4 (binary: 100): The binary representation is "100," which is not a palindrome.

// Number 5 (binary: 101): The binary representation is "101," which is a palindrome. We increment the count to 3.

// Number 6 (binary: 110): The binary representation is "110," which is not a palindrome.

// Number 7 (binary: 111): The binary representation is "111," which is a palindrome. We increment the count to 4.
        int test=2;
        int n=0;

        while(test!=0){
            n++;
            String s=check(n,"");
            if(palindrome(s)){
                test--;
            }
        }
        System.out.println(n);
    }
    public static String check(int n,String ans) {
        if(n==1) return "1"+ans;
        int rem=n%2;
        String s=Integer.toString(rem);
        return check(n/2,s+ans);   
    }
    public static boolean palindrome(String s){
        int i=0,j=s.length()-1;
        while(i<j){
            if(s.charAt(i)!=s.charAt(j))return false;
            i++;j--;
        }
        return true;
    }
}
