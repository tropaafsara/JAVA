import java.util.ArrayList;
import java.util.List;

public class KnapsackDP {
    public static int knapsack(int val[], int wt[], int W, int n){
        if(W==0 || n==0){
            return 0;
        }
        if(wt[n-1]<=W){//valid
            //include
            int ans1 = val[n-1]+knapsack(val, wt, W-wt[n-1], n-1);

            //exclude
            int ans2 = knapsack(val,wt,W,n-1);
            return Math.max(ans1, ans2);
        }else{//not valid
            return knapsack(val,wt,W,n-1);
        }
    }
    
    //O(n*W)
    public static int knapsackMemo(int val[], int wt[], int W, int n, int[][] dp){ 
        if(W==0 || n==0){
            return 0;
        }
        if(dp[n][W]!=-1){
            return dp[n][W];
        }
        if(wt[n-1]<=W){//valid, if -1 then call recursion
            //include
            int ans1 = val[n-1]+knapsackMemo(val, wt, W-wt[n-1], n-1,dp);
            //exclude
            int ans2 = knapsackMemo(val,wt,W,n-1,dp);
            
            dp[n][W] = Math.max(ans1, ans2);
            return dp[n][W];
        }else{//not valid
            dp[n][W] = knapsackMemo(val,wt,W,n-1,dp);
            return dp[n][W];
        }
    }

    /* top down approach removes the recursion call.
     * Recursion call creates call stack and there maybe stack overflow
     * that's why top down approach is the best (avoids stack overflow error)
     */
    
    public static int knapsackTab(int val[], int wt[], int W, int n){
        int[][] dp = new int[n+1][W+1];
        for(int i=0;i<dp.length;i++){//row
            dp[i][0] =  0;
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
        //System.out.println(knapsack(val,wt,W,val.length));
        // System.out.println(knapsack(val,wt,W,val.length,dp));
        System.out.println(knapsackTab(val,wt,W));
    }

    public List<List<Integer>> perfectSum(int arr[],int n, int sum) 
	{ 
	    List<List<Integer>>[][] dp = new ArrayList[n+1][sum+1];
        for(int i=0;i<dp.length;i++){//row
            for(int j=0;j<dp[0].length;j++){
                dp[i][j]=new ArrayList<>();
            }
        }
        for(int i=1;i<n+1;i++){//row = n = i
            dp[i][0].add(new ArrayList());
            for(int j=0;j<sum+1;j++){//col = W = j
                 if(arr[i-1]<=j){
                    int include = (dp[i-1][j-arr[i-1]]);
                    int exclude = (dp[i-1][j]);
                    dp[i][j] =(include+exclude);
                }else{
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        return dp[n][sum];
	} 
    static Boolean isSubsetSum(int n, int arr[], int sum){
        // code here
        Boolean[][] dp = new Boolean[n+1][sum+1];
        for(int i=0;i<dp.length;i++){//row
            dp[i][0] = true;
        }
        for(int i=1;i<dp[0].length;i++){//col
            dp[0][i] = false;
        }
        for(int i=1;i<n+1;i++){//row = n = i
            for(int j=1;j<sum+1;j++){//col = W = j
                if(arr[i-1]<=j){
                    dp[i][j] =(dp[i-1][j-arr[i-1]] | dp[i-1][j]);
                }else{
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        return dp[n][sum];
    }
}
