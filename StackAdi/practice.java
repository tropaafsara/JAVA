import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;
import java.util.*;
public class practice {
    //almost equivalent strings
    public static boolean checkAlmostEquivalent(String word1, String word2) {
        Set<Character> set = new HashSet<>();
        HashMap<Character,Integer> hm1 = new HashMap<>();
        for(int i=0;i<word1.length();i++){
            char ch = word1.charAt(i);
            hm1.put(ch,hm1.getOrDefault(ch,0)+1);
            set.add(ch);
        }
        HashMap<Character,Integer> hm2 = new HashMap<>();
        for(int i=0;i<word2.length();i++){
            char ch = word2.charAt(i);
            hm2.put(ch,hm2.getOrDefault(ch,0)+1);
            set.add(ch);
        }
        for (char ch : set) {
            if(hm1.containsKey(ch) && hm2.containsKey(ch)){
                if(Math.abs(hm1.get(ch)-hm2.get(ch))>3){
                return false;
                }
            }else if(hm1.containsKey(ch)){
                if(hm1.get(ch)>3){
                    return false;
                }
            }else if(hm2.containsKey(ch)){
                if(hm2.get(ch)>3){
                    return false;
                }
            }
        }
        return true;
    }
    public static String[] func(String[] s, String[] t){
        String[] res = new String[2];
        for(int i=0;i<s.length;i++){
            if(s[i].length()==t[i].length() && checkAlmostEquivalent(s[i], t[i])==true){
                res[i] = "YES";
            }else{
                res[i] = "NO";
            }
        }
        return res;
    }
    //array reduction
    public static int solve2(int[] arr){
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i=0;i<arr.length;i++){
            pq.add(arr[i]);
        }
        int cost = 0;
        while(pq.size()>1){
            int a = pq.poll();
            int b = pq.poll();
            cost+=a+b;
            pq.add(a+b);
        }
        return cost;
    }
    //circular printer
    public static int getTime(String str) {
        int ans = 0;
        // Start from the first char
        int count = Math.abs(str.charAt(0) - 65); // Count original steps from char 'A' (Ascii = 65)
        if (count > 13) {
            ans += 26 % count;
        } else {
            ans += count;
        }

        for (int i = 1; i < str.length(); i++) {
            count = Math.abs(str.charAt(i) - str.charAt(i - 1));
            if (count > 13) {
                ans += 26 % count;
            } else {
                ans += count;
            }
        }

        return ans;
    }
    public static int solve10(String s){
        int ans = 0;
        int count = Math.abs(s.charAt(0)-65);//x to A
        if(count>13){
            ans+=26%count;
        }else{
            ans+=count;
        }
        for(int i=1;i<s.length();i++){
            count = Math.abs(s.charAt(i)-s.charAt(i-1));
            if(count>13){
                ans+=26%count;
            }else{
                ans+=count;
            }
        }
        return ans;
    }

    
    // String s = "abc!#e#lg#ek#!#f#s";
    // System.out.println(solve5(s));
    public static int solve5(String str){
        Stack<Character> s = new Stack<>();
        int count = 0;
        for(int i=0;i<str.length();i++){
            char ch = str.charAt(i);
            if(!s.isEmpty() && ch=='#' && Character.isAlphabetic(s.peek())){
                s.pop();
                if(s.peek()=='#'){
                    s.pop();
                    if(s.peek()=='!'){
                        s.pop();
                        count++;
                    }else{
                        continue;
                    }
                }else{
                    continue;
                }
            }else{
                s.push(ch);
            }
        }
        return count;
    }
    public static void main(String[] args) {
        String s = "abcdeef";
        String t = "abaaacc";

        // String[] s = {"aabaab","aaaaabb"};
        // String[] t = {"bbabbc","abb"};
        // String[] res = func(s, t);
        // for(int i=0;i<res.length;i++){
        //     System.out.print(res[i]+" ");
        // }

        // int[] arr = {1,2,3,4};
        // System.out.println(solve2(arr));

        // System.out.println(solve10("AZGB"));

        // int n = 12;
        // String s = Integer.toString(n);
        // char[] ch = s.toCharArray();
        // System.out.println(s);
        
        }


        

    }

