import java.util.*;

public class DaltontheTeacher {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-->0){
            int count=0;
            int n = sc.nextInt();
            int[] arr = new int[n];
            for(int i=0;i<n;i++){
                arr[i] = sc.nextInt();
                if(arr[i]==i+1){
                    count++;
                }
            }
            // for(int i=1;i<n;i++){
            //     if(arr[i]==i+1 ||  arr[i-1]==i){
            //         int temp = arr[i];
            //         arr[i] = arr[i-1];
            //         arr[i-1] = temp;
            //         count++;
            //     }
                
            // }

            
        
            System.out.println((count+1)/2);
        }
    }
}
