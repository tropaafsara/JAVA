public class practice4 {
    /* public static int avgNum(int a, int b, int c){
        int r = (a+b+c)/3;
        return r;
    } */


    /* public static boolean isEven(int a){
        if(a%2==0){
            return true;
        }else{
            return false;
        }

    } */

    /* public static boolean isPalindrome(int n){
        int temp=n;
        int reversed =0;
        while(n>0){
            int rem = n%10; 
            reversed = (reversed*10)+rem;
            n=n/10;
        }
       if(temp==reversed){
        return true;
       }else{
        return false;
       }
    } */

    public static int sumOfDigits(int n){
        int sum = 0 ;
        while(n>0){
            int lastDigit = n%10;
            sum = sum + lastDigit;
            n/=10;
        }
        return sum;
    }
        
    
    public static void main(String[] args) {
        // System.out.println(avgNum(2, 5, 6));
        // System.out.println(isEven(5));
        // System.out.println(isPalindrome(1211));
        System.out.println(sumOfDigits(1211));
    }
    
}
