import java.util.Scanner;
//pass by reference
public class p {
    public static void update(int a, int b){
        a = 3;
        b=70;
        System.out.println(a);
    }
    public static void main(String[] args) {
        int marks[] = new int[100];
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b= 8;
        
        update(a,b);  
        //pass by value 
        System.out.println(b); 
    }
}
