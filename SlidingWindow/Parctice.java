import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Parctice {
   public static int longk(String s, int k){
    HashMap<Character, Integer> hm = new HashMap<>();
    int i=0,j=0;
    int max =-1;
    while(j<s.length()){
        char ch = s.charAt(j);
        hm.put(ch, hm.getOrDefault(ch, 0)+1);
        if(hm.size()<k){
            j++;
        }
        else if(hm.size()==k){
            max = Math.max(max, j-i+1);
            j++;
        }else if(hm.size()>k){
            while(hm.size()>k){
                char ch2 = s.charAt(i);
                hm.put(ch2, hm.get(ch2)-1);
                if(hm.get(ch2)==0){
                    hm.remove(ch2);
                }
                i++;
            }
            j++;
        }
    }
    return max;
   }
    public static void main(String[] args) {
       String s = "aabacbebebe";
       int k=3;
       System.out.println(longk(s,k));
    }
}
