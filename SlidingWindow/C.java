import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Scanner;

public class C {
    public static int count(int[] arr, int k){
        for(int i=0;i<arr.length;i++){
            arr[i] = arr[i]%2==0?0:1;
        }
        int i=0;
        int j=0;
        int ps = 0;
        int ans = 0;
        while(j<arr.length){
            ps+=arr[j];
            while(ps>=k){
                ans++;
                ps-=arr[i];
                i++;
            }
            j++;
        }
        return ans;
        
    }
    public static void main(String[] args) {
        int[] arr = {1,1,2,1,1};
        int k =3;
        System.out.println(count(arr, k));

    }
}
