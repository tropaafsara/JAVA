import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;

public class BinaryStringCopying {
    // private static String sortSubstring(String s, int l, int r){
    //     char[] arr = s.toCharArray();
    //     // Sorting the substring 
    //     Arrays.sort(arr,l-1,r);//Arrays.sort causes Time limit exceeded
    //     return new String(arr);
    // }
    private static String sortSubstring(String s, int l, int r){
        char[] arr = s.toCharArray();
        // Sorting the substring 
        for (int i = l - 1; i < r; i++) {
            for (int j = i + 1; j <= r - 1; j++) {
                if (arr[i] > arr[j]) {
                    char temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }
        return new String(arr);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-->0){
            int n = sc.nextInt();
            int m = sc.nextInt();
            String s = sc.next();

            HashSet<String> set = new HashSet<>();
            for(int i=0;i<m;i++){
                int l = sc.nextInt();
                int r = sc.nextInt();
                
                set.add(sortSubstring(s, l, r));
            }
            System.out.println(set.size());
        }
    }
}
