import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Monsters {
    public static List<Integer> calc(int[] arr, int k,List<Integer> a){
        
        int max = Integer.MIN_VALUE;
        int maxHealthIndex=0;
        for(int i=0;i<arr.length;i++){
            
            if (arr[i] > arr[maxHealthIndex]) {
                maxHealthIndex = i;
            }
            // max = Math.max(max,arr[i]);
            // maxHealthIndex = i;
        }

        // int x = max-k;
        int x = arr[maxHealthIndex] - k;
        arr[maxHealthIndex] = x;
        
        if(x<0 || x==0){
            a.add(maxHealthIndex+1);
            System.out.println(a.size());
            
        }
        if (a.size() == arr.length) {
            
            return a;
        }
        calc(arr, k,a);
        return a;
        
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-->0){
            int n = sc.nextInt();//number of monsters
            int k = sc.nextInt();//damage which Monocarp's ability deals.
            int[] arr = new int[n];//initial health points of monsters.
            for(int i=0;i<n;i++){
                arr[i] = sc.nextInt();
            }
            List<Integer> b = new ArrayList<>();
            List<Integer> a = calc(arr,k,b);
            for(int i=0;i<a.size();i++){
                System.out.print(a.get(i)+" ");
            }


            System.out.println();

        }
    }
}
