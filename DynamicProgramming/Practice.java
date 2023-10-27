public class Practice {
    public static int lcsMemo(String s1, String s2, int n, int m, int[][] dp){
        if(n==0 || m==0){
            return 0;
        }
        if(dp[n][m]!=-1){
            return dp[n][m];
        }
        if(s1.charAt(n-1)==s2.charAt(n-2)){
            return lcsMemo(s1, s2, n-1, m-1, dp)+1;
        }else{
            int ans1 = lcsMemo(s1, s2, n, m-1, dp);
            int ans2 = lcsMemo(s1, s2, n-1, m, dp);
            return dp[n][m] = Math.max(ans1, ans2);
        }

    }
    public static int lcs(String s1, String s2){
        int n = s1.length();
        int m = s2.length();
        int[][] dp = new int[n+1][m+1];
        for(int i=0;i<n+1;i++){
            for(int j=0;j<m+1;j++){
                dp[i][j] = -1;
            }
        }
        return lcsMemo(s1,s2,n,m,dp);
    }

    public static int longestCommonSubsequence(String s1, String s2, int n, int m){
        if(n==0||m==0){
            return 0;
        }   
        if(s1.charAt(n-1)==s2.charAt(m-1)){
            return longestCommonSubsequence(s1, s2, n-1,m-1)+1;
        }else{
            int ans1 = longestCommonSubsequence(s1, s2, n, m-1);
            int ans2 = longestCommonSubsequence(s1, s2, n-1, m);
            return Math.max(ans1, ans2);
        }
    }
    public static void main(String[] args) {
        String s1 = "abcde";
        String s2 = "abcodpe";
        longestCommonSubsequence(s1, s2, s1.length(), s2.length());
    }
}
