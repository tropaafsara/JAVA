import java.util.Scanner;

public class contest {
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int tc= sc.nextInt();
        for(int i=0;i<tc;i++){
            int n= sc.nextInt();
            int sum=0;
            for(int j=0;j<n;j++){
                
                int a = sc.nextInt();
                int b = sc.nextInt();
                if(a>b){
                    sum++;
                }

            }
            System.out.println(sum);
        }
        
    }
}
