import java.util.Arrays;
import java.util.Scanner;

public class l {
    private static String sortSubstring(String s, int l, int r){
        char[] arr = s.toCharArray();
        // Sorting the substring in-place

        Arrays.sort(arr,l-1,r);
        return new String(arr);
    }
    public static void main(String[] args) {
        String s = "101100";
        char[] arr = s.toCharArray();
        System.out.println(s);
        Arrays.sort(arr,1,4);
        for(int i=0;i<arr.length;i++){
            System.out.print(arr[i]+" ");
        }


        // Scanner sc = new Scanner(System.in);
        // int t = sc.nextInt();
        // while(t-->0){
        //     int n = sc.nextInt();
        //     int m = sc.nextInt();
        //     String s = sc.next();

        //     int l = sc.nextInt();
        //     int r = sc.nextInt();

        //     String s2 = sortSubstring(s, l, r);
        //     System.out.println(s2);
        // }
    }
}
