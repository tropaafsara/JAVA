import java.util.*;
import java.io.*;
import java.math.BigInteger;
 
public class C_Binary_String_Copying {
    static class FastReader {
        BufferedReader br;
        StringTokenizer st;
 
        public FastReader() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }
 
        String next() {
            while (st == null || !st.hasMoreTokens()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }
 
        int nextInt() {
            return Integer.parseInt(next());
        }
 
        long nextLong() {
            return Long.parseLong(next());
        }
 
        double nextDouble() {
            return Double.parseDouble(next());
        }
 
        String nextLine() {
            String str = "";
            try {
                str = br.readLine().trim();
            } catch (Exception e) {
                e.printStackTrace();
            }
            return str;
        }
    }
 
    public static void main(String[] args) {
        // try {
        FastReader vt = new FastReader();
        PrintWriter out = new PrintWriter(System.out);
        int testCases = vt.nextInt();
        // int testCases = 1;
        while (testCases-- > 0) {
            // write code here
            int n = vt.nextInt();
            int m = vt.nextInt();
            String s = vt.next();
            ArrayList<Integer> zero = new ArrayList<>();
            ArrayList<Integer> one = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                if (s.charAt(i) == '0') {
                    zero.add(i);
                } else {
                    one.add(i);
                }
            }
            boolean check = false;
            Set<ArrayList<Integer>> set = new HashSet<>();
            for (int i = 0; i < m; i++) {
                int l = vt.nextInt() - 1;
                int h = vt.nextInt() - 1;
                int up = upper_bound(zero, h) - 1;
                int z = -1;
                if (up >= 0) {
                    z = zero.get(up);
                }
                int lb = lower_bound(one, l);
                int o = n;
                if (lb < one.size()) {
                    o = one.get(lb);
                }
                if (z < l || o > h || z < o) {
                    check = true;
                } else {
                    ArrayList<Integer> li = new ArrayList<>();
                    li.add(o);
                    li.add(z);
                    set.add(li);
                }
            }
            int ans = set.size();
            if (check == true)
                ans++;
            out.println(ans);
        }
        out.flush();
        // } catch (Exception e) {
        // return;
        // }
    }
 
    static int upper_bound(ArrayList<Integer> arr, int key) {
        int mid, N = arr.size();
        int low = 0;
        int high = N;
        while (low < high && low != N) {
            mid = low + (high - low) / 2;
            if (key >= arr.get(mid)) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        return low;
    }
 
    static int lower_bound(ArrayList<Integer> array, int key) {
        int low = 0, high = array.size();
        int mid;
        while (low < high) {
            mid = low + (high - low) / 2;
            if (key <= array.get(mid)) {
                high = mid;
            } else {
 
                low = mid + 1;
            }
        }
        if (low < array.size() && array.get(low) < key) {
            low++;
        }
        return low;
    }
}