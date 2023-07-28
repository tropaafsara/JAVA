import java.util.*;

public class ParitySort {
    public static boolean sort(int[] arr){
        int n = arr.length;
        int min = Integer.MAX_VALUE;
            for(int i=0;i<n/2;i++ ){
                int j;
                for(j=i;j<n;j++ ){
                 min = Math.min(arr[j],min);
                }
                if((arr[i]%2==0 && min%2==0) || (arr[i]%2!=0 && min%2!=0)){
                    int temp = arr[i];
                    arr[i]= min;
                    arr[j] = temp;
                    System.out.println("YES");
                }else{
                    System.out.println("NO");
                    break;
                } 



            }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-->0){
            int n = sc.nextInt();
            int[] arr = new int[n];
            for(int i=0;i<n;i++ ){
                arr[i] = sc.nextInt();
            }
            sort(arr);
            
            

            

            
             
            
              
            


        }
    }
}
