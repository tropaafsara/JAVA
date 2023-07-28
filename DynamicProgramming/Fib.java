public class Fib {
    public static int calc(int n, int[] f){//O(n) by DP, but by recursion TC is exponential O(2^n)
        if(n==0 || n==1){
            return n;
        }
        if(f[n]!=0){
            return f[n];
        }
        f[n] = calc(n-1,f)+calc(n-2,f);
        return f[n];//go back to step 9
    }
    public static void main(String[] args) {
        int n=5;
        int f[] = new int[n+1];
        int ans = calc(n,f);
        System.out.println(ans);

    }
}