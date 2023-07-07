import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class A {
    public static void forbiddenInteger(int n, int k, int x) {
        int sum = 0;
        int count = 0;
        int[] takenIntegers = new int[n];
        for (int i = 1; i <= k; i++) {
            if (i!= x && sum+i<=n) {
                takenIntegers[count++] = i;
                sum += i;
            }
        }
        if (sum == n) {
                System.out.println("YES");
                System.out.println(count);
                for (int i = 0; i < count; i++) {
                    System.out.print(takenIntegers[i] + " ");
                }
                System.out.println();
            } else {
                System.out.println("NO");
            }

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testCase = sc.nextInt();
        for (int i = 0; i < testCase; i++) {
            int n = sc.nextInt();
            int k = sc.nextInt();
            int x = sc.nextInt();
            forbiddenInteger(n, k, x);

        }
    }
}
