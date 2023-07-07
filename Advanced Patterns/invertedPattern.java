public class invertedPattern {
    
      /* public  static void hollow_rectangle(int  rows, int cols){
        for(int i=1;i<=rows;i++){
            for(int j=1;j<=cols;j++){
                if(i==1 || i==rows || j==1 || j==cols){
                    System.out.print("*");
                }else{
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
      } */


      
    /* public static void invertedPattern(int n){
        //space = n-i
        for(int i=1;i<=n;i++){
            for(int j=1;j<=n-i;j++){ 
                System.out.print(" ");
            }
            for(int j = 1; j<=i; j++){
                System.out.print("*");
            }
            System.out.println();
        }
    } */

    /* public static void inverted_half_pyramid_with_numbers(int n){

        for(int i=1; i<=n; i++){
            for(int j = 1; j<=n-i+1 ; j++){
                System.out.print(j);
            }
            System.out.println();
        }
    } */

    /* public static void floyds_triange(int n){
        int counter = 1;
        for(int i =1 ; i<=n ; i++){
            for(int j = 1 ; j <=i; j++){
                System.out.print(counter+" ");
                counter++;
            }
            System.out.println();
        }
    } */

    
    /* public static void binary_triangle(int n){
        for(int i =1; i<=n ; i++){
            for(int j=1;j<=i;j++){
                if((i+j)%2==0){
                    System.out.print("1");
                }else{
                    System.out.print("0");
                }
            }
            System.out.println();
        }
    } */

    /* public static void butterfly(int n){

        
        for(int i =1; i<=n ; i++){
            //stars - i
            for(int j = 1;j<=i;j++){
                System.out.print("*");
            }
            //spaces - (n-i)*2
            for(int j=1;j<=(n-i)*2;j++){
                System.out.print(" ");
            }
            //stars - i
            for(int j = 1;j<=i;j++){
                System.out.print("*");
            }
            
            System.out.println();
        }
        for(int i =n; i>=1 ; i--){
            //stars - i
            for(int j = 1;j<=i;j++){
                System.out.print("*");
            }
            //spaces - (n-i)*2
            for(int j=1;j<=(n-i)*2;j++){
                System.out.print(" ");
            }
            //stars - i
            for(int j = 1;j<=i;j++){
                System.out.print("*");
            }
            
            System.out.println();
        }
    } */

    /* public static void solid_rhombus_pattern(int n){
        for(int i =1; i<=n; i++){
            for(int j = 1; j<=n-i; j++){
                System.out.print(" ");
            }
            for(int j=1; j<=n; j++){
                System.out.print("*");
            }
            System.out.println();
        }
    } */

    /* public static void hollow_rhombus(int n){
        for(int i=1; i<=n;i++){
            for(int j = 1; j<=n-i; j++){
                System.out.print(" ");
            }
            for(int j=1;j<=n;j++){
                if(i==1 || i==n || j==1 || j==n){
                    System.out.print("*");
                }else{
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    } */

    /* public static void diamond(int n){
        for(int i =1; i<=n; i++){
            for(int j= 1; j<=n-i; j++){
                System.out.print(" ");
            }
            for(int j=1;j<=(2*i)-1;j++){
                System.out.print("*");
            }
            
            System.out.println();
        }
        for(int i =n; i>=1; i--){
            for(int j= 1; j<=n-i; j++){
                System.out.print(" ");
            }
            for(int j=1;j<=(2*i)-1;j++){
                System.out.print("*");
            }
            
            System.out.println();
        }
    } */


    /* public static void main(String[] args) {
        // hollow_rectangle(4, 5);
        // invertedPattern(4);
        // inverted_half_pyramid_with_numbers(5);
        // floyds_triange(5);
        // binary_triangle(5);
        // butterfly(5);
        // solid_rhombus_pattern(5);
        // hollow_rhombus(5);
        diamond(4);
    } */



   
    
}
