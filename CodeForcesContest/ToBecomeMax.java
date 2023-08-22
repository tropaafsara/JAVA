import java.util.Scanner;

public class ToBecomeMax {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
            int t = sc.nextInt();
            while(t-->0){
                int n = sc.nextInt();
                int k = sc.nextInt();

                int[] a = new int[n];
                for (int i = 0; i < n; i++) {
                    a[i] = sc.nextInt();
                }
                int max = a[0];
                for (int i = 0; i < n - 1 && k > 0; i++) {
                    if (a[i] < a[i + 1]) {
                        int diff = a[i + 1] - a[i];
                        if (diff <= k) {
                            k -= diff;
                            a[i] += diff;
                            max = Math.max(max, a[i]);
                        } else {
                            max = Math.max(max, a[i] + k);
                            break;
                        }
                    }
                }
    
                System.out.println(max);


            }
    }
}
