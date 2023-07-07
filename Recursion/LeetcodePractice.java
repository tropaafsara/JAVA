public class LeetcodePractice {
    //326-Recursion
    public static boolean isPowerOfThree(int n){
        //base case
        if(n==1){
            return true;
        }
        if(n==0){
            return false;
        }
        if(n%2 !=0){
            return false;
        }
        return isPowerOfThree(n/2); 
        
    }
    public static int fib(int n) {
        if(n==0 || n==1){
            return n;
        }
        return fib(n-1)+fib(n-2);
    }
    public static void main(String[] args) {
        // int n=1;
        // System.out.println(isPowerOfThree(n));

        int n=4;
        System.out.println(fib(n));
    }
}
