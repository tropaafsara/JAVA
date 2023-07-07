public class LongestSubWithNoRepeat {
    public static int lengthOfLongestSubstring(String s){
        int count[] = new int[256];
        int l = 0;
        int r = 0;
        int ans = 0;
        while(r<s.length()){
            count[s.charAt(r)]++;
            while(count[s.charAt(r)]>1){
                count[s.charAt(l)]--;
                l++;
            }
            ans = Math.max(ans,r-l+1);
            r++;

        }
        return ans;
    }
    public static void main(String[] args) {
        String s = "abcabcbb";
        System.out.println(lengthOfLongestSubstring(s));
    }
}
