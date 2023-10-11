public class Practice {
    public static int knapsack(int val[], int wt[], int W, int n){
        if(n==0 || W ==0){
            return 0;
        }
        if(wt[n-1]<=W){
            int include = val[n-1]+knapsack(val, wt, W-wt[n-1], n-1);
            int exclude = knapsack(val, wt, W, n-1);
            return Math.max(include,exclude);
        }else{
            return knapsack(val, wt, W, n-1);
        }
    }
    public static int knapsackMemo(int val[], int wt[], int W, int n,int[][] dp){
        if(n==0 || W ==0){
            return 0;
        }
        if(dp[n][W]!=-1){
            return dp[n][W];
        }
        if(wt[n-1]<=W){
            int include = val[n-1]+knapsackMemo(val, wt, W-wt[n-1], n-1,dp);
            int exclude = knapsackMemo(val, wt, W, n-1,dp);
            dp[n][W] = Math.max(include,exclude);
            return dp[n][W];
        }else{
            dp[n][W] = knapsackMemo(val, wt, W, n-1,dp);
            return dp[n][W];
        }
    }
    public static int knapsackTab(int val[], int wt[], int W, int n){
        int[][] dp = new int[n+1][W+1];
        for(int i=0;i<dp.length;i++){//row
            dp[i][0] = 0;
        }
        for(int i=0;i<dp[0].length;i++){//col
            dp[0][i] = 0;
        }
        for(int i=1;i<n+1;i++){//row = n = i
            for(int j=1;j<W+1;j++){//col = W = j
                if(wt[i-1]<=j){
                    int include = val[i-1]+dp[i-1][j-wt[i-1]];
                    int exclude = dp[i-1][j];
                    dp[i][j] = Math.max(include, exclude);
                }else{
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        return dp[n][W];
    }
    public static void main(String[] args) {
        int val[] = {15,14,10,45,30};
        int wt[] = {2,5,1,3,4};
        int W = 7;
        int[][] dp = new int[val.length+1][W+1];
        for(int i=0;i<dp.length;i++){
            for(int j=0;j<dp[0].length;j++){
                dp[i][j]=-1;
            }
        }
        System.out.println(knapsackMemo(val,wt,W,val.length,dp));
    }
}
