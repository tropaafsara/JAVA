import java.util.Scanner;
import java.util.Stack;

public class practice4 {
    public static void calc(Stack<Integer> sc1, int n){
        Stack<Integer> sc2 = new Stack<>();
        int a=0;
        for(int i=1;i<=n;i++){
           sc2.push(i);
        }
        while(!sc2.isEmpty()){
            int top = sc2.pop();
            if(!sc1.contains(top)){
                a+=top;
            }       
        }
        System.out.println(a);

        
    }

    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        int testCase = sc.nextInt();
        for (int i = 0; i < testCase; i++) {
            Stack<Integer> sc1 = new Stack<>();
            int n = sc.nextInt();
            int m = sc.nextInt();
            for (int j = 0; j < m; j++) {
                sc1.push(sc.nextInt());
            }
            calc(sc1, n);
            
        }

    }
}
