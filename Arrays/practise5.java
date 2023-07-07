import java.util.Arrays;
import java.util.Scanner;

public class practise5 {
    public static int findSum(int A[],int N){
        Arrays.sort(A);
        return  A[0] + A[N-1];
        
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int A[] = new int[N];
        for(int i=0; i<N;i++){
            A[i] = sc.nextInt();
        }
        
        System.out.println(findSum(A, N));
     }
}
