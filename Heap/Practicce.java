import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.PriorityQueue;

public class Practicce {
    
    // public static String solve(String s ){
    //     //count occurances
    //     HashMap<Character, Integer> hm = new HashMap<>();
    //     for(int i=0;i<s.length();i++){
    //         char ch = s.charAt(i);
    //         hm.put(ch, hm.getOrDefault(ch, 0)+1);
    //     }
    //     //build maxheap
    //     PriorityQueue<Character> maxHeap = new PriorityQueue<>((a,b)->hm.get(b)-hm.get(a));
    //     //adding all elements
    //     maxHeap.addAll(hm.keySet());

    //     String ans = "";
        

    //     while(!maxHeap.isEmpty()){
    //         char ch2 = maxHeap.poll();
    //         int val2 = hm.get(ch2);
    //         if()
    //     }  
    //     return new String(c); 
    // }
    // public static String solve2(String s ){
    //     int max = 0;
    //     char maxChar = 'a';
    //     int[] freq = new int[26];
    //     for(int i=0;i<s.length();i++){
    //         char ch = s.charAt(i);
    //         freq[ch-'a']++;
    //         if(freq[ch-'a']>max){
    //             max = freq[ch-'a'];//character with max freq
    //             maxChar = ch;
    //         }
    //     }
    //     if(max>(s.length()+1)/2){
    //         return "";
    //     }
    // }
    public static boolean solve(String s1, String s2 ){
        int j=0;
        for(int i=0;i<s1.length();i++){
            int c1 = s1.charAt(i)-'a';
            int c2 = s2.charAt(j)-'a';
            if(c1==c2 || c2==(c1+1)%26){
                j++;
            }else{
                continue;
            }
        }
        return j==s2.length();
    }
    public static void main(String[] args) {
       String str1 = "abc";
       String str2 = "ad";
       System.out.println(solve(str1,str2));
       
    }
}
