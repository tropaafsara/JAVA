import java.lang.annotation.Target;

public class RotatedArray {
    //Rotating an Array

    public static void leftRotate(int[] arr, int n, int d) {
        int ans[] = new int[n];
        for(int i=0;i<(n-d);i++) {
            ans[i]=arr[i+d];
        }
        for(int i=0;i<d;i++){
            ans[n-d+i]=arr[i];
        }
        for(int i=0;i<n;i++){
            System.out.print(ans[i]+" ");
        }   
    }
    //Rotate the array to the left
    public static void rotateArr(int arr[], int d, int n)
    {
        // add your code here
    }
    //Rotate the array to the right

    //153. Find Minimum in Rotated Sorted Array
    public static int findMin(int[] nums) {
        int n = nums.length;
        int low=0;
        int high = n-1;
        while(low<=high){
            int mid = low+(high-low)/2;
            if(nums[low]<=nums[high]){
                return nums[0];  
            }
            if(nums[mid]>nums[mid+1]){
                return nums[mid+1];
            }
            else if(nums[mid]<nums[mid-1]){ 
                return nums[mid];
            }
            else if(nums[mid]>=nums[low]){
                low = mid+1;
            }else if(nums[mid]<=nums[high]){ 
                high = mid-1;
            }
        }
        return -1;
    }
    //how many times the array is sorted
    public int findMin2(int[] arr) {
        int n = arr.length;
        int ans =0;
        int low=0;
        int high = n-1;
        if(arr[low]<=arr[high]){
            return arr[0];  
        }
        while(low<=high){
            int mid = low + (high - low) /2;
            
            if(mid-1>=0&&arr[mid]<arr[mid-1]){
                ans = arr[mid];
                break;
            }
            else if(arr[mid]>arr[high])
                low=mid+1;
            else 
                high=mid-1;
        }
        return ans;
    }
    //Search an Element in a Rotated Sorted Array
    public static int binarySearch(int[] arr,int val,int start, int end){
        while(start<=end){
            int mid = start+(end-start)/2;
            if(val==arr[mid]){
                return mid;
            }
            else if(val>arr[mid]){
                start = mid+1;
            }else if(val<arr[mid]){
                end = mid-1;
            }

        }
        return -1;
    }
    public static int search(int A[], int l, int h, int key)
    {
       int idx = findMin(A);
       int a = binarySearch(A, key,0,idx-1);
       int b = binarySearch(A, key,idx+1,A.length);
       if(a==-1 && b==-1){
        return -1;
       }else if(a==-1){
        return b;
       }else{
        return a;
       }
    }

    //Search an element in sorted and rotated array
    public static int Search(int arr[], int target)
	{
        int start=0;
        int end = arr.length-1;
        int ans = -1;
        while(start<=end){
            int mid = start+(end-start)/2;
            if(arr[mid]== target){
                ans = mid;
            }
            //left sorted
            if(arr[start]<=arr[mid]){
                if(arr[start]<=target && target<=arr[mid]){
                    end = mid-1;
                }else{
                    start = mid+1;
                }
            }else{//right sorted
                if(arr[mid]<=target && target<=arr[end]){
                    start = mid+1;
                }else{
                    end = mid-1;
                }
            }
        }
        return ans;
	}
    //Search an element in sorted and rotated array containing duplicate elements
    public static boolean Search2(int arr[], int target)
	{
        int start=0;
        int end = arr.length-1;
        while(start<=end){
            int mid = start+(end-start)/2;
            if(arr[mid]== target){
                return true;
            }
            //extra condition
            if(arr[start]==arr[mid] && arr[mid]==arr[end]){
                start++;
                end--;
                continue;
            }
            //left sorted
            if(arr[start]<=arr[mid]){
                if(arr[start]<=target && target<=arr[mid]){
                    end = mid-1;
                }else{
                    start = mid+1;
                }
            }else{//right sorted
                if(arr[mid]<=target && target<=arr[end]){
                    start = mid+1;
                }else{
                    end = mid-1;
                }
            }
        }
        return false;
	}
    //189. Rotate Array
    public static void reverse(int[] nums, int start,int end){
        while(start<end){
            int temp = nums[start];
            nums[start]= nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }
    public static void rotate(int[] nums, int k) {//O(n)
        k%=nums.length;
        reverse(nums,0,nums.length-1);
        reverse(nums,0,k-1);
        reverse(nums,k,nums.length-1);
    }

    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,7};
        rotate(arr, 3);
       

    }
}
