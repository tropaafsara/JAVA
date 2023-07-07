public class Strings {
    public static boolean isPrime(int n){
        if(n<=1){
            return false;
        }
        for(int i=2;i<n;i++){
            if(n%i==0){
               return false;
            }
        }
        return true;
    }
    public static void printPrime(int n){
            for(int i=2;i<=n;i++){
                int sum =0;
                if(isPrime(i)){
                    System.out.println(i+" ");
                    sum = n-i;
                }
            }
    }
    public static void main(String[] args) {
        int n =10;
        printPrime(n);
        
    }
}
