public class TargetSum {
    public static boolean targetSumSubset(int[] arr, int sum){//O(n*sum)
        int n = arr.length;
        boolean[][] dp = new boolean[n+1][sum+1];
        //i = item, j=target sum
        
        for(int i=0; i<n+1;i++){
            dp[i][0] = true;
        }
        for(int i=1;i<n+1;i++){
            
            for(int j=1;j<sum+1;j++){
                int v = arr[i-1];
                //include
                if(v<=j && dp[i-1][j-v]){
                    dp[i][j] = true;
                }
                //exclude
                else if(dp[i-1][j]==true){
                    dp[i][j] = true;
                }
            }
        }
        return dp[n][sum];
    }
    public static boolean subsetSum(int[] arr, int sum){//O(n*sum)
        int n = arr.length;
        boolean[][] dp = new boolean[n+1][sum+1];
        //i = item, j=target sum
        
        for(int i=0; i<n+1;i++){
            dp[i][0] = true;
        }
        
        for(int i=1;i<n+1;i++){
            for(int j=1;j<sum+1;j++){
                int a = arr[i-1];
                if(a<=j){
                    boolean include = dp[i-1][j-a];
                    boolean exclude = dp[i-1][j];
                    dp[i][j] = include || exclude;
                }else{//exclude profit
                    boolean exclude = dp[i-1][j];
                   dp[i][j] = exclude;
                }

            }
        }
        return dp[n][sum];
    }
    public static int countSubsetSum(int[] arr, int sum){//O(n*sum)
        int n = arr.length;
        int[][] dp = new int[n+1][sum+1];
        
        for(int i=0; i<n+1;i++){
            dp[i][0] = 1;
        }
        
        for(int i=1;i<n+1;i++){
            for(int j=1;j<sum+1;j++){
                int a = arr[i-1];
                if(a<=j){
                    int include = dp[i-1][j-a];
                    int exclude = dp[i-1][j];
                    dp[i][j] = include + exclude;
                }else{//exclude profit
                    int exclude = dp[i-1][j];
                   dp[i][j] = exclude;
                }
            }
        }
        return dp[n][sum];
    }
        
    
    public static boolean canThreePartsEqualSum(int[] arr){//O(n*sum)
        int sum=0;
        if(arr.length<3){
            return false;
        }
        for(int k=0; k<arr.length;k++){
            sum+=arr[k];
        }
        if(sum%3!=0){
            return false;
        }else{
            return subsetSum(arr, sum/3);
        }
    }

    //count no. of subset with a given diff
    //similar to target sum
    public static int countSubsetWithGivenDiff(int[] arr , int diff){
       
        int sum=0;
        for(int i=0;i<arr.length;i++){
            sum+=arr[i];
        }
        if(((sum - diff) % 2 == 1) || (diff > sum)){
            return 0;
        }
            
        int sum1= (diff+sum)/2;
        return countSubsetSum(arr, sum1);
    }
    public static void main(String[] args) {
        // int[] arr = {4,2,7,1,3,1};
        // int sum=10;
        // System.out.println(targetSumSubset(arr, sum));
        // System.out.println(subsetSum(arr, 3));
        // System.out.println(canThreePartsEqualSum(arr));

        // int[] arr ={2,3,5,6,8,10};
        // System.out.println(countSubsetSum(arr, 10));

        // int[] arr = {1, 1,1,1,1};
        int[] arr = {1};
        System.out.println(countSubsetWithGivenDiff(arr, 2));
    }
}
