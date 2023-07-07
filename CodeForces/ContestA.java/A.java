import java.util.Scanner;

public class A {
    

    public static int sumOfA(int[] a) {
        int sum = 0;
        for (int i = 0; i < a.length; i++) {
            sum += a[i];
        }
        return sum;
    }
    public static int sumOfB(int[] b) {
        int sum = 0;
        for (int i = 0; i < b.length; i++) {
            sum += b[i];
        }
        return sum;
    }
    public static void res(int[] a, int[] b) {
        int result = sumOfA(a) - sumOfB(b);
        if(result>0){
            System.out.println("Tsondu");
        }
        else if(result<0){
            System.out.println("Tenzing");
        }else{
            System.out.println("Draw");
        }
        

    }

    public static void main(String[] args) {
       

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            int tsoA = sc.nextInt();
            int tenzB = sc.nextInt();
            int[] a = new int[tsoA];
            int[] b = new int[tenzB];
            for (int j = 0; j < tsoA; j++) {
                a[j] = sc.nextInt();
            }
            for (int j = 0; j < tenzB; j++) {
                b[j] = sc.nextInt();
            }
            res(a, b);
        }
        

    }
}
