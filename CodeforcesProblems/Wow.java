import com.sun.source.tree.Tree;
 
import java.util.*;
import java.lang.*;
import java.io.*;
 
public class C {
    public static void main(String[] args) throws IOException {
        FastReader s = new FastReader();
        PrintWriter out = new PrintWriter(System.out);
        int t = s.nextInt();
        outer: while (t-- > 0) {
            int n = s.nextInt(), m = s.nextInt();
            char[] arr = s.nextArrayChar();
            TreeSet<Integer> zeroes = new TreeSet<>();
            TreeSet<Integer> ones = new TreeSet<>();
            for(int i = 0; i < n; i++){
                if(arr[i] == '0'){
                    zeroes.add(i);
                }
                else{
                    ones.add(i);
                }
            }
            ones.add(n);
            zeroes.add(0);
            HashSet<String> pairs = new HashSet<>();
            for(int i = 0; i < m; i++){
                int x = s.nextInt()-1, y = s.nextInt()-1;
                x = ones.ceiling(x);
                y = zeroes.floor(y);
                if(y <= x){
                    pairs.add(n + " " + n);
                }
                else{
                    pairs.add(x + " " + y);
                }
            }
            out.println(pairs.size());
        }
        out.flush();
    }
 
    public static class Pair<T, E> {
        T p1;
        E p2;
        Pair(T a, E b) {
            this.p1 = a;
            this.p2 = b;
        }
        void setValue(T a, E b) {
            this.p1 = a;
            this.p2 = b;
        }
 
        void setA(T a){
            this.p1 = a;
        }
        void setB(E b){
            this.p2 = b;
        }
        Pair getValue() {
            return this;
        }
        @Override
        public int hashCode() {
            return Objects.hash(p1, p2);
        }
 
        @Override
        public boolean equals(Object startObject) {
            if(this == startObject){
                return true;
            }
            if(startObject == null || getClass() != startObject.getClass()){
                return false;
            }
            Pair<T, E> pair = (Pair<T, E>) startObject;
            return p1.equals(pair.p1) && p2.equals(pair.p2);
        }
    }
 
    private static long lcm(long a, long b) {
        return a * (b / gcd(a, b));
    }
    private static long gcd(long a, long b) {
        while (b > 0)
        {
            long temp = b;
            b = a % b; // % is remainder
            a = temp;
        }
        return a;
    }
    private static int lcm(int a, int b) {
        return a * (b / gcd(a, b));
    }
    private static int gcd(int a, int b) {
        while (b > 0)
        {
            int temp = b;
            b = a % b; // % is remainder
            a = temp;
        }
        return a;
    }
 
    public static class FastReader {
        BufferedReader br;
        StringTokenizer st;
 
        public FastReader() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }
 
        public String next() throws IOException {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }
 
        int nextInt() throws IOException {
            return Integer.parseInt(next());
        }
 
        long nextLong() throws IOException {
            return Long.parseLong(next());
        }
 
        double nextDouble() throws IOException {
            return Double.parseDouble(next());
        }
 
        String nextLine() throws IOException {
            String str = "";
            if (st != null && st.hasMoreTokens()) {
                str = st.nextToken("\n");
            } else {
                str = br.readLine();
            }
            return str;
        }
 
        int[] nextArrayInt(int n) throws IOException {
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = nextInt();
            }
            return arr;
        }
 
        long[] nextArrayLong(int n) throws IOException {
            long[] arr = new long[n];
            for (int i = 0; i < n; i++) {
                arr[i] = nextLong();
            }
            return arr;
        }
 
        double[] nextArrayDouble(int n) throws IOException {
            double[] arr = new double[n];
            for (int i = 0; i < n; i++) {
                arr[i] = nextDouble();
            }
            return arr;
        }
 
        String[] nextArrayString(int n) throws IOException {
            String[] arr = new String[n];
            for (int i = 0; i < n; i++) {
                arr[i] = next();
            }
            return arr;
        }
 
        char[] nextArrayChar() throws IOException {
            return next().toCharArray();
        }
 
        static void shuffleArray(int[] ar){
            Random rnd = new Random();
            for (int i = ar.length - 1; i > 0; i--)
            {
                int index = rnd.nextInt(i + 1);
                int a = ar[index];
                ar[index] = ar[i];
                ar[i] = a;
            }
        }
 
        static void shuffleArray(long[] ar){
            Random rnd = new Random();
            for (int i = ar.length - 1; i > 0; i--)
            {
                int index = rnd.nextInt(i + 1);
                long a = ar[index];
                ar[index] = ar[i];
                ar[i] = a;
            }
        }
 
        public int[] nextSortedArrayInt(int n) throws IOException {
            int[] arr = nextArrayInt(n);
            shuffleArray(arr);
            Arrays.sort(arr);
            return arr;
        }
 
        public long[] nextSortedArrayLong(int n) throws IOException {
            long[] arr = nextArrayLong(n);
            shuffleArray(arr);
            Arrays.sort(arr);
            return arr;
        }
    }
}