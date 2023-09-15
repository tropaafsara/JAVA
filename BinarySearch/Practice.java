import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class Practice {
    public static int binarySearch(int arr[],int val, boolean flag){
        int start =0;
        int end = arr.length-1;
        int ans =-1;
        while(start<=end){
            int mid = start+(end-start)/2;
            if(arr[mid]==val){
                ans = mid;
                if(flag){
                    end = mid-1;
                }else{
                    start = mid+1;
                }
            }
            else if(arr[mid]>val){
                end = mid-1;
            }else{
                start = mid+1;
            }
        }
        return ans;
    }
    //Find the Rotation Count in Rotated Sorted array
    public static int solve(int arr[]){
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
    public static void frequencySort(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        for(int i=0; i<s.length();i++){
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i),0)+1);
        }
        List<Character> chars  = new ArrayList<>(map.keySet());
        chars.sort((ch1,ch2)->map.get(ch2)-map.get(ch1));
        
        StringBuilder sb = new StringBuilder();
        for (char ch : chars) {
            for (int i = 0; i < map.get(ch); i++) {
                sb.append(ch);
            }
        }
    }
    //
    public static int solve2(int[] nums){
        if(nums.length==1)
        {
            return 0;
        }
        int maxElement =  Integer.MIN_VALUE;
        int minElement =  Integer.MAX_VALUE;
        int minIdx = -1;
        int maxIdx = -1;
        //find min and max value
        for(int i=0;i<nums.length;i++){
            if(nums[i]>=maxElement){//341553 , we need to take last 5
                maxElement = nums[i];
                maxIdx = i;
            }
            if(nums[i]<minElement){//3411553 , we need to take first 1
                minElement = nums[i];
                minIdx = i;
            }
        }
        if(minIdx<=maxIdx){
            return minIdx+(nums.length-maxIdx-1);
        }else{
            return minIdx+(nums.length-maxIdx-1)-1;
        }
    }
    //spiral matrix 
    public static void solve5(int[][] matrix){
        int startRow = 0;
        int startCol = 0;
        int endRow = matrix.length-1;
        int endCol = matrix[0].length-1;
        while(startRow<=endRow && startCol<=endCol){
            //top
            for(int j=startCol;j<=endCol;j++){
                System.out.print(matrix[startRow][j]+" ");
            }
            //right
            for(int i=startRow+1;i<=endRow;i++){
                System.out.print(matrix[i][endCol]+" ");
            }
            //bottom
            for(int j=endCol-1;j>=startCol;j--){
                if(startRow==endRow){
                    break;
                }
                System.out.print(matrix[endRow][j]+" ");
            }
            //left
            for(int j=endRow-1;j>=startCol+1;j--){
                if(startCol==endCol){
                    break;
                }
                System.out.print(matrix[j][startCol]+" ");
            }
            startRow++;
            endRow--;
            startCol++;
            endCol--;
        }
    }
    public static void main(String[] args) {
       int[] nums = {1,2};
       System.out.println(solve2(nums));
    }
}
