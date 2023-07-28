import java.util.Scanner;

public class MorningSandwich {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-->0){
            int b = sc.nextInt();
            int c = sc.nextInt();
            int h = sc.nextInt();

            if (b > c + h) {
                System.out.println(2*(c+h)+1);
            } else {
                System.out.println(2*(b-1)+1);
            }
    

        }
    }
}
