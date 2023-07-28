import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class VikaandtheBridge {
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt(); // Number of test cases

        while (t-- > 0) {
            int n = scanner.nextInt(); // Number of planks
            int k = scanner.nextInt(); // Number of colors

            List<List<Integer>> gaps = new ArrayList<>(n + 1);
            List<Integer> pre = new ArrayList<>(n + 1);
            List<Integer> a = new ArrayList<>(n + 1);

            for (int i = 0; i <= n; i++) {
                pre.add(0);
                gaps.add(new ArrayList<>());
            }

            for (int i = 1; i <= n; i++) {
                a.add(scanner.nextInt());
            }

            for (int i = 1; i <= n; i++) {
                gaps.get(a.get(i)).add(i - pre.get(a.get(i)) - 1);
                pre.set(a.get(i), i);
            }

            int mn = Integer.MAX_VALUE;
            for (int i = 1; i <= k; i++) {
                gaps.get(i).add(n - pre.get(i));
                Collections.sort(gaps.get(i), Collections.reverseOrder());
                int res = gaps.get(i).get(0) / 2;

                if (gaps.get(i).size() >= 2) {
                    res = Math.max(res, gaps.get(i).get(1));
                }

                mn = Math.min(mn, res);
            }

            System.out.println(mn);
        }
    }
}
