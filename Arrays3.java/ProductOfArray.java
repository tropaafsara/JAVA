public class ProductOfArray {
    public static int[] productOfArray(int[] arr){
        int n = arr.length ;
        int[] prefix = new int[n];
        int[] postfix = new int[n];
        int[] op = new int[n];
        int prod =1;

        for(int i=0; i<n;i++){
            prod*=arr[i];
            prefix[i] = prod;
        }
        prod=1;
        for(int i=n-1; i>=0;i--){
            prod*=arr[i];
            postfix[i] = prod;
        }
        op[0] = postfix[1];
        op[n-1] = prefix[n-2];
        for(int i=1;i<=n-2;i++){
            op[i] = prefix[i-1]*postfix[i+1];
        }
        return op;
        // for(int i=0;i<op.length;i++){
        //     System.out.print(op[i]+" ");
        // }






        //print
        // for(int i=0;i<postfix.length;i++){
        //     System.out.print(prefix[i]+" ");
        // }
        // System.out.println();
        // for(int i=0;i<postfix.length;i++){
        //     System.out.print(postfix[i]+" ");
        // }
        // System.out.println();
        

    }
    
    public static void main(String[] args) {
        int[] arr = {1,2,3,4};
        productOfArray(arr);
    }
}
