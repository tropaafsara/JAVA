import java.util.Scanner;
import java.util.Vector;

public class E {
    static long maxSubArray(Vector<Integer> nums) {
        int n = nums.size();
        int ans = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            for (int j = i, curSum = 0; j < n; j++) {
                curSum += nums.get(j);
                ans = Math.max(ans, curSum);
            }
        }
        return ans;
    }

    static boolean isPrime(int k, int n, Vector<Integer> a) {
        Vector<Integer> v = new Vector<>(k);
        for (int i = 0; i < k; i++) {
            v.add(0);
        }
        for (int i = 0; i < n; i++) {
            v.set(a.get(i) % k, v.get(a.get(i) % k) + 1);
        }
        for (int i = 0; i < k; i++) {
            if (v.get(i) <= 1)
                return true;
        }
        return false;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        while (t-- > 0) {
            int n, c;
            int l, r;
            n = scanner.nextInt();
            c = scanner.nextInt();
            l = 0;
            int sum = 0;
            Vector<Integer> a = new Vector<>();
            for (int i = 0; i < n; i++) {
                r = scanner.nextInt();
                a.add(r);
                l += r * r;
                sum += r;
            }

            c -= l;
            c = c / 4;
            c = c / n;
            sum /= 2 * n;
            int temp = (int) Math.sqrt(sum * sum + c);
            temp -= sum;
            System.out.println(temp);
        }
        scanner.close();
    }
}
