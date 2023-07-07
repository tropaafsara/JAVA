//revise strongly, sum o ber korsi, yahoooo
//vai re vai, max min o ber korsi, ulala

public class Subarrays {
    public static void getSubArrays(int arr[]){
        int sum = 0;
        int maxSum=Integer.MIN_VALUE;
        int minSum=Integer.MAX_VALUE;
        
        for(int i =0; i<arr.length;i++){
            for(int j = i ; j<arr.length;j++){
                
                for(int k=i;k<=j;k++){
                    sum = arr[k]+sum;
                    System.out.print(arr[k]+" ");
                    
                      
                }
                System.out.println(": sum = "+sum);
                if(maxSum<sum){
                    maxSum=sum;
                }
                if(minSum>sum){
                    minSum=sum;
                }
                System.out.println();
                sum=0;
                
            }
        }
        System.out.println("Max number = "+maxSum);
        System.out.println("Min number = "+minSum);
    }

    public static void main(String[] args) {
        //subarray = continuous part of array
        int arr[] = {2,4,6,8,10};
        getSubArrays(arr);
    }
    
}
