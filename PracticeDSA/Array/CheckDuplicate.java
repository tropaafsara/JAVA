import java.util.*;
public class CheckDuplicate {
    public static boolean containsDuplicate(int[] nums) {
        
        //wrong
        // Arrays.sort(nums);
        // for(int i=0;i<nums.length;i++){
        //     if(nums[i]==nums[i+1]){
        //         return true;
        //     }
        // }
        // return false;


        //this is the ans
        Arrays.sort(nums);
        for (int i = 1; i <nums.length; i++) {
            if (nums[i] == nums[i - 1])
          
                return true;
        }
        return false;

        
    }


    public static void main(String[] args) {

        // int[] nums = {1,2,3,4};

        int[] nums = {1,2,3,1};
        System.out.println(containsDuplicate(nums));
        
    }
}
