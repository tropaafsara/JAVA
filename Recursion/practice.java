public class practice {
    public static int fact(int n){
        if(n==1){
            return 1;
        }
        return n*fact(n-1);
    }
    public static int printSum(int n){
        if(n==1){
            return  1;
        }
        return n+printSum(n-1);
    }
    public static int fib(int n){
        if(n==0 || n==1){
            return n;
        }
        int a = fib(n-1);
        int b = fib(n-2);
        int fn = a+b;
        return fn;
    }

    public static boolean isSorted(int arr[], int i){
        if(i==arr.length-1){ //base case bcz at last array is always sorted
            return true;
        }
        if(arr[i]>arr[i+1]){
            return false;
        }
        return isSorted(arr, i+1);
    }
    public static int FO(int arr[], int i, int key){
        if(i==arr.length){
            return -1;
        }

        //base case
        if(arr[i]==key){
            return i;
        }
        return FO(arr, i+1, key);
    }

    public static int pow(int x, int n){
        if(n==0){
            return 1;
        }
        return x*pow(x,n-1);
    }
    public static void main(String[] args) {
        // int n=7;
        // System.out.println(fact(n));
        // System.out.println(printSum(n));
        // System.out.println(fib(n));

        // int arr[] = {2,3,4,5,1};
        // int arr[] = {1,2,3,4,5};
        // System.out.println(isSorted(arr, 0));

        int arr[] = {8,3,6,9,5,5};
        System.out.println(FO(arr, 0, 5));

        // int x=2;
        // int n=5;
        // System.out.println(pow(x, n));
    }
}
