import java.util.ArrayList;
import java.util.Scanner;

public class A {  
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        for(int i=0;i<t;i++){
            int n = sc.nextInt();
            ArrayList<Integer> arr = new ArrayList<>();
            for(int j=0;j<n;j++){
                arr.add(sc.nextInt());
            }
            while(arr.size() > 1){
                int mid = arr.size()+1/2;
                if((mid+1)<arr.size()-1 && (mid-1)>0){
                int k = arr.get(mid-1) + arr.get(mid+1);
                arr.set(mid,k);
                arr.remove(mid-1);
                arr.remove(mid+1);
                arr.remove(arr.get(0));
                arr.remove(arr.get(arr.size()-1));
                if(arr.size()==1){
                   System.out.println(arr.get(0));
                   break;
                }
                }
            }
            
        }
        
            
    }
}
