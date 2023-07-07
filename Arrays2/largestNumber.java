import java.util.*;
public class largestNumber {
    public static int largestNumber(int n[]) {
        int largest=Integer.MIN_VALUE; //- infinity
        for(int i=0;i<n.length;i++){
            if(n[i]>largest){
                largest=n[i];
                
            }
        }
        return largest;
    }
    public static int getSmallest(int n[]){
        int smallest = Integer.MAX_VALUE;
        for(int i=0;i<n.length;i++){
            if(n[i]<smallest){
                smallest=n[i];
            }
        }
        return smallest;
    }
    public static void main(String[] args) {
        int numbers[]={1,5,2,8,6};
        int n1 = largestNumber(numbers);
        System.out.println("largest number is = "+n1);
        int n2 = getSmallest(numbers);
        System.out.println("smallest number is = "+n2); 
        
    }
}
