import java.util.Scanner;

public class B {
    public static int countWays(int n,int[] ways){
        //memoization
        if(n==0){
            return 1;
        }
        if(n<0){
            return 0;
        }
        if(ways[n]!=-1){
            return ways[n]; 
        }
        ways[n] =  countWays(n-1,ways)+countWays(n-2,ways);
        return ways[n];
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-->0){
            int n = sc.nextInt();
            int k = sc.nextInt();
            int arr[] = new int[n+1];
            for(int i=0;i<=n;i++){
                arr[i] = i;
            }
            System.out.println(countWays(k,  arr));
        }
    }
}
