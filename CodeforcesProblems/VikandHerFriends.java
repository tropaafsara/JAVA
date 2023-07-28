import java.util.*;
public class VikandHerFriends{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        for(int i=0;i<t;i++){
            int n = sc.nextInt();
            int m = sc.nextInt();
            int k = sc.nextInt();

            int x = sc.nextInt();
            int y = sc.nextInt();
            int xi,yi;
            boolean canEscape = true;
            for(int j=0;j<k;j++){
                 xi = sc.nextInt();
                 yi = sc.nextInt();
                 int dx = Math.abs(x - xi);
                 int dy = Math.abs(y - yi);

                if ((dx + dy) % 2 == 0) { // if Vika and friend are in same type of room
                    canEscape = false;
                }   
    
            }
            if(canEscape){
            System.out.println("YES");
        }else{
            System.out.println("NO");
        }
        }
        

    }
}
