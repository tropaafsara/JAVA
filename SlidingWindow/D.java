import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Stack;

public class D {
   public static void solve(int[] arr, int k){
        for(int l = 0;l<arr.length;l++){
            arr[l] = arr[l]%2==0?0:1;
        }
        HashMap<Integer, Integer> hm = new HashMap<>();
        int ps = 0;
        int maxL = 0;
        for(int i=0;i<arr.length;i++){
            ps+=arr[i];
            hm.put(ps, hm.getOrDefault(ps, 0)+1);
            
            if(ps==k){
                maxL++;
            }
            if(hm.containsKey(ps-k)){
                maxL+=hm.get(ps-k);
            }
        }


        for (Map.Entry<Integer, Integer> entry : hm.entrySet()) {
        System.out.println("Key: " + entry.getKey() + ", Value: " + entry.getValue());
    }
        // return maxL;    
    }

    public static int solve9(String s){
        int i=0;
        int j= 0;
        int max = -1;
        HashMap<Character,Integer> hm = new HashMap<>();
        while(j<s.length()){
            hm.put(s.charAt(j), hm.getOrDefault(s.charAt(j), 0)+1);
            if(hm.size()==j-i+1){
                max = Math.max(max,j-i+1);
            }else if(hm.size()<j-i+1){
                while(hm.size()<j-i+1){
                    int count = hm.get(s.charAt(i));
                    hm.put(s.charAt(i), count-1);
                    if(hm.get(s.charAt(i))==0){
                        hm.remove(s.charAt(i));
                    }
                    i++;
                } 
            }
            j++;
        }
        return max;
    }
   
    public static int sovle10(String s, int k, char ch){
        int i = 0;
        int j =0;
        while(j<s.length()){
            if(s.charAt(j)!=ch){
                k--;
            }
            while(k<0){
                if(ch==s.charAt(i)){
                    i++;
                }else{
                    
                }
            }
            j++;
        }
    }
    public static void main(String[] args) {
        int[] arr = {1,1,2,1,1};
        // System.out.println(solve(arr, 3));
        // solve(arr, 3);
        String s = "abcabcbb";
        System.out.println(solve9(s));
    }
}
