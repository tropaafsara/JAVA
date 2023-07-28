import java.util.Scanner;
//Ten Words of Wisdom
public class Q {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for(int i=0;i<t;i++){
            int n = sc.nextInt();
            int maxq =-1;
            int quality = Integer.MIN_VALUE;
            for(int j=0;j<n;j++){
                 int a = sc.nextInt();
                 int b = sc.nextInt();
                 if(a<=10){
                  if(b>quality){
                    quality = b;
                    maxq = j+1;
                  }
                }
                 
            }
            System.out.println(maxq);
            
        }
        
    }
}
