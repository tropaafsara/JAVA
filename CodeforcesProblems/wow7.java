//c

import java.util.*;
 
// Treemap<Integer, Integer> map = new Treemap<>();
// get, put, for
 
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = 1;
        T = sc.nextInt();
//        Map<Integer, Integer> map = new TreeMap<>();
        for(int x = 0 ; x < T ; x++) {
            int n = sc.nextInt();
            int k = sc.nextInt();
            String s = sc.next();
 
//            System.out.println(s);
            int[] next = new int[n + 1];
            int[] prev = new int[n + 1];
            for(int i = 0 ; i <= n ; i++) {
                next[i] = n;
                prev[i] = 0;
            }
            for(int i = 0 ; i < n ; i++) if(s.charAt(i) == '0') {
                prev[i + 1] = i + 1;
            } else {
                prev[i + 1] = prev[i];
            }
 
            for(int i = n - 1 ; i >= 0 ; i--) if(s.charAt(i) == '1') {
                next[i] = i;
            } else {
                next[i] = next[i + 1];
            }
            TreeSet<String> map = new TreeSet<>();
            for(int i = 0 ; i < k ; i++) {
                int l = sc.nextInt(), r = sc.nextInt();
                l = next[l - 1];
                r = prev[r] - 1;
                if(l > r) {
                    l = 0;
                    r = 0;
                }
                map.add(l + " " + r);
            }
            System.out.println(map.size());
        }
    }