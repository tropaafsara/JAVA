import java.util.ArrayList;
import java.util.List;

public class MinSubsetSumDiff {
    //doesn't work for negative test cases
    public static List<Integer> subsetSum(int[] arr, int sum){//O(n*sum)
        List<Integer> list = new ArrayList<>();
        int n = arr.length;
        boolean[][] dp = new boolean[n+1][sum+1];
        
        
        for(int i=0; i<n+1;i++){
            dp[i][0] = true;
        }
        
        for(int i=1;i<n+1;i++){
            for(int j=1;j<sum+1;j++){
                int a = arr[i-1];
                if(a<=j){//include
                    boolean include = dp[i-1][j-a];
                    boolean exclude = dp[i-1][j];
                    dp[i][j] = include || exclude;
                }else{//exclude 
                    boolean exclude = dp[i-1][j];
                   dp[i][j] = exclude;
                }

            }
        }
        for (int i =0;i<=n+1;i++){
            for (int j = 0;j<=sum/2;j++){
                if (i == n){
                    if (dp[i][j]){
                        list.add(j);
                    }
                }
            }
        }
        return list;
    }
    
    public static int minSubsetSumDiff(int[]arr){
        int range = 0;
        for(int i=0;i<arr.length;i++){
            range+=arr[i];
        }
        
        List<Integer> list = subsetSum(arr, range);
        int mn = Integer.MAX_VALUE;
        for(int i=0;i<list.size();i++){
            mn = Math.min(mn,range-(2*list.get(i)));
        }
        return mn;
        
    }

    public static void main(String[] args) {
        // int[] arr = {3,9,7,3};
        int[] arr = {3,9,7,3};
        System.out.println(minSubsetSumDiff(arr));
        
    }
}
