public class TilingProblem {
    public static int tilingProblem(int n){//2 x n (floor size) or for 4 x n same solve
        //base case
        if(n==0 || n==1){
            return 1;
        }
        //todo work 
        //vertical choice
        int fnm1 = tilingProblem(n-1);

        //horizontal choice
        int fnm2 = tilingProblem(n-2);

        int totalWays = fnm1+fnm2;
        return totalWays;
    }
    public static void main(String[] args) {
        System.out.println(tilingProblem(3));
    }
}
