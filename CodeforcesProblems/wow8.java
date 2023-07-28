import java.util.*;
import java.util.concurrent.LinkedBlockingDeque;
//
//import org.graalvm.compiler.phases.graph.FixedNodeRelativeFrequencyCache;
 
import javax.print.DocFlavor.INPUT_STREAM;
import javax.print.attribute.HashAttributeSet;
 
import java.awt.Checkbox;
import java.io.*;
import java.math.*;
import java.sql.Array;
import java.sql.ResultSet;
 
 
public class Main {
 
    
     private static class MyScanner {
            private static final int BUF_SIZE = 2048;
            BufferedReader br;
     
            private MyScanner() {
                br = new BufferedReader(new InputStreamReader(System.in));
            }
     
            private boolean isSpace(char c) {
                return c == '\n' || c == '\r' || c == ' ';
            }
     
            String next() {
                try {
                    StringBuilder sb = new StringBuilder();
                    int r;
                    while ((r = br.read()) != -1 && isSpace((char)r));
                    if (r == -1) {
                        return null;
                    }
     
                    sb.append((char) r);
                    while ((r = br.read()) != -1 && !isSpace((char)r)) {
                        sb.append((char)r);
                    }
                    return sb.toString();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                return null;
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
        }
      static class Reader{
          
            BufferedReader br;
            StringTokenizer st;
            public Reader() {
                br = new BufferedReader(new InputStreamReader(System.in));
            }
            String next() 
            { 
                while (st == null || !st.hasMoreElements()) 
                { 
                    try
                    { 
                        st = new StringTokenizer(br.readLine()); 
                    } 
                    catch (IOException  e) 
                    { 
                        e.printStackTrace(); 
                    } 
                } 
                return st.nextToken(); 
            } 
 
            int nextInt() 
            { 
                return Integer.parseInt(next()); 
            } 
 
            long nextLong() 
            { 
                return Long.parseLong(next()); 
            } 
 
            double nextDouble() 
            { 
                return Double.parseDouble(next()); 
            } 
 
            String nextLine() 
            { 
                String str = ""; 
                try
                { 
                    str = br.readLine(); 
                } 
                catch (IOException e) 
                { 
                    e.printStackTrace(); 
                } 
                return str; 
            } 
        }
     
      static long mod = (long)(1e9 + 7);
     
    static void sort(long[] arr ) {
         ArrayList<Long> al = new ArrayList<>();
         for(long e:arr) al.add(e);
         Collections.sort(al);
         for(int i = 0 ; i<al.size(); i++) arr[i] = al.get(i);
     }
    static void sort(int[] arr ) {
         ArrayList<Integer> al = new ArrayList<>();
         for(int e:arr) al.add(e);
         Collections.sort(al);
         for(int i = 0 ; i<al.size(); i++) arr[i] = al.get(i);
     }
    
    static void sort(char[] arr) {
        ArrayList<Character> al = new ArrayList<Character>();
        for(char cc:arr) al.add(cc);
        Collections.sort(al);
        for(int i = 0 ;i<arr.length ;i++) arr[i] = al.get(i);
    }
 
    static long mod_mul(  long... a) {
        long ans = a[0]%mod;
        for(int i = 1 ; i<a.length ; i++) {
            ans = (ans * (a[i]%mod))%mod;
        }
        
        return ans;
    }
    static long mod_sum( long... a) {
        long ans = 0;
        for(long e:a) {
            ans = (ans + e)%mod;
        }
        return ans;
    }
     static long gcd(long a, long b)
      {      
         if (b == 0)
            return a;
         return gcd(b, a % b); 
      }
     static void print(long[] arr) {
         System.out.println("---print---");
         for(long e:arr) System.out.print(e+" ");
         System.out.println("-----------");
     }
     static void print(int[] arr) {
         System.out.println("---print---");
         for(long e:arr) System.out.print(e+" ");
         System.out.println("-----------");
     }
     static boolean[] prime(int num) {
            boolean[] bool = new boolean[num];
             
              for (int i = 0; i< bool.length; i++) {
                 bool[i] = true;
              }
              for (int i = 2; i< Math.sqrt(num); i++) {
                 if(bool[i] == true) {
                    for(int j = (i*i); j<num; j = j+i) {
                       bool[j] = false;
                    }
                 }
              }
              if(num >= 0) {
                  bool[0] = false;
                  bool[1] = false;
              }
              
              return bool;
        }
 
     static long modInverse(long a, long m)
        {
            long g = gcd(a, m);
           
              return   power(a, m - 2);
            
        }
       static long lcm(long a , long b) {
           return (a*b)/gcd(a, b);
       }
       static int lcm(int a , int b) {
           return (int)((a*b)/gcd(a, b));
       }
     static long power(long x, long y){
         if(y<0) return 0;
         long m = mod;
            if (y == 0) return 1; long p = power(x, y / 2) % m; p = (int)((p * (long)p) % m);
            if (y % 2 == 0) return p; else return (int)((x * (long)p) % m); }
       
     static class Combinations{
             private long[] z;  // factorial
             private long[] z1; // inverse factorial
             private long[] z2; // incerse number
             private long mod;
              public Combinations(long N , long mod) {
                  this.mod = mod;
                z = new long[(int)N+1];
                z1 = new long[(int)N+1];
                z[0] = 1;
                for(int i =1 ; i<=N ; i++) z[i] = (z[i-1]*i)%mod;
                 z2 = new long[(int)N+1];
                z2[0] = z2[1] = 1;
                for (int i = 2; i <= N; i++)
                    z2[i] = z2[(int)(mod % i)] * (mod - mod / i) % mod;
                
                
                z1[0] = z1[1] = 1;
                
                for (int i = 2; i <= N; i++)
                    z1[i] = (z2[i] * z1[i - 1]) % mod;
            }
              long fac(long n) {
                  return z[(int)n];
              }
              long invrsNum(long n) {
                  return z2[(int)n];
              }
              long invrsFac(long n) {
                  return z1[(int)n];
              }
              long ncr(long N, long R)
              {        if(R<0 || R>N ) return 0;
                    long ans = ((z[(int)N] * z1[(int)R])
                              % mod * z1[(int)(N - R)])
                             % mod;
                    return ans;
                }
          }
          static class DisjointUnionSets {
                int[] rank, parent;
                int n;
              
                public DisjointUnionSets(int n)
                {
                    rank = new int[n];
                    parent = new int[n];
                    this.n = n;
                    makeSet();
                }
              
                void makeSet()
                {
                    for (int i = 0; i < n; i++) {
                      
                        parent[i] = i;
                    }
                }
              
                int find(int x)
                {
                    if (parent[x] != x) {
                    
                        parent[x] = find(parent[x]);
              
                    }
              
                    return parent[x];
                }
              
                void union(int x, int y)
                {
                    int xRoot = find(x), yRoot = find(y);
              
                    if (xRoot == yRoot)
                        return;
              
                    if (rank[xRoot] < rank[yRoot])
              
                        parent[xRoot] = yRoot;
              
                    else if (rank[yRoot] < rank[xRoot])
              
                        parent[yRoot] = xRoot;
              
                    else
                    {
                        parent[yRoot] = xRoot;
              
                        rank[xRoot] = rank[xRoot] + 1;
                    }
                }
            }
          static int max(int... a ) {
              int max = a[0];
              for(int e:a) max = Math.max(max, e);
              return max;
          }
          static long max(long... a ) {
              long max = a[0];
              for(long e:a) max = Math.max(max, e);
              return max;
          }
          static int min(int... a ) {
              int min = a[0];
              for(int e:a) min = Math.min(e, min);
              return min;
          }
          static long min(long... a ) {
              long min = a[0];
              for(long e:a) min = Math.min(e, min);
              return min;
          }
          static int[] KMP(String str) {
              int n = str.length();
              int[] kmp = new int[n];
              for(int i = 1 ; i<n ; i++) {
                  int j = kmp[i-1];
                  while(j>0 && str.charAt(i) != str.charAt(j)) {
                      j = kmp[j-1];
                  }
                  if(str.charAt(i) == str.charAt(j)) j++;
                  kmp[i] = j;
              }
              
              return kmp;
          }
          
          
/************************************************ Query **************************************************************************************/      
     
/*****************************************         Sparse Table    ********************************************************/
          static class SparseTable{
                
                private long[][] st;
                
                SparseTable(long[] arr){
                    int n = arr.length;
                    st = new long[n][25];
                    log = new int[n+2];
                    build_log(n+1);
                    build(arr);
                }
                
                private void build(long[] arr) {
                    int n = arr.length;
                    
                    for(int i = n-1 ; i>=0 ; i--) {
                        for(int j = 0 ; j<25 ; j++) {
                            int r = i + (1<<j)-1;
                            if(r>=n) break;
                            if(j == 0 ) st[i][j] = arr[i];
                            else st[i][j] = min(st[i][j-1] , st[ i + ( 1 << (j-1) ) ][ j-1 ] );
                        }
                    }
                }
                public long gcd(long a  ,long b) {
                    if(a == 0) return b;
                    return gcd(b%a , a);
                }
                public long query(int l ,int r) {
                    int w = r-l+1;
                    int power = log[w];
                    return min(st[l][power],st[r - (1<<power) + 1][power]);
                }
                private int[] log;
                void build_log(int n) {
                    log[1] = 0;
                    for(int i = 2 ; i<=n ; i++) {
                        log[i] = 1 + log[i/2];
                    }
                }
            }
          
          
/********************************************************    Segement Tree    *****************************************************/
 
          static class SegmentTree{
             long[] tree;
             long[] arr;
             int n;
             SegmentTree(long[] arr){
                 this.n = arr.length;
                 tree = new long[4*n+1];
                 this.arr = arr;
                 buildTree(0, n-1, 1);
             }
             
             
              void buildTree(int s ,int e  ,int index ) {
                    if(s == e) {
                        tree[index] = arr[s];
                        return;
                    }
                
                    int mid = (s+e)/2;
                    
                    buildTree( s,  mid, 2*index);
                    buildTree( mid+1, e, 2*index+1);
                    
                    tree[index] = gcd(tree[2*index] , tree[2*index+1]);
                }
              
             long query(int si ,int ei) {
                 return query(0 ,n-1 , si ,ei , 1   );
             }
             private long query( int ss ,int se ,int qs , int qe,int index) {
                    
                    if(ss>=qs && se<=qe) return tree[index];
                    
                    if(qe<ss || se<qs) return (long)(0);
                    
                    int mid = (ss + se)/2;
                    long left = query( ss , mid , qs ,qe , 2*index);
                    long right= query(mid + 1 , se , qs ,qe , 2*index+1);
                    return min(left, right);
                }
             public void update(int index , int val) {
                 arr[index] = val;
                 update(index , 0 , n-1 , 1);
             }
             private void update(int id ,int si , int ei , int index) {
                 if(id < si || id>ei) return;
                 if(si == ei ) { 
                     tree[index] = arr[id];
                     return;
                 }
                 if(si > ei) return;
                 int mid = (ei + si)/2;
                    
                    update( id,  si, mid , 2*index);
                    update( id , mid+1, ei , 2*index+1);
                    
                    tree[index] = Math.min(tree[2*index] ,tree[2*index+1]);
             }
              
         }
         
 
/* ***************************************************************************************************************************************************/     
     
//          static MyScanner sc = new MyScanner(); // only in case of less memory
          static Reader sc = new Reader();
          static int TC;
     static StringBuilder sb = new StringBuilder();
     static  PrintWriter out=new PrintWriter(System.out);
     public static void main(String args[]) throws IOException {
 
         int tc = 1;
         tc = sc.nextInt();
        
         TC = 0;
         for(int i = 1 ; i<=tc ; i++) {
             TC++;
//           sb.append("Case #" + i + ": "  );    // During KickStart && HackerCup
             TEST_CASE();
              
         }
         System.out.print(sb);
     }
   
     static void TEST_CASE() {
    	int n = sc.nextInt();
    	int k = sc.nextInt();
    	char[] arr = sc.next().toCharArray();
    	int[] num = new int[n];
    	for(int i = 0 ; i<n ; i++) num[i] = arr[i]-'0';
    	int[] rightMostZero= new int[n];
    	int li = n;
    	for(int i = n-1 ; i>=0;i--) {
    		if(num[i] == 1) 
    			li = i;
    		rightMostZero[i] = li;
    	}
    	int[] leftOne = new int[n];
    	li = -1;
    	for(int i = 0 ; i<n ; i++) {
    		if(num[i] == 0)
    			li = i;
    		leftOne[i] = li;
    	}
//    	for(int e:rightMostZero) System.out.print(e+" ");
//    	System.out.println();
    	Map<Integer , Set<Integer>> map = new HashMap<Integer, Set<Integer>>();
    	while(k-->0) {
    		int a = sc.nextInt()-1;
    		int b = sc.nextInt()-1;
    		a = rightMostZero[a];
    		b = leftOne[b];
//    		System.out.println(a+" "+b);
    		if(b<=a) {
    			a = 0;
    			b = 0;
    		}
    		if(!map.containsKey(a)) map.put(a, new HashSet<>());
    		map.get(a).add(b);
    	}
    	int ans = 0;
    	for(int key:map.keySet()) {
    		ans += map.get(key).size();
    	}
    	sb.append(ans+"\n");
     }
 
}
/*******************************************************************************************************************************************************/
 
/** 
 2 3 2
 */
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 