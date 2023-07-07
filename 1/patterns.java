import java.util.Scanner;

public class patterns {
    public static void main(String[] args) {
        
        /* int i,j, l=10;
        for(i=0;i<l;i++){
           for(j=0;j<=i;j++){
            System.out.print("*");
           }
           System.out.println();
        } */
        //---------------------------------------
        /* ****
           ***
           **
           *     */
        /* int i,j, l=4;
        for(i=l;i>0;i--){
            for(j=i;j>0;j--){
                System.out.print("*");
            }
            System.out.println();
        } */
        /* int i,j, l=4;
        for(i=1;i<=l;i++){
            for(j=1;j<=(l-i+1);j++){
                System.out.print("*");
            }
            System.out.println();
        }
 */
        

        //----------------------------------------
        
        /* 1
           12
           123
           1234 */

           /* int i,j,n=4;
           for(i=1;i<=n;i++){
            for(j=1;j<=i;j++){
                System.out.print(j);
            }
            System.out.println();
           } */

           //--------------------------------------
           /* A
              BC
              DEF
              GHIJ
            */

            /* char ch = 'A';
            int i,j,n=4;
            for(i=1;i<=n;i++){
                for(j=1;j<=i;j++){
                    System.out.print(ch);
                    ch++;
                }
                System.out.println();
            } */
            

    }
    
}
