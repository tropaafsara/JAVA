public class PrintSubarray {
    //brute force -> O(n^3)
    public static void printSubarrays(int[] arr){
        int n = arr.length;
        for(int i=0;i<n;i++){
            for(int j=i;j<n;j++){
                for(int k=i;k<=j;k++){
                    System.out.print(arr[k]+" ");
                }
                System.out.println();
            }
        }
    }
    public static void printSum(int[] arr){
        int n = arr.length;
        for(int i=0;i<n;i++){
            for(int j=i;j<n;j++){
                int sum =0;
                for(int k=i;k<=j;k++){
                    sum += arr[k];
                    System.out.print(arr[k]+" ");
                }  
                System.out.print("sum = "+sum); 
                System.out.println();
            }
        }

    }
    public static void printMaxSum(int[] arr){
        int n = arr.length;
        int maxSum = Integer.MIN_VALUE;
        for(int i=0;i<n;i++){
            for(int j=i;j<n;j++){
                
                int sum =0;
                for(int k=i;k<=j;k++){
                    sum += arr[k];
                    System.out.print(arr[k]+" ");
                }  
                System.out.print("sum = "+sum); 
                if(maxSum<sum){
                    maxSum = sum;
                }
                System.out.println();
            }
        }

        System.out.println(maxSum);
    }

    //prefix sum -> O(n^2)
    public static void prefixSum(int[] arr){
        int n = arr.length;
        int maxSum = Integer.MIN_VALUE;

        int prefix[] = new int[arr.length];
        //calc prefix
        prefix[0] = arr[0];
        for(int i=1; i<prefix.length;i++){
            prefix[i] = prefix[i-1]+arr[i];
        }


        for(int i=0;i<n;i++){
            for(int j=i;j<n;j++){
                int sum =0;

                sum = i ==0 ? prefix[j] : prefix[j] - prefix[i-1] ; 
                // System.out.print("sum = "+sum); 
                if(maxSum<sum){
                    maxSum = sum;
                }
            }
        }

        System.out.println(maxSum);
    }
    //kadane's algo
    public static void kadanesAlgo(int[] arr){
        int n = arr.length;
        int currSum = 0;
        int maxSum = Integer.MIN_VALUE;
        for(int i=0;i<n;i++){
            currSum += arr[i];
            if(currSum<0){
                currSum=0;
            }
            maxSum = Math.max(maxSum, currSum);
        }
        System.out.println(maxSum);
    }
    public static void main(String[] args) {
        // int[] arr ={2,4,6,8,10};
        // printSubarrays(arr);
        // printSum(arr);
        // printMaxSum(arr);
        // prefixSum(arr);

        int[] arr = {-2,-3,4,-1,-2,1,5,-3};
        kadanesAlgo(arr);
    }
}
