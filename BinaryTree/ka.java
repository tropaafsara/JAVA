import java.util.Arrays;
import java.util.Scanner;

public class ka {
    // public static int sol(int[] arr){
        
    //     int[] a = new int[arr.length];
    //     for(int i=0;i<arr.length;i++){
    //         a[i] = 0;
    //     }
    //     int count = a(arr);
    //     for(int i=0;i<arr.length;i++){
    //         if(arr[i]==a[i]){
    //             return count;
    //         }
            
    //     }
        
        
    // }
    public static int a(int[] arr){
        int count=0;
        Arrays.sort(arr);
        count+=arr[arr.length-1];
        return count+1;
        
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] arr = {2,2,0,0,1};
        int res = a(arr);
        System.out.println(res);
    }
}
