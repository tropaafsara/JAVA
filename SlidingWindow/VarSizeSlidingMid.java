public class VarSizeSlidingMid {
    //2024. Maximize the Confusion of an Exam
    public static int helper(String s, int k, char ch){
        int i=0, j=0, ans=0, n = s.length();
        while(j<n){
            if(ch!=s.charAt(j)){
                k--;
            }
            while(k<0){
                if(ch==s.charAt(i)){
                    i++;
                }else{
                    k++;
                    i++;
                }
            }
            ans = Math.max(ans, j-i+1);
            j++;
        }
        return ans;
    }
    public static int maxConsecutiveAnswers(String answerKey, int k) {
        return Math.max(helper(answerKey, k, 'T'), helper(answerKey, k, 'F'));
    }

    //1493. Longest Subarray of 1's After Deleting One Element (String)
    public static int helper1(String s, int k, char ch){
        int i=0, j=0, ans=0, n = s.length();
        while(j<n){
            if(ch!=s.charAt(j)){
                k--;
            }
            while(k<0){
                if(ch==s.charAt(i)){
                    i++;
                }else{
                    k++;
                    i++;
                }
            }
            ans = Math.max(ans, j-i+1);
            j++;
        }
        return ans-1;
    }
    public static int longestSubarray(String s) {
        int ans = helper1(s, 1, '1');
        return ans;
    }
    //1493. Longest Subarray of 1's After Deleting One Element (Array)
    public static int helper2(int[] nums, int k, int a){
        int i=0, j=0, ans=0, n = nums.length;
        while(j<n){
            if(a!=nums[j]){
                k--;
            }
            while(k<0){
                if(a==nums[i]){
                    i++;
                }else{
                    k++;
                    i++;
                }
            }
            ans = Math.max(ans, j-i+1);
            j++;
        }
        return ans-1;
    }
    public static int longestSubarray2(int[] nums) {
        int ans = helper2(nums, 1, 1);
        return ans;
    }
    //1004. Max Consecutive Ones III
    public static int helper3(int[] nums, int k, int a){
        int i=0, j=0, ans=0, n = nums.length;
        while(j<n){
            if(a!=nums[j]){
                k--;
            }
            while(k<0){
                if(a==nums[i]){
                    i++;
                }else{
                    k++;
                    i++;
                }
            }
            ans = Math.max(ans, j-i+1);
            j++;
        }
        return ans;
    }
    public static int longestOnes(int[] nums, int k) {
        int ans = helper3(nums, k, 1);
        return ans;
    }
    public static void main(String[] args) {
        // String s = "TTFF";
        // int k=2;
        // System.out.println(maxConsecutiveAnswers(s, k));

        // String s = "011101101";
        // System.out.println(longestSubarray(s));

        // int[] nums = {1,1,1};
        // System.out.println(longestSubarray2(nums));


        int[] nums = {1,1,1,0,0,0,1,1,1,1,0};
        System.out.println(longestOnes(nums,2));
       
    }
}
