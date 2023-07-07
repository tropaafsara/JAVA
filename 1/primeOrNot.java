/* public class primeOrNot {
    public static boolean isPrime(int n){
        boolean isPrime = true;

        for( int i=2;i<=n-1;i++){
            if(n%i==0){
                isPrime = false;
                break;
            }
        }
        return isPrime;
    }
    public static void main(String[] args) {
        System.out.println(isPrime(8));
        
    }
    
}
 */




 /* public class primeOrNot {
    public static boolean isPrime(int n){
        // boolean isPrime = true;
        
        if(n==2){
            return true;
        }
        
        for( int i=2;i<=n-1;i++){
            if(n%i==0){
                return false;
                
            }
            
        }
        return true;
       
        
    }
    public static void main(String[] args) {
        System.out.println(isPrime(8));
        
    }
    
} */





public class primeOrNot {
    public static boolean isPrime(int n){
        // boolean isPrime = true;
        
        if(n==2){
            return true;
        }
        for( int i=2;i<=Math.sqrt(n);i++){
            if(n%i==0){
                return false;
            } 
        }
        return true;
    }
    //print all primes in a range
    public static void primeInRange(int n){
        for(int i=2;i<=n;i++){
           if( isPrime(i)==true){
            System.out.print(i+" ");
           }
        }

    }
    public static void main(String[] args) {
        System.out.println(isPrime(8));
        primeInRange(20);  //this function won't return any value so sout wont work
        
        
    }
    
}