import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {
    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums.length == 0) {
            return new ArrayList<>();
        }
        Arrays.sort(nums);
        for(int i=0; i<nums.length-2;i++) {
            if(i==0 || nums[i]!=nums[i-1]){
                int j = i + 1;
                int k = nums.length - 1;
                while (j < k) {
                    int sum = nums[i] + nums[j] + nums[k];
                    if (sum == 0) {
                        res.add(Arrays.asList(nums[i], nums[j], nums[k]));
                        while(j<k && nums[j] == nums[j+1]){
                            j++;
                        }
                        while(j<k && nums[k] == nums[k-1]){
                            k--;
                        }
                        j++;
                        k--;
                        
                    } else if (sum > 0) {
                        k--;
                    } else {
                        j++;
                    }
                   
                }

            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = { -1, 0, 1, 2, -1, -4 };
        System.out.println(threeSum(nums));
    }
}
