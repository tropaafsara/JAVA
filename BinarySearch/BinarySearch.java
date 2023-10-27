import java.util.ArrayList;
import java.util.Arrays;

public class BinarySearch {
    public static int binarySearch(int[] arr,int val){
        int start =0;
        int end =arr.length-1;
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
    //34. Find First and Last Position of Element in Sorted Array
    public static int first(int[] arr,int val){
        int start =0;
        int end =arr.length-1;
        int ans =-1;
        while(start<=end){
            int mid = start+(end-start)/2;
            if(val==arr[mid]){
                ans = mid;
                end = mid-1;
            }
            else if(val>arr[mid]){
                start = mid+1;
            }else if(val<arr[mid]){
                end = mid-1;
            }

        }
        return ans;
    }
    public static int last(int[] arr,int val){
        int start =0;
        int end =arr.length-1;
        int ans =-1;
        while(start<=end){
            int mid = start+(end-start)/2;
            if(val==arr[mid]){
                ans = mid;
                start = mid+1;
            }
            else if(val>arr[mid]){
                start = mid+1;
            }else if(val<arr[mid]){
                end = mid-1;
            }

        }
        return ans;
    }
    public static int[] searchRange(int[] nums, int target) {
        // return new int[]{first(nums, target),last(nums, target)};

        //or
        int[] result = new int[2];
       result[0] = first(nums, target);
       result[1]  = last(nums,target);
       return result;

       //or
       //https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/solutions/3950949/simple-java-solution-beats-100-with-java-beginner-friendly-beats-99-67-in-memory/
    }
    //2nd approach
    public static int find(int[] arr,int val,boolean flag){
        int start =0;
        int end =arr.length-1;
        int ans =-1;
        while(start<=end){
            int mid = start+(end-start)/2;
            if(val==arr[mid]){
                ans = mid;
                if(flag){
                    end = mid-1;
                }else{
                    start = mid+1;
                } 
            }
            else if(val>arr[mid]){
                start = mid+1;
            }else if(val<arr[mid]){
                end = mid-1;
            }
        }
        return ans;
    }
    public static int[] searchRange2(int[] nums, int target) {
        return new int[]{find(nums, target,true),find(nums, target,false)};
        
    }
    public static ArrayList<Integer>  searchRange3(int[] nums, int target) {
        return new ArrayList<>(Arrays.asList(find(nums, target,true),find(nums, target,false)));
    }
    //COUNT Number of occurrence
    public static int count(int[] nums, int target) {
        int first = find(nums, target,true);
        int last = find(nums, target,false);
        return last-first+1;
        
    }
    //Floor in a Sorted Array
    public static int floor(int[] arr,int val){
        int start =0;
        int end =arr.length-1;
        int res =-1;
        while(start<=end){
            int mid = start+(end-start)/2;
            if(val==arr[mid]){
                return mid;
            }
            else if(val>arr[mid]){
                res = mid;
                start = mid+1;
            }else if(val<arr[mid]){
                end = mid-1;
            }

        }
        return res;
    }
    //744. Find Smallest Letter Greater Than Target
    public static char ceil(char[] arr, char val){
        int start =0;
        int end =arr.length-1;
        char res =arr[0];
        while(start<=end){
            int mid = start+(end-start)/2;
            if(val==arr[mid] && arr[mid+1]<=end ){
                return arr[mid+1];
            }
            else if(val>arr[mid]){
                start = mid+1;
            }else if(val<arr[mid]){
                res= arr[mid];
                end = mid-1;
            }
        }
        return res;
    }
    //Find the Rotation Count in Rotated Sorted array
    /* For right/clockwise rotation idx number will be no. of rotation */
    public static int solve(int arr[]){
        int start =0;
        int end = arr.length;
        if(arr[0]<arr[end]){
            return 0;
        }
        while(start<=end){
            int mid = start+(end-start)/2;
            if(mid-1 >=0 && arr[mid]<arr[mid-1]){
                return mid;
            }
            else if(arr[mid]>arr[end]){
                start = mid+1;
            }else{
                end = mid-1;
            }
        }
        return -1;
    }
    //Find Minimum in Rotated Sorted Array
    public static int findMin(int arr[]){
        int start =0;
        int end = arr.length;
        if(arr[0]<arr[end]){
            return arr[0];
        }
        while(start<=end){
            int mid = start+(end-start)/2;
            if(mid-1 >=0 && arr[mid]<arr[mid-1]){
                return arr[mid];
            }
            else if(arr[mid]>arr[end]){
                start = mid+1;
            }else{
                end = mid-1;
            }
        }
        return -1;
    }
    //searching in nearly sorted array
    public static int modifiedBinarySearch(int[] arr,int val){
        int start =0;
        int end =arr.length-1;
        while(start<=end){
            int mid = start+(end-start)/2;
            if(val==arr[mid]){
                return mid;
            }
            if(mid+1<=end && val==arr[mid+1]){
                return mid+1;
            }
            if(mid-1 >=0 && val==arr[mid-1]){
                return mid-1;
            }
            if(val>arr[mid]){
                start = mid+2;
            }else{
                end = mid-2;
            }
        }
        return -1;
    }
    //floor
    public static int floor5(int[] arr,int val){//greatest elemnt smaller than val
        int start =0;
        int end =arr.length-1;
        int res =0;
        while(start<=end){
            int mid = start+(end-start)/2;
            if(val==arr[mid]){
                return mid;
            }
            else if(val>arr[mid]){
                res = mid;
                start = mid+1;
            }else if(val<arr[mid]){
                end = mid-1;
            }

        }
        return -1;
    }
    //Find position of an element in an Infinite Sorted Array
    /* in infinite array we dont know the high, so first find high then perform binary search */
    public static int infiniteSortedArray(int[] arr, int k){
        int low =0;
        int high =1;
        while(k>arr[high]){
            low = high;
            high = high*2;
        }
        // binarySearch(arr,low, high,k);
    }
    //Index of First 1 in a Binary Sorted Infinite Array
    public static int infiniteSortedArray(int[] arr, int k){
        //find low and high
        int low =0;
        int high =1;
        while(k>arr[high]){
            low = high;
            high = high*2;
        }
        // first(arr,low,high,k);//get the first occurance
    }
    //
    public static void main(String[] args) {
        int[] arr = {1,2,8,10,11,12,19};
        System.out.println(floor(null, 5));
    }
}
