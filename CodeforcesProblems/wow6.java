import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.io.*;
 
public class ccf{
 
 
 
 
    //functions to reduce time
 
    public static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
 
 
 
    public static int max=Integer.MAX_VALUE, min=Integer.MIN_VALUE;
    public static long maxl=Long.MAX_VALUE, minl=Long.MIN_VALUE;
    public static long mod=1000000007;
    public static void main(String[] swami) throws FileNotFoundException {
 
 
//
//        File file = new File("/home/swamikedari/Documents/IdeaProjects/cpContests/src/testcases.txt");
//
//        // Check if the file exists
//        if (file.exists() && !file.isDirectory()) {
//            br= new BufferedReader(new FileReader(file));
//        }
 
        int t=getint();
        while(t-->0) {
            int n=getint(), m=getint();
            String st=getstr();
            char[] ch=st.toCharArray();
            int[] ar=new int[n];
            int l=-1, r=n;
            for(int i=0;i<n;i++){
                if(ch[i]=='0'){
                    l=i;
                }
                ar[i]=l;
            }
 
            int[] ar1=new int[n];
            for(int i=n-1;i>-1;i--){
                if(ch[i]=='1'){
                    r=i;
                }
                ar1[i]=r;
            }
            HashSet<ArrayList<Integer> > set=new HashSet<>();
            boolean istrue=false;
 
            for(int i=0;i<m;i++){
                int indl=getint(), indr=getint();
                indl--; indr--;
                int val1=ar[indr], val=ar1[indl];
                if(val1>val && val1>indl && val<indr){
                    ArrayList<Integer> list=new ArrayList<>();
                    list.add(val);
                    list.add(val1);
                    set.add(list);
                }
                else{
                    istrue=true;
                }
            }
//            for(int[ a : set){
//                print(a);
//            }
 
            if(istrue){
                println(1+set.size());
            }
            else{
                println(set.size());
            }
 
 
        }
 
 
 
 
 
 
    }
 
    public static boolean cycle(HashMap<Character,Character> map,char val){
        char ch=map.get(val);
        while(ch!=val){
            if(!map.containsKey(ch)){
                return false;
            }
            else{
                ch=map.get(ch);
            }
        }
        return true;
    }
 
    public static long dfs(ArrayList<ArrayList<Integer>> ar,int i,int tk,boolean[] vis,long[][] a,long[][] dp,boolean[][] v){
        vis[i]=true;
        long ans1=0, ans2=0;
        if(v[i][tk]){
            return dp[i][tk];
        }
        for(int k: ar.get(i)){
            if(!vis[k]){
                ans1+=Math.max(dfs(ar,k,0,vis,a,dp,v)+Math.abs(a[k][0]-a[i][tk]), dfs(ar,k,1,vis,a,dp,v)+Math.abs(a[k][1]-a[i][tk]));
            }
        }
        v[i][tk]=true;
        vis[i]=false;
        return dp[i][tk]=ans1;
    }
 
 
 
    // Assumed int size
    static final int INT_SIZE = 32;
 
    // A Trie Node
    static class TrieNode
    {
        int value;  // Only used in leaf nodes
        TrieNode[] arr =  new TrieNode[2];
        public TrieNode() {
            value = 0;
            arr[0] = null;
            arr[1] = null;
        }
    }
    static TrieNode root;
 
    // Inserts pre_xor to trie with given root
    static void insert(int pre_xor)
    {
        TrieNode temp = root;
 
        // Start from the msb, insert all bits of
        // pre_xor into Trie
        for (int i=INT_SIZE-1; i>=0; i--)
        {
            // Find current bit in given prefix
            int val = (pre_xor & (1<<i)) >=1 ? 1 : 0;
 
            // Create a new node if needed
            if (temp.arr[val] == null)
                temp.arr[val] = new TrieNode();
 
            temp = temp.arr[val];
        }
 
        // Store value at leaf node
        temp.value = pre_xor;
    }
 
    // Finds the maximum XOR ending with last number in
    // prefix XOR 'pre_xor' and returns the XOR of this
    // maximum with pre_xor which is maximum XOR ending
    // with last element of pre_xor.
    static int query(int pre_xor)
    {
        TrieNode temp = root;
        for (int i=INT_SIZE-1; i>=0; i--)
        {
            // Find current bit in given prefix
            int val = (pre_xor & (1<<i)) >= 1 ? 1 : 0;
 
            // Traverse Trie, first look for a
            // prefix that has opposite bit
            if (temp.arr[1-val] != null)
                temp = temp.arr[1-val];
 
                // If there is no prefix with opposite
                // bit, then look for same bit.
            else if (temp.arr[val] != null)
                temp = temp.arr[val];
        }
        return pre_xor^(temp.value);
    }
 
    // Returns maximum XOR value of a subarray in
    // arr[0..n-1]
    static int maxSubarrayXOR(int arr[], int n)
    {
        // Create a Trie and insert 0 into it
        root = new TrieNode();
        insert(0);
 
        // Initialize answer and xor of current prefix
        int result = Integer.MIN_VALUE;
        int pre_xor =0;
 
        // Traverse all input array element
        for (int i=0; i<n; i++)
        {
            // update current prefix xor and insert it
            // into Trie
            pre_xor = pre_xor^arr[i];
            insert(pre_xor);
 
            // Query for current prefix xor in Trie and
            // update result if required
            result = Math.max(result, query(pre_xor));
 
        }
        return result;
    }
 
    public static long getmin(long[] a,int i,int j,long[][] dp,boolean[][] vis){
        if(i>=j){
            return 0;
        }
        if(vis[i][j]){
            return dp[i][j];
        }
        long  val1=a[j]-a[i];
        vis[i][j]=true;
        dp[i][j]=Math.min(val1+getmin(a,i+1,j,dp,vis),val1+getmin(a,i,j-1,dp,vis));
 
        return dp[i][j];
    }
    public static void dfs(ArrayList<ArrayList<Integer>> ar,int i,int[] ans,boolean[] vis,HashMap<Integer,Integer> map){
        if(!vis[i]){
            vis[i]=true;
            boolean istrue=false;
            for(int k: ar.get(i)){
                if(!vis[k] && map.get(k)<map.get(i)){
                    istrue=true;
                }
                dfs(ar,k,ans,vis,map);
            }
 
            if(istrue){
                ans[0]++;
            }
        }
    }
 
 
 
 
    static StringTokenizer st=new StringTokenizer("");
    static String next() {
        while (!st.hasMoreTokens())
            try {
                st=new StringTokenizer(br.readLine());
            } catch (IOException e) {
                e.printStackTrace();
            }
        return st.nextToken();
    }
 
 
 
 
    public static int[] getarr(int n){
        int[] a=new int[n];
        for(int i=0;i<n;i++){
            a[i]=getint();
        }
        return a;
    }
 
    public static long[] getarrl(int n){
        long[] a=new long[n];
        for(int i=0;i<n;i++){
            a[i]=getlong();
        }
        return a;
    }
    public  static int getint(){
        return Integer.parseInt(next());
    }
 
    public  static long getlong(){
        return Long.parseLong(next());
    }
 
    public static String getstr(){
        return next();
    }
 
    // print statements
 
    public static void println(int i){
        System.out.println(i);
    }
    public static void println(String k){
        System.out.println(k);
    }
 
    public static void println(long k){
        System.out.println(k);
    }
    public static void println(float k){
        System.out.println(k);
    }
    public static void println(char k){
        System.out.println(k);
    }
    public static void println(double k){System.out.println(k); }
    public static void println(){System.out.println();}
    public static void println(int[] a){
        System.out.println(Arrays.toString(a));
    }
    public static void println(long[] a){
        System.out.println(Arrays.toString(a));
    }
    public static void println(char[] a){
        System.out.println(Arrays.toString(a));
    }
    public static void println(float[] a){
        System.out.println(Arrays.toString(a));
    }
    public static void println(double[] a){
        System.out.println(Arrays.toString(a));
    }
    public static void print(int[] A) {
        for(int i : A) {
            System.out.print(i+" ");
        }
        System.out.println();
    }
    public static void print(long[] A) {
        for(long i : A) {
            System.out.print(i+" ");
        }
        System.out.println();
    }
 
    public static void print(int i){
        System.out.print(i);
    }
    public static void print(String k){
        System.out.print(k);
    }
    public static void print(double k){System.out.print(k); }
    public static void print(long k){
        System.out.print(k);
    }
    public static void print(float k){
        System.out.print(k);
    }
    public static void print(char k){
        System.out.print(k);
    }
 
 
    // mod by the number
    static long mod(long x) {
        return ((x%mod + mod)%mod);
    }
 
    // gcd
    public static long gcd(long i,long j){
        if(i==0){
            return j;
        }
        return gcd(j%i,i);
    }
 
    // lcm
    public static long lcm(long i,long j){
        return i*j/gcd(i,j);
    }
 
 
    public static int gcd(int i,int j){
        if(i==0){
            return j;
        }
        return gcd(j%i,i);
    }
 
    // lcm
    public static int lcm(int i,int j){
        return i*j/gcd(i,j);
    }
 
    // quick sort
 
    public static void quicksort(int[] a,int l,int h){
        if(l<h){
            int pivot=partition(a,l,h);
            quicksort(a,l,pivot-1);
            quicksort(a,pivot+1,h);
        }
    }
 
    public static int partition(int[] a,int l,int h){
        int i=l-1;
        int piv=a[h];
        for(int j=l;j<h;j++){
            if(a[j]<piv){
                i++;
                swap(a,i,j);
            }
        }
        swap(a,i+1,h);
        return i+1;
    }
 
    public static void quicksortrev(int[] a,int l,int h){
        if(l<h){
            int pivot=partitionrev(a,l,h);
            quicksortrev(a,l,pivot-1);
            quicksortrev(a,pivot+1,h);
        }
    }
 
    public static int partitionrev(int[] a,int l,int h){
        int i=l-1;
        int piv=a[h];
        for(int j=l;j<h;j++){
            if(a[j]>piv){
                i++;
                swap(a,i,j);
            }
        }
        swap(a,i+1,h);
        return i+1;
    }
 
    public static void swap(int[] a,int i,int j){
        int temp=a[i];
        a[i]=a[j];
        a[j]=temp;
 
    }
 
 
 
    // binarysearch for the input and between the input
 
    public static int bs(int[] a,int i,int j,int k,int n){
        if(i<=j){
            int mid=mid(i,j);
            if(mid+1<n && a[mid]<=k && a[mid+1]>k){
                return mid;
            }
            else if(a[mid]<=k && mid==n-1){
                return mid;
            }
            else if(a[mid]>k && mid==0){
                return mid;
            }
            else if(a[mid]<k){
                return  bs(a,mid+1,j,k,n);
            }
            else{
                return bs(a,i,mid-1,k,n);
            }
        }
        return -1;
    }
 
    public static int mid(int i,int j){
        return (i+j)/2;
    }
 
    public static int bs(long[] a,int i,int j,long  k,int n){
        if(i<=j){
            int mid=mid(i,j);
            if(mid+1<n && a[mid]<=k && a[mid+1]>k){
                return mid;
            }
            else if(a[mid]<=k && mid==n-1){
                return mid;
            }
            else if(a[mid]<k){
                return  bs(a,mid+1,j,k,n);
            }
            else{
                return bs(a,i,mid-1,k,n);
            }
        }
        return -1;
    }
 
    public static long mid(long i,long j){
        return (i+j)/2;
    }
 
    // converting the int value to the char value and vice versa
    public static int toint(char a){
        return (int)a-48;
    }
 
    public static int tochar(int a){
        return (char)(a+48);
    }
 
    // converting the small alphabet characters to index and vice-versa
    public static int chartoint(char a){
        return (int)a-97;
    }
 
    public static char inttochar(int a){
        return (char)(a+97);
    }
 
 
    // important dp problems memoization solutions
 
    public static int lcs(String a,String b,int i,int j,int[][] dp){
        if(i<0 || j<0){
            return 0;
        }
        if(dp[i][j]>0){
            return dp[i][j];
        }
        if(a.charAt(i)==b.charAt(j)){
            return dp[i][j]=lcs(a,b,i-1,j-1,dp)+1;
        }
        else{
            return dp[i][j]=Math.max(lcs(a,b,i-1,j,dp),lcs(a,b,i,j-1,dp));
        }
    }
 
    // power functions
 
    public static long pow(long a,long b){
        long ans=1;
        while(b!=0){
            if(b%2==1){
                ans=(ans*a)%1000000007;
            }
            a=a*a;
            a=a%1000000007;
            b/=2;
        }
        return ans;
    }
 
 
    // min and max functions
 
    public static int max(int a, int b){
        return Math.max(a, b);
    }
 
    public static int min(int a, int b){
        return Math.min(a, b);
    }
 
 
    static int max(int[] A) {
        int max=Integer.MIN_VALUE;
        for (int j : A) {
            max = Math.max(max, j);
        }
        return max;
    }
    static int min(int[] A) {
        int min=Integer.MAX_VALUE;
        for (int j : A) {
            min = Math.min(min, j);
        }
        return min;
    }
    static long max(long[] A) {
        long max=Long.MIN_VALUE;
        for (long l : A) {
            max = Math.max(max, l);
        }
        return max;
    }
    static long min(long[] A) {
        long min=Long.MAX_VALUE;
        for (long l : A) {
            min = Math.min(min, l);
        }
        return min;
    }
 
    // prime numbers related functions
    public static ArrayList<Integer> sieveOfEratosthenes(int n)
    {
        ArrayList<Integer> primes = new ArrayList<>();
        boolean[] prime = new boolean[n+1];
        for(int i=0;i<=n;i++)
            prime[i] = true;
 
        for(int p = 2; p*p <=n; p++)
        {
 
            if(prime[p])
            {
 
                for(int i = p*p; i <= n; i += p)
                    prime[i] = false;
            }
        }
 
 
        for(int i = 2; i <= n; i++)
        {
            if(prime[i])
                primes.add(i);
        }
        return primes;
    }
 
 
    // prefix sum arrays and suffix sum array
 
    public static long [] prefix(long [] A) {
        long[] p=new long[A.length];
        p[0]=A[0];
        for(int i=1;i<A.length;i++)
            p[i]=p[i-1]+A[i];
        return p;
    }
    public static long [] prefix(int [] A) {
        long[] p=new long[A.length];
        p[0]=A[0];
        for(int i=1;i<A.length;i++)
            p[i]=p[i-1]+A[i];
        return p;
    }
    public static long [] suffix(long [] A) {
        long[] p=new long[A.length];
        p[A.length-1]=A[A.length-1];
        for(int i=A.length-2;i>=0;i--)
            p[i]=p[i+1]+A[i];
        return p;
    }
    public static long [] suffix(int [] A) {
        long[] p=new long[A.length];
        p[A.length-1]=A[A.length-1];
        for(int i=A.length-2;i>=0;i--)
            p[i]=p[i+1]+A[i];
        return p;
    }
 
 
    // hash map direct storage using the arrays
 
    public static HashMap<Long,Long> hash(long [] A){
        HashMap<Long,Long> map=new HashMap<Long, Long>();
        for(long i : A) {
            if(map.containsKey(i)) {
                map.put(i, map.get(i)+(long)1);
            }
            else {
                map.put(i, (long)1);
            }
        }
        return map;
    }
 
    public static HashMap<Integer,Long> hash(int[] A){
        HashMap<Integer,Long> map=new HashMap<Integer, Long>();
        for(int i : A) {
            if(map.containsKey(i)) {
                map.put(i, map.get(i)+(long)1);
            }
            else {
                map.put(i, (long)1);
            }
        }
        return map;
    }
 
 
    public static HashMap<Character,Long> hash(char [] A){
        HashMap<Character,Long> map=new HashMap<Character,Long>();
        for(char i : A) {
            if(map.containsKey(i)) {
                map.put(i, map.get(i)+(long)1);
            }
            else {
                map.put(i, (long)1);
            }
        }
        return map;
    }
 
    // segment tree implementation
    public static int[] array=new int[100005];
    public static int[] segarray=new int[4*100005];
 
    public static void buildmax(int ind,int low,int high){
        int mid=mid(low,high);
        if(low==high){
            segarray[ind]=array[low];
        }
        buildmax(2*ind+1,low,mid);
        buildmax(2*ind+2,mid+1,high);
        segarray[ind]=max(array[2*ind+1],array[2*ind+2]);
 
    }
 
    public static int querymax(int ind,int low,int high,int l,int r){
        if(low>=l && high<=r){
            return segarray[ind];
        }
        if(high<l || low>r){
            return min;
        }
        int mid=mid(low,high);
        int left=querymax(2*ind+1,low,mid,l,r);
        int right=querymax(2*ind+2,mid+1,high,l,r);
        return max(left,right);
    }
 
 
    public static void buildsum(int ind,int low,int high){
        int mid=mid(low,high);
        if(low==high){
            segarray[ind]=array[low];
        }
        buildsum(2*ind+1,low,high);
        buildsum(2*ind+2,low,high);
        segarray[ind]=segarray[2*ind+1]+segarray[2*ind+2];
    }
 
    public static int querysum(int ind,int low,int high,int l,int r){
        if (low >= l && high <= r) {
            return segarray[ind];
        }
        if(high<l || low>r){
            return 0;
        }
        int mid=mid(low,high);
        int left=querysum(2*ind+1,low,mid,l,r);
        int right=querysum(2*ind+2,mid+1,high,l,r);
        return left+right;
 
    }
 
 
 
 
 
 
 
 
 
}
