import java.util.Scanner;

public class A {
    
    public static boolean isSorted(int[] arr){
        for(int i=0;i<arr.length-1;i++){
            if(arr[i]>arr[i+1]){
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-->0){
            int a = sc.nextInt();
            int[] arr = new int[a];
            for(int i=0;i<a;i++){
                arr[i] = sc.nextInt();
            }
            int res = Integer.MAX_VALUE;
            if(!isSorted(arr)){
                System.out.println(0);
            }else{
                    for(int i=0;i<arr.length-1;i++){
                    int dif  = arr[i+1]-arr[i];
                    res = Math.min((res), dif);
                }
                System.out.println(res/2+1);
            }
            
            
            
        }
    }
}

