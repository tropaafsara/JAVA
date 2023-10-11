import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Parctice {
   public static int solve(String str1, String str2){
        int k = str2.length();
        HashMap<Character,Integer> hm = new HashMap<>();
        int i=0;
        int j = 0;
        int ans = 0;
        for(int l=0;l<str2.length();l++){
            hm.put(str2.charAt(l), hm.getOrDefault(str2.charAt(l), 0)+1);
        }
        int cnt = hm.size();
        while(j<str1.length()){
            if(hm.containsKey(str1.charAt(j))){
                int count = hm.get(str1.charAt(j));
                count-=1;
                hm.put(str1.charAt(i), count);
                if(count==0){
                    cnt--;
                }
            }
            if(j-i+1<k){
                j++;
            }else if(j-i+1==k){
                if(cnt==0){
                    ans++;
                }
                if(hm.containsKey(str1.charAt(i))){
                    int count = hm.get(str1.charAt(i));
                    count+=1;
                    hm.put(str1.charAt(i), count);
                    if(count==1){
                        cnt++;
                    }
                }
                i++;
                j++;
            }
        }
        return ans;
   }
    public static void main(String[] args) {
       String s = "forxxorfxdofr";
       System.out.println(solve(s,"for"));
    }
}
