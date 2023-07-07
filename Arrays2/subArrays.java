import java.util.*;
public class subArrays {
    public static void subarrays(int n[]) {
        int largest = Integer.MIN_VALUE;
        int ts=0;
        for(int i=0;i<=n.length;i++){
            int start = i;
            for(int j=i; j<n.length;j++){
                int end = j;
                int sum=0;
                for(int k=start;k<=end;k++){
                    
                    sum=sum+n[k];
                    System.out.print(n[k]);
                }
                System.out.println("  sum = "+sum);
                if(sum>largest){
                    largest=sum;
                }
                
                sum=0;
                ts++;
                System.out.println();
            }
           
        }
        System.out.println("Total subarrays"+ts);
        System.out.println("largest sum is: "+largest);
    }
    public static void main(String[] args) {
        int numbers[]={2,4,6,8,10};
        subarrays(numbers);
    }
}
