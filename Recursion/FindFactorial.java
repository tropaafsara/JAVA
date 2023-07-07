public class FindFactorial {
    public static int fact(int n){ //O(n)
        if(n==0){//we can write n == 1 as well
            return 1;
        }
        int fnm1 = fact(n-1);
        int fn = n* fact(n-1);
        return fn;
    }
    //sum of N natural number
    public static int calcSum(int n){
        if(n==1){
            return 1;
        }
        int Snm1 = calcSum(n-1);
        int Sn = n + Snm1;
        return Sn;
    }
    //calculate nth term fibonacci
    public static int fib(int n){
        if(n==0 || n==1){
            return n;
        }
        int fnm1 = fib(n-1);
        int fnm2 = fib(n-2);
        int fn = fnm1+fnm2;
        return fn;
    }

    //calculate if an array is sorted or not
    public static boolean isSorted(int arr[], int i){
        if(i==arr.length-1){
            return true;
        }
        if(arr[i]>arr[i+1]){
            return false;
        }

        return isSorted(arr, i+1);

    }

    //find first occurance
    public static int firstOccurance(int arr[], int i, int key){
        if(i== arr.length){
            return -1;
        }
        if(arr[i]==key){
            return i;
        }
        return firstOccurance(arr, i+1, key);

    }
    //find last occurance
    public static int lastOccurance(int arr[], int i, int key){
        if(i == arr.length){
            return -1;
        }
        int isFound = lastOccurance(arr, i+1, key);//it will tell if a key exists later or not
        if(isFound != -1){ //if key exists
            return isFound; // return last index that has key
        }

        //check with self
        if(arr[i]==key){
            return i;
        }
        return isFound;//or return -1

    }

    public static int power(int x, int n){
        if(n==0){
            return 1;
        }
        // int xnm1 = power(x, n-1);
        // int xn = x * xnm1;
        // return xn;

        return x*power(x, n-1);

    }
    public static void main(String[] args) {
        int n=25;
        // System.out.println(fact(n));
        // System.out.println(calcSum(n));
        // System.out.println(fib(n));

        // int arr[] = {2,3,4,5,1};
        // System.out.println(isSorted(arr, 0));//start from 0th index

        // int arr[] = {8,3,6,9,5,10,2,5,3};   
        // System.out.println(firstOccurance(arr, 0, 5));
        // System.out.println(lastOccurance(arr, 0, 5));

        System.out.println(power(2, 10));
    }
}
