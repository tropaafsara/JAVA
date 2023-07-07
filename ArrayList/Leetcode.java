import java.util.*;;
public class Leetcode {
    public static boolean isMonotonic(int[] nums) {
        boolean inc = true;
        boolean dec = true;
        for(int i=0;i<nums.length-1;i++){
            if(nums[i]>nums[i+1]){
                inc = false;
            }
            if(nums[i]>nums[i+1]){
                dec = false;
            }
        }
        return inc || dec;
        
    }
    //find lonely number
    public static List<Integer> findLonely(int[] nums) {
        Arrays.sort(nums);
        List<Integer> ans=new ArrayList<>();
        for(int i=1;i<nums.length-1;i++){
            if((nums[i]!=nums[i+1]) && (nums[i]+1 !=nums[i+1])){
                ans.add(nums[i]);
            }
            
        }
        return ans;
    }

    public static int[] twoSum(int[] numbers, int target) {
        int lp=0;
         int rp= numbers.length-1;
 
         while(lp<rp){
           int sum =  numbers[lp]+numbers[rp];
           if(sum==target){
             break;
           }
           if(sum>target){
             rp--;
           }else{
             lp++;
           }
         }
         return new int[] {lp+1, rp+1};

        // int l = 0, r = numbers.length - 1;
	
	// while (numbers[l] + numbers[r] != target) {
	// 	if (numbers[l] + numbers[r] < target) l++;
	// 	else r--;
	// }

	// return new int[] {l+1, r+1};
    //  }
    }


    public static void main(String[] args) {
        // int[] nums ={1,2,2,3};       
        // System.out.println(isMonotonic(nums));

        // int[] nums ={1,3,5,3};
        // System.out.println(findLonely(nums));

        int[] nums ={2,7,11,15};
        System.out.println(twoSum(nums, 9));

    }
}