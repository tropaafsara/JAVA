import java.util.HashMap;

public class VariableSizeWindow {
    // public static int lenOfSmallSubarr(int arr[], int k){
    //     int i=0;
    //     int j=0;
    //     int sum=0;
    //     int min =Integer.MAX_VALUE;
    //     while(j<arr.length){
    //         sum+=arr[j];
    //         while(sum>=k){
    //             min = Math.min(min,j-i+1);
    //             sum-=arr[i];
    //             i++;
    //         }
    //         j++;
    //     }
    //     return min == Integer.MAX_VALUE?0:min;
    // } 
    //for positive integers only & characters
    // public static int lenOfLongSubarr(int arr[], int k){
    //     int i=0;
    //     int j=0;
    //     int sum=0;
    //     int max =Integer.MIN_VALUE;
    //     while(j<arr.length){
    //         sum+=arr[j];
    //         if(sum==k){
    //             max = Math.max(max,j-i+1);
    //         }
    //         while(sum>k){
    //             sum-=arr[i];
    //             i++;
    //         }
    //         j++;
    //     }
    //     return max == Integer.MIN_VALUE?0:max;
    // } 



    //Longest subarray with sum k
    public static int lenOfLongSubarr(int arr[], int k){
        HashMap<Integer, Integer> map = new HashMap<>();
        int prefixSum=0;
        int maxLength=0;
        for(int i=0;i<arr.length;i++){
            prefixSum+=arr[i];

            if(prefixSum==k){
                maxLength=i+1;
            }
            if(map.containsKey(prefixSum-k)){
                int currentLength = i - map.get(prefixSum-k);
                 maxLength = Math.max(maxLength, currentLength);
            }
            map.put(prefixSum, map.getOrDefault(prefixSum, i));
        }
        return maxLength;
    }
    //1248. Count Number of Nice Subarrays
    public static int numberOfSubarrays(int[] arr, int k) {
        //odd =1, even =0, sum=k, variable size window
        for(int i=0;i<arr.length;i++){
            arr[i] = arr[i]%2 == 0 ?  0 : 1;
        }
        HashMap<Integer, Integer> hm = new HashMap<>();
        int ps= 0;
        int maxL=0;
        for(int i=0;i<arr.length;i++){
            ps+=arr[i];
            // hm.put(ps, hm.getOrDefault(ps, i));//val starts from 0
            hm.put(ps, hm.getOrDefault(ps, 0)+1);//val starts from 1
            if(ps==k){
                maxL++;
            }
            if(hm.containsKey(ps-k)){
                maxL+=hm.get(ps-k);
            }
        }
        return maxL;
    }
    

    // Longest subarray with sum divisible by K
    public static int longSubarrWthSumDivByK(int arr[], int k){
        HashMap<Integer, Integer> map = new HashMap<>();
        int prefixSum=0;
        int maxLength=0;
        
        for(int i=0;i<arr.length;i++){
            // prefixSum = (prefixSum+arr[i])%k;
            prefixSum+=arr[i];

            
            // int mod = ((prefixSum % k) + k) % k; // to handle negative test cases
            int mod = (prefixSum % k);

            if(mod==0){
                maxLength=i+1;
            }
            else if(!map.containsKey(mod)){
                map.put(mod,i);
            }else{
                int currentLength = i - map.get(mod);
                 maxLength = Math.max(maxLength, currentLength);
            }
        }
        return maxLength;

    }
    //974. count all Subarray Sums Divisible by K
    public static int longSubarrWthSumDivByK2(int arr[], int k){
        HashMap<Integer, Integer> map = new HashMap<>();
        int prefixSum=0;
        int count=0;
        
        for(int i=0;i<arr.length;i++){
            prefixSum+=arr[i];
            int mod = ((prefixSum % k) + k) % k; // to handle negative test cases
            // int mod = (prefixSum % k);
            if(mod==0){
                count++;
            }
            // if(mod<0){
            //     mod = mod+k;
            // }
            
            if(map.containsKey(mod)){
                count+=map.get(mod);
            }
            map.put(mod,map.getOrDefault(mod, 0)+1);
        }
        return count;
    }
    //Zero Sum Subarrays
    public static int zeroFilledSubarray(int arr[]){
        HashMap<Integer, Integer> map = new HashMap<>();
        int prefixSum=0;
        int count =0;
        
        for(int i=0;i<arr.length;i++){
            // prefixSum = (prefixSum+arr[i])%k;
            prefixSum = (prefixSum+arr[i]);

            if(prefixSum==0){
                count++;
            }
            // else if(!map.containsKey(prefixSum)){
            //     map.put(prefixSum,i);
            // }else{
            //     int currentLength = i - map.get(prefixSum);
            //     count++;
            // }

            if(map.containsKey(prefixSum)){
                count+=map.get(prefixSum);
            }
            map.put(prefixSum, map.getOrDefault(prefixSum, 0) + 1);
        }
        return count;

    }

    //Longest K unique characters substring
    public static int longestkSubstr(String s, int k) {
        int i=0;
        int j=0;
        HashMap<Character,Integer> map = new HashMap<>();
        int max = -1;
        while(j<s.length()){
            char ch = s.charAt(j);
            map.put(ch,map.getOrDefault(ch, 0)+1);
            if(map.size()<k){
                j++;
            }
            if(map.size()==k){
                max = Math.max(max, j-i+1);
                j++;
            }   
            else if(map.size()>k){
                while(map.size()>k){
                    Character ch2 = s.charAt(i);
                    map.put(ch2, map.get(ch2)-1);
                    if(map.get(ch2)==0){
                        map.remove(ch2);
                    }
                    i++;
                }
                j++;
            }
        }
        return max;
    }
    //3. Longest Substring Without Repeating Characters -> all unique characters
    public static int lengthOfLongestSubstring(String s) {
        int i=0, j=0;
        HashMap<Character,Integer> map = new HashMap<>();
        int max = -1;
        while(j<s.length()){
            char ch = s.charAt(j);
            map.put(ch,map.getOrDefault(ch, 0)+1);
            if(map.size()==j-i+1){
                max = Math.max(max, j-i+1);
            }   
            else if(map.size()<j-i+1){//duplicate exists
                while(map.size()<j-i+1){
                    Character ch2 = s.charAt(i);
                    map.put(ch2, map.get(ch2)-1);
                    if(map.get(ch2)==0){
                        map.remove(ch2);
                    }
                    i++;
                }
            }
            j++;
        }
        return max;
    }
    //459. Repeated Substring Pattern
    public static boolean repeatedSubstringPattern(String s) {
        HashMap<Character,Integer> hm = new HashMap<>();
        for(int i=s.length()/2;i>=0;i--){
            if(s.length()%i==0){
                String substr = s.substring(0, i);
                StringBuilder sb = new StringBuilder();
                for(int j=1;j<=s.length()/i;i++){
                    sb.append(substr);
                }
                if(sb.toString().equals(s)){
                    return true;
                }
            }
        }
        return false;
    }
    //5. Longest Palindromic Substring
    public static boolean isPalindrome(String str) {
        // Remove spaces and convert the string to lowercase
        str = str.replaceAll("\\s+", "").toLowerCase();
        int left = 0;
        int right = str.length() - 1;

        while (left < right) {
            if (str.charAt(left) != str.charAt(right)) {
                return false; // Not a palindrome
            }
            left++;
            right--;
        }

        return true; // It's a palindrome
    }
    public static String longestPalindrome(String s) {
        int i=0, j=0;
        StringBuilder sb = new StringBuilder();
        int max =0;
        while(j<s.length()){
            if(isPalindrome(s.substring(i, j))){
                sb.append(s.substring(i, j));
                max = Math.max(max, j-i+1);
            }
            j++;
        }
        return sb.toString();
    } 
    
   
    public static void main(String[] args) {
        System.out.println(longestPalindrome("babad"));
        // int arr[] = {10, 5, 2, 7, 1, 9};
        // int k = 15;
        // System.out.println(lenOfLongSubarr(arr, k));



        // int arr[] = {2, 7, 6, 1, 4, 5};
        // int k = 3;
        // System.out.println(longSubarrWthSumDivByK(arr, k));



        // int arr[] = {6,-1,-3,4,-2,2,4,6,-12,-7};
        // System.out.println(zeroFilledSubarray(arr));

        // String s = "aabacbebebe";
        // int K = 3;
        // System.out.println(longestkSubstr(s, K));

        // int[] nums ={2,2,2,1,2,2,1,2,2,2};
        // System.out.println(numberOfSubarrays(nums,  2));

        int[] nums = {4,5,0,-2,-3,1};
        // System.out.println(longSubarrWthSumDivByK2(nums, 5));

        // String s = "pwwkew";
        // System.out.println(lengthOfLongestSubstring(s));

        // String s = "ababba";
        // System.out.println(repeatedSubstringPattern(s));
    }
}
