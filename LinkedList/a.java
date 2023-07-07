import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class a {
    public static boolean palindrome(int n){
        int sum =0;
        int temp =n;
        if(n<0){
            return false;
        }
        if(n==0){
            return true;
        }
        while(n!=0){
            sum = (sum*10)+(n%10);
            n = n/10;
        }
        if(sum==temp){
            return true;
        }
        return false;
    }

    public static int[] twoSum(int[] nums, int target){
        HashMap<Integer,Integer> hm = new HashMap<>();
        for(int i=0;i<nums.length;i++){
            int diff = target-nums[i];
            if(hm.containsKey(diff)){
                return new int[] {hm.get(diff),i};
            }else{
                hm.put(nums[i], i);
            }  
        }
        return new int[] {-1, -1};
    }
    public static List<List<Integer>> threeSum(int[] nums){
        List<List<Integer>>  res = new ArrayList<>();
        Arrays.sort(nums);
        for(int i=0; i<nums.length-2;i++){
            if(i==0 || nums[i]!=nums[i-1]){
                int j=i+1;
            int k = nums.length-1;
            while(j<k){
                    int sum = nums[i]+nums[j]+nums[k];
                if(sum==0){
                    res.add(Arrays.asList(nums[i], nums[j], nums[k]));
                    while(j<k && nums[j]==nums[j+1]){
                        j++;
                    }
                    while(j<k && nums[k]==nums[k-1]){
                        k--;
                    }
                    j++;
                    k--;
                }
                else if(sum<0){
                    j++;
                }else{
                    k--;
                }
                }
            }
            
            
        }
        return res;
    }
    public static int divisor(int n1, int n2){
        List<Integer> res1 = new ArrayList<>();
        for(int i=1; i<=n1 && i<=n2;i++){
            if(n1%i==0 && n2%i==0){//common divisors
                res1.add(i);
            }
            
        }
        return res1.get(res1.size()-1);
    }
    public static void i(){
        int i=2;
        System.out.println(i++);
        System.out.println(i);
        System.out.println(++i);
        System.out.println(i);
    }
    //Find the Number Occurring Odd Number of Times
    public static int occurance(int[] arr){
        HashMap<Integer,Integer> hm = new HashMap<>();
        for(int i=0; i<arr.length;i++){
            hm.put(arr[i], hm.getOrDefault(arr[i], 0)+1);
        }
        //iterate through hashmap
        for (int num : hm.keySet()) {
            if(hm.get(num)%2!=0){
                return num;
            }
        }
        return -1;
    }
    public static void main(String[] args) {
        // int n = 1233211;
        // System.out.println(palindrome(n));
        // int[] nums = {2,7,11,15};
        // int target =9;
        // System.out.println(twoSum(nums, target));
        // int[] nums = {-1,0,1,2,-1,-4};
        // System.out.println(threeSum(nums));
        int n1 = 12;
        // int n2 = 33;
        // System.out.println(divisor(n1,n2));
        // i();
        int[] arr = {5, 7, 2, 7, 5, 2, 5};
        System.out.println(occurance(arr));
    }
}

