//leetcode 33 no. problem   
public class Practice {
    public static int search(int[] nums, int target){
        int ans = searchArray(nums, target, 0, nums.length-1);
        return ans;
    }
    public static int searchArray(int arr[], int target,int si,int ei){
        

        if(si>ei){
            return -1;
        }

        int mid = si+(ei-si)/2;
        if(arr[mid]==target){
            return mid;
        }
        
        if(arr[si]<=arr[mid]){
            if(arr[si]<=target && target<=arr[mid]){
                return searchArray(arr, target, si, mid-1);
            }else{
                return searchArray(arr, target, mid+1, ei);
            }
        }else{
            if(arr[mid]<=target && target<=arr[ei]){
                return searchArray(arr, target, mid+1, ei);
            }else{
                return searchArray(arr, target, si, mid-1);
            }
        }
    }
    public static void main(String[] args) {
        int[] nums = {4,5,6,7,0,1,2};
        int target = 3; 
        System.out.println(search(nums, target));
        
    }
}
