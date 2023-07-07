import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class c {
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int n = sc.nextInt();
        for(int i=0;i<n;i++){
            int a = sc.nextInt();
            ArrayList<String[]> al = new ArrayList<>();
            String[] str = new String[a];
            for(int j=0;j<3;j++){
                for(int k=0; k<a;k++){
                    str[k] = sc.next();
                }
                
                al.add(str);
            }
            // Print the ArrayList
            for (String[] arr : al) {
                for (String s : arr) {
                    System.out.print(s + " ");
                }
                System.out.println();
            }
            

        }
        

    }
}
