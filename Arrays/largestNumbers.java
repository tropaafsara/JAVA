

public class largestNumbers {
    public static int getMaxMin(int numbers[]){
        int largest = Integer.MIN_VALUE; // -infinity
        int smallest = Integer.MAX_VALUE; // +infinity
        for(int i=0;i<numbers.length;i++){
            if(numbers[i]>largest){
                largest = numbers[i];    
            }
        }
        for(int i=0;i<numbers.length;i++){
            if(numbers[i]<smallest){
                smallest = numbers[i];    
            }
        }

        System.out.println(smallest);
        return largest;
    }
    public static void main(String[] args) {
        
        int numbers[]= {3,4,6,23,5,6,3,5,6,8,1,23,24255,100000000};
        System.out.println(getMaxMin(numbers));
    }
    
}
