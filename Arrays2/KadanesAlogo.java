import java.util.*;
public class KadanesAlogo {
    public static void subarrays(int n[]) {
        int largest = Integer.MIN_VALUE;
        int ts=0;
        int prefix[]=new int[n.length];
        prefix[0]=n[0];
        for(int i=1;i<n.length;i++){
            prefix[i]=prefix[i-1]+n[i];
        }
        for(int i=0;i<=n.length;i++){
            int start = i;
            for(int j=i; j<n.length;j++){
                int end = j;

                int sum= start ==0 ? prefix[end]: prefix[end]-prefix[start-1];
                
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
    public static int kadane(int nums[]) {
        int ms=Integer.MIN_VALUE;
        int cs= 0;
        for(int i=0;i<nums.length;i++){
            cs=cs+nums[i];
            if(cs<0){
                cs=0;
            }
            ms=Math.max(cs, ms);//whichever is max set to ms
        }
        return ms;
       
    }
    public static void main(String[] args) {
        int numbers[]={1};
        System.out.println(kadane(numbers));
    }
}

