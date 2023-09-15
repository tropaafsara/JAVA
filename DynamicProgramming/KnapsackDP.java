public class KnapsackDP {//O(n*W)
    public static int knapsack(int val[], int wt[], int W, int n, int[][] dp){ 
        if(W==0 || n==0){
            return 0;
        }
        if(dp[n][W]!=-1){
            return dp[n][W];
        }
        if(wt[n-1]<=W){//valid, if -1 then call recursion
            //include
            int ans1 = val[n-1]+knapsack(val, wt, W-wt[n-1], n-1,dp);
            //exclude
            int ans2 = knapsack(val,wt,W,n-1,dp);
            
            dp[n][W] = Math.max(ans1, ans2);
            return dp[n][W];
        }else{//not valid
            dp[n][W] = knapsack(val,wt,W,n-1,dp);
            return dp[n][W];
        }
    }

    /* top down approach removes the recursion call.
     * Recursion call creates call stack and there maybe stack overflow
     * that's why top down approach is the best (avoids stack overflow error)
     */
    public static int knapsackTab(int val[], int wt[], int W){
        int n = val.length;
        int[][] dp = new int[n+1][W+1];
        for(int i=0;i<dp.length;i++){//0th col
            dp[i][0] = 0;
        }
        for(int j=0;j<dp[0].length;j++){//0th row
            dp[0][j] = 0;
        }
        for(int i=1;i<n+1;i++){
            for(int j=1;j<W+1;j++){
                int v = val[i-1];//ith item
                int w = wt[i-1];
                if(w<=j){
                    int includeProfit = v+dp[i-1][j-w];//1
                    int excludeProfit = dp[i-1][j];//2
                    dp[i][j] = Math.max(includeProfit,excludeProfit);
                }else{//exclude profit
                    int excludeProfit = dp[i-1][j];//3
                   dp[i][j] = excludeProfit;
                }
            }
        }
        printdp(dp);
        return dp[n][W];
    }
    public static void printdp(int[][] dp){
        for(int i=0;i<dp.length;i++){
            for(int j=0;j<dp[0].length;j++){
                System.out.print(dp[i][j]+" ");
            }
            System.out.println();
        }
    }
    
    public static void main(String[] args) {
        int val[] = {15,14,10,45,30};
        int wt[] = {2,5,1,3,4};
        int W = 7;
        int[][] dp = new int[val.length+1][W+1];
        for(int i=0;i<dp.length;i++){
            for(int j=0;j<dp[0].length;j++){
                dp[i][j] = -1;
            }
        }
        // System.out.println(knapsack(val,wt,W,val.length,dp));
        System.out.println(knapsackTab(val,wt,W));
    }
}
