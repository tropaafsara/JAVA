import java.util.HashMap;

public class MediumLeetCode {
    //1876. Substrings of Size Three with Distinct Characters => (similar to Count anagrams)
    public static int countGoodSubstrings(String str) {
        int k=3;
        int i=0;
        int j=0;
        int ans=0;
        
        HashMap<Character, Integer> hm = new HashMap<>();
        while(j<str.length()){
            hm.put(str.charAt(j), hm.getOrDefault(str.charAt(j), 0)+1);
            if(j-i+1<k){
                j++;
            }else{
                if(hm.size() == 3){
                    ans++;
                }
                hm.put(str.charAt(i), hm.get(str.charAt(i))-1);
                if(hm.get(str.charAt(i))==0){
                    hm.remove(str.charAt(i));
                }
                i++;
                j++;
            }
          
        }
        return ans;
    }
    public static void main(String[] args) {
        String s = "owuxoelszb";
        int a = countGoodSubstrings(s);
        System.out.println(a);
    }
}
