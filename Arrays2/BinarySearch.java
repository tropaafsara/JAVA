public class BinarySearch {
    public static int binarySearch(int n[],int key) {
        int start = 0;
        int end = n.length-1;
        
        while(start<=end){
            int mid = (start+end)/2;
            if(n[mid]==key){
                return mid;
            }
            else if(n[mid]<key){
                end = mid-1;
            }else{
                start = mid+1;
            }
        }
        return -1;
    }
    public static void main(String[] args) {
        int numbers[]={3,5,9,12,17,19,23,45};
        int key=12;
        int result = binarySearch(numbers,key);
        System.out.println(result);

        
    }
}
