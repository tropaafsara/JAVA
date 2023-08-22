import java.util.Scanner;

public class GoodArrays {
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
            int t = sc.nextInt();
            while(t-->0){
                int n = sc.nextInt();
                long[] a1 = new long[n];
                long sum=0;
                int s=0;
                for(int i=0;i<n;i++){
                   a1[i] = sc.nextInt();
                   sum+=a1[i];
                   if(a1[i]==1){
                    s+=2;
                   }else{
                    s+=1;
                   }
                }
                if(n==1 || s>sum){
                    System.out.println("NO");
                }else{
                    System.out.println("YES");
                }
            }
    }
}
