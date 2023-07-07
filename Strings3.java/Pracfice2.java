import java.util.Scanner;

public class Pracfice2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testCase = sc.nextInt();
       
        for (int i = 0; i < testCase; i++) {
             int result = 0;
            int n = sc.nextInt();
            int x = sc.nextInt();
            int k = sc.nextInt();
            int p = sc.nextInt();
            int remBells = 0;

            int totalBells = x * 10;

            if (k > x) {
                remBells = (k - x) * 5;
            }
            if (k <= x) {
                totalBells = k * 10;
            }
            if (n == k) {
                result = result + 20;
            }
            result += p + remBells + totalBells;
            System.out.println(result);
        }

        
    }
}
