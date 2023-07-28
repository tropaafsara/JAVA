public class SubsetSum {
    public static boolean isSubsetSum(int N, int arr[], int sum){
        boolean[][] dp = new boolean[N+1][sum+1];
        for(int i=0;i<dp.length;i++){//0th col
            dp[i][0] = true ;
        }
        for(int i=1;i<N+1;i++){
            for(int j=1;j<sum+1;j++){
                if(arr[i-1]<=j){
                    boolean include = dp[i-1][j-arr[i-1]];
                    boolean exclude = dp[i-1][j];
                    dp[i][j] = include||exclude;
                }else{
                    boolean exclude = dp[i-1][j];
                   dp[i][j] = exclude;
                }
            }
        }
        
        return dp[N][sum];
    }
    public static boolean equalSum(int N, int arr[], int sum){
        if(sum%2!=0){
            return false;
        }else{
            sum=sum/2;
            boolean[][] dp = new boolean[N+1][sum+1];
        for(int i=0;i<dp.length;i++){//0th col
            dp[i][0] = true ;
        }
        for(int i=1;i<N+1;i++){
            for(int j=1;j<sum+1;j++){
                if(arr[i-1]<=j){
                    boolean include = dp[i-1][j-arr[i-1]];
                    boolean exclude = dp[i-1][j];
                    dp[i][j] = include||exclude;
                }else{
                    boolean exclude = dp[i-1][j];
                   dp[i][j] = exclude;
                }
            }
        }
        
        return dp[N][sum];
        }
        
    }
    public static int countSubsetSum(int N, int arr[], int sum){
        int[][] dp = new int[N+1][sum+1];
        for(int i=0;i<dp.length;i++){//0th col
            dp[i][0] = 1 ;
        }
        for(int i=1;i<N+1;i++){
            for(int j=1;j<sum+1;j++){
                if(arr[i-1]<=j){
                    int include = dp[i-1][j-arr[i-1]];
                    int exclude = dp[i-1][j];
                    dp[i][j] = include+exclude;
                }else{
                    int exclude = dp[i-1][j];
                   dp[i][j] = exclude;
                }
            }
        }
        
        return dp[N][sum];
    }
    public static void printdp(boolean[][] dp){
        for(int i=0;i<dp.length;i++){
            for(int j=0;j<dp[0].length;j++){
                System.out.print(dp[i][j]+" ");
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {
        // int arr[] = {3, 34, 4, 12, 5, 2};
        // int N = arr.length;
        // int sum = 9;
        // System.out.println(isSubsetSum(N, arr, sum));

        //equal sum
        // int arr[] = {1,2,5};
        // int N = arr.length;
        // int sum=0;
        // for(int i=0;i<N;i++){
        //     sum+=arr[i];
        // }
        // System.out.println(equalSum(N, arr, sum));

        //count subset-sum
        int arr[] = {1, 1, 1, 1};
        int N = arr.length;
        int sum = 1;
        System.out.println(countSubsetSum(N, arr, sum));
    }
}
