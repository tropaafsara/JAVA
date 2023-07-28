public import java.io.*;
import java.util.*;
import java.awt.Point;
 
public class ProbB {
    static class Pair implements Comparable<Pair>{
        public int a, b;
        public Pair(int a, int b){
            this.a = a;
            this.b = b;
        }
        public int compareTo(Pair other){
            if(other.a == this.a){
                return this.b - other.b;
            }
            return other.a - this.a;
        }
    }
    static PrintWriter pw;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        pw = new PrintWriter(System.out);
        StringTokenizer st = new StringTokenizer(br.readLine());
        int T = Integer.parseInt(st.nextToken());
        while (T-- > 0) {
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            int[] a = new int[N];
            st = new StringTokenizer(br.readLine());
            String S = st.nextToken();
            for(int i = 0; i<S.length(); i++){
                if(S.charAt(i) == '1') a[i] = 1;
            }
            Pair[] inters = new Pair[M];
            TreeSet<Integer> l_one = new TreeSet<>();
            TreeSet<Integer>  r_zero = new TreeSet<>();
            for(int i = 0;i<M; i++){
                st = new StringTokenizer(br.readLine());
                int l = Integer.parseInt(st.nextToken()) - 1;
                int r = Integer.parseInt(st.nextToken()) - 1;
                inters[i] = new Pair(l , r);
 
            }
            for(int i = 0; i<N; i++){
                if(a[i] == 0) r_zero.add(i);
                else l_one.add(i);
            }
            boolean single = false;
            TreeSet<Pair> uni = new TreeSet<>();
            for(int i = 0; i<M; i++){
                //can we cut this interval?
                int new_l = inters[i].a;
                int new_r = inters[i].b;
                if(l_one.ceiling(inters[i].a) != null){
                    //make sure that l is greater than current
                    new_l = l_one.ceiling(inters[i].a);//cut interval here
                }else{
                    uni.add(new Pair(-1, -1));
                    continue;
                }
                if(r_zero.floor(inters[i].b) != null){
                    //make sure r is smaller
                    new_r = r_zero.floor(inters[i].b);//ncut interval here
                }else{
                    uni.add(new Pair(-1, -1));
                    continue;
                }
               // pw.println(new_l + " "+ new_r);
                if(new_l > new_r) {
                    uni.add(new Pair(-1, -1));
                    continue;
                }
                uni.add(new Pair(new_l, new_r));
            }
            int ans = uni.size();
            pw.println(ans);
        }
        pw.close();
    }
 
    static final Random random = new Random();
    static final int mod = 1_000_000_007;
 
    static void ruffleSort(int[] a) {
        int n = a.length;// shuffle, then sort
        for (int i = 0; i < n; i++) {
            int oi = random.nextInt(n), temp = a[oi];
            a[oi] = a[i];
            a[i] = temp;
        }
        Arrays.sort(a);
    }
 
    static long add(long a, long b) {
        return (a + b) % mod;
    }
 
    static long sub(long a, long b) {
        return ((a - b) % mod + mod) % mod;
    }
 
    static long mul(long a, long b) {
        return (a * b) % mod;
    }
 
    static long exp(long base, long exp) {
        if (exp == 0)
            return 1;
        long half = exp(base, exp / 2);
        if (exp % 2 == 0)
            return mul(half, half);
        return mul(half, mul(half, base));
    }
 
    static long[] factorials = new long[2_000_001];
    static long[] invFactorials = new long[2_000_001];
 
    static void precompFacts() {
        factorials[0] = invFactorials[0] = 1;
        for (int i = 1; i < factorials.length; i++)
            factorials[i] = mul(factorials[i - 1], i);
        invFactorials[factorials.length - 1] = exp(factorials[factorials.length - 1], mod - 2);
        for (int i = invFactorials.length - 2; i >= 0; i--)
            invFactorials[i] = mul(invFactorials[i + 1], i + 1);
    }
 
    static long nCk(int n, int k) {
        return mul(factorials[n], mul(invFactorials[k], invFactorials[n - k]));
    }
 
    static void sort(int[] a) {
        ArrayList<Integer> l = new ArrayList<>();
        for (int i : a)
            l.add(i);
        Collections.sort(l);
        for (int i = 0; i < a.length; i++)
            a[i] = l.get(i);
    }
 
    static class FastScanner {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer("");
 
        String next() {
            while (!st.hasMoreTokens())
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            return st.nextToken();
        }
 
        int nextInt() {
            return Integer.parseInt(next());
        }
 
        int[] readArray(int n) {
            int[] a = new int[n];
            for (int i = 0; i < n; i++)
                a[i] = nextInt();
            return a;
        }
 
        long nextLong() {
            return Long.parseLong(next());
        }
    }
 
} {
    
}
