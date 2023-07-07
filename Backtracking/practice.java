import java.util.*;
public class practice {
    //sortArrayByParity(int[] arr)
    
    public static int findDuplicate(int[] nums) {
        int n;
        for(int i=0;i<nums.length-1;i++){
            for(int j=i+1;j<nums.length;j++){
                if(nums[i]==nums[j]){
                    n = nums[i];
                }
            }
        }
        
    }

    public static void main(String[] args) {
        int[] nums = {1,3,4,2,2};
        System.out.println(findDuplicate(nums));    
    }
}
