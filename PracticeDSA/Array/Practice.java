//https://www.geeksforgeeks.org/maximum-and-minimum-in-an-array/

public class Practice {
    public static int findMaxNumber(int arr[]){
        int largestNumber = Integer.MIN_VALUE;
        int smallestNumber = Integer.MAX_VALUE;
        for(int i=0;i<arr.length;i++){
            if(largestNumber<arr[i]){
                largestNumber = arr[i];
            }     
        }
        return largestNumber;
    }
    public static int findMinNumber(int arr[]){
        int smallestNumber = Integer.MAX_VALUE;
        for(int i=0;i<arr.length;i++){
            if(smallestNumber>arr[i]){
                smallestNumber = arr[i];
            }     
        }
        return smallestNumber;
    }

    
    public static void main(String[] args) {
        int arr[] = {3, 5, 4, 1, 9};
        System.out.println(findMaxNumber(arr));
        System.out.println(findMinNumber(arr));
    }
}
