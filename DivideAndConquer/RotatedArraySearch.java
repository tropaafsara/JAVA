public class RotatedArraySearch {
    public static int search(int arr[], int target, int si, int ei){
        //base case
        if(si>ei){
            return -1;
        }


        int mid = si+(ei-si)/2;//(si+ei)/2

        if(arr[mid]==target){
            return mid;
        }

        //mid on L1
        if(arr[si]<=arr[mid]){
            //case a: search left
            if(arr[si]<=target && target<=arr[mid]){
                return search(arr, target, si, mid-1);
            }else{
                //case b: right
                return search(arr, target, mid+1, ei);
            }
        }

        //mid on L2
        else{
            //case c: right
            if(arr[mid]<=target && target<=ei){
                return search(arr, target, mid+1, ei);
            }else{
                //case d: left
                return search(arr, target, si, mid-1);
            }
        }
    }
    public static void main(String[] args) {
        int arr[] = {1};
        int target = 0; // output -> 4
        int tarIdx = search(arr, target, 0, arr.length-1);
        System.out.println(tarIdx);
    }
}
