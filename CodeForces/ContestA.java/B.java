import java.util.Scanner;
import java.util.Stack;

public class B {
    public static void b(Stack<Integer> s3, Stack<Integer> s1, Stack<Integer> s2, int fav){

    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            int book = sc.nextInt();
            int fav = sc.nextInt();

            int[] s1 = new int[n];
            int[] s2 = new int[n];
            int[] s3 = new int[n];


            for(int j=0;j<book;j++){
                s1[j] = sc.nextInt();
            }
            for(int j=0;j<book;j++){
                s2[j] = sc.nextInt();
            }
            for(int j=0;j<book;j++){
                s3[j] = sc.nextInt();
            }

            
           
        }
    }
}
