public class UnboundKnapsack {
    //it's a fully unbounded knapsack problem
    public static int rodCutting(int[] price, int N){
        int[] length = new int[N];
        for(int i=0;i<N;i++){
            length[i] = i+1;
        }
        int n = price.length;
        int[][] dp = new int[n+1][N+1];
        for(int i=0;i<dp.length;i++){//col -> 0
            dp[i][0] = 0;
        }
        for(int i=0;i<dp[0].length;i++){//row -> 0
            dp[0][i] = 0;
        }
        for(int i=1;i<n+1;i++){
            for(int j=1;j<N+1;j++){
                int p = price[i-1];
                int l = length[i-1];
                if(l<=j){
                    //include
                    int include = p+dp[i][j-l];
                    //exclude
                    int exclude = dp[i-1][j];
                    dp[i][j] = Math.max(include, exclude);
                }else{
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        return dp[n][N];
    }
    //1547. Minimum Cost to Cut a Stick
    public static int minCostStick(int n, int[] cuts){
        int[] cuts2 = new int[cuts.length+1];
        for(int i=0;i<cuts.length;i++){
            cuts2[i] = cuts[i];
        }
        cuts2[cuts.length] = n;
        int[] price = new int[cuts2.length];
        
        price[0] = cuts2[0];
        for(int i=1;i<cuts2.length;i++){
            price[i] = cuts2[i]-cuts2[i-1];
        }
        // for(int i=0;i<cuts2.length;i++){
        //     System.out.print(cuts2[i]+" ");
        // }
        // System.out.println();
        // for(int i=0;i<cuts2.length;i++){
        //     System.out.print(price[i]+" "); 
        // }
        int m = price.length;
        int N = cuts2.length;
        int[][] dp = new int[m+1][N+1];
        for(int i=0;i<dp.length;i++){//col -> 0
            dp[i][0] = 0;
        }
        for(int i=0;i<dp[0].length;i++){//row -> 0
            dp[0][i] = 0;
        }
        for(int i=1;i<m+1;i++){
            for(int j=1;j<N+1;j++){
                if(cuts2[i-1]<=j){
                    dp[i][j] = Math.max(price[i-1]+dp[i][j-cuts2[i-1]], dp[i-1][j]);
                }else{
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        return dp[m][N];
    }



    public static int coinChange2(int[] coins,int amount){
        int N = coins.length;
        int[][] dp = new int[N+1][amount+1];
        for(int i=0;i<dp.length;i++){//0th col
            dp[i][0] = 1 ;
        }
        for(int i=1;i<N+1;i++){
            for(int j=1;j<amount+1;j++){
                if(coins[i-1]<=j){
                    dp[i][j] = dp[i][j-coins[i-1]]+dp[i-1][j];
                }else{
                    int exclude = dp[i-1][j];
                   dp[i][j] = exclude;
                }
            }
        }
        
        return dp[N][amount];

        
    }

    public static int coinChange(int[] coins, int amount){
        int n = coins.length;
        
        int[][] dp = new int[n+1][amount+1];
        for(int i=1;i<dp.length;i++){//col -> 0
            dp[i][0] = 0;
        }
        for(int i=0;i<dp[0].length;i++){//col -> 0
            dp[0][i] = Integer.MAX_VALUE-1;
        }
        
        for(int j=1;j<dp[0].length;j++){//col -> 0
            int i=1;
            if(j%coins[0]==0){
                dp[i][j] = j/coins[0];
            }else{
                dp[i][j] = Integer.MAX_VALUE-1;
            }
            
        }
        for(int i=2;i<n+1;i++){
            for(int j=1;j<amount+1;j++){
                int c = coins[i-1];
                if(c<=j){
                    //include
                    int include = dp[i][j-c];
                    //exclude
                    int exclude = dp[i-1][j];

                    dp[i][j] =Math.min((1+include),exclude);
                }else{
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        return (dp[n][amount]==Integer.MAX_VALUE-1 ? -1 : dp[n][amount]);
    }
    
    public static void main(String[] args) {
        // int[] price = {1, 5, 8, 9, 10, 17, 17, 20};
        // int N = 8;
        // System.out.println(rodCutting(price,N));

        // int[] coins = {1,2,5};
        // int amount = 5;
        // System.out.println(coinChange2(coins, amount));

        // int[] coins = {2,5,10,1};
        // int amount = 27;
        // System.out.println(coinChange(coins,amount));


        int[] cuts = {1,3,4,5};
        System.out.println(minCostStick(7, cuts));
    }
}
